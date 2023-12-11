// Test generated by RoostGPT for test test-Koreai using AI Type Vertex AI and AI Model code-bison-32k


// Test generated for /UpdateAccountInfo_put for http method type PUT in rest-assured framework


// RoostTestHash=adb57fbf1b


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

public class UpdateAccountInfoPutTest {
  
    @Test  
    public void UpdateAccountInfo_put_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/UpdateAccountInfoPutTest.csv"))) {  
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
				.pathParam("X-Auth-token", map.get("X-Auth-token"))
				.pathParam("X-CORRELATION-ID", map.get("X-CORRELATION-ID"))
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"accountNumber\": \"" + map.get("accountNumber") + "\",\n" +
					"  \"customerId\": \"" + map.get("customerId") + "\",\n" +
					"  \"email\": \"" + map.get("email") + "\",\n" +
					"  \"alternatePhoneNumber\": \"" + map.get("alternatePhoneNumber") + "\",\n" +
					"  \"isAlternateMobileNumber\": \"" + map.get("isAlternateMobileNumber") + "\",\n" +
					"  \"phone\": \"" + map.get("phone") + "\",\n" +
					"  \"isPrimaryMobileNumber\": \"" + map.get("isPrimaryMobileNumber") + "\",\n" +
					"  \"location\": \"" + map.get("location") + "\",\n" +
					"  \"isStatement\": \"" + map.get("isStatement") + "\n" +
 				"}")
                .when()
                .put("/UpdateAccountInfo")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
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
