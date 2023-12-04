// Test generated by RoostGPT for test Koreai-restassured using AI Type Open AI and AI Model gpt-4-1106-preview

// Test generated for /resetPassword_post for http method type POST in rest-assured framework

// RoostTestHash=79c3f016d8

package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResetPasswordPostTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = System.getenv("BASE_URL");
    }

    @Test
    public void resetPasswordPostTest() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/resetPassword_post.csv"))) {
            String headerLine = reader.readLine();
            String[] headers = headerLine.split(",");

            String line;
            while ((line = reader.readLine()) != null) {
                Map<String, String> dataMap = createDataMap(headers, line.split(","));

                Response response = given()
                        .contentType(ContentType.JSON)
                        .body(createRequestBody(dataMap))
                        .post("/resetPassword")
                        .then()
                        .extract()
                        .response();

                validateResponse(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> createDataMap(String[] headers, String[] data) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            map.put(headers[i], data[i]);
        }
        return map;
    }

    private String createRequestBody(Map<String, String> dataMap) {
        return "{\n" +
                "  \"username\": \"" + dataMap.get("username") + "\",\n" +
                "  \"password\": \"" + dataMap.get("password") + "\"\n" +
                "}";
    }

    private void validateResponse(Response response) {
        switch (response.statusCode()) {
            case 200:
                System.out.println("Description: Password has been updated successfully.");
                break;
            case 400:
                validateErrorResponse(response, "Description: Bad Request.");
                break;
            case 401:
                System.out.println("Description: Authorization failed.");
                validateErrorResponse(response, "Description: Authorization failed.");
                break;
            case 404:
                validateNotFoundResponse(response, "Description: Not Found.");
                break;
            case 422:
                validateUnprocessableEntityResponse(response, "Description: Unprocessable Entity.");
                break;
            default:
                System.out.println("Description: An unexpected error occurred.");
        }
    }

    private void validateErrorResponse(Response response, String description) {
        System.out.println(description);
        assertThat(response.jsonPath().getString("error"), notNullValue());
        assertThat(response.jsonPath().getString("error.message"), instanceOf(String.class));
    }

    private void validateNotFoundResponse(Response response, String description) {
        System.out.println(description);
        assertThat(response.jsonPath().getString("error"), equalTo("Not Found"));
    }

    private void validateUnprocessableEntityResponse(Response response, String description) {
        System.out.println(description);
        assertThat(response.jsonPath().getList("errors"), not(empty()));
        assertThat(response.jsonPath().getString("message"), containsString("Validation failed"));
    }
}
