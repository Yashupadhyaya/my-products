// ********RoostGPT********
/*
Test generated by RoostGPT for test test-postman1 using AI Type Open AI and AI Model gpt-4-1106-preview

Test generated for /order-service/orders/onboarding_post for http method type POST in rest-assured framework

RoostTestHash=2762b233e6


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class onboardingPostTest {
  
    @Test  
    public void onboardingPost_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "onboardingPostTest.csv"))) {  
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
				.pathParam("channel", map.get("channel") != null ? map.get("channel") : "")
				.pathParam("X-Trace-Id", map.get("X-Trace-Id") != null ? map.get("X-Trace-Id") : "")
				.pathParam("username", map.get("username") != null ? map.get("username") : "")
                .when()
                .post("/order-service/orders/onboarding")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 201) {
					System.out.println("Description: Created");
    
              if (response.jsonPath().get("orderId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("orderId"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("requestId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("requestId"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Bad Request");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 401) {
					System.out.println("Description: Unauthorized");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 403) {
					System.out.println("Description: Forbidden");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 405) {
					System.out.println("Description: Method Not allowed");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 409) {
					System.out.println("Description: Conflict");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 422) {
					System.out.println("Description: Unprocessable Entity");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("code"), anyOf(equalTo("601"), equalTo("602"), equalTo("603"), equalTo("604"), equalTo("605"), equalTo("606"), equalTo("607"), equalTo("608"), equalTo("424")));
  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 500) {
					System.out.println("Description: Internal Server Error");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
