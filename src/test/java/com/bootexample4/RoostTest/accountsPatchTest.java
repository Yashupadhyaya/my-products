// Test generated by RoostGPT for test test-Koreai using AI Type Azure Open AI and AI Model roost-gpt4-32k


// Test generated for /accounts_patch for http method type PATCH in rest-assured framework


// RoostTestHash=2758affb7e


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

public class accountsPatchTest {
  
    @Test  
    public void accounts_patch_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/accountsPatchTest.csv"))) {  
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
					"  \"email\": \"" + (map.get("email") != null ? map.get("email") : "") + "\n" +
 				"}")
                .when()
                .patch("/accounts")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Bad Request");
    
              if (response.jsonPath().get("error") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("description") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("error") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$")); 

                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("description") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("value") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(undefined.class));  
          }
    
              if (response.jsonPath().get("field") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("schema_field") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));  
          }
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
