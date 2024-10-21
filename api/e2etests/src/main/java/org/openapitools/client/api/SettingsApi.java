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
import org.openapitools.client.model.UpdateInfoDTO;
import org.openapitools.client.model.UserInfoDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingsApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public SettingsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SettingsApi(ApiClient apiClient) {
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
     * Build call for profileSettingsGet
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les informations de l&#39;utilisateur ont bien été récupérées </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileSettingsGetCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/profile/settings";

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
    private okhttp3.Call profileSettingsGetValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return profileSettingsGetCall(_callback);

    }

    /**
     * Obtenir les informations de l&#39;utilisateur.
     * dans la page des paramètres, on a besoin de récupérer les données d&#39;inscription de l&#39;utilisateur afin qu&#39;il puisse les voir et les modifier si il le souhaite.
     * @return UserInfoDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les informations de l&#39;utilisateur ont bien été récupérées </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public UserInfoDTO profileSettingsGet() throws ApiException {
        ApiResponse<UserInfoDTO> localVarResp = profileSettingsGetWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Obtenir les informations de l&#39;utilisateur.
     * dans la page des paramètres, on a besoin de récupérer les données d&#39;inscription de l&#39;utilisateur afin qu&#39;il puisse les voir et les modifier si il le souhaite.
     * @return ApiResponse&lt;UserInfoDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les informations de l&#39;utilisateur ont bien été récupérées </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserInfoDTO> profileSettingsGetWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = profileSettingsGetValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<UserInfoDTO>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Obtenir les informations de l&#39;utilisateur. (asynchronously)
     * dans la page des paramètres, on a besoin de récupérer les données d&#39;inscription de l&#39;utilisateur afin qu&#39;il puisse les voir et les modifier si il le souhaite.
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les informations de l&#39;utilisateur ont bien été récupérées </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileSettingsGetAsync(final ApiCallback<UserInfoDTO> _callback) throws ApiException {

        okhttp3.Call localVarCall = profileSettingsGetValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<UserInfoDTO>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for profileSettingsPut
     * @param updateInfoDTO  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les informations souhaitées ont bien été modifiées. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileSettingsPutCall(UpdateInfoDTO updateInfoDTO, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/profile/settings";

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
    private okhttp3.Call profileSettingsPutValidateBeforeCall(UpdateInfoDTO updateInfoDTO, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'updateInfoDTO' is set
        if (updateInfoDTO == null) {
            throw new ApiException("Missing the required parameter 'updateInfoDTO' when calling profileSettingsPut(Async)");
        }

        return profileSettingsPutCall(updateInfoDTO, _callback);

    }

    /**
     * Modifier les informations de l&#39;utilisateur.
     * L&#39;utilisateur peut modifier certaines informations à propos de son compte si il le souhaite.
     * @param updateInfoDTO  (required)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les informations souhaitées ont bien été modifiées. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public String profileSettingsPut(UpdateInfoDTO updateInfoDTO) throws ApiException {
        ApiResponse<String> localVarResp = profileSettingsPutWithHttpInfo(updateInfoDTO);
        return localVarResp.getData();
    }

    /**
     * Modifier les informations de l&#39;utilisateur.
     * L&#39;utilisateur peut modifier certaines informations à propos de son compte si il le souhaite.
     * @param updateInfoDTO  (required)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les informations souhaitées ont bien été modifiées. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<String> profileSettingsPutWithHttpInfo(UpdateInfoDTO updateInfoDTO) throws ApiException {
        okhttp3.Call localVarCall = profileSettingsPutValidateBeforeCall(updateInfoDTO, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Modifier les informations de l&#39;utilisateur. (asynchronously)
     * L&#39;utilisateur peut modifier certaines informations à propos de son compte si il le souhaite.
     * @param updateInfoDTO  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Les informations souhaitées ont bien été modifiées. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call profileSettingsPutAsync(UpdateInfoDTO updateInfoDTO, final ApiCallback<String> _callback) throws ApiException {

        okhttp3.Call localVarCall = profileSettingsPutValidateBeforeCall(updateInfoDTO, _callback);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userLoginDelete
     * @param login User&#39;s login of the account to delete (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le profil de l&#39;utilisateur a bien été supprimé. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userLoginDeleteCall(String login, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/user/{login}"
            .replace("{" + "login" + "}", localVarApiClient.escapeString(login.toString()));

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
    private okhttp3.Call userLoginDeleteValidateBeforeCall(String login, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new ApiException("Missing the required parameter 'login' when calling userLoginDelete(Async)");
        }

        return userLoginDeleteCall(login, _callback);

    }

    /**
     * Permet à l&#39;utilisateur de supprimer son compte.
     * Permet à l&#39;utilisateur actuellement connecté de supprimer son compte si il le souhaite, ceci le redirige vers la page de connexion avec son compte supprimé de la base de donnée.
     * @param login User&#39;s login of the account to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le profil de l&#39;utilisateur a bien été supprimé. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public void userLoginDelete(String login) throws ApiException {
        userLoginDeleteWithHttpInfo(login);
    }

    /**
     * Permet à l&#39;utilisateur de supprimer son compte.
     * Permet à l&#39;utilisateur actuellement connecté de supprimer son compte si il le souhaite, ceci le redirige vers la page de connexion avec son compte supprimé de la base de donnée.
     * @param login User&#39;s login of the account to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le profil de l&#39;utilisateur a bien été supprimé. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> userLoginDeleteWithHttpInfo(String login) throws ApiException {
        okhttp3.Call localVarCall = userLoginDeleteValidateBeforeCall(login, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Permet à l&#39;utilisateur de supprimer son compte. (asynchronously)
     * Permet à l&#39;utilisateur actuellement connecté de supprimer son compte si il le souhaite, ceci le redirige vers la page de connexion avec son compte supprimé de la base de donnée.
     * @param login User&#39;s login of the account to delete (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Le profil de l&#39;utilisateur a bien été supprimé. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call userLoginDeleteAsync(String login, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = userLoginDeleteValidateBeforeCall(login, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
}