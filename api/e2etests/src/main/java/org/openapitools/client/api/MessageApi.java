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

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.openapitools.client.model.ErrorDTO;
import org.openapitools.client.model.MessageDTO;
import org.openapitools.client.model.NewMessageDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public MessageApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MessageApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for messageConversationidPost
     * @param conversationid Id of the conversation of the messages to retrieve (required)
     * @param newMessageDTO  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Ajout du message à la liste de messages avec le contact et retour de la liste des messages </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call messageConversationidPostCall(Long conversationid, NewMessageDTO newMessageDTO, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = newMessageDTO;

        // create path and map variables
        String localVarPath = "/message/{conversationid}"
            .replace("{" + "conversationid" + "}", localVarApiClient.escapeString(conversationid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call messageConversationidPostValidateBeforeCall(Long conversationid, NewMessageDTO newMessageDTO, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'conversationid' is set
        if (conversationid == null) {
            throw new ApiException("Missing the required parameter 'conversationid' when calling messageConversationidPost(Async)");
        }

        // verify the required parameter 'newMessageDTO' is set
        if (newMessageDTO == null) {
            throw new ApiException("Missing the required parameter 'newMessageDTO' when calling messageConversationidPost(Async)");
        }

        return messageConversationidPostCall(conversationid, newMessageDTO, _callback);

    }

    /**
     * Permet à l&#39;utilisateur d&#39;ajouter un message à une conversation.
     * 
     * @param conversationid Id of the conversation of the messages to retrieve (required)
     * @param newMessageDTO  (required)
     * @return List&lt;MessageDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Ajout du message à la liste de messages avec le contact et retour de la liste des messages </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public List<MessageDTO> messageConversationidPost(Long conversationid, NewMessageDTO newMessageDTO) throws ApiException {
        ApiResponse<List<MessageDTO>> localVarResp = messageConversationidPostWithHttpInfo(conversationid, newMessageDTO);
        return localVarResp.getData();
    }

    /**
     * Permet à l&#39;utilisateur d&#39;ajouter un message à une conversation.
     * 
     * @param conversationid Id of the conversation of the messages to retrieve (required)
     * @param newMessageDTO  (required)
     * @return ApiResponse&lt;List&lt;MessageDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Ajout du message à la liste de messages avec le contact et retour de la liste des messages </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<MessageDTO>> messageConversationidPostWithHttpInfo(Long conversationid, NewMessageDTO newMessageDTO) throws ApiException {
        okhttp3.Call localVarCall = messageConversationidPostValidateBeforeCall(conversationid, newMessageDTO, null);
        Type localVarReturnType = new TypeToken<List<MessageDTO>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Permet à l&#39;utilisateur d&#39;ajouter un message à une conversation. (asynchronously)
     * 
     * @param conversationid Id of the conversation of the messages to retrieve (required)
     * @param newMessageDTO  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Ajout du message à la liste de messages avec le contact et retour de la liste des messages </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call messageConversationidPostAsync(Long conversationid, NewMessageDTO newMessageDTO, final ApiCallback<List<MessageDTO>> _callback) throws ApiException {

        okhttp3.Call localVarCall = messageConversationidPostValidateBeforeCall(conversationid, newMessageDTO, _callback);
        Type localVarReturnType = new TypeToken<List<MessageDTO>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for messageGet
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le message a bien été récupéré. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call messageGetCall(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/message";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call messageGetValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return messageGetCall(_callback);

    }

    /**
     * Recevoir un nouveau message.
     * C&#39;est ici ou on fait de l&#39;attente active, on fait une requête Get pour récupérer de nouveaux messages.
     * @return MessageDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le message a bien été récupéré. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public MessageDTO messageGet() throws ApiException {
        ApiResponse<MessageDTO> localVarResp = messageGetWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Recevoir un nouveau message.
     * C&#39;est ici ou on fait de l&#39;attente active, on fait une requête Get pour récupérer de nouveaux messages.
     * @return ApiResponse&lt;MessageDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le message a bien été récupéré. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<MessageDTO> messageGetWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = messageGetValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<MessageDTO>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Recevoir un nouveau message. (asynchronously)
     * C&#39;est ici ou on fait de l&#39;attente active, on fait une requête Get pour récupérer de nouveaux messages.
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le message a bien été récupéré. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call messageGetAsync(final ApiCallback<MessageDTO> _callback) throws ApiException {

        okhttp3.Call localVarCall = messageGetValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<MessageDTO>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for messagePost
     * @param newMessageDTO  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le message a bien été envoyé, on retourne la liste des messages (màj). </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call messagePostCall(NewMessageDTO newMessageDTO, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = newMessageDTO;

        // create path and map variables
        String localVarPath = "/message";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call messagePostValidateBeforeCall(NewMessageDTO newMessageDTO, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'newMessageDTO' is set
        if (newMessageDTO == null) {
            throw new ApiException("Missing the required parameter 'newMessageDTO' when calling messagePost(Async)");
        }

        return messagePostCall(newMessageDTO, _callback);

    }

    /**
     * Envoyer un message.
     * 
     * @param newMessageDTO  (required)
     * @return List&lt;MessageDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le message a bien été envoyé, on retourne la liste des messages (màj). </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public List<MessageDTO> messagePost(NewMessageDTO newMessageDTO) throws ApiException {
        ApiResponse<List<MessageDTO>> localVarResp = messagePostWithHttpInfo(newMessageDTO);
        return localVarResp.getData();
    }

    /**
     * Envoyer un message.
     * 
     * @param newMessageDTO  (required)
     * @return ApiResponse&lt;List&lt;MessageDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le message a bien été envoyé, on retourne la liste des messages (màj). </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<MessageDTO>> messagePostWithHttpInfo(NewMessageDTO newMessageDTO) throws ApiException {
        okhttp3.Call localVarCall = messagePostValidateBeforeCall(newMessageDTO, null);
        Type localVarReturnType = new TypeToken<List<MessageDTO>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Envoyer un message. (asynchronously)
     * 
     * @param newMessageDTO  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le message a bien été envoyé, on retourne la liste des messages (màj). </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call messagePostAsync(NewMessageDTO newMessageDTO, final ApiCallback<List<MessageDTO>> _callback) throws ApiException {

        okhttp3.Call localVarCall = messagePostValidateBeforeCall(newMessageDTO, _callback);
        Type localVarReturnType = new TypeToken<List<MessageDTO>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for messageToutsupprimerGet
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Messages bien supprimés. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call messageToutsupprimerGetCall(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/message/toutsupprimer";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call messageToutsupprimerGetValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return messageToutsupprimerGetCall(_callback);

    }

    /**
     * Supprimer tous les messages.
     * 
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Messages bien supprimés. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public void messageToutsupprimerGet() throws ApiException {
        messageToutsupprimerGetWithHttpInfo();
    }

    /**
     * Supprimer tous les messages.
     * 
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Messages bien supprimés. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> messageToutsupprimerGetWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = messageToutsupprimerGetValidateBeforeCall(null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Supprimer tous les messages. (asynchronously)
     * 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Messages bien supprimés. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call messageToutsupprimerGetAsync(final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = messageToutsupprimerGetValidateBeforeCall(_callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
}
