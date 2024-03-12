// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /threads/{thread_id}/runs/{run_id}_post for http method type POST in rest-assured framework

RoostTestHash=a0d35b17b8


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

public class runsRunIdPostTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/runs_run_idPostTest.csv");
    }

  
    @Test  
    public void runsRunIdPost_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "https://api.openai.com/v1";  
  
                Response response = given()
				.pathParam("thread_id", testData.get("thread_id") != null ? testData.get("thread_id") : "")
				.pathParam("run_id", testData.get("run_id") != null ? testData.get("run_id") : "")
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"metadata\": \"" + (testData.get("metadata") != null ? testData.get("metadata") : "") + "\n" +
 				"}")
				.header("api_key", testData.get("api_key"))
                .when()
                .post("/threads/{thread_id}/runs/{run_id}")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: OK");
      
              if (response.jsonPath().get("id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("object") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("object"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("object"), anyOf(equalTo("thread.run")));
  
          }
      
              if (response.jsonPath().get("created_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("created_at"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("thread_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("thread_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("assistant_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("assistant_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("status") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("status"), anyOf(equalTo("queued"), equalTo("in_progress"), equalTo("requires_action"), equalTo("cancelling"), equalTo("cancelled"), equalTo("failed"), equalTo("completed"), equalTo("expired")));
  
          }
      
              if (response.jsonPath().get("required_action") != null) {      
              if (response.jsonPath().get("required_action.type") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("required_action.type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("required_action.type"), anyOf(equalTo("submit_tool_outputs")));
  
          }
      
              if (response.jsonPath().get("required_action.submit_tool_outputs") != null) {      
              if (response.jsonPath().get("required_action.submit_tool_outputs.tool_calls") != null) {      
                for (int i = 0; i < response.jsonPath().getList("required_action.submit_tool_outputs.tool_calls").size(); i++) {      
              if (response.jsonPath().get("required_action.submit_tool_outputs.tool_calls["+ i +"].id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("required_action.submit_tool_outputs.tool_calls["+ i +"].id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("required_action.submit_tool_outputs.tool_calls["+ i +"].type") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("required_action.submit_tool_outputs.tool_calls["+ i +"].type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("required_action.submit_tool_outputs.tool_calls["+ i +"].type"), anyOf(equalTo("function")));
  
          }
      
              if (response.jsonPath().get("required_action.submit_tool_outputs.tool_calls["+ i +"].function") != null) {      
              if (response.jsonPath().get("required_action.submit_tool_outputs.tool_calls["+ i +"].function.name") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("required_action.submit_tool_outputs.tool_calls["+ i +"].function.name"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("required_action.submit_tool_outputs.tool_calls["+ i +"].function.arguments") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("required_action.submit_tool_outputs.tool_calls["+ i +"].function.arguments"), instanceOf(String.class));  
          }
  
          }
      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("required_action.submit_tool_outputs.tool_calls"), instanceOf(List.class));
  
          }
  
          }
  
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
      
              if (response.jsonPath().get("expires_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("expires_at"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("started_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("started_at"), instanceOf(Integer.class));  
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
      
              if (response.jsonPath().get("model") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("model"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("instructions") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("instructions"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("tools") != null) {      
                for (int i = 0; i < response.jsonPath().getList("tools").size(); i++) {      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("tools"), instanceOf(List.class));
  
          }
      
              if (response.jsonPath().get("file_ids") != null) {      
                for (int i = 0; i < response.jsonPath().getList("file_ids").size(); i++) {      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("file_ids"), instanceOf(List.class));
  
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
