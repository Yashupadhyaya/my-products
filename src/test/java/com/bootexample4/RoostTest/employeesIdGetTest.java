// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /employees/{id}_get for http method type GET in rest-assured framework

RoostTestHash=36bc161fb6


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class employeesIdGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/employees_idGetTest.csv");
    }

  
    @Test  
    public void employeesIdGet_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "https://virtserver.swaggerhub.com/061REB413/employee-service/0.1";  
  
                Response response = given()
				.pathParam("id", testData.get("id") != null ? testData.get("id") : "")
                .when()
                .get("/employees/{id}")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: Successful operation");
      
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
if (response.statusCode() == 404) {
					System.out.println("Description: Not found");
				}
  
            }  
    }
}
