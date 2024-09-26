// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-test using AI Type Open AI and AI Model gpt-4

Test generated for /user/{username}_get for http method type GET in rest-assured framework

RoostTestHash=77bc35590b


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
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
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;

public class userUsernameGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/user_usernameGetTest.csv");
    }

  
    @Test  
    public void userUsernameGet_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = "/api/v3";  
  
                Response responseObj = given()
				.pathParam("username", testData.get("username") != null ? testData.get("username") : "")
                .when()
                .get("/user/{username}")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();
              if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
                String xmlResponse = responseObj.asString();
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONObject jsonData = jsonResponse.getJSONObject("xml");
                String jsonString = jsonData.toString();
                response = new JsonPath(jsonString);
        
              } else {  
                response = responseObj.jsonPath(); 
              }  
         
                if (responseObj.statusCode() == 200) {
					System.out.println("Description: successful operation");
      
              if (response.get("id") != null) {      
              if (response.get("id.id") != null) {  
                MatcherAssert.assertThat(response.get("id.id"), instanceOf(Integer.class));  
          }
      
              if (response.get("id.username") != null) {  
                MatcherAssert.assertThat(response.get("id.username"), instanceOf(String.class));  
          }
      
              if (response.get("id.firstName") != null) {  
                MatcherAssert.assertThat(response.get("id.firstName"), instanceOf(String.class));  
          }
      
              if (response.get("id.lastName") != null) {  
                MatcherAssert.assertThat(response.get("id.lastName"), instanceOf(String.class));  
          }
      
              if (response.get("id.email") != null) {  
                MatcherAssert.assertThat(response.get("id.email"), instanceOf(String.class));  
          }
      
              if (response.get("id.password") != null) {  
                MatcherAssert.assertThat(response.get("id.password"), instanceOf(String.class));  
          }
      
              if (response.get("id.phone") != null) {  
                MatcherAssert.assertThat(response.get("id.phone"), instanceOf(String.class));  
          }
      
              if (response.get("id.userStatus") != null) {  
                MatcherAssert.assertThat(response.get("id.userStatus"), instanceOf(Integer.class));  
          }
  
          }
      
              if (response.get("username") != null) {      
              if (response.get("username.id") != null) {  
                MatcherAssert.assertThat(response.get("username.id"), instanceOf(Integer.class));  
          }
      
              if (response.get("username.username") != null) {  
                MatcherAssert.assertThat(response.get("username.username"), instanceOf(String.class));  
          }
      
              if (response.get("username.firstName") != null) {  
                MatcherAssert.assertThat(response.get("username.firstName"), instanceOf(String.class));  
          }
      
              if (response.get("username.lastName") != null) {  
                MatcherAssert.assertThat(response.get("username.lastName"), instanceOf(String.class));  
          }
      
              if (response.get("username.email") != null) {  
                MatcherAssert.assertThat(response.get("username.email"), instanceOf(String.class));  
          }
      
              if (response.get("username.password") != null) {  
                MatcherAssert.assertThat(response.get("username.password"), instanceOf(String.class));  
          }
      
              if (response.get("username.phone") != null) {  
                MatcherAssert.assertThat(response.get("username.phone"), instanceOf(String.class));  
          }
      
              if (response.get("username.userStatus") != null) {  
                MatcherAssert.assertThat(response.get("username.userStatus"), instanceOf(Integer.class));  
          }
  
          }
      
              if (response.get("firstName") != null) {      
              if (response.get("firstName.id") != null) {  
                MatcherAssert.assertThat(response.get("firstName.id"), instanceOf(Integer.class));  
          }
      
              if (response.get("firstName.username") != null) {  
                MatcherAssert.assertThat(response.get("firstName.username"), instanceOf(String.class));  
          }
      
              if (response.get("firstName.firstName") != null) {  
                MatcherAssert.assertThat(response.get("firstName.firstName"), instanceOf(String.class));  
          }
      
              if (response.get("firstName.lastName") != null) {  
                MatcherAssert.assertThat(response.get("firstName.lastName"), instanceOf(String.class));  
          }
      
              if (response.get("firstName.email") != null) {  
                MatcherAssert.assertThat(response.get("firstName.email"), instanceOf(String.class));  
          }
      
              if (response.get("firstName.password") != null) {  
                MatcherAssert.assertThat(response.get("firstName.password"), instanceOf(String.class));  
          }
      
              if (response.get("firstName.phone") != null) {  
                MatcherAssert.assertThat(response.get("firstName.phone"), instanceOf(String.class));  
          }
      
              if (response.get("firstName.userStatus") != null) {  
                MatcherAssert.assertThat(response.get("firstName.userStatus"), instanceOf(Integer.class));  
          }
  
          }
      
              if (response.get("lastName") != null) {      
              if (response.get("lastName.id") != null) {  
                MatcherAssert.assertThat(response.get("lastName.id"), instanceOf(Integer.class));  
          }
      
              if (response.get("lastName.username") != null) {  
                MatcherAssert.assertThat(response.get("lastName.username"), instanceOf(String.class));  
          }
      
              if (response.get("lastName.firstName") != null) {  
                MatcherAssert.assertThat(response.get("lastName.firstName"), instanceOf(String.class));  
          }
      
              if (response.get("lastName.lastName") != null) {  
                MatcherAssert.assertThat(response.get("lastName.lastName"), instanceOf(String.class));  
          }
      
              if (response.get("lastName.email") != null) {  
                MatcherAssert.assertThat(response.get("lastName.email"), instanceOf(String.class));  
          }
      
              if (response.get("lastName.password") != null) {  
                MatcherAssert.assertThat(response.get("lastName.password"), instanceOf(String.class));  
          }
      
              if (response.get("lastName.phone") != null) {  
                MatcherAssert.assertThat(response.get("lastName.phone"), instanceOf(String.class));  
          }
      
              if (response.get("lastName.userStatus") != null) {  
                MatcherAssert.assertThat(response.get("lastName.userStatus"), instanceOf(Integer.class));  
          }
  
          }
      
              if (response.get("email") != null) {      
              if (response.get("email.id") != null) {  
                MatcherAssert.assertThat(response.get("email.id"), instanceOf(Integer.class));  
          }
      
              if (response.get("email.username") != null) {  
                MatcherAssert.assertThat(response.get("email.username"), instanceOf(String.class));  
          }
      
              if (response.get("email.firstName") != null) {  
                MatcherAssert.assertThat(response.get("email.firstName"), instanceOf(String.class));  
          }
      
              if (response.get("email.lastName") != null) {  
                MatcherAssert.assertThat(response.get("email.lastName"), instanceOf(String.class));  
          }
      
              if (response.get("email.email") != null) {  
                MatcherAssert.assertThat(response.get("email.email"), instanceOf(String.class));  
          }
      
              if (response.get("email.password") != null) {  
                MatcherAssert.assertThat(response.get("email.password"), instanceOf(String.class));  
          }
      
              if (response.get("email.phone") != null) {  
                MatcherAssert.assertThat(response.get("email.phone"), instanceOf(String.class));  
          }
      
              if (response.get("email.userStatus") != null) {  
                MatcherAssert.assertThat(response.get("email.userStatus"), instanceOf(Integer.class));  
          }
  
          }
      
              if (response.get("password") != null) {      
              if (response.get("password.id") != null) {  
                MatcherAssert.assertThat(response.get("password.id"), instanceOf(Integer.class));  
          }
      
              if (response.get("password.username") != null) {  
                MatcherAssert.assertThat(response.get("password.username"), instanceOf(String.class));  
          }
      
              if (response.get("password.firstName") != null) {  
                MatcherAssert.assertThat(response.get("password.firstName"), instanceOf(String.class));  
          }
      
              if (response.get("password.lastName") != null) {  
                MatcherAssert.assertThat(response.get("password.lastName"), instanceOf(String.class));  
          }
      
              if (response.get("password.email") != null) {  
                MatcherAssert.assertThat(response.get("password.email"), instanceOf(String.class));  
          }
      
              if (response.get("password.password") != null) {  
                MatcherAssert.assertThat(response.get("password.password"), instanceOf(String.class));  
          }
      
              if (response.get("password.phone") != null) {  
                MatcherAssert.assertThat(response.get("password.phone"), instanceOf(String.class));  
          }
      
              if (response.get("password.userStatus") != null) {  
                MatcherAssert.assertThat(response.get("password.userStatus"), instanceOf(Integer.class));  
          }
  
          }
      
              if (response.get("phone") != null) {      
              if (response.get("phone.id") != null) {  
                MatcherAssert.assertThat(response.get("phone.id"), instanceOf(Integer.class));  
          }
      
              if (response.get("phone.username") != null) {  
                MatcherAssert.assertThat(response.get("phone.username"), instanceOf(String.class));  
          }
      
              if (response.get("phone.firstName") != null) {  
                MatcherAssert.assertThat(response.get("phone.firstName"), instanceOf(String.class));  
          }
      
              if (response.get("phone.lastName") != null) {  
                MatcherAssert.assertThat(response.get("phone.lastName"), instanceOf(String.class));  
          }
      
              if (response.get("phone.email") != null) {  
                MatcherAssert.assertThat(response.get("phone.email"), instanceOf(String.class));  
          }
      
              if (response.get("phone.password") != null) {  
                MatcherAssert.assertThat(response.get("phone.password"), instanceOf(String.class));  
          }
      
              if (response.get("phone.phone") != null) {  
                MatcherAssert.assertThat(response.get("phone.phone"), instanceOf(String.class));  
          }
      
              if (response.get("phone.userStatus") != null) {  
                MatcherAssert.assertThat(response.get("phone.userStatus"), instanceOf(Integer.class));  
          }
  
          }
      
              if (response.get("userStatus") != null) {      
              if (response.get("userStatus.id") != null) {  
                MatcherAssert.assertThat(response.get("userStatus.id"), instanceOf(Integer.class));  
          }
      
              if (response.get("userStatus.username") != null) {  
                MatcherAssert.assertThat(response.get("userStatus.username"), instanceOf(String.class));  
          }
      
              if (response.get("userStatus.firstName") != null) {  
                MatcherAssert.assertThat(response.get("userStatus.firstName"), instanceOf(String.class));  
          }
      
              if (response.get("userStatus.lastName") != null) {  
                MatcherAssert.assertThat(response.get("userStatus.lastName"), instanceOf(String.class));  
          }
      
              if (response.get("userStatus.email") != null) {  
                MatcherAssert.assertThat(response.get("userStatus.email"), instanceOf(String.class));  
          }
      
              if (response.get("userStatus.password") != null) {  
                MatcherAssert.assertThat(response.get("userStatus.password"), instanceOf(String.class));  
          }
      
              if (response.get("userStatus.phone") != null) {  
                MatcherAssert.assertThat(response.get("userStatus.phone"), instanceOf(String.class));  
          }
      
              if (response.get("userStatus.userStatus") != null) {  
                MatcherAssert.assertThat(response.get("userStatus.userStatus"), instanceOf(Integer.class));  
          }
  
          }
				}
if (responseObj.statusCode() == 400) {
					System.out.println("Description: Invalid username supplied");
				}
if (responseObj.statusCode() == 404) {
					System.out.println("Description: User not found");
				}
  
            }  
    }
}
