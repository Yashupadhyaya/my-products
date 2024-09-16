// Test generated by RoostGPT for test test-Koreai using AI Type Azure Open AI and AI Model roost-gpt4-32k


// Test generated for /locateProfile_post for http method type POST in rest-assured framework


// RoostTestHash=2b60fcac41


package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class locateProfilePostTest {
  
    @Test  
    public void locateProfile_post_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/locateProfilePostTest.csv"))) {  
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
				.body("{\n"+
					"  \"customerId\": \"" + map.get("customerId") + "\",\n" +
					"  \"ssNumber\": \"" + map.get("ssNumber") + "\",\n" +
					"  \"ssnShort\": \"" + map.get("ssnShort") + "\",\n" +
					"  \"accountNumber\": \"" + map.get("accountNumber") + "\n" +
 				"}")
                .when()
                .post("/locateProfile")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: success");
  
            if (response.jsonPath().get("accountNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("accountNumber"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("cardDetails") != null) {  
            if (response.jsonPath().get("cardDetails.cardNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("cardDetails.cardNumber"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("cardDetails.expiryDate") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("cardDetails.expiryDate"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("cardDetails.cvv") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("cardDetails.cvv"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("cardDetails.pin") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("cardDetails.pin"), instanceOf(String.class));  
          }
  
          }
  
            if (response.jsonPath().get("personalQuestions") != null) {  
            if (response.jsonPath().get("personalQuestions.DOB") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("personalQuestions.DOB"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("personalQuestions.SSN") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("personalQuestions.SSN"), instanceOf(Integer.class));  
          }
  
            if (response.jsonPath().get("personalQuestions.SecretPassword") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("personalQuestions.SecretPassword"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("personalQuestions.LDAmount") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("personalQuestions.LDAmount"), instanceOf(Integer.class));  
          }
  
            if (response.jsonPath().get("personalQuestions.AccNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("personalQuestions.AccNumber"), instanceOf(String.class));  
          }
  
          }
  
            if (response.jsonPath().get("ssNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("ssNumber"), instanceOf(Integer.class));  
          }
  
            if (response.jsonPath().get("ssnShort") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("ssnShort"), instanceOf(Integer.class));  
          }
  
            if (response.jsonPath().get("alternatePhoneNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("alternatePhoneNumber"), instanceOf(Integer.class));  
          }
  
            if (response.jsonPath().get("customerId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("customerId"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("email") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("email"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("identificationNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("identificationNumber"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("identificationType") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("identificationType"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("image") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("image"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("isAlternateMobileNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("isAlternateMobileNumber"), instanceOf(Boolean.class));  
          }
  
            if (response.jsonPath().get("isPrimaryMobileNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("isPrimaryMobileNumber"), instanceOf(Boolean.class));  
          }
  
            if (response.jsonPath().get("location") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("location"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("name") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("name"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("personalBanker") != null) {  
            if (response.jsonPath().get("personalBanker.name") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("personalBanker.name"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("personalBanker.email") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("personalBanker.email"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("personalBanker.mobileNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("personalBanker.mobileNumber"), instanceOf(String.class));  
          }
  
          }
  
            if (response.jsonPath().get("phone") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("phone"), instanceOf(Integer.class));  
          }
  
            if (response.jsonPath().get("securityQuestions") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getList("securityQuestions"), instanceOf(List.class));
  
          }
  
            if (response.jsonPath().get("segmentId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("segmentId"), instanceOf(Integer.class));  
          }
  
            if (response.jsonPath().get("userId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("userId"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 401) {
					System.out.println("Description: Error: Authorisation failed.");
  
            if (response.jsonPath().get("err") != null) {  
            if (response.jsonPath().get("err.message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("err.message"), instanceOf(String.class));  
          }
  
          }
				}
if (response.statusCode() == 404) {
					System.out.println("Description: Error: Not Found");
  
            if (response.jsonPath().get("err") != null) {  
            if (response.jsonPath().get("err.message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("err.message"), instanceOf(String.class));  
          }
  
          }
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
