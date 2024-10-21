# ContactApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**profileContactContactidDelete**](ContactApi.md#profileContactContactidDelete) | **DELETE** /profile/contact/{contactid} | Permet à l&#39;utilisateur de supprimer un de ses contacts. |
| [**profileContactContactidPost**](ContactApi.md#profileContactContactidPost) | **POST** /profile/contact/{contactid} | Permet à l&#39;utilisateur de créer une conversation avec un contact. |
| [**profileContactContactidPut**](ContactApi.md#profileContactContactidPut) | **PUT** /profile/contact/{contactid} | Permet à l&#39;utilisateur de modifier des informations sur le contact souhaité. |
| [**profileContactGet**](ContactApi.md#profileContactGet) | **GET** /profile/contact | Obtenir la liste de tous ses contacts |
| [**profileContactPost**](ContactApi.md#profileContactPost) | **POST** /profile/contact | Permet à l&#39;utilisateur d&#39;ajouter un contact. |


<a id="profileContactContactidDelete"></a>
# **profileContactContactidDelete**
> List&lt;ContactInfoDTO&gt; profileContactContactidDelete(contactid)

Permet à l&#39;utilisateur de supprimer un de ses contacts.

Si l&#39;utilisateur ne souhaite plus avoir un contact donné, il dispose d&#39;une option pour le supprimer de sa base de données.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContactApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    ContactApi apiInstance = new ContactApi(defaultClient);
    Long contactid = 56L; // Long | Contact's id
    try {
      List<ContactInfoDTO> result = apiInstance.profileContactContactidDelete(contactid);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContactApi#profileContactContactidDelete");
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
| **contactid** | **Long**| Contact&#39;s id | |

### Return type

[**List&lt;ContactInfoDTO&gt;**](ContactInfoDTO.md)

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Le contact a été supprimé avec succès, on retourne la liste des contacts mise à jour |  -  |
| **0** | Error |  -  |

<a id="profileContactContactidPost"></a>
# **profileContactContactidPost**
> profileContactContactidPost(contactid)

Permet à l&#39;utilisateur de créer une conversation avec un contact.

Si l&#39;utilisateur souhaite discuter avec un utilisateur pour la première fois, en appuyant sur le bouton une conversation se crée au niveau du home.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContactApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    ContactApi apiInstance = new ContactApi(defaultClient);
    Long contactid = 56L; // Long | Contact's id
    try {
      apiInstance.profileContactContactidPost(contactid);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContactApi#profileContactContactidPost");
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
| **contactid** | **Long**| Contact&#39;s id | |

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
| **200** | Conversation créée avec succès. |  -  |
| **0** | Error |  -  |

<a id="profileContactContactidPut"></a>
# **profileContactContactidPut**
> List&lt;ContactInfoDTO&gt; profileContactContactidPut(contactid, updateInfoDTO)

Permet à l&#39;utilisateur de modifier des informations sur le contact souhaité.

Si l&#39;utilisateur souhaite renommé un de ses contacts, il peut effectué ceci, ainsi que modifier l&#39;avatar du contact.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContactApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    ContactApi apiInstance = new ContactApi(defaultClient);
    Long contactid = 56L; // Long | Contact's id
    UpdateInfoDTO updateInfoDTO = new UpdateInfoDTO(); // UpdateInfoDTO | 
    try {
      List<ContactInfoDTO> result = apiInstance.profileContactContactidPut(contactid, updateInfoDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContactApi#profileContactContactidPut");
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
| **contactid** | **Long**| Contact&#39;s id | |
| **updateInfoDTO** | [**UpdateInfoDTO**](UpdateInfoDTO.md)|  | |

### Return type

[**List&lt;ContactInfoDTO&gt;**](ContactInfoDTO.md)

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Le contact a été modifié avec succès, on retourne la liste des contacts mise à jour |  -  |
| **0** | Error |  -  |

<a id="profileContactGet"></a>
# **profileContactGet**
> List&lt;ContactInfoDTO&gt; profileContactGet()

Obtenir la liste de tous ses contacts

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContactApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    ContactApi apiInstance = new ContactApi(defaultClient);
    try {
      List<ContactInfoDTO> result = apiInstance.profileContactGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContactApi#profileContactGet");
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

[**List&lt;ContactInfoDTO&gt;**](ContactInfoDTO.md)

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Les contacts ont bien été récupérés. |  -  |
| **0** | Error |  -  |

<a id="profileContactPost"></a>
# **profileContactPost**
> List&lt;ContactInfoDTO&gt; profileContactPost(ajoutContactDTO)

Permet à l&#39;utilisateur d&#39;ajouter un contact.

Si l&#39;utilisateur souhaite discuter avec un contact qui n&#39;existe pas encore dans sa base de données, il peut l&#39;ajouter.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContactApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    ContactApi apiInstance = new ContactApi(defaultClient);
    AjoutContactDTO ajoutContactDTO = new AjoutContactDTO(); // AjoutContactDTO | 
    try {
      List<ContactInfoDTO> result = apiInstance.profileContactPost(ajoutContactDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContactApi#profileContactPost");
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
| **ajoutContactDTO** | [**AjoutContactDTO**](AjoutContactDTO.md)|  | |

### Return type

[**List&lt;ContactInfoDTO&gt;**](ContactInfoDTO.md)

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Contact créé avec succès et on renvoie tous les champs de contacts remplis avec un avatar par défaut et un login qu&#39;on déduit de l&#39;adresse e-mail. |  -  |
| **0** | Error |  -  |

