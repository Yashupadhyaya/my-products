// ********RoostGPT********
/*
Test generated by RoostGPT for test postman-testvtal using AI Type Open AI and AI Model gpt-4

Test generated for /appointment/{appointmentId}_patch for http method type PATCH in rest-assured framework

RoostTestHash=05501a2311


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
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
import org.json.JSONArray;
import java.util.Arrays;

public class appointmentAppointmentIdPatchTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @BeforeEach
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      String[] envVarsList = {"appointmentId", "BASE_URL"};
      envList = dataloader.load("src/test/java/com/bootexample4/RoostTest/appointment_appointmentIdPatchTest.csv", envVarsList);
    }

  
    @Test  
    public void appointmentAppointmentIdPatch_Test() throws JSONException {
        this.setUp();
        Integer testNumber = 1;
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = (testData.get("BASE_URL") != null && !testData.get("BASE_URL").isEmpty()) ? testData.get("BASE_URL"): testData.get("BASE_URL");  
          JSONObject requestBodyObject = new JSONObject();
          if(testData.get("RequestBody") != null){
              requestBodyObject = new JSONObject(testData.get("RequestBody"));
          }
                Response responseObj = given()
				.pathParam("appointmentId", testData.get("appointmentId") != null ? testData.get("appointmentId") : "")
				.contentType(ContentType.JSON)
				.body(requestBodyObject.toString())
                .when()
                .patch("/appointment/{appointmentId}")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();

              System.out.printf("Test Case %d: appointmentAppointmentIdPatch_Test \n", testNumber++);
              System.out.println("Request: PATCH /appointment/{appointmentId}");
              System.out.println("Status Code: " + responseObj.statusCode());
              if (testData.get("statusCode") != null) {
                String statusCodeFromCSV = testData.get("statusCode");
                if (statusCodeFromCSV.contains("X")) {
                  MatcherAssert.assertThat(
                      "Expected a status code of category " + statusCodeFromCSV + ", but got "
                          + Integer.toString(responseObj.statusCode()) + " instead",
                      Integer.toString(responseObj.statusCode()).charAt(0), equalTo(statusCodeFromCSV.charAt(0)));
                } else {
                  MatcherAssert.assertThat(
                      Integer.toString(responseObj.statusCode()), equalTo(statusCodeFromCSV));
                }
              } 
              				else {  
      List<Integer> expectedStatusCodes = Arrays.asList(200,400,401,403,404,406,412,423,429,500,503,504);
				MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
          }
				String stringifiedStatusCode = Integer.toString(responseObj.statusCode());
        switch(responseObj.statusCode()){
        
          case 200:
            stringifiedStatusCode = "200";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 400:
            stringifiedStatusCode = "400";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 401:
            stringifiedStatusCode = "401";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 403:
            stringifiedStatusCode = "403";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 404:
            stringifiedStatusCode = "404";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 406:
            stringifiedStatusCode = "406";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 412:
            stringifiedStatusCode = "412";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 423:
            stringifiedStatusCode = "423";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 429:
            stringifiedStatusCode = "429";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 500:
            stringifiedStatusCode = "500";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 503:
            stringifiedStatusCode = "503";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 504:
            stringifiedStatusCode = "504";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
    }

      switch(Integer.toString(responseObj.statusCode()).charAt(0)){
      
    }

      
              if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
                String xmlResponse = responseObj.asString();
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONObject jsonData = jsonResponse.getJSONObject("xml");
                String jsonString = jsonData.toString();
                response = new JsonPath(jsonString);
        
              } else if(contentType.contains("application/json")){  
                response = responseObj.jsonPath(); 
              } else {
                System.out.println("Response content type found: "+contentType+", but RoostGPT currently only supports the following response content types: application/json,text/xml,application/xml");
                continue;
              }
         
                if(stringifiedStatusCode.equals("200")){					System.out.println("Description: successful operation");
      
              if (response.get("order") != null) {
                      
              if (response.get("order.type") != null) {
                  
                MatcherAssert.assertThat(response.get("order.type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("order.type"), anyOf(equalTo("Instalação"), equalTo("Retirada"), equalTo("RemanejamentoPonto"), equalTo("ChamadoTecnico")));

              }
      
              if (response.get("order.associatedDocument") != null) {
                  
                MatcherAssert.assertThat(response.get("order.associatedDocument"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("order.associatedDocument").length(), lessThanOrEqualTo(30));

              }
      
              if (response.get("order.addressChange") != null) {
                      
              if (response.get("order.addressChange.flag") != null) {
                  
                MatcherAssert.assertThat(response.get("order.addressChange.flag"), instanceOf(Boolean.class));
              }

              }

              }
      
              if (response.get("customer") != null) {
                      
              if (response.get("customer.subscriberId") != null) {
                  
                MatcherAssert.assertThat(response.get("customer.subscriberId"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("customer.subscriberId").length(), lessThanOrEqualTo(30));

              }

              }
      
              if (response.get("appointment") != null) {
                      
              if (response.get("appointment.id") != null) {
                  
                MatcherAssert.assertThat(response.get("appointment.id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("appointment.id").length(), lessThanOrEqualTo(30));

              }
      
              if (response.get("appointment.startDate") != null) {
                  
                MatcherAssert.assertThat(response.get("appointment.startDate"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("appointment.startDate").length(), lessThanOrEqualTo(25));

              }
      
              if (response.get("appointment.finishDate") != null) {
                  
                MatcherAssert.assertThat(response.get("appointment.finishDate"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("appointment.finishDate").length(), lessThanOrEqualTo(25));

              }
      
              if (response.get("appointment.priority") != null) {
                      
              if (response.get("appointment.priority.flag") != null) {
                  
                MatcherAssert.assertThat(response.get("appointment.priority.flag"), instanceOf(Boolean.class));
              }
      
              if (response.get("appointment.priority.reason") != null) {
                  
                MatcherAssert.assertThat(response.get("appointment.priority.reason"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("appointment.priority.reason").length(), lessThanOrEqualTo(80));

              }

              }

              }
      
              if (response.get("address") != null) {
                      
              if (response.get("address.id") != null) {
                  
                MatcherAssert.assertThat(response.get("address.id"), instanceOf(Integer.class));  
                MatcherAssert.assertThat(response.getString("address.id").length(), lessThanOrEqualTo(20));

              }

              }
      
              if (response.get("products") != null) {
                      
              if (response.get("products.product") != null) {
                      
                for (int i = 0; i < response.getList("products.product").size(); i++) {      
              if (response.get("products.product["+ i +"].type") != null) {
                  
                MatcherAssert.assertThat(response.get("products.product["+ i +"].type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("products.product["+ i +"].type"), anyOf(equalTo("Banda Larga")));

              }
      
                  }    
                MatcherAssert.assertThat(response.getList("products.product"), instanceOf(List.class));

              }

              }
      
              if (response.get("control") != null) {
                      
              if (response.get("control.type") != null) {
                  
                MatcherAssert.assertThat(response.get("control.type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("control.type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("control.type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("control.message") != null) {
                  
                MatcherAssert.assertThat(response.get("control.message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("control.message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("control.code") != null) {
                  
                MatcherAssert.assertThat(response.get("control.code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("control.code").length(), lessThanOrEqualTo(3));

              }

              }
				}
if(stringifiedStatusCode.equals("400")){					System.out.println("Description: Bad Request");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("401")){					System.out.println("Description: Unauthorized");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("403")){					System.out.println("Description: Forbidden - Scope Not Permitted");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("404")){					System.out.println("Description: Not Found");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("406")){					System.out.println("Description: Not Acceptable");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("412")){					System.out.println("Description: Not Acceptable");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("423")){					System.out.println("Description: Locked");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("429")){					System.out.println("Description: Too Many Requests - Exceeded Quota");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("500")){					System.out.println("Description: Internal Server Error");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("503")){					System.out.println("Description: Service Unavailable");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}
if(stringifiedStatusCode.equals("504")){					System.out.println("Description: Gateway Timeout");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));
  
                MatcherAssert.assertThat(response.getString("type").length(), lessThanOrEqualTo(1));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("message").length(), lessThanOrEqualTo(250));

              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("code").length(), lessThanOrEqualTo(3));

              }
				}


            }  
    }
}
