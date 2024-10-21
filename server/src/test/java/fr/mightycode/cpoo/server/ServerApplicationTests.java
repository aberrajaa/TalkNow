package fr.mightycode.cpoo.server;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWebTestClient
class ServerApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private WebTestClient webClient;

  @Test
  void testSignUpSignInSignOut() throws Exception {

    mvc.perform(post("/user/signup")
        .contentType(APPLICATION_JSON)
        .content("""
          {
            "login": "admin.admin",
            "password": "admin",
            "firstname": "admin",
            "secondname": "admin",
            "address": "admin.admin@talknow",
            "date": "2023-11-29"
          }"""))
      .andExpect(status().isOk());

    // Signing up a non-existing account should succeed
    mvc.perform(post("/user/signup")
        .contentType(APPLICATION_JSON)
        .content("""
          {
            "login": "test.test",
            "password": "test",
            "firstname": "test",
            "secondname": "test",
            "address": "test.test@talknow",
            "date": "2023-11-29"
          }"""))
      .andExpect(status().isOk());

    // Signing up an existing account should fail with CONFLICT
    mvc.perform(post("/user/signup")
        .contentType(APPLICATION_JSON)
        .content("""
          {
            "login": "test.test",
            "password": "test",
            "firstname": "test",
            "secondname": "test",
            "address": "test.test@talknow",
            "date": "2023-11-29"
          }"""))
      .andExpect(status().isConflict());

    mvc.perform(delete("/user/test.test"));


    // Signing in with invalid credentials should fail with UNAUTHORIZED
    webClient.post()
      .uri("/user/signin")
      .contentType(APPLICATION_JSON)
      .bodyValue("""
        {
          "login": "admin.admin",
          "password": "invalid"
        }""")
      .exchange()
      .expectStatus().isUnauthorized();

    // Signing in a fresh account should succeed
    webClient.post()
      .uri("/user/signin")
      .contentType(APPLICATION_JSON)
      .bodyValue("""
        {
          "login": "admin.admin",
          "password": "admin"
        }""")
      .exchange()
      .expectStatus().isOk();

    mvc.perform(delete("/user/admin.admin"));

  }
}
