// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /threads/{thread_id}/runs/{run_id}/steps/{step_id}_get for http method type GET in rest-assured framework

RoostTestHash=3f215f305e


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

public class stepsStepIdGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/steps_step_idGetTest.csv");
    }

  
    @Test  
    public void stepsStepIdGet_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "https://api.openai.com/v1";  
  
                Response response = given()
				.pathParam("thread_id", testData.get("thread_id") != null ? testData.get("thread_id") : "")
				.pathParam("run_id", testData.get("run_id") != null ? testData.get("run_id") : "")
				.pathParam("step_id", testData.get("step_id") != null ? testData.get("step_id") : "")
				.header("api_key", testData.get("api_key"))
                .when()
                .get("/threads/{thread_id}/runs/{run_id}/steps/{step_id}")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: OK");
      
              if (response.jsonPath().get("id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("object") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("object"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("object"), anyOf(equalTo("thread.run.step")));
  
          }
      
              if (response.jsonPath().get("created_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("created_at"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("assistant_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("assistant_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("thread_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("thread_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("run_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("run_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("type") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("type"), anyOf(equalTo("message_creation"), equalTo("tool_calls")));
  
          }
      
              if (response.jsonPath().get("status") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("status"), anyOf(equalTo("in_progress"), equalTo("cancelled"), equalTo("failed"), equalTo("completed"), equalTo("expired")));
  
          }
      
              if (response.jsonPath().get("step_details") != null) {  
          }
      
              if (response.jsonPath().get("last_error") != null) {      
              if (response.jsonPath().get("last_error.code") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("last_error.code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("last_error.code"), anyOf(equalTo("server_error"), equalTo("rate_limit_exceeded")));
  
          }
      
              if (response.jsonPath().get("last_error.message") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("last_error.message"), instanceOf(String.class));  
          }
  
          }
      
              if (response.jsonPath().get("expired_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("expired_at"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("cancelled_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("cancelled_at"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("failed_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("failed_at"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("completed_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("completed_at"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("metadata") != null) {  
          }
      
              if (response.jsonPath().get("usage") != null) {      
              if (response.jsonPath().get("usage.completion_tokens") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("usage.completion_tokens"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("usage.prompt_tokens") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("usage.prompt_tokens"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("usage.total_tokens") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("usage.total_tokens"), instanceOf(Integer.class));  
          }
  
          }
				}
  
            }  
    }
}