// Test generated by RoostGPT for test test-Koreai using AI Type Azure Open AI and AI Model roost-gpt4-32k


// Test generated for /GetScheduleTransfers_post for http method type POST in rest-assured framework


// RoostTestHash=7b4d2d87f9


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

public class GetScheduleTransfersPostTest {
  
    @Test  
    public void GetScheduleTransfers_post_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/GetScheduleTransfersPostTest.csv"))) {  
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
				.pathParam("koreUserId", map.get("koreUserId") != null ? map.get("koreUserId") : "")
				.pathParam("botId", map.get("botId") != null ? map.get("botId") : "")
				.pathParam("userCode", map.get("userCode") != null ? map.get("userCode") : "")
				.pathParam("accountId", map.get("accountId") != null ? map.get("accountId") : "")
				.pathParam("Authorization", map.get("Authorization") != null ? map.get("Authorization") : "")
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"customerId\": \" + (map.get("customerId") != null ? map.get("customerId") : "") + \"+ "\",\n" +
					"  \"status\": \" + (map.get("status") != null ? map.get("status") : "") + \"+ "\n" +
 				"}")
                .when()
                .post("/GetScheduleTransfers")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: schedule transfer list response");
    
              if (response.jsonPath().get("Type") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("Type"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("CustomerId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("CustomerId"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("Amount") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("Amount"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("SourceAccountNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("SourceAccountNumber"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("TargetAccountNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("TargetAccountNumber"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("DueDate") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("DueDate"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("InvoiceNumber") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("InvoiceNumber"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("Currency") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("Currency"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("Status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("Status"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("ScheduledDate") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("ScheduledDate"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("NextScheduleDate") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("NextScheduleDate"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
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
