// Test generated by RoostGPT for test credential-register-rest-assured using AI Type Azure Open AI and AI Model roost-gpt4-32k


// Test generated for /me_get for http method type GET in rest-assured framework


// RoostTestHash=ae6b8ce5ab


package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;

public class meGetTest {
  
    @Test  
    public void me_get_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/meGetTest.csv"))) {  
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
                .when()
                .get("/me")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
  
            if (response.jsonPath().get("id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("did") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("did"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("name") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("name"), CoreMatchers.matchesPattern(^[\p{L} .'-]{1,100}$)); 

                MatcherAssert.assertThat(response.jsonPath().get("name"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("image") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("image"), CoreMatchers.matchesPattern(^\w+:(\/?\/?)[^\s]+$)); 

                MatcherAssert.assertThat(response.jsonPath().get("image"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("email") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("email"), CoreMatchers.matchesPattern(^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$)); 

                MatcherAssert.assertThat(response.jsonPath().get("email"), instanceOf(String.class));
                MatcherAssert.assertThat(response.jsonPath().getString("email"),/^[^s@]+@[^s@]+.[^s@]+$/.test(
                  response.jsonPath().getString("email")
                )); 
  
          }
  
            if (response.jsonPath().get("settings") != null) {  
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
