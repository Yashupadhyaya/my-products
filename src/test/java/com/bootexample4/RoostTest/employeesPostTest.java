// Test generated by RoostGPT for test test-postman using AI Type Open AI and AI Model gpt-4-1106-preview


// Test generated for /employees_post for http method type POST in rest-assured framework


// RoostTestHash=b517afeac4


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

public class employeesPostTest {
  
    @Test  
    public void employees_post_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/employeesPostTest.csv"))) {  
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
					"  \"id\": \"" + (map.get("id") != null ? map.get("id") : "") + "\",\n" +
					"  \"jobTitle\": \"" + (map.get("jobTitle") != null ? map.get("jobTitle") : "") + "\",\n" +
					"  \"name\": \"" + (map.get("name") != null ? map.get("name") : "") + "\",\n" +
					"  \"email\": \"" + (map.get("email") != null ? map.get("email") : "") + "\n" +
 				"}")
                .when()
                .post("/employees")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 201) {
					System.out.println("Description: employee created");
				}
if (response.statusCode() == 400) {
					System.out.println("Description: invalid input, object invalid");
				}
if (response.statusCode() == 409) {
					System.out.println("Description: an existing employee already exists");
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
