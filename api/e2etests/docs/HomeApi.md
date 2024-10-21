# HomeApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**profileAccueilGet**](HomeApi.md#profileAccueilGet) | **GET** /profile/accueil | Permet de récupérer le prénom et l&#39;avatar de l&#39;utilisateur connecté. |
| [**profileConversationsConversationidDelete**](HomeApi.md#profileConversationsConversationidDelete) | **DELETE** /profile/conversations/{conversationid} | Permet à l&#39;utilisateur de supprimer une conversation. |
| [**profileConversationsGet**](HomeApi.md#profileConversationsGet) | **GET** /profile/conversations | Obtenir la liste des conversations. |


<a id="profileAccueilGet"></a>
# **profileAccueilGet**
> UserHomeInfoDTO profileAccueilGet()

Permet de récupérer le prénom et l&#39;avatar de l&#39;utilisateur connecté.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.HomeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    HomeApi apiInstance = new HomeApi(defaultClient);
    try {
      UserHomeInfoDTO result = apiInstance.profileAccueilGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HomeApi#profileAccueilGet");
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

[**UserHomeInfoDTO**](UserHomeInfoDTO.md)

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | L&#39;avatar et le prénom ont bien été récupérés. |  -  |
| **0** | Error |  -  |

<a id="profileConversationsConversationidDelete"></a>
# **profileConversationsConversationidDelete**
> profileConversationsConversationidDelete(conversationid)

Permet à l&#39;utilisateur de supprimer une conversation.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.HomeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    HomeApi apiInstance = new HomeApi(defaultClient);
    Long conversationid = 56L; // Long | Id of the conversation to delete
    try {
      apiInstance.profileConversationsConversationidDelete(conversationid);
    } catch (ApiException e) {
      System.err.println("Exception when calling HomeApi#profileConversationsConversationidDelete");
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
| **conversationid** | **Long**| Id of the conversation to delete | |

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
| **200** | La conversation a bien été supprimée. |  -  |
| **0** | Error |  -  |

<a id="profileConversationsGet"></a>
# **profileConversationsGet**
> List&lt;ConversationDTO&gt; profileConversationsGet()

Obtenir la liste des conversations.

Permet à l&#39;utilisateur de récupérer toutes ses conversations.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.HomeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    HomeApi apiInstance = new HomeApi(defaultClient);
    try {
      List<ConversationDTO> result = apiInstance.profileConversationsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HomeApi#profileConversationsGet");
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

[**List&lt;ConversationDTO&gt;**](ConversationDTO.md)

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Les conversations ont bien été récupérées. |  -  |
| **0** | Error |  -  |

