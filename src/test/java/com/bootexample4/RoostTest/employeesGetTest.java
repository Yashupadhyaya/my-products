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

public class employeesGetTest {

    private String getUrl() {
        return "http://example.com"; // replace with actual URL fetching logic
    }
  
    @Test  
    public void employees_get_Test() {  
        RestAssured.baseURI = getUrl();  
  
        try (BufferedReader reader = new BufferedReader(new FileReader("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "employeesGetTest.csv"))) {  
            String headerLine = reader.readLine();  
            String[] headers = headerLine.split(",");  
  
            String line;  
            while ((line = reader.readLine()) != null) {  
                String[] data = line.split(",");  
                Map<String, String> map = new HashMap<>();  
                for (int i = 0; i < headers.length; i++) {  
                    map.put(headers[i], data[i]);  
                }  
                
                Response response = given()
				.pathParam("searchString", map.get("searchString") != null ? map.get("searchString") : "")
                .when()
                .get("/employees")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: Search results matching the filter criteria");
    
                    if (response.jsonPath().get("id") != null) {
                        MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
                    }
    
                    if (response.jsonPath().get("jobTitle") != null) {
                        MatcherAssert.assertThat(response.jsonPath().get("jobTitle"), instanceOf(String.class));  
                    }
    
                    if (response.jsonPath().get("name") != null) {
                        MatcherAssert.assertThat(response.jsonPath().get("name"), instanceOf(String.class));  
                    }
    
                    if (response.jsonPath().get("email") != null) {
                        MatcherAssert.assertThat(response.jsonPath().get("email"), instanceOf(String.class));  
                    }
                }
                if (response.statusCode() == 400) {
                    System.out.println("Description: Bad input");
                }
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
