// Test generated by RoostGPT for test Koreai-restassured using AI Type Open AI and AI Model gpt-4-1106-preview

// Test generated for /TransferFunds_post for http method type POST in rest-assured framework

// RoostTestHash=289ed66c26

package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TransferFundsPostTest {

    @Test
    public void TransferFunds_post_Test() {
        RestAssured.baseURI = System.getenv("BASE_URL");

        // Read CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/TransferFunds_post.csv"))) {
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
                    .pathParam("koreUserId", map.get("koreUserId"))
                    .pathParam("botId", map.get("botId"))
                    .pathParam("userCode", map.get("userCode"))
                    .pathParam("accountId", map.get("accountId"))
                    .header("Authorization", map.get("Authorization"))
                    .contentType(ContentType.JSON)
                    .body(map)
                    .when()
                    .post("/TransferFunds")
                    .then()
                    .extract().response();

                switch (response.statusCode()) {
                    case 200:
                        validateSuccessResponse(response);
                        break;
                    case 400:
                        validateErrorResponse(response);
                        break;
                    case 401:
                        validateUnauthorisedResponse(response);
                        break;
                    case 404:
                        validateNotFoundResponse(response);
                        break;
                    case 422:
                        validateUnprocessableEntityResponse(response);
                        break;
                    default:
                        fail("Unexpected status code: " + response.statusCode());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateSuccessResponse(Response response) {
        assertThat("Transaction success", response.statusCode(), equalTo(200));
        // Add more validations as required based on the success response structure
    }

    private void validateErrorResponse(Response response) {
        assertThat("Error: Bad Request", response.statusCode(), equalTo(400));
        assertThat(response.jsonPath().get("err.message"), instanceOf(String.class));
        // Add more validations as required based on the error response structure
    }

    private void validateUnauthorisedResponse(Response response) {
        assertThat("Error: Authorisation failed.", response.statusCode(), equalTo(401));
        assertThat(response.jsonPath().get("err.message"), instanceOf(String.class));
        // Add more validations as required based on the unauthorised response structure
    }

    private void validateNotFoundResponse(Response response) {
        assertThat("Error: Not Found", response.statusCode(), equalTo(404));
        assertThat(response.jsonPath().get("err.message"), instanceOf(String.class));
        // Add more validations as required based on the not found response structure
    }

    private void validateUnprocessableEntityResponse(Response response) {
        assertThat("Error: Unprocessable Entity", response.statusCode(), equalTo(422));
        assertThat(response.jsonPath().get("err.message"), instanceOf(String.class));
        // Add more validations as required based on the unprocessable entity response structure
    }
}
