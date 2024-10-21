# AuthenticationApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**userSigninPost**](AuthenticationApi.md#userSigninPost) | **POST** /user/signin | Permet à un utilisateur déjà inscrit de se connecter. |
| [**userSignoutPost**](AuthenticationApi.md#userSignoutPost) | **POST** /user/signout | Permet à l&#39;utilisateur de se déconnecter. |
| [**userSignupPost**](AuthenticationApi.md#userSignupPost) | **POST** /user/signup | Permet à l&#39;utilisateur de s&#39;inscrire à l&#39;application. |
| [**userUsernameGet**](AuthenticationApi.md#userUsernameGet) | **GET** /user/username | Obtenir le nom d&#39;utilisateur |


<a id="userSigninPost"></a>
# **userSigninPost**
> String userSigninPost(userDTO)

Permet à un utilisateur déjà inscrit de se connecter.

L&#39;utilisateur effectue une requête de type POST afin de fournir son login et mot de passe, côté serveur on vérifie si le login et de mot de passe reçu est présent dans la base de données.

### Example
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

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userDTO** | [**UserDTO**](UserDTO.md)|  | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Authentification réussie. |  -  |
| **0** | Error |  -  |

<a id="userSignoutPost"></a>
# **userSignoutPost**
> userSignoutPost()

Permet à l&#39;utilisateur de se déconnecter.

L&#39;utilisateur n&#39;a pas besoin d&#39;envoyer de contenu dans le requête POST, mais cette route lui permet ainsi de se déconnecter

### Example
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
    try {
      apiInstance.userSignoutPost();
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#userSignoutPost");
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Déconnexion réussie. |  -  |
| **0** | Error |  -  |

<a id="userSignupPost"></a>
# **userSignupPost**
> userSignupPost(userInscriptionDTO)

Permet à l&#39;utilisateur de s&#39;inscrire à l&#39;application.

L&#39;utilisateur effectue une requête de type POST afin de fournir sous format JSON les informations suivantes, login, password, first name, second name, birthday date.

### Example
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
    UserInscriptionDTO userInscriptionDTO = new UserInscriptionDTO(); // UserInscriptionDTO | 
    try {
      apiInstance.userSignupPost(userInscriptionDTO);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#userSignupPost");
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
| **userInscriptionDTO** | [**UserInscriptionDTO**](UserInscriptionDTO.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Inscription réussie |  -  |
| **0** | Error |  -  |

<a id="userUsernameGet"></a>
# **userUsernameGet**
> String userUsernameGet()

Obtenir le nom d&#39;utilisateur

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");
    
    // Configure API key authorization: CookieAuth
    ApiKeyAuth CookieAuth = (ApiKeyAuth) defaultClient.getAuthentication("CookieAuth");
    CookieAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //CookieAuth.setApiKeyPrefix("Token");

    AuthenticationApi apiInstance = new AuthenticationApi(defaultClient);
    try {
      String result = apiInstance.userUsernameGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthenticationApi#userUsernameGet");
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

**String**

### Authorization

[CookieAuth](../README.md#CookieAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Récupération du nom d&#39;utilisateur réussie |  -  |
| **0** | Error |  -  |

