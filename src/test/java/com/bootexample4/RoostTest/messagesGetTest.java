// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /threads/{thread_id}/messages_get for http method type GET in rest-assured framework

RoostTestHash=5da0d73360


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

public class messagesGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/messagesGetTest.csv");
    }

  
    @Test  
    public void messagesGet_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "https://api.openai.com/v1";  
  
                Response response = given()
				.pathParam("thread_id", testData.get("thread_id") != null ? testData.get("thread_id") : "")
				.pathParam("limit", testData.get("limit") != null ? testData.get("limit") : "")
				.pathParam("order", testData.get("order") != null ? testData.get("order") : "")
				.pathParam("after", testData.get("after") != null ? testData.get("after") : "")
				.pathParam("before", testData.get("before") != null ? testData.get("before") : "")
				.header("api_key", testData.get("api_key"))
                .when()
                .get("/threads/{thread_id}/messages")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: OK");
      
              if (response.jsonPath().get("object") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("object"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("data") != null) {      
                for (int i = 0; i < response.jsonPath().getList("data").size(); i++) {      
              if (response.jsonPath().get("data["+ i +"].id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("data["+ i +"].id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("data["+ i +"].object") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("data["+ i +"].object"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("data["+ i +"].object"), anyOf(equalTo("thread.message")));
  
          }
      
              if (response.jsonPath().get("data["+ i +"].created_at") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("data["+ i +"].created_at"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("data["+ i +"].thread_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("data["+ i +"].thread_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("data["+ i +"].role") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("data["+ i +"].role"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("data["+ i +"].role"), anyOf(equalTo("user"), equalTo("assistant")));
  
          }
      
              if (response.jsonPath().get("data["+ i +"].content") != null) {      
                for (int i1 = 0; i1 < response.jsonPath().getList("data["+ i +"].content").size(); i1++) {      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("data["+ i +"].content"), instanceOf(List.class));
  
          }
      
              if (response.jsonPath().get("data["+ i +"].assistant_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("data["+ i +"].assistant_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("data["+ i +"].run_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("data["+ i +"].run_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("data["+ i +"].file_ids") != null) {      
                for (int i1 = 0; i1 < response.jsonPath().getList("data["+ i +"].file_ids").size(); i1++) {      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("data["+ i +"].file_ids"), instanceOf(List.class));
  
          }
      
              if (response.jsonPath().get("data["+ i +"].metadata") != null) {  
          }
      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("data"), instanceOf(List.class));
  
          }
      
              if (response.jsonPath().get("first_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("first_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("last_id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("last_id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("has_more") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("has_more"), instanceOf(Boolean.class));  
          }
				}
  
            }  
    }
}