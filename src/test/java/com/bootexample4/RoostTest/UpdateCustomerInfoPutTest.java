// Test generated by RoostGPT for test Koreai-restassured using AI Type Open AI and AI Model gpt-4-1106-preview

// Test generated for /UpdateCustomerInfo_put for http method type PUT in rest-assured framework

// RoostTestHash=89ddb90785

package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpdateCustomerInfoPutTest {
  
    @Before
    public void setUp() {
        RestAssured.baseURI = System.getenv("BASE_URL");
    }
  
    @Test  
    public void updateCustomerInfoPutTest() {    
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/UpdateCustomerInfo_put.csv"))) {  
            String headerLine = reader.readLine();  
            String[] headers = headerLine.split(",");  
  
            String line;  
            while ((line = reader.readLine()) != null) {
                Map<String, String> customerInfo = extractDataFromCSV(headers, line);  
                Response response = submitUpdateRequest(customerInfo);
                validateResponse(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

    private Map<String, String> extractDataFromCSV(String[] headers, String line) {
        String[] data = line.split(",");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            map.put(headers[i], data[i]);
        }
        return map;
    }

    private Response submitUpdateRequest(Map<String, String> customerInfo) {
        return given()
                .headers(extractHeaders(customerInfo))
                .contentType(ContentType.JSON)
                .body(extractBody(customerInfo))
                .when()
                .put("/UpdateCustomerInfo")  
                .then()
                .extract().response();
    }

    private Map<String, String> extractHeaders(Map<String, String> customerInfo) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", customerInfo.get("Authorization"));
        headers.put("X-Auth-token", customerInfo.get("X-Auth-token"));
        headers.put("X-CORRELATION-ID", customerInfo.get("X-CORRELATION-ID"));
        // Add other headers as needed
        return headers;
    }

    private String extractBody(Map<String, String> customerInfo) {
        return "{\n"
                + "  \"customerId\": \"" + customerInfo.get("customerId") + "\",\n"
                + "  \"email\": \"" + customerInfo.get("email") + "\",\n"
                + "  \"alternatePhoneNumber\": \"" + customerInfo.get("alternatePhoneNumber") + "\",\n"
                + "  \"isAlternateMobileNumber\": \"" + customerInfo.get("isAlternateMobileNumber") + "\",\n"
                + "  \"phone\": \"" + customerInfo.get("phone") + "\",\n"
                + "  \"isPrimaryMobileNumber\": \"" + customerInfo.get("isPrimaryMobileNumber") + "\",\n"
                + "  \"location\": \"" + customerInfo.get("location") + "\"\n"
                + "}";
    }

    private void validateResponse(Response response) {
        int statusCode = response.statusCode();
        switch (statusCode) {
            case 200:
                System.out.println("Description: successful operation");
                // Add success response assertions here, possibly checking some response body data
                break;
            case 400:
                validateErrorResponse(response.getBody().asString(), "Unprocessable Entity");
                break;
            case 401:
                System.out.println("Description: Error: Authorization failed.");
                validateErrorResponse(response.getBody().asString(), "Authorization failed");
                break;
            case 404:
                System.out.println("Description: Error: Not Found");
                validateNotFoundResponse(response.getBody().asString());
                break;
            // ... Add other cases for different status codes and call respective validate methods
        }
    }

    private void validateErrorResponse(String response, String expectedErrorMessage) {
        assertThat("Verify error message", response.contains(expectedErrorMessage), equalTo(true));
    }

    private void validateNotFoundResponse(String response) {
        // Specific assertions for a 404 Not Found response
    }

    // Implement other validation methods such as validateUnprocessableEntityResponse here

}

