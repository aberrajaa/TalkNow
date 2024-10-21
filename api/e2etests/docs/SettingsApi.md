# SettingsApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**profileSettingsGet**](SettingsApi.md#profileSettingsGet) | **GET** /profile/settings | Obtenir les informations de l&#39;utilisateur. |
| [**profileSettingsPut**](SettingsApi.md#profileSettingsPut) | **PUT** /profile/settings | Modifier les informations de l&#39;utilisateur. |
| [**userLoginDelete**](SettingsApi.md#userLoginDelete) | **DELETE** /user/{login} | Permet à l&#39;utilisateur de supprimer son compte. |


<a id="profileSettingsGet"></a>
# **profileSettingsGet**
> UserInfoDTO profileSettingsGet()

Obtenir les informations de l&#39;utilisateur.

dans la page des paramètres, on a besoin de récupérer les données d&#39;inscription de l&#39;utilisateur afin qu&#39;il puisse les voir et les modifier si il le souhaite.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SettingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    SettingsApi apiInstance = new SettingsApi(defaultClient);
    try {
      UserInfoDTO result = apiInstance.profileSettingsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SettingsApi#profileSettingsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UserInfoDTO**](UserInfoDTO.md)

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Les informations de l&#39;utilisateur ont bien été récupérées |  -  |
| **0** | Error |  -  |

<a id="profileSettingsPut"></a>
# **profileSettingsPut**
> String profileSettingsPut(updateInfoDTO)

Modifier les informations de l&#39;utilisateur.

L&#39;utilisateur peut modifier certaines informations à propos de son compte si il le souhaite.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SettingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    SettingsApi apiInstance = new SettingsApi(defaultClient);
    UpdateInfoDTO updateInfoDTO = new UpdateInfoDTO(); // UpdateInfoDTO | 
    try {
      String result = apiInstance.profileSettingsPut(updateInfoDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SettingsApi#profileSettingsPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **updateInfoDTO** | [**UpdateInfoDTO**](UpdateInfoDTO.md)|  | |

### Return type

**String**

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Les informations souhaitées ont bien été modifiées. |  -  |
| **0** | Error |  -  |

<a id="userLoginDelete"></a>
# **userLoginDelete**
> userLoginDelete(login)

Permet à l&#39;utilisateur de supprimer son compte.

Permet à l&#39;utilisateur actuellement connecté de supprimer son compte si il le souhaite, ceci le redirige vers la page de connexion avec son compte supprimé de la base de donnée.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SettingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    SettingsApi apiInstance = new SettingsApi(defaultClient);
    String login = "login_example"; // String | User's login of the account to delete
    try {
      apiInstance.userLoginDelete(login);
    } catch (ApiException e) {
      System.err.println("Exception when calling SettingsApi#userLoginDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **login** | **String**| User&#39;s login of the account to delete | |

### Return type

null (empty response body)

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Le profil de l&#39;utilisateur a bien été supprimé. |  -  |
| **0** | Error |  -  |

