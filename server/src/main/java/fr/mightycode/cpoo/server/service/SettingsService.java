package fr.mightycode.cpoo.server.service;

import fr.mightycode.cpoo.server.entity.UserInfo;
import fr.mightycode.cpoo.server.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {
  @Autowired
  private UserInfoRepository userRepo;

  // Méthode pour obtenir les informations d'un utilisateur
  public UserInfo getInformations(String login) {
    UserInfo user = userRepo.findByLogin(login); // Recherche de l'utilisateur par son nom d'utilisateur
    return user; // Renvoie les informations de l'utilisateur
  }

  // Méthode pour mettre à jour la base de données avec les informations d'un utilisateur
  public void updateBdd(UserInfo user) {
    userRepo.save(user); // Enregistrement des informations de l'utilisateur dans la base de données
  }

}
