package fr.mightycode.cpoo.server.controller;

import fr.mightycode.cpoo.server.dto.MessageDTO;
import fr.mightycode.cpoo.server.dto.NewMessageDTO;
import fr.mightycode.cpoo.server.entity.Contact;
import fr.mightycode.cpoo.server.entity.MyConversation;
import fr.mightycode.cpoo.server.entity.UserInfo;
import fr.mightycode.cpoo.server.model.Message;
import fr.mightycode.cpoo.server.repository.MessageRepository;
import fr.mightycode.cpoo.server.repository.MyConversationRepository;
import fr.mightycode.cpoo.server.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class MessageController {

  private static SecretKey secretKey;
  @Autowired
  private final RouterService routerService;
  @Autowired
  private final MessageService messageService;
  @Value("${cpoo.server.domain}")
  private String serverDomain;
  @Autowired
  private SettingsService settingsService;
  @Autowired
  private HomeService homeservice;
  @Autowired
  private MessageRepository messageRepository;
  @Autowired
  private ContactService contactService;
  @Autowired
  private MyConversationRepository myConversationRepository;

  // Méthode pour chiffrer un message avec l'algorithme AES
  public static String encrypt(String message) throws Exception {
    if (secretKey == null) {
      secretKey = generateSecretKey();
    }

    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);

    byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
    return Base64.getEncoder().encodeToString(encryptedBytes);
  }

  // Méthode pour déchiffrer un message chiffré avec l'algorithme AES
  public static String decrypt(String encryptedMessage) throws Exception {
    if (secretKey == null) {
      throw new IllegalStateException("La clé secrète doit être générée avant le déchiffrement.");
    }

    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, secretKey);

    byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
    byte[] decryptedBytes = cipher.doFinal(decodedBytes);
    return new String(decryptedBytes, StandardCharsets.UTF_8);
  }

  // Méthode pour générer une clé secrète pour le chiffrement AES
  private static SecretKey generateSecretKey() throws Exception {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(128);
    return keyGenerator.generateKey();
  }

  // Méthode pour obtenir le nom d'utilisateur actuel
  public String getCurrentUsername() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User user) {
      return user.getUsername();
    } else {
      return null;
    }
  }

  // Endpoint pour envoyer un nouveau message
  @PostMapping(value = "{conversationid}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ArrayList<MessageDTO> messagePost(final Principal user, @RequestBody final NewMessageDTO newMessage, @PathVariable long conversationid) throws Exception {
    Contact contactToSendTo = null;
    String username = getCurrentUsername();
    ArrayList<MessageDTO> listMessageToSend = new ArrayList<>();
    UserInfo currentUser = settingsService.getInformations(username);

    // Recherche du contact destinataire
    for (Contact contacts : currentUser.getContacts()) {
      if (contacts.getPseudo().equals(newMessage.to())) {
        contactToSendTo = contacts;
      }
    }

    String to = newMessage.to() + "@" + contactToSendTo.getDomain();

    // Création d'un message RouterService à partir des données du DTO
    RouterService.Message routerMessage = new RouterService.Message(UUID.randomUUID(), System.currentTimeMillis(), user.getName() + "@" + serverDomain, to, newMessage.type(), newMessage.body());

    Optional<MyConversation> conversation = myConversationRepository.findById(conversationid);
    if (conversation != null) {
      MyConversation conversationToSave = conversation.get();
      Message messageToSave = new Message(routerMessage);
      messageToSave.setConversation(conversationToSave);
      messageRepository.save(messageToSave);
      conversationToSave.setLastMessage(messageToSave.getBody());
      Instant instant = Instant.ofEpochMilli(messageToSave.getTimestamp());
      OffsetDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toOffsetDateTime();
      conversationToSave.setLastMessageDate(localDateTime);
      myConversationRepository.save(conversationToSave);
      listMessageToSend = homeservice.transformListMessageInListMessageDTO(conversationToSave);
    }
/* Bloc de code à décommenter si on veut chiffrer les communications entre utilisateurs de talknow
    if (contactToSendTo.getDomain().equals("talknow")) {
      // Chiffre le message avant de l'envoyer
      RouterService.Message routerMessageChiffre = new RouterService.Message(UUID.randomUUID(), System.currentTimeMillis(), user.getName() + "@" + serverDomain, to, newMessage.type(), encrypt(newMessage.body()));
      routerService.routeMessage(routerMessageChiffre);
    } else {
      routerService.routeMessage(routerMessage);
    }
*/
      // Route le message
      routerService.routeMessage(routerMessage); //ligne à commenter lorsque on veut chiffrer les communications entre utilisateurs de talknow


    // Retourne la liste des messages envoyés
    return listMessageToSend;
  }

  // Endpoint pour recevoir le prochain message asynchrone
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public DeferredResult<ResponseEntity<MessageDTO>> messageGet(final Principal user) throws Exception {
    DeferredResult<ResponseEntity<MessageDTO>> deferredResult = new DeferredResult<>();
    try {
      boolean test = false;
      String username = getCurrentUsername();
      UserInfo currentUser = settingsService.getInformations(username);

      // Récupère le prochain message à partir du service MessageService
      Message messageR = messageService.getNextMessage(currentUser.getLogin() + "@" + serverDomain);
      Message messageReceived;

      if (messageR == null) {
        deferredResult.setResult(new ResponseEntity<>(HttpStatus.ACCEPTED));
      } else {
        String[] domaineOfIncome = messageR.getFrom().split("@");

/* Bloc de code à décommenter si on veut chiffrer les communications entre utilisateurs de talknow
        // Vérifie si le message est chiffré avec "talknow" et déchiffre si nécessaire
        if (domaineOfIncome[1].equals("talknow")) {
          messageReceived = messageR;
          messageReceived.setBody(decrypt(messageR.getBody()));
        } else {
          messageReceived = messageR;
        }
*/
        messageReceived = messageR; //ligne à commenter lorsque on veut chiffrer les communications entre utilisateurs de talknow
        String[] parts = messageReceived.getFrom().split("@");
        // Recherche de la conversation correspondante ou création si nécessaire
        for (MyConversation conversation : currentUser.getConversations()) {
          if (conversation.getContactPseudo().equals(parts[0])) {
            messageReceived.setConversation(conversation);
            messageRepository.save(messageReceived);
            conversation.setLastMessage(messageReceived.getBody());
            Instant instant = Instant.ofEpochMilli(messageReceived.getTimestamp());
            OffsetDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toOffsetDateTime();
            conversation.setLastMessageDate(localDateTime);
            myConversationRepository.save(conversation);
            test = true;
          }
        }
        // Crée une nouvelle conversation si le contact n'existe pas
        if (!test) {
          contactService.addContact(messageReceived.getFrom(), currentUser);
          String[] split = messageReceived.getFrom().split("@");
          String pseudoContact = split[0];
          MyConversation conversationToDealWith = contactService.createConversation(currentUser, pseudoContact);
          messageReceived.setConversation(conversationToDealWith);
          messageRepository.save(messageReceived);
          conversationToDealWith.setLastMessage(messageReceived.getBody());
          Instant instant = Instant.ofEpochMilli(messageReceived.getTimestamp());
          OffsetDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toOffsetDateTime();
          conversationToDealWith.setLastMessageDate(localDateTime);
          myConversationRepository.save(conversationToDealWith);
        }

        MessageDTO messageToSend = new MessageDTO(messageReceived);
        deferredResult.setResult(new ResponseEntity<>(messageToSend, HttpStatus.OK));
      }
    }
    catch (final InterruptedException ex) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
    }
    return deferredResult;
  }
}

