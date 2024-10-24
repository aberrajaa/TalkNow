# openapi-java-client

Talknow API
- API version: 0.0.1

This is a prototype of Talknow Project's front/back API.



*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>0.0.1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'openapi-java-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'openapi-java-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "org.openapitools:openapi-java-client:0.0.1"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-0.0.1.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    AuthenticationApi apiInstance = new AuthenticationApi(defaultClient);
    UserDTO userDTO = new UserDTO(); // UserDTO | 
    try {
      String result = apiInstance.userSigninPost(userDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#userSigninPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AuthenticationApi* | [**userSigninPost**](docs/AuthenticationApi.md#userSigninPost) | **POST** /user/signin | Permet à un utilisateur déjà inscrit de se connecter.
*AuthenticationApi* | [**userSignoutPost**](docs/AuthenticationApi.md#userSignoutPost) | **POST** /user/signout | Permet à l&#39;utilisateur de se déconnecter.
*AuthenticationApi* | [**userSignupPost**](docs/AuthenticationApi.md#userSignupPost) | **POST** /user/signup | Permet à l&#39;utilisateur de s&#39;inscrire à l&#39;application.
*AuthenticationApi* | [**userUsernameGet**](docs/AuthenticationApi.md#userUsernameGet) | **GET** /user/username | Obtenir le nom d&#39;utilisateur
*ContactApi* | [**profileContactContactidDelete**](docs/ContactApi.md#profileContactContactidDelete) | **DELETE** /profile/contact/{contactid} | Permet à l&#39;utilisateur de supprimer un de ses contacts.
*ContactApi* | [**profileContactContactidPost**](docs/ContactApi.md#profileContactContactidPost) | **POST** /profile/contact/{contactid} | Permet à l&#39;utilisateur de créer une conversation avec un contact.
*ContactApi* | [**profileContactContactidPut**](docs/ContactApi.md#profileContactContactidPut) | **PUT** /profile/contact/{contactid} | Permet à l&#39;utilisateur de modifier des informations sur le contact souhaité.
*ContactApi* | [**profileContactGet**](docs/ContactApi.md#profileContactGet) | **GET** /profile/contact | Obtenir la liste de tous ses contacts
*ContactApi* | [**profileContactPost**](docs/ContactApi.md#profileContactPost) | **POST** /profile/contact | Permet à l&#39;utilisateur d&#39;ajouter un contact.
*HomeApi* | [**profileAccueilGet**](docs/HomeApi.md#profileAccueilGet) | **GET** /profile/accueil | Permet de récupérer le prénom et l&#39;avatar de l&#39;utilisateur connecté.
*HomeApi* | [**profileConversationsConversationidDelete**](docs/HomeApi.md#profileConversationsConversationidDelete) | **DELETE** /profile/conversations/{conversationid} | Permet à l&#39;utilisateur de supprimer une conversation.
*HomeApi* | [**profileConversationsGet**](docs/HomeApi.md#profileConversationsGet) | **GET** /profile/conversations | Obtenir la liste des conversations.
*MessageApi* | [**messageConversationidPost**](docs/MessageApi.md#messageConversationidPost) | **POST** /message/{conversationid} | Permet à l&#39;utilisateur d&#39;ajouter un message à une conversation.
*MessageApi* | [**messageGet**](docs/MessageApi.md#messageGet) | **GET** /message | Recevoir un nouveau message.
*MessageApi* | [**messagePost**](docs/MessageApi.md#messagePost) | **POST** /message | Envoyer un message.
*MessageApi* | [**messageToutsupprimerGet**](docs/MessageApi.md#messageToutsupprimerGet) | **GET** /message/toutsupprimer | Supprimer tous les messages.
*SettingsApi* | [**profileSettingsGet**](docs/SettingsApi.md#profileSettingsGet) | **GET** /profile/settings | Obtenir les informations de l&#39;utilisateur.
*SettingsApi* | [**profileSettingsPut**](docs/SettingsApi.md#profileSettingsPut) | **PUT** /profile/settings | Modifier les informations de l&#39;utilisateur.
*SettingsApi* | [**userLoginDelete**](docs/SettingsApi.md#userLoginDelete) | **DELETE** /user/{login} | Permet à l&#39;utilisateur de supprimer son compte.


## Documentation for Models

 - [AjoutContactDTO](docs/AjoutContactDTO.md)
 - [ContactInfoDTO](docs/ContactInfoDTO.md)
 - [ConversationDTO](docs/ConversationDTO.md)
 - [ErrorDTO](docs/ErrorDTO.md)
 - [MessageDTO](docs/MessageDTO.md)
 - [NewMessageDTO](docs/NewMessageDTO.md)
 - [UpdateInfoDTO](docs/UpdateInfoDTO.md)
 - [UserDTO](docs/UserDTO.md)
 - [UserHomeInfoDTO](docs/UserHomeInfoDTO.md)
 - [UserInfoDTO](docs/UserInfoDTO.md)
 - [UserInscriptionDTO](docs/UserInscriptionDTO.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="CookieAuth"></a>
### CookieAuth

- **Type**: API key
- **API key parameter name**: JSESSIONID
- **Location**: 


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



