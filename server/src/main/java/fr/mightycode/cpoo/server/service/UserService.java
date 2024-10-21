package fr.mightycode.cpoo.server.service;

import fr.mightycode.cpoo.server.dto.UserInscriptionDTO;
import fr.mightycode.cpoo.server.entity.UserInfo;
import fr.mightycode.cpoo.server.repository.UserInfoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
  private final PasswordEncoder passwordEncoder;

  private final UserDetailsManager userDetailsManager;

  private final UserInfoRepository customUserRepository;

  private final HttpServletRequest httpServletRequest;

  // Méthode pour l'inscription d'un utilisateur
  public String signup(UserInscriptionDTO user) {
    UserInfo c = customUserRepository.findByLogin(user.getLogin()); // Recherche de l'utilisateur par nom d'utilisateur
    if (c == null) { // Si l'utilisateur n'existe pas
      if (isValidEmail(user.getAddress()) && isValidName(user.getFirstname()) && isValidName(user.getSecondname()) && isValidPassword(user.getPassword())) {
        UserInfo customUser = new UserInfo(user.getLogin(), user.getPassword(), user.getFirstname(), user.getSecondname(), user.getAddress(), user.getDate());
        customUser.setPassword(passwordEncoder.encode(user.getPassword())); // Encodage du mot de passe
        customUserRepository.save(customUser); // Enregistrement de l'utilisateur dans le dépôt
        return "signup"; // Renvoie "signup" pour indiquer une inscription réussie
      } else {
        if (!isValidPassword(user.getPassword())) {
          return "bad motdepasse"; // Renvoie "bad motdepasse" pour indiquer un mot de passe invalide
        }
        if (!isValidName(user.getFirstname()) || !isValidName(user.getSecondname())) {
          return "bad name"; // Renvoie "bad name" pour indiquer un nom invalide
        }

      }
    }
    return "exist"; // Renvoie "exist" pour indiquer que l'utilisateur existe déjà
  }

  // Méthode pour valider une adresse e-mail
  public boolean isValidEmail(String email) {
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z]+$";
    return Pattern.compile(regex).matcher(email).matches();
  }

  // Méthode pour valider un nom (composé de lettres)
  public boolean isValidName(String name) {
    String regex = "^[A-Za-z]+$";
    return name != null && !name.isEmpty() && Pattern.compile(regex).matcher(name).matches();
  }

  // Méthode pour valider la longueur du mot de passe
  public boolean isValidPassword(String password) {
    return password.length() >= 4;
  }

  // Méthode pour la connexion d'un utilisateur
  public String signin(final String login, final String password) throws ServletException {
    UserInfo c = customUserRepository.findByLogin(login); // Recherche de l'utilisateur par nom d'utilisateur
    if (c == null) {
      return "utilisateur inexistant"; // Renvoie "utilisateur inexistant" si l'utilisateur n'existe pas
    }
    if (passwordEncoder.matches(password, c.getPassword())) { // Vérification du mot de passe
      final HttpSession session = httpServletRequest.getSession(false);
      if (session != null) {
        if (getCurrentUsername().equals(login)) {
          return "deja connecte"; // Renvoie "deja connecte" si l'utilisateur est déjà connecté
        } else {
          return "connexion refuse"; // Renvoie "connexion refuse" si la connexion est refusée
        }
      }
      if (!userDetailsManager.userExists(login)) {
        userDetailsManager.createUser(new User(login, c.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER"))));
      }
      httpServletRequest.login(login, password);
      httpServletRequest.getSession(true); // Crée une nouvelle session

      return "connexion reussi"; // Renvoie "connexion reussi" pour indiquer une connexion réussie
    }

    return "mot de passe incorrect"; // Renvoie "mot de passe incorrect" en cas de mot de passe incorrect
  }

  // Méthode pour la déconnexion de l'utilisateur
  public void signout() throws ServletException {
    User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    userDetailsManager.deleteUser(u.getUsername()); // Suppression de l'utilisateur
    httpServletRequest.logout(); // Déconnexion de la session
  }

  // Méthode pour supprimer un utilisateur
  public boolean delete(String login) {
    UserInfo userToDelete = customUserRepository.findByLogin(login);
    if (userToDelete != null) {
      customUserRepository.delete(userToDelete); // Suppression de l'utilisateur
      return true;
    }
    return false;
  }

  // Méthode pour obtenir le nom d'utilisateur de l'utilisateur connecté
  public String getUserLogin() {
    final HttpSession session = httpServletRequest.getSession(true);
    if (session != null)
      return null;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
      UserInfo c = customUserRepository.findByLogin(((UserDetails) principal).getUsername());
      return c.getLogin();
    } else {
      return "Principal is not an instance of CustomUserDetails";
    }
  }

  // Méthode pour obtenir le nom d'utilisateur de l'utilisateur connecté
  public String getUsername() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) {
      UserInfo c = customUserRepository.findByLogin(((UserDetails) principal).getUsername());
      return c.getLogin();
    } else {
      return "Principal is not an instance of CustomUserDetails";
    }
  }

  // Méthode pour obtenir le nom d'utilisateur de l'utilisateur connecté
  public String getCurrentUsername() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof User user) {
      return user.getUsername();
    } else {
      return null;
    }
  }
}
