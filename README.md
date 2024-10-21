# INFO4 CPOO project

This is the base project your team **MUST** FORK to implement its version of the instant messaging app.

## Server

The server is a Spring Boot app that should ne located in the /server directory.
 An embryo allowing to receive an send messages to other domains is provided.

## Client

The client is an Angular Web app that should be located in the /client directory.

## Comment tester la messagerie :

Pour pouvoir envoyer un message à un utilisateur il faut d'abord l'ajouter en contact. Pour ajouter un contact il faut cliquer sur l'icône "Contact" (personnage) puis cliquer sur le "+". Cela crée un champ où entrer l'adresse valide (i.e, format : pseudo@nom_app) du contact. Le contact se crée et apparaît dans la liste de contacts avec ses infos... Une nouvelle fois un "+" permet de créer une conversation vide avec ce contact en cliquant dessus. La conversation créée apparaît dans la liste de conversations au niveau de la page "Home" (cliquer sur l'icône "maison" pour s'y rendre). Il est maintenant possible d'envoyer un message au contact.

### Chiffrement des messages :

Pour les conversations entre utilisateurs de l'application Talknow, les messages sont chiffrés/déchiffrés à l'aide d'une clé (AES 128bits) générée au lancement du serveur. Cela rend les messages illisibles pour toute personne qui se connecte sur le routeur. Cependant, la clé étant générée au lancement du serveur, le chiffrement n'est pas fonctionnel si chacun des deux utilisateurs d'une conversation lance le serveur de son côté. Il est opérationnel si les utilisateurs communiquent via l'application déployée en ligne. Pour le tester il suffit de décommenter dans la classe "MessageController", dans les méthodes "post" et "get" un bloc "if" (et commenter une ligne, cela est précisé en commentaires dans le code).

## Mockups

The static mockups of the UI (images, HTML files...) should be deliveed in the /client/mockups directory.

The "actionable" version of the mockups should be delivered in the /client directory.
It is recommanded but not mandatory to deliver this "actionable" version the first version of the Angular app.

## Router

The message router used by your server to send and receive messages. It is deployed at https://cpoo-router.mightycode.tech/

**This code is provided for information, you don't actually need it to implement your the project.**
