// Test generated by RoostGPT for test test-Koreai using AI Type Vertex AI and AI Model code-bison-32k


// Test generated for /ccPay_post for http method type POST in rest-assured framework


// RoostTestHash=c6fa681866


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

public class ccPayPostTest {
  
    @Test  
    public void ccPay_post_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/ccPayPostTest.csv"))) {  
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
				.pathParam("accountId", map.get("accountId"))
				.pathParam("Authorization", map.get("Authorization"))
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"customerId\": \"" + map.get("customerId") + "\",\n" +
					"  \"amount\": \"" + map.get("amount") + "\",\n" +
					"  \"currency\": \"" + map.get("currency") + "\",\n" +
					"  \"sourceAccountId\": \"" + map.get("sourceAccountId") + "\",\n" +
					"  \"targetAccountId\": \"" + map.get("targetAccountId") + "\",\n" +
					"  \"transactionType\": \"" + map.get("transactionType") + "\",\n" +
					"  \"dueDate\": \"" + map.get("dueDate") + "\n" +
 				"}")
                .when()
                .post("/ccPay")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: Credit Card payment scheduled successfully");
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