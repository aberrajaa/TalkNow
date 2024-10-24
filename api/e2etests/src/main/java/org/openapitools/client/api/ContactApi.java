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


import org.openapitools.client.model.AjoutContactDTO;
import org.openapitools.client.model.ContactInfoDTO;
import org.openapitools.client.model.ErrorDTO;
import org.openapitools.client.model.UpdateInfoDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ContactApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ContactApi(ApiClient apiClient) {
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
     * Build call for profileContactContactidDelete
     * @param contactid Contact&#39;s id (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le contact a été supprimé avec succès, on retourne la liste des contacts mise à jour </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactContactidDeleteCall(Long contactid, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/profile/contact/{contactid}"
            .replace("{" + "contactid" + "}", localVarApiClient.escapeString(contactid.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call profileContactContactidDeleteValidateBeforeCall(Long contactid, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'contactid' is set
        if (contactid == null) {
            throw new ApiException("Missing the required parameter 'contactid' when calling profileContactContactidDelete(Async)");
        }

        return profileContactContactidDeleteCall(contactid, _callback);

    }

    /**
     * Permet à l&#39;utilisateur de supprimer un de ses contacts.
     * Si l&#39;utilisateur ne souhaite plus avoir un contact donné, il dispose d&#39;une option pour le supprimer de sa base de données.
     * @param contactid Contact&#39;s id (required)
     * @return List&lt;ContactInfoDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le contact a été supprimé avec succès, on retourne la liste des contacts mise à jour </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public List<ContactInfoDTO> profileContactContactidDelete(Long contactid) throws ApiException {
        ApiResponse<List<ContactInfoDTO>> localVarResp = profileContactContactidDeleteWithHttpInfo(contactid);
        return localVarResp.getData();
    }

    /**
     * Permet à l&#39;utilisateur de supprimer un de ses contacts.
     * Si l&#39;utilisateur ne souhaite plus avoir un contact donné, il dispose d&#39;une option pour le supprimer de sa base de données.
     * @param contactid Contact&#39;s id (required)
     * @return ApiResponse&lt;List&lt;ContactInfoDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le contact a été supprimé avec succès, on retourne la liste des contacts mise à jour </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<ContactInfoDTO>> profileContactContactidDeleteWithHttpInfo(Long contactid) throws ApiException {
        okhttp3.Call localVarCall = profileContactContactidDeleteValidateBeforeCall(contactid, null);
        Type localVarReturnType = new TypeToken<List<ContactInfoDTO>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Permet à l&#39;utilisateur de supprimer un de ses contacts. (asynchronously)
     * Si l&#39;utilisateur ne souhaite plus avoir un contact donné, il dispose d&#39;une option pour le supprimer de sa base de données.
     * @param contactid Contact&#39;s id (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le contact a été supprimé avec succès, on retourne la liste des contacts mise à jour </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactContactidDeleteAsync(Long contactid, final ApiCallback<List<ContactInfoDTO>> _callback) throws ApiException {

        okhttp3.Call localVarCall = profileContactContactidDeleteValidateBeforeCall(contactid, _callback);
        Type localVarReturnType = new TypeToken<List<ContactInfoDTO>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for profileContactContactidPost
     * @param contactid Contact&#39;s id (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Conversation créée avec succès. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactContactidPostCall(Long contactid, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/profile/contact/{contactid}"
            .replace("{" + "contactid" + "}", localVarApiClient.escapeString(contactid.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call profileContactContactidPostValidateBeforeCall(Long contactid, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'contactid' is set
        if (contactid == null) {
            throw new ApiException("Missing the required parameter 'contactid' when calling profileContactContactidPost(Async)");
        }

        return profileContactContactidPostCall(contactid, _callback);

    }

    /**
     * Permet à l&#39;utilisateur de créer une conversation avec un contact.
     * Si l&#39;utilisateur souhaite discuter avec un utilisateur pour la première fois, en appuyant sur le bouton une conversation se crée au niveau du home.
     * @param contactid Contact&#39;s id (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Conversation créée avec succès. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public void profileContactContactidPost(Long contactid) throws ApiException {
        profileContactContactidPostWithHttpInfo(contactid);
    }

    /**
     * Permet à l&#39;utilisateur de créer une conversation avec un contact.
     * Si l&#39;utilisateur souhaite discuter avec un utilisateur pour la première fois, en appuyant sur le bouton une conversation se crée au niveau du home.
     * @param contactid Contact&#39;s id (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Conversation créée avec succès. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> profileContactContactidPostWithHttpInfo(Long contactid) throws ApiException {
        okhttp3.Call localVarCall = profileContactContactidPostValidateBeforeCall(contactid, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Permet à l&#39;utilisateur de créer une conversation avec un contact. (asynchronously)
     * Si l&#39;utilisateur souhaite discuter avec un utilisateur pour la première fois, en appuyant sur le bouton une conversation se crée au niveau du home.
     * @param contactid Contact&#39;s id (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Conversation créée avec succès. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactContactidPostAsync(Long contactid, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = profileContactContactidPostValidateBeforeCall(contactid, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for profileContactContactidPut
     * @param contactid Contact&#39;s id (required)
     * @param updateInfoDTO  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le contact a été modifié avec succès, on retourne la liste des contacts mise à jour </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactContactidPutCall(Long contactid, UpdateInfoDTO updateInfoDTO, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = updateInfoDTO;

        // create path and map variables
        String localVarPath = "/profile/contact/{contactid}"
            .replace("{" + "contactid" + "}", localVarApiClient.escapeString(contactid.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call profileContactContactidPutValidateBeforeCall(Long contactid, UpdateInfoDTO updateInfoDTO, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'contactid' is set
        if (contactid == null) {
            throw new ApiException("Missing the required parameter 'contactid' when calling profileContactContactidPut(Async)");
        }

        // verify the required parameter 'updateInfoDTO' is set
        if (updateInfoDTO == null) {
            throw new ApiException("Missing the required parameter 'updateInfoDTO' when calling profileContactContactidPut(Async)");
        }

        return profileContactContactidPutCall(contactid, updateInfoDTO, _callback);

    }

    /**
     * Permet à l&#39;utilisateur de modifier des informations sur le contact souhaité.
     * Si l&#39;utilisateur souhaite renommé un de ses contacts, il peut effectué ceci, ainsi que modifier l&#39;avatar du contact.
     * @param contactid Contact&#39;s id (required)
     * @param updateInfoDTO  (required)
     * @return List&lt;ContactInfoDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le contact a été modifié avec succès, on retourne la liste des contacts mise à jour </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public List<ContactInfoDTO> profileContactContactidPut(Long contactid, UpdateInfoDTO updateInfoDTO) throws ApiException {
        ApiResponse<List<ContactInfoDTO>> localVarResp = profileContactContactidPutWithHttpInfo(contactid, updateInfoDTO);
        return localVarResp.getData();
    }

    /**
     * Permet à l&#39;utilisateur de modifier des informations sur le contact souhaité.
     * Si l&#39;utilisateur souhaite renommé un de ses contacts, il peut effectué ceci, ainsi que modifier l&#39;avatar du contact.
     * @param contactid Contact&#39;s id (required)
     * @param updateInfoDTO  (required)
     * @return ApiResponse&lt;List&lt;ContactInfoDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le contact a été modifié avec succès, on retourne la liste des contacts mise à jour </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<ContactInfoDTO>> profileContactContactidPutWithHttpInfo(Long contactid, UpdateInfoDTO updateInfoDTO) throws ApiException {
        okhttp3.Call localVarCall = profileContactContactidPutValidateBeforeCall(contactid, updateInfoDTO, null);
        Type localVarReturnType = new TypeToken<List<ContactInfoDTO>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Permet à l&#39;utilisateur de modifier des informations sur le contact souhaité. (asynchronously)
     * Si l&#39;utilisateur souhaite renommé un de ses contacts, il peut effectué ceci, ainsi que modifier l&#39;avatar du contact.
     * @param contactid Contact&#39;s id (required)
     * @param updateInfoDTO  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le contact a été modifié avec succès, on retourne la liste des contacts mise à jour </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactContactidPutAsync(Long contactid, UpdateInfoDTO updateInfoDTO, final ApiCallback<List<ContactInfoDTO>> _callback) throws ApiException {

        okhttp3.Call localVarCall = profileContactContactidPutValidateBeforeCall(contactid, updateInfoDTO, _callback);
        Type localVarReturnType = new TypeToken<List<ContactInfoDTO>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for profileContactGet
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les contacts ont bien été récupérés. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactGetCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/profile/contact";

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
    private okhttp3.Call profileContactGetValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return profileContactGetCall(_callback);

    }

    /**
     * Obtenir la liste de tous ses contacts
     * 
     * @return List&lt;ContactInfoDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les contacts ont bien été récupérés. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public List<ContactInfoDTO> profileContactGet() throws ApiException {
        ApiResponse<List<ContactInfoDTO>> localVarResp = profileContactGetWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Obtenir la liste de tous ses contacts
     * 
     * @return ApiResponse&lt;List&lt;ContactInfoDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les contacts ont bien été récupérés. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<ContactInfoDTO>> profileContactGetWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = profileContactGetValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<List<ContactInfoDTO>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Obtenir la liste de tous ses contacts (asynchronously)
     * 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les contacts ont bien été récupérés. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactGetAsync(final ApiCallback<List<ContactInfoDTO>> _callback) throws ApiException {

        okhttp3.Call localVarCall = profileContactGetValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<List<ContactInfoDTO>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for profileContactPost
     * @param ajoutContactDTO  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contact créé avec succès et on renvoie tous les champs de contacts remplis avec un avatar par défaut et un login qu&#39;on déduit de l&#39;adresse e-mail. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactPostCall(AjoutContactDTO ajoutContactDTO, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = ajoutContactDTO;

        // create path and map variables
        String localVarPath = "/profile/contact";

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
    private okhttp3.Call profileContactPostValidateBeforeCall(AjoutContactDTO ajoutContactDTO, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'ajoutContactDTO' is set
        if (ajoutContactDTO == null) {
            throw new ApiException("Missing the required parameter 'ajoutContactDTO' when calling profileContactPost(Async)");
        }

        return profileContactPostCall(ajoutContactDTO, _callback);

    }

    /**
     * Permet à l&#39;utilisateur d&#39;ajouter un contact.
     * Si l&#39;utilisateur souhaite discuter avec un contact qui n&#39;existe pas encore dans sa base de données, il peut l&#39;ajouter.
     * @param ajoutContactDTO  (required)
     * @return List&lt;ContactInfoDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contact créé avec succès et on renvoie tous les champs de contacts remplis avec un avatar par défaut et un login qu&#39;on déduit de l&#39;adresse e-mail. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public List<ContactInfoDTO> profileContactPost(AjoutContactDTO ajoutContactDTO) throws ApiException {
        ApiResponse<List<ContactInfoDTO>> localVarResp = profileContactPostWithHttpInfo(ajoutContactDTO);
        return localVarResp.getData();
    }

    /**
     * Permet à l&#39;utilisateur d&#39;ajouter un contact.
     * Si l&#39;utilisateur souhaite discuter avec un contact qui n&#39;existe pas encore dans sa base de données, il peut l&#39;ajouter.
     * @param ajoutContactDTO  (required)
     * @return ApiResponse&lt;List&lt;ContactInfoDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contact créé avec succès et on renvoie tous les champs de contacts remplis avec un avatar par défaut et un login qu&#39;on déduit de l&#39;adresse e-mail. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<ContactInfoDTO>> profileContactPostWithHttpInfo(AjoutContactDTO ajoutContactDTO) throws ApiException {
        okhttp3.Call localVarCall = profileContactPostValidateBeforeCall(ajoutContactDTO, null);
        Type localVarReturnType = new TypeToken<List<ContactInfoDTO>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Permet à l&#39;utilisateur d&#39;ajouter un contact. (asynchronously)
     * Si l&#39;utilisateur souhaite discuter avec un contact qui n&#39;existe pas encore dans sa base de données, il peut l&#39;ajouter.
     * @param ajoutContactDTO  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Contact créé avec succès et on renvoie tous les champs de contacts remplis avec un avatar par défaut et un login qu&#39;on déduit de l&#39;adresse e-mail. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileContactPostAsync(AjoutContactDTO ajoutContactDTO, final ApiCallback<List<ContactInfoDTO>> _callback) throws ApiException {

        okhttp3.Call localVarCall = profileContactPostValidateBeforeCall(ajoutContactDTO, _callback);
        Type localVarReturnType = new TypeToken<List<ContactInfoDTO>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
