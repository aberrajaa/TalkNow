package fr.mightycode.cpoo.server.controller;

import fr.mightycode.cpoo.server.dto.UpdateInfoDTO;
import fr.mightycode.cpoo.server.dto.UserInfoDTO;
import fr.mightycode.cpoo.server.entity.UserInfo;
import fr.mightycode.cpoo.server.service.SettingsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("profile")
@RequiredArgsConstructor
public class SettingsController {
  private final PasswordEncoder passwordEncoder;
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
  @GetMapping(value = "settings")
  public UserInfoDTO getUserInfo(HttpSession session) {
    String username = getCurrentUsername(); // Obtient le nom d'utilisateur actuel
    UserInfo user = settingsService.getInformations(username); // Appel de la méthode getInformations du service SettingsService
    UserInfoDTO userToSend = new UserInfoDTO(user.getLogin(), user.getPassword(), user.getFirstName(), user.getSecondName(), user.getAdress(), user.getBirthdayDate(), user.getAvatar()); // Crée un DTO UserInfoDTO avec les informations de l'utilisateur
    return userToSend; // Renvoie les informations de l'utilisateur
  }

  // Endpoint pour mettre à jour les informations de l'utilisateur
  @PutMapping(value = "settings")
  public ResponseEntity<String> updateUserInfo(@RequestBody UpdateInfoDTO updateRequest) {
    String type = updateRequest.getType(); // Obtient le type de mise à jour (ex: "password", "firstname", "lastname", "avatar")
    String value = updateRequest.getValue(); // Obtient la nouvelle valeur à mettre à jour
    String username = getCurrentUsername(); // Obtient le nom d'utilisateur actuel
    UserInfo user = settingsService.getInformations(username); // Appel de la méthode getInformations du service SettingsService pour obtenir les informations de l'utilisateur
    switch (type) {
      case "password": // Si le type de mise à jour est "password"
        user.setPassword(passwordEncoder.encode(value)); // Encode et met à jour le mot de passe de l'utilisateur
        settingsService.updateBdd(user); // Appel de la méthode updateBdd du service SettingsService pour mettre à jour la base de données
        break;
      case "firstname": // Si le type de mise à jour est "firstname"
        user.setFirstName(value); // Met à jour le prénom de l'utilisateur
        settingsService.updateBdd(user); // Appel de la méthode updateBdd du service SettingsService pour mettre à jour la base de données
        break;
      case "lastname": // Si le type de mise à jour est "lastname"
        user.setSecondName(value); // Met à jour le nom de famille de l'utilisateur
        settingsService.updateBdd(user); // Appel de la méthode updateBdd du service SettingsService pour mettre à jour la base de données
        break;
      case "avatar": // Si le type de mise à jour est "avatar"
        user.setAvatar(value); // Met à jour l'avatar de l'utilisateur
        settingsService.updateBdd(user); // Appel de la méthode updateBdd du service SettingsService pour mettre à jour la base de données
        break;
    }
    return ResponseEntity.ok(type + " mis à jour avec succès"); // Renvoie une réponse HTTP OK avec le type de mise à jour mis à jour avec succès
  }
}





