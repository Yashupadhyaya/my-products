// Test generated by RoostGPT for test test-postman using AI Type Open AI and AI Model gpt-4-1106-preview


// Test generated for /grants_get for http method type GET in rest-assured framework


// RoostTestHash=692c6b853f


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

public class grantsGetTest {
  
    @Test  
    public void grants_get_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/grantsGetTest.csv"))) {  
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
				.header("Token", System.getenv("API_KEY"))
                .when()
                .get("/grants")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
    
              if (response.jsonPath().get("total") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("total"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("grants") != null) {    
                for (int i = 0; i < response.jsonPath().getList("grants").size(); i++) {    
              if (response.jsonPath().get("grants["+ i +"].id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].id"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("grants["+ i +"].token") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("grants["+ i +"].token"), matchesPattern("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].token"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("grants["+ i +"].createdAt") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].createdAt"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("grants["+ i +"].updatedAt") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].updatedAt"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("grants["+ i +"].account") != null) {    
              if (response.jsonPath().get("grants["+ i +"].account.id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].account.id"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("grants["+ i +"].account.name") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("grants["+ i +"].account.name"), matchesPattern("^[\p{L} .'-]{1,100}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].account.name"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("grants["+ i +"].account.image") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].account.image"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("grants["+ i +"].account.email") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("grants["+ i +"].account.email"), matchesPattern("^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$")); 

                MatcherAssert.assertThat(response.jsonPath().get("grants["+ i +"].account.email"), instanceOf(String.class));MatcherAssert.assertThat(
                  response.jsonPath().getString("grants["+ i +"].account.email"),
                  Matchers.matchesPattern("^[^\s@]+@[^\s@]+\.[^\s@]+$")
                ); 
  
          }
  
          }
    
                  }  
                MatcherAssert.assertThat(response.jsonPath().getList("grants"), instanceOf(List.class));
  
          }
				}
if (response.statusCode() == 401) {
					System.out.println("Description: Authentication Required");
    
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
