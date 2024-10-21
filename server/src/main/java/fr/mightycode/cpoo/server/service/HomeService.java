package fr.mightycode.cpoo.server.service;

import fr.mightycode.cpoo.server.dto.MessageDTO;
import fr.mightycode.cpoo.server.dto.UserHomeInfoDTO;
import fr.mightycode.cpoo.server.entity.MyConversation;
import fr.mightycode.cpoo.server.entity.UserInfo;
import fr.mightycode.cpoo.server.model.Message;
import fr.mightycode.cpoo.server.repository.ContactRepository;
import fr.mightycode.cpoo.server.repository.MyConversationRepository;
import fr.mightycode.cpoo.server.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HomeService {
  @Autowired
  private ContactRepository contactRepo;
  @Autowired
  private MyConversationRepository conversationRepo;
  @Autowired
  private UserInfoRepository userRepo;

  // Méthode pour obtenir des informations sur un utilisateur
  public UserHomeInfoDTO getInfoUser(String username) {
    UserInfo userToGet = userRepo.findByLogin(username); // Recherche de l'utilisateur par son nom d'utilisateur
    UserHomeInfoDTO userToSend = new UserHomeInfoDTO(userToGet.getFirstName(), userToGet.getAvatar()); // Création d'un DTO avec les informations de l'utilisateur
    return userToSend; // Renvoie les informations de l'utilisateur
  }

  // Méthode pour transformer une liste de messages en liste de DTO de messages
  public ArrayList<MessageDTO> transformListMessageInListMessageDTO(MyConversation conversation) {
    ArrayList<MessageDTO> messagesToSend = new ArrayList<>();
    for (Message message : conversation.getMyMessages()) {
      MessageDTO messageToTransform = new MessageDTO(message); // Transformation d'un message en DTO de message
      messagesToSend.add(messageToTransform); // Ajout du DTO à la liste
    }
    return messagesToSend; // Renvoie la liste de DTO de messages
  }

  // Méthode pour supprimer une conversation
  public void deleteConversation(long id) {
    conversationRepo.deleteById(id); // Suppression de la conversation par son identifiant
  }

}
