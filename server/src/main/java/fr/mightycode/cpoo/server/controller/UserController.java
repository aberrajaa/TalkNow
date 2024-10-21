package fr.mightycode.cpoo.server.controller;

import fr.mightycode.cpoo.server.dto.UserDTO;
import fr.mightycode.cpoo.server.dto.UserInscriptionDTO;
import fr.mightycode.cpoo.server.repository.UserInfoRepository;
import fr.mightycode.cpoo.server.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  private final HttpServletRequest httpServletRequest;
  @Autowired
  private UserInfoRepository repository;

  // Endpoint pour l'inscription d'un utilisateur
  @PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, String>> signup(@RequestBody UserInscriptionDTO user) {

    String infos = userService.signup(user); // Appel de la méthode signup du service UserService
    if (infos.equals("exist")) { // Si l'utilisateur existe déjà
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Already exist"); // Renvoie une erreur 409 (CONFLICT)
    }
    if (infos.equals("signup")) { // Si l'inscription est réussie
      Map<String, String> response = new HashMap<>();
      response.put("message", "Connection Accepted"); // Crée une réponse avec un message "Connection Accepted"
      return ResponseEntity.ok(response); // Renvoie une réponse HTTP OK avec le message
    }
    if (infos.equals("bad motdepasse")) { // Si le mot de passe est invalide
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "mot de passe faux"); // Renvoie une erreur 401 (UNAUTHORIZED)
    }
    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "nom faux"); // Si le nom est invalide, renvoie une erreur 401 (UNAUTHORIZED)
  }

  // Endpoint pour la connexion d'un utilisateur
  @PostMapping(value = "signin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, String>> signin(@RequestBody final UserDTO user) {
    try {
      String information = userService.signin(user.login(), user.password()); // Appel de la méthode signin du service UserService
      if (information.equals("deja connecte")) { // Si l'utilisateur est déjà connecté
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Already signed in"); // Renvoie une erreur 409 (CONFLICT)
      }
      if (information.equals("connexion reussi")) { // Si la connexion est réussie
        Map<String, String> response = new HashMap<>();
        response.put("message", "Connection Accepted" + user.login()); // Crée une réponse avec un message "Connection Accepted"
        return ResponseEntity.ok(response); // Renvoie une réponse HTTP OK avec le message
      }
      if (information.equals("mot de passe incorrect")) { // Si le mot de passe est incorrect
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Bad credentials"); // Renvoie une erreur 401 (UNAUTHORIZED)
      }
      if (information.equals("connexion refuse")) { // Si la connexion est refusée
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Autre utilisateur actuellement connecte"); // Renvoie une erreur 401 (UNAUTHORIZED)
      }
    }
    catch (ServletException e) {
      throw new RuntimeException(e);
    }
    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not registered"); // Si l'utilisateur n'est pas enregistré, renvoie une erreur 401 (UNAUTHORIZED)
  }

  // Endpoint pour la déconnexion d'un utilisateur
  @PostMapping(value = "signout")
  public void signout() {
    try {
      userService.signout(); // Appel de la méthode signout du service UserService
    }
    catch (final ServletException ex) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex); // Renvoie une erreur 500 (INTERNAL_SERVER_ERROR) en cas d'erreur de serveur
    }
  }

  @DeleteMapping(value = "/{login}")
  public void delete(@PathVariable String login) {
    if (!userService.delete(login))
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
  }



}
