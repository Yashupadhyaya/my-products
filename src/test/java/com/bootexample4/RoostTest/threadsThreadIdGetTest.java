// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /threads/{thread_id}_get for http method type GET in rest-assured framework

RoostTestHash=7a1fdf3895


*/

// ********RoostGPT********

package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
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

public class threadsThreadIdGetTest {

    List<Map<String, String>> envList = new ArrayList<>();

    // Assuming that TestdataLoader class is available in classpath
    @BeforeEach
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/threads_thread_idGetTest.csv");
    }

    @Test  
    public void threadsThreadIdGet_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "https://api.openai.com/v1";  
  
                Response response = given()
				.pathParam("thread_id", testData.get("thread_id") != null ? testData.get("thread_id") : "")
				.header("api_key", testData.get("api_key"))
                .when()
                .get("/threads/{thread_id}")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: OK");
      
              if (response.jsonPath().get("id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("object") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("object"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("object"), anyOf(equalTo("thread")));
  
          }
      
              if (response.jsonPath().get("created_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("created_at"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("metadata") != null) {  
          }
				}
  
            }  
    }
}
