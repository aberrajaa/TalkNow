package fr.mightycode.cpoo.server.controller;

import fr.mightycode.cpoo.server.dto.AjoutContactDTO;
import fr.mightycode.cpoo.server.dto.ContactInfoDTO;
import fr.mightycode.cpoo.server.dto.UpdateInfoDTO;
import fr.mightycode.cpoo.server.entity.Contact;
import fr.mightycode.cpoo.server.entity.MyConversation;
import fr.mightycode.cpoo.server.entity.UserInfo;
import fr.mightycode.cpoo.server.repository.MyConversationRepository;
import fr.mightycode.cpoo.server.service.ContactService;
import fr.mightycode.cpoo.server.service.HomeService;
import fr.mightycode.cpoo.server.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping("profile")
@RequiredArgsConstructor
public class ContactController {
  @Autowired
  private ContactService contactService;
  @Autowired
  private SettingsService settingsService;

  @Autowired
  private MyConversationRepository conversationRepository;

  @Autowired
  private HomeService homeService;


  // Méthode pour obtenir le nom d'utilisateur actuel
  public String getCurrentUsername() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User user) {
      return user.getUsername();
    } else {
      return null;
    }
  }

  // Endpoint pour obtenir la liste des contacts de l'utilisateur
  @GetMapping(value = "contact")
  public ArrayList<ContactInfoDTO> getListContacts() {
    String currentUsername = getCurrentUsername();
    UserInfo currentUser = settingsService.getInformations(currentUsername);
    ArrayList<ContactInfoDTO> listOfContact = new ArrayList<ContactInfoDTO>();
    if (!currentUser.getContacts().isEmpty()) {
      for (Contact contact : currentUser.getContacts()) {
        ContactInfoDTO contactToSend = new ContactInfoDTO(contact.getFirstname(), contact.getLastname(), contact.getEmail(), contact.getPseudo(), contact.getAvatar(), contact.getId());
        listOfContact.add(contactToSend);
      }
    }
    return listOfContact;
  }

  // Endpoint pour ajouter un contact à la liste de l'utilisateur
  @PostMapping(value = "contact")
  public ArrayList<ContactInfoDTO> ajouterContact(@RequestBody AjoutContactDTO email) {
    String currentUsername = getCurrentUsername();
    String[] parts = email.getEmail().split("@");
    UserInfo currentUser = settingsService.getInformations(currentUsername);
    if (!email.equals(currentUser.getAdress())) {
      if (!contactService.contactAlreadyExist(parts[0], currentUser)) {
        contactService.addContact(email.getEmail(), currentUser);
      }
      ArrayList<ContactInfoDTO> listOfContact = new ArrayList<ContactInfoDTO>();
      for (Contact contact : currentUser.getContacts()) {
        ContactInfoDTO contactToSend = new ContactInfoDTO(contact.getFirstname(), contact.getLastname(), contact.getEmail(), contact.getPseudo(), contact.getAvatar(), contact.getId());
        listOfContact.add(contactToSend);
      }
      return listOfContact;
    }
    return null;
  }

  // Endpoint pour mettre à jour les informations d'un contact
  @PutMapping(value = "contact/{contactid}")
  public ArrayList<ContactInfoDTO> modificationContact(@PathVariable long contactid, @RequestBody UpdateInfoDTO updateRequest) {
    String type = updateRequest.getType();
    String value = updateRequest.getValue();
    String username = getCurrentUsername();
    UserInfo currentUser = settingsService.getInformations(username);
    switch (type) {
      case "avatar":
        Contact contactToModify = contactService.getContactFromBdd(contactid);
        for (MyConversation conversation : currentUser.getConversations()) {
          if (contactToModify.getPseudo().equals(conversation.getContactPseudo())) {
            conversation.setContactAvatar(value);
            conversationRepository.save(conversation);
          }
        }
        contactToModify.setAvatar(value);
        contactService.saveInBdd(contactToModify);
        break;
      case "firstname":
        Contact contactToModifier = contactService.getContactFromBdd(contactid);
        for (MyConversation conversation : currentUser.getConversations()) {
          if (contactToModifier.getPseudo().equals(conversation.getContactPseudo())) {
            //conversation.setContactPseudo(value);
            conversationRepository.save(conversation);
          }
        }
        contactToModifier.setFirstname(value);
        contactService.saveInBdd(contactToModifier);
        break;
      case "lastname":
        Contact contactaModifier = contactService.getContactFromBdd(contactid);
        for (MyConversation conversation : currentUser.getConversations()) {
          if (contactaModifier.getPseudo().equals(conversation.getContactPseudo())) {
            //conversation.setContactPseudo(value);
            conversationRepository.save(conversation);
          }
        }
        contactaModifier.setLastname(value);
        contactService.saveInBdd(contactaModifier);
        break;
    }
    ArrayList<ContactInfoDTO> listOfContact = new ArrayList<ContactInfoDTO>();
    if (!currentUser.getContacts().isEmpty()) {
      for (Contact contact : currentUser.getContacts()) {
        ContactInfoDTO contactToSend = new ContactInfoDTO(contact.getFirstname(), contact.getLastname(), contact.getEmail(), contact.getPseudo(), contact.getAvatar(), contact.getId());
        listOfContact.add(contactToSend);
      }
    }
    return listOfContact;
  }

  // Endpoint pour supprimer un contact de la liste de l'utilisateur
  @DeleteMapping(value = "contact/{contactid}")
  public ArrayList<ContactInfoDTO> deleteContact(@PathVariable long contactid) {
    Contact contactToDelete = contactService.getContactFromBdd(contactid);
    String username = getCurrentUsername();
    UserInfo currentUser = settingsService.getInformations(username);
    for (MyConversation conversation : new ArrayList<>(currentUser.getConversations())) {
      if (contactToDelete.getPseudo().equals(conversation.getContactPseudo())) {
        conversationRepository.delete(conversation);
        currentUser.getConversations().remove(conversation);
        settingsService.updateBdd(currentUser);
      }
    }

    if (contactToDelete != null) {
      Iterator<Contact> iterator = currentUser.getContacts().iterator();
      while (iterator.hasNext()) {
        Contact contact = iterator.next();
        if (contact.getId() == contactid) {
          iterator.remove();
        }
      }
      contactService.deleteContact(contactid);
    }
    ArrayList<ContactInfoDTO> listOfContact = new ArrayList<ContactInfoDTO>();
    if (!currentUser.getContacts().isEmpty()) {
      for (Contact contact : currentUser.getContacts()) {
        ContactInfoDTO contactToSend = new ContactInfoDTO(contact.getFirstname(), contact.getLastname(), contact.getEmail(), contact.getPseudo(), contact.getAvatar(), contact.getId());
        listOfContact.add(contactToSend);
      }
    }
    for (MyConversation conversation : conversationRepository.findAll()) {
      System.out.println(conversation.getContactPseudo());
    }
    return listOfContact;
  }

  // Endpoint pour créer une nouvelle conversation avec un contact
  @PostMapping(value = "contact/{contactid}")
  public void createConversation(@PathVariable long contactid) {
    String currentUsername = getCurrentUsername();
    UserInfo currentUser = settingsService.getInformations(currentUsername);
    Contact currentContact = contactService.getContactFromBdd(contactid);

    if (currentUser != null && currentUser.getLogin() != null && !contactService.conversationAlreadyExist(currentContact.getPseudo(), currentUser)) {
      MyConversation newConversation = new MyConversation(currentContact.getPseudo(), currentContact.getAvatar(), currentUser);
      newConversation.setUserInfo(currentUser);
      conversationRepository.save(newConversation);
      currentUser.getConversations().add(newConversation);
      settingsService.updateBdd(currentUser);
    }
  }
}
