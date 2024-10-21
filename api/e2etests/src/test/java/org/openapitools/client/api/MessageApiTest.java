/*
 * Talknow API
 * This is a prototype of Talknow Project's front/back API.
 *
 * The version of the OpenAPI document: 0.0.1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import okhttp3.OkHttpClient;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * API tests for MessageApi
 */

public class MessageApiTest {
    private final MessageApi messageApi = new MessageApi();

    private final ContactApi contactApi = new ContactApi();
    private final AuthenticationApi authenticationApi = new AuthenticationApi();
    private final HomeApi homeApi = new HomeApi();
    private final SettingsApi settingsApi = new SettingsApi();

    @BeforeEach
    public void init() throws ApiException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.cookieJar(new MyCookieJar()).build();
        ApiClient apiClient = new ApiClient(okHttpClient);
        authenticationApi.setApiClient(apiClient);
        settingsApi.setApiClient(apiClient);
        homeApi.setApiClient(apiClient);
        contactApi.setApiClient(apiClient);
        messageApi.setApiClient(apiClient);
    }

    /**
     * Permet à l&#39;utilisateur d&#39;ajouter un message à une conversation.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void messageConversationidPostTest() throws ApiException {
        UserInscriptionDTO inscription = new UserInscriptionDTO().login("xavi.hernandez").password("password").firstname("xavi").secondname("hernandez").address("xavi.hernandez@talknow").date(null);
        authenticationApi.userSignupPostWithHttpInfo(inscription);
        UserInscriptionDTO inscription2 = new UserInscriptionDTO().login("quentin.perez").password("password").firstname("quentin").secondname("perez").address("quentin.perez@talknow").date(null);
        authenticationApi.userSignupPostWithHttpInfo(inscription2);
        try {
            homeApi.profileConversationsGet();
            Assertions.fail();
        } catch (ApiException e) {
            assertEquals(HttpStatus.SC_FORBIDDEN, e.getCode());
        }
        authenticationApi.userSigninPost(new UserDTO().login("xavi.hernandez").password("password"));
        List<ContactInfoDTO> listofcontact = contactApi.profileContactPost(new AjoutContactDTO().email("quentin.perez@talknow"));
        ContactInfoDTO contactToCreateConversationWith = null;
        for (ContactInfoDTO contact : listofcontact) {
            if (contact.getPseudo().equals("quentin.perez")) {
                contactToCreateConversationWith = contact;
            }
        }
        contactApi.profileContactContactidPost(contactToCreateConversationWith.getId());
        List<ConversationDTO> listOfConversation = homeApi.profileConversationsGet();
        ConversationDTO conversationWithQuentin = null;
        for (ConversationDTO conversations : listOfConversation) {
            if (conversations.getContactPseudo().equals("quentin.perez")) {
                conversationWithQuentin = conversations;
            }
        }
        Long conversationid = conversationWithQuentin.getId();
        NewMessageDTO newMessageDTO = new NewMessageDTO().to(conversationWithQuentin.getContactPseudo()).type("string").body("Bonjour je suis jose");
        List<MessageDTO> response = messageApi.messageConversationidPost(conversationid, newMessageDTO);
        assertFalse(response.isEmpty());
        boolean messageExist = false;
        for (MessageDTO messageDTO : response) {
            if (messageDTO.getBody().equals("Bonjour je suis jose")) {
                messageExist = true;
                break;
            }
        }
        assertTrue(messageExist);//le message a bien été posté et il est présent dans la conversation
        authenticationApi.userSignoutPost();
        authenticationApi.userSigninPost(new UserDTO().login("quentin.perez").password("password"));
        messageApi.messageGet();
        List<ConversationDTO> listOfConversationOfQuentin = homeApi.profileConversationsGet();
        ConversationDTO conversationWithJose = null;
        boolean messageRecu = false;
        for (ConversationDTO conversationDTO : listOfConversationOfQuentin) {
            if (conversationDTO.getContactPseudo().equals("xavi.hernandez")) {
                conversationWithJose = conversationDTO;
            }
        }
        assertEquals(conversationWithJose.getLastMessage(), "Bonjour je suis jose");
        for (MessageDTO messagewithjose : conversationWithJose.getMyMessages()) {
            if (messagewithjose.getBody().equals("Bonjour je suis jose")) {
                messageRecu = true;
                assertEquals(messagewithjose.getFrom(), "xavi.hernandez@talknow");
                assertEquals(messagewithjose.getTo(), "quentin.perez@talknow");
                assertEquals(messagewithjose.getType(), "string");

            }
        }
        assertTrue(messageRecu);//quentin a bien recu le message de josé
        settingsApi.userLoginDelete("quentin.perez");
        settingsApi.userLoginDelete("xavi.hernandez");

    }

    /**
     * Recevoir un nouveau message.
     * <p>
     * C&#39;est ici ou on fait de l&#39;attente active, on fait une requête Get pour récupérer de nouveaux messages.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void messageGetTest() throws ApiException {
        UserInscriptionDTO inscription = new UserInscriptionDTO().login("luis.enrique").password("password").firstname("luis").secondname("enrique").address("luis.enrique@talknow").date(null);
        authenticationApi.userSignupPostWithHttpInfo(inscription);
        UserInscriptionDTO inscription2 = new UserInscriptionDTO().login("simone.inzaghi").password("password").firstname("simone").secondname("inzaghi").address("simone.inzaghi@talknow").date(null);
        authenticationApi.userSignupPostWithHttpInfo(inscription2);
        try {
            homeApi.profileConversationsGet();
            Assertions.fail();
        } catch (ApiException e) {
            assertEquals(HttpStatus.SC_FORBIDDEN, e.getCode());
        }
        authenticationApi.userSigninPost(new UserDTO().login("luis.enrique").password("password"));
        List<ContactInfoDTO> listofcontact = contactApi.profileContactPost(new AjoutContactDTO().email("simone.inzaghi@talknow"));
        ContactInfoDTO contactToCreateConversationWith = null;
        for (ContactInfoDTO contact : listofcontact) {
            if (contact.getPseudo().equals("simone.inzaghi")) {
                contactToCreateConversationWith = contact;
            }
        }
        contactApi.profileContactContactidPost(contactToCreateConversationWith.getId());
        List<ConversationDTO> listOfConversation = homeApi.profileConversationsGet();
        ConversationDTO conversationWithQuentin = null;
        for (ConversationDTO conversations : listOfConversation) {
            if (conversations.getContactPseudo().equals("simone.inzaghi")) {
                conversationWithQuentin = conversations;
            }
        }
        Long conversationid = conversationWithQuentin.getId();
        NewMessageDTO newMessageDTO = new NewMessageDTO().to(conversationWithQuentin.getContactPseudo()).type("string").body("On teste le get");
        List<MessageDTO> response = messageApi.messageConversationidPost(conversationid, newMessageDTO);
        assertFalse(response.isEmpty());
        boolean messageExist = false;
        for (MessageDTO messageDTO : response) {
            if (messageDTO.getBody().equals("On teste le get")) {
                messageExist = true;
                break;
            }
        }
        assertTrue(messageExist);//le message a bien été posté et il est présent dans la conversation

        authenticationApi.userSignoutPost();
        authenticationApi.userSigninPost(new UserDTO().login("simone.inzaghi").password("password"));
        messageApi.messageGet();
        List<ConversationDTO> listOfConversationOfQuentin = homeApi.profileConversationsGet();
        ConversationDTO conversationWithJose = null;
        boolean messageRecu = false;
        for (ConversationDTO conversationDTO : listOfConversationOfQuentin) {
            if (conversationDTO.getContactPseudo().equals("luis.enrique")) {
                conversationWithJose = conversationDTO;
            }
        }
        assertEquals(conversationWithJose.getLastMessage(), "On teste le get");
        for (MessageDTO messagewithjose : conversationWithJose.getMyMessages()) {
            if (messagewithjose.getBody().equals("On teste le get")) {
                messageRecu = true;
                assertEquals(messagewithjose.getFrom(), "luis.enrique@talknow");
                assertEquals(messagewithjose.getTo(), "simone.inzaghi@talknow");
                assertEquals(messagewithjose.getType(), "string");

            }
        }
        assertTrue(messageRecu);//quentin a bien recu le message de josé
        settingsApi.userLoginDelete("luis.enrique");
        settingsApi.userLoginDelete("simone.inzaghi");
    }
}
