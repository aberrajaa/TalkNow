package fr.mightycode.cpoo.server.service;

import fr.mightycode.cpoo.server.dto.ContactInfoDTO;
import fr.mightycode.cpoo.server.entity.Contact;
import fr.mightycode.cpoo.server.entity.MyConversation;
import fr.mightycode.cpoo.server.entity.UserInfo;
import fr.mightycode.cpoo.server.repository.ContactRepository;
import fr.mightycode.cpoo.server.repository.MyConversationRepository;
import fr.mightycode.cpoo.server.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class ContactService {
  @Autowired
  private ContactRepository contactRepo;
  @Autowired
  private SettingsService settingsService;
  @Autowired
  private MyConversationRepository conversationRepository;
  @Autowired
  private UserInfoRepository userRepo;

  //Fonction qui permet de vérifier si l'input de l'email est valide ou non.
  public boolean isValidEmail(String email) {
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z]+$";
    return Pattern.compile(regex).matcher(email).matches();
  }

  //Fonction qui permet d'ajouter un contact à la base données.
  public void addContact(String email, UserInfo user) {

    String[] parts = email.split("@");
    if (parts.length == 2 && isValidEmail(email)) {
      String userName = parts[0];
      String domain = parts[1];
      String[] nameParts = userName.split("\\.");

      if (nameParts.length == 2) {
        String firstName = nameParts[0];
        String lastName = nameParts[1];
        String pseudo = userName;
        String nomdomaine = domain;
        Contact newcontact = new Contact(firstName, lastName, email, pseudo, nomdomaine, user);
        user.getContacts().add(newcontact);
        contactRepo.save(newcontact);
        userRepo.save(user);
      } else {
        String firstname = userName;
        Contact newContact = new Contact(userName, "", email, userName, domain, user);
        user.getContacts().add(newContact);
        contactRepo.save(newContact);
        userRepo.save(user);
      }
    } else {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "bad format");
    }
  }

  //Fonction qui permet de savoir si un contact existe déja dans la base de données ou non.
  public boolean contactAlreadyExist(String pseudo, UserInfo currentUser) {
    for (Contact contact : currentUser.getContacts()) {
      if (contact.getPseudo().equals(pseudo)) {
        return true;
      }
    }
    return false;
  }

  //Fonction qui permet de supprimer un contact de la base de données.
  public void supprimerContact(long id, UserInfo user) {
    Optional<Contact> contactToDelete = contactRepo.findById(id);
    if (contactToDelete.isPresent()) {
      Contact contactNotNull = contactToDelete.get();
      user.getContacts().remove(contactNotNull);
      userRepo.save(user);
      contactRepo.delete(contactNotNull);
    }
  }

  //Fonction qui permet d'obtenir les informations sur un contact.
  public ContactInfoDTO getInfosContact(long id) {
    Optional<Contact> contact = contactRepo.findById(id);
    if (contact.isPresent()) {
      Contact contactNotNull = contact.get();
      ContactInfoDTO contactToSend = new ContactInfoDTO(contactNotNull.getFirstname(), contactNotNull.getLastname(), contactNotNull.getEmail(), contactNotNull.getPseudo(), contactNotNull.getPseudo(), contactNotNull.getId());
      return contactToSend;
    } else {
      return null;
    }
  }

  //Fonction qui permet de vérifier si une conversation existe déjà ou non.
  public boolean conversationAlreadyExist(String pseudo, UserInfo currentUser) {
    boolean doesConversationExist = false;
    for (MyConversation conversation : currentUser.getConversations()) {
      if (conversation.getContactPseudo().equals(pseudo)) {
        doesConversationExist = true;
        break;
      }
    }
    return doesConversationExist;
  }

  //Fonction qui permet de créer une conversation.
  public MyConversation createConversation(UserInfo currentUser, String contactpseudo) {
    Contact currentContact = null;
    for (Contact contact : currentUser.getContacts()) {
      if (contact.getPseudo().equals(contactpseudo)) {
        currentContact = contact;
      }
    }
    MyConversation newConversation = new MyConversation(currentContact.getPseudo(), currentContact.getAvatar(), currentUser);
    newConversation.setUserInfo(currentUser);
    conversationRepository.save(newConversation);
    currentUser.getConversations().add(newConversation);
    settingsService.updateBdd(currentUser);
    return newConversation;
  }

  //Fonction qui permet de supprimer un contact de la base de données.
  public void deleteContact(long id) {
    contactRepo.deleteById(id);
  }

  //Fonction qui permet d'enregistrer un contact dans la base de données.
  public void saveInBdd(Contact contactToSave) {
    contactRepo.save(contactToSave);
  }

  //Fonction qui permet de récupérer un contact de la base de données.
  public Contact getContactFromBdd(long id) {
    Optional<Contact> contactToReturn = contactRepo.findById(id);
    if (contactToReturn.isPresent()) {
      return contactToReturn.get();
    }
    return null;
  }


}
