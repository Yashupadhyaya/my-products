// Test generated by RoostGPT for test credential-register-rest-assured using AI Type Azure Open AI and AI Model roost-gpt4-32k


// Test generated for /credentials_get for http method type GET in rest-assured framework


// RoostTestHash=66f52a572f


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

public class credentialsGetTest {
  
    @Test  
    public void credentials_get_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/com/bootexample4/RoostTest/credentialsGetTest.csv"))) {  
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
				.pathParam("size", map.get("size"))
				.pathParam("offset", map.get("offset"))
                .when()
                .get("/credentials")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
  
            if (response.jsonPath().get("total") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("total"), instanceOf(Integer.class));  
          }
  
            if (response.jsonPath().get("credentials") != null) {  
              for (int i = 0; i < response.jsonPath().getList("credentials").size(); i++) {  
            if (response.jsonPath().get("credentials[`"+ i +"`].id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("credentials[`"+ i +"`].id"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("credentials[`"+ i +"`].format") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("credentials[`"+ i +"`].format"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("credentials[`"+ i +"`].format"), anyOf(equalTo("jwt_vc_json"), equalTo("jwt_vc_json-ld"), equalTo("ldp_vc")));
  
          }
  
            if (response.jsonPath().get("credentials[`"+ i +"`].credential") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("credentials[`"+ i +"`].credential"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("credentials[`"+ i +"`].status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("credentials[`"+ i +"`].status"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("credentials[`"+ i +"`].status"), anyOf(equalTo("active"), equalTo("suspended"), equalTo("revoked"), equalTo("expired"), equalTo("pending")));
  
          }
  
            if (response.jsonPath().get("credentials[`"+ i +"`].statusUpdatedAt") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("credentials[`"+ i +"`].statusUpdatedAt"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("credentials[`"+ i +"`].createdAt") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("credentials[`"+ i +"`].createdAt"), instanceOf(String.class));  
          }
  
                }  
                MatcherAssert.assertThat(response.jsonPath().getList("credentials"), instanceOf(List.class));
  
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
