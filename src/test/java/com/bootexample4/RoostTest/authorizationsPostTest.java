// Test generated by RoostGPT for test credential-register-rest-assured using AI Type Vertex AI and AI Model code-bison-32k


// Test generated for /authorizations_post for http method type POST in rest-assured framework


// RoostTestHash=ed8c1b7bff


package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
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
import static org.hamcrest.text.*;

public class authorizationsPostTest {
  
    @Test  
    public void authorizations_post_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/authorizationsPostTest.csv"))) {  
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
					"  \"email\": \"" + map.get("email") + "\n" +
 				"}")
                .when()
                .post("/authorizations")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 201) {
					System.out.println("Description: successful operation");
  
            if (response.jsonPath().get("id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("name") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("name"), matchesPattern("^[\p{L} .'-]{1,100}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("name"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("email") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("email"), matchesPattern("^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$")); 

                MatcherAssert.assertThat(response.jsonPath().get("email"), instanceOf(String.class));MatcherAssert.assertThat(
                  response.jsonPath().getString("email"),
                  Matchers.matchesPattern("^[^\s@]+@[^\s@]+\.[^\s@]+$")
                ); 
  
          }
  
            if (response.jsonPath().get("createdAt") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("createdAt"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("updatedAt") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("updatedAt"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Bad Request");
				}
if (response.statusCode() == 401) {
					System.out.println("Description: Authentication Required");
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
