// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /completions_post for http method type POST in rest-assured framework

RoostTestHash=85a68d2752


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

public class completionsPostTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/completionsPostTest.csv");
    }

  
    @Test  
    public void completionsPost_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "https://api.openai.com/v1";  
  
                Response response = given()
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"model\": \"" + (testData.get("model") != null ? testData.get("model") : "") + "\",\n" +
					"  \"prompt\": \"" + (testData.get("prompt") != null ? testData.get("prompt") : "") + "\",\n" +
					"  \"best_of\": \"" + (testData.get("best_of") != null ? testData.get("best_of") : "") + "\",\n" +
					"  \"echo\": \"" + (testData.get("echo") != null ? testData.get("echo") : "") + "\",\n" +
					"  \"frequency_penalty\": \"" + (testData.get("frequency_penalty") != null ? testData.get("frequency_penalty") : "") + "\",\n" +
					"  \"logit_bias\": \"" + (testData.get("logit_bias") != null ? testData.get("logit_bias") : "") + "\",\n" +
					"  \"logprobs\": \"" + (testData.get("logprobs") != null ? testData.get("logprobs") : "") + "\",\n" +
					"  \"max_tokens\": \"" + (testData.get("max_tokens") != null ? testData.get("max_tokens") : "") + "\",\n" +
					"  \"n\": \"" + (testData.get("n") != null ? testData.get("n") : "") + "\",\n" +
					"  \"presence_penalty\": \"" + (testData.get("presence_penalty") != null ? testData.get("presence_penalty") : "") + "\",\n" +
					"  \"seed\": \"" + (testData.get("seed") != null ? testData.get("seed") : "") + "\",\n" +
					"  \"stop\": \"" + (testData.get("stop") != null ? testData.get("stop") : "") + "\",\n" +
					"  \"stream\": \"" + (testData.get("stream") != null ? testData.get("stream") : "") + "\",\n" +
					"  \"suffix\": \"" + (testData.get("suffix") != null ? testData.get("suffix") : "") + "\",\n" +
					"  \"temperature\": \"" + (testData.get("temperature") != null ? testData.get("temperature") : "") + "\",\n" +
					"  \"top_p\": \"" + (testData.get("top_p") != null ? testData.get("top_p") : "") + "\",\n" +
					"  \"user\": \"" + (testData.get("user") != null ? testData.get("user") : "") + "\n" +
 				"}")
				.header("api_key", testData.get("api_key"))
                .when()
                .post("/completions")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: OK");
      
              if (response.jsonPath().get("id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("choices") != null) {      
                for (int i = 0; i < response.jsonPath().getList("choices").size(); i++) {      
              if (response.jsonPath().get("choices["+ i +"].finish_reason") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("choices["+ i +"].finish_reason"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("choices["+ i +"].finish_reason"), anyOf(equalTo("stop"), equalTo("length"), equalTo("content_filter")));
  
          }
      
              if (response.jsonPath().get("choices["+ i +"].index") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("choices["+ i +"].index"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("choices["+ i +"].logprobs") != null) {      
              if (response.jsonPath().get("choices["+ i +"].logprobs.text_offset") != null) {      
                for (int i1 = 0; i1 < response.jsonPath().getList("choices["+ i +"].logprobs.text_offset").size(); i1++) {      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("choices["+ i +"].logprobs.text_offset"), instanceOf(List.class));
  
          }
      
              if (response.jsonPath().get("choices["+ i +"].logprobs.token_logprobs") != null) {      
                for (int i1 = 0; i1 < response.jsonPath().getList("choices["+ i +"].logprobs.token_logprobs").size(); i1++) {      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("choices["+ i +"].logprobs.token_logprobs"), instanceOf(List.class));
  
          }
      
              if (response.jsonPath().get("choices["+ i +"].logprobs.tokens") != null) {      
                for (int i1 = 0; i1 < response.jsonPath().getList("choices["+ i +"].logprobs.tokens").size(); i1++) {      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("choices["+ i +"].logprobs.tokens"), instanceOf(List.class));
  
          }
      
              if (response.jsonPath().get("choices["+ i +"].logprobs.top_logprobs") != null) {      
                for (int i1 = 0; i1 < response.jsonPath().getList("choices["+ i +"].logprobs.top_logprobs").size(); i1++) {      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("choices["+ i +"].logprobs.top_logprobs"), instanceOf(List.class));
  
          }
  
          }
      
              if (response.jsonPath().get("choices["+ i +"].text") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("choices["+ i +"].text"), instanceOf(String.class));  
          }
      
                  }    
                MatcherAssert.assertThat(response.jsonPath().getList("choices"), instanceOf(List.class));
  
          }
      
              if (response.jsonPath().get("created") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("created"), instanceOf(Integer.class));  
          }
      
              if (response.jsonPath().get("model") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("model"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("system_fingerprint") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("system_fingerprint"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("object") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("object"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("object"), anyOf(equalTo("text_completion")));
  
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
