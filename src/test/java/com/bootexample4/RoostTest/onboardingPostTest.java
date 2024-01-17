package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class onboardingPostTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(onboardingPostTest.class);

  @BeforeAll
  public static void setup() {
    RestAssured.baseURI = System.getenv("BASE_URL");
  }

  @Test
  public void onboarding_post_Test() {
    String csvFilePath = "src" + File.separator + "test" + File.separator + "java" + File.separator + "com"
        + File.separator
        + "bootexample4" + File.separator + "RoostTest" + File.separator + "onboardingPostTest.csv";

    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
      String headerLine = reader.readLine();
      String[] headers = headerLine.split(",");

      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");

        // Create a map of header to data
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
          map.put(headers[i], data[i]);
        }

        Response response = given()
            .contentType(ContentType.JSON)
            .queryParam("channel", map.getOrDefault("channel", ""))
            .queryParam("X-Trace-Id", map.getOrDefault("X-Trace-Id", ""))
            .queryParam("username", map.getOrDefault("username", ""))
            .when()
            .post("/order-service/orders/onboarding")
            .then()
            .extract().response();

        int statusCode = response.statusCode();
        LOGGER.info("Description: {}", response.getStatusLine());
        switch (statusCode) {
          case 201:
          case 400:
          case 401:
          case 403:
          case 405:
          case 409:
          case 422:
          case 500:
            if (response.jsonPath().get("code") != null) {
              MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));
            }

            if (response.jsonPath().get("message") != null) {
              MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));
            }

            if (response.jsonPath().get("status") != null) {
              MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));
            }

            if (statusCode == 422) {
              MatcherAssert.assertThat(response.jsonPath().getString("code"),
                  anyOf(equalTo("601"), equalTo("602"), equalTo("603"),
                      equalTo("604"), equalTo("605"), equalTo("606"), equalTo("607"), equalTo("608"), equalTo("424")));
            }
            break;

          default:
            LOGGER.error("Unhandled status code: {}", statusCode);
        }
      }
    } catch (IOException e) {
      LOGGER.error("IOException occurred: {}", e.getMessage(), e);
      fail("Failed to read CSV file");
    }
  }
}
