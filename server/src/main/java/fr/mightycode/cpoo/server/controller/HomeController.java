package fr.mightycode.cpoo.server.controller;

import fr.mightycode.cpoo.server.dto.ConversationDTO;
import fr.mightycode.cpoo.server.dto.MessageDTO;
import fr.mightycode.cpoo.server.dto.UserHomeInfoDTO;
import fr.mightycode.cpoo.server.entity.MyConversation;
import fr.mightycode.cpoo.server.entity.UserInfo;
import fr.mightycode.cpoo.server.service.HomeService;
import fr.mightycode.cpoo.server.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("profile")
@RequiredArgsConstructor
public class HomeController {

  @Autowired
  private HomeService homeservice;

  @Autowired
  private SettingsService settingsService;

  // Méthode pour obtenir le nom d'utilisateur actuel
  public String getCurrentUsername() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User user) {
      return user.getUsername();
    } else {
      return null;
    }
  }

  // Endpoint pour obtenir les informations de l'utilisateur
  @GetMapping(value = "accueil")
  public UserHomeInfoDTO getInfoUser() {
    String currentUsername = getCurrentUsername();
    UserHomeInfoDTO userToSend = homeservice.getInfoUser(currentUsername);
    return userToSend;
  }

  // Endpoint pour obtenir la liste des conversations de l'utilisateur
  @GetMapping(value = "conversations")
  public ArrayList<ConversationDTO> getConversationList() {
    String currentUsername = getCurrentUsername();
    UserInfo currentUser = settingsService.getInformations(currentUsername);
    ArrayList<ConversationDTO> conversationListToSend = new ArrayList<ConversationDTO>();

    // Parcours des conversations de l'utilisateur et transformation en ConversationDTO
    for (MyConversation conversation : currentUser.getConversations()) {
      ArrayList<MessageDTO> listMessageToSend = homeservice.transformListMessageInListMessageDTO(conversation);
      ConversationDTO conversationDTO = new ConversationDTO(conversation.getId(), conversation.getContactPseudo(), conversation.getContactAvatar(), conversation.getLastMessage(), conversation.getLastMessageDate(), listMessageToSend);
      conversationListToSend.add(conversationDTO);
    }
    return conversationListToSend;
  }

  // Endpoint pour supprimer une conversation
  @DeleteMapping(value = "conversations/{conversationid}")
  public void deleteConversation(@PathVariable long conversationid) {
    homeservice.deleteConversation(conversationid);
    String username = getCurrentUsername();
    UserInfo user = settingsService.getInformations(username);
  }
}
