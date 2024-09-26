// Test generated by RoostGPT for test credentialwallet-rest-assured using AI Type Open AI and AI Model gpt-4-1106-preview

// Test generated for /authorizations_get for http method type GET in rest-assured framework

package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.*;

public class authorizationsGetTest {

  @Test
  public void authorizations_get_Test() {
    RestAssured.baseURI = "http://0.0.0.0:4012";

    // Read CSV file
    try (BufferedReader reader = new BufferedReader(
        new FileReader("src/test/java/com/bootexample4/RoostTest/authorizationsGetTest.csv"))) {
      String headerLine = reader.readLine();
      String[] headers = headerLine.split(",");

      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");

        // Create a map of header to data
        Map<String, String> map = new HashMap<>();
        map.put("API_KEY", "yash");
        for (int i = 0; i < headers.length; i++) {
          map.put(headers[i], data[i]);
        }

        Response response = given()
            .header("Token", map.get("API_KEY"))
            .when()
            .get("/authorizations")
            .then()
            .extract().response();

        int statusCode = response.statusCode();
        MatcherAssert.assertThat(statusCode, anyOf(is(200), is(400), is(401)));

        switch (statusCode) {
          case 200:
            System.out.println("Description: successful operation");
            List<Map<String, Object>> authorizations = response.jsonPath().getList("authorizations");
            MatcherAssert.assertThat(authorizations, not(empty()));

            authorizations.forEach(auth -> {
              System.out.println(auth);
              MatcherAssert.assertThat(auth.get("id"), instanceOf(String.class));
              MatcherAssert.assertThat(auth.get("name"), instanceOf(String.class));
              MatcherAssert.assertThat(auth.get("name").toString(), matchesPattern("^[\\p{L} .'-]{1,100}$"));
              MatcherAssert.assertThat(auth.get("email"), instanceOf(String.class));
              MatcherAssert.assertThat(auth.get("email").toString(), matchesPattern("^\\S+@\\S+\\.\\S+$"));
              MatcherAssert.assertThat(auth.get("createdAt"), instanceOf(String.class));
              MatcherAssert.assertThat(auth.get("updatedAt"), instanceOf(String.class));
            });
            break;

          case 400:
          case 401:
            System.out.println("Description: " + (statusCode == 400 ? "Bad Request" : "Authentication Required"));
            MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));
            MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));
            MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$"));
            MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(String.class));
            MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));
            MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));
            break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
