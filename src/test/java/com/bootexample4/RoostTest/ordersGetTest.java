// Test generated by RoostGPT for test test-postman1 using AI Type Open AI and AI Model gpt-4-1106-preview


// Test generated for /order-report/orders_get for http method type GET in rest-assured framework


// RoostTestHash=2ed4ac3d33


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

public class ordersGetTest {
  
    @Test  
    public void orders_get_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "ordersGetTest.csv"))) {  
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
				.pathParam("X-Trace-Id", map.get("X-Trace-Id") != null ? map.get("X-Trace-Id") : "")
				.pathParam("channel", map.get("channel") != null ? map.get("channel") : "")
				.pathParam("orderId", map.get("orderId") != null ? map.get("orderId") : "")
				.pathParam("customerName", map.get("customerName") != null ? map.get("customerName") : "")
				.pathParam("profileId", map.get("profileId") != null ? map.get("profileId") : "")
				.pathParam("accountId", map.get("accountId") != null ? map.get("accountId") : "")
				.pathParam("serviceId", map.get("serviceId") != null ? map.get("serviceId") : "")
				.pathParam("channel", map.get("channel") != null ? map.get("channel") : "")
				.pathParam("state", map.get("state") != null ? map.get("state") : "")
				.pathParam("offset", map.get("offset") != null ? map.get("offset") : "")
				.pathParam("limit", map.get("limit") != null ? map.get("limit") : "")
				.pathParam("showOrderStatusCount", map.get("showOrderStatusCount") != null ? map.get("showOrderStatusCount") : "")
				.pathParam("username", map.get("username") != null ? map.get("username") : "")
                .when()
                .get("/order-report/orders")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: Success");
    
              if (response.jsonPath().get("_metadata") != null) {    
              if (response.jsonPath().get("_metadata.hasNext") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("_metadata.hasNext"), instanceOf(Boolean.class));  
          }
    
              if (response.jsonPath().get("_metadata.count") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("_metadata.count"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("_metadata.totalCount") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("_metadata.totalCount"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("_metadata.requestId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("_metadata.requestId"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("_metadata.channel") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("_metadata.channel"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("_metadata.totalFailedOrderCount") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("_metadata.totalFailedOrderCount"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("_metadata.totalCompletedOrderCount") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("_metadata.totalCompletedOrderCount"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("_metadata.totalPendingOrderCount") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("_metadata.totalPendingOrderCount"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("_metadata.totalInProgressOrderCount") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("_metadata.totalInProgressOrderCount"), instanceOf(String.class));  
          }
  
          }
    
              if (response.jsonPath().get("results") != null) {    
                for (int i = 0; i < response.jsonPath().getList("results").size(); i++) {    
              if (response.jsonPath().get("results["+ i +"].orderId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].orderId"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].orderType") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].orderType"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].name") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].name"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].description") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].description"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].externalId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].externalId"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].profileId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].profileId"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].serviceId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].serviceId"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].accountId") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].accountId"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].customerName") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].customerName"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].channel") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].channel"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].state") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].state"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].stateReason") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].stateReason"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].createdDate") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].createdDate"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].createdBy") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].createdBy"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].lastModifiedDate") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].lastModifiedDate"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].lastModifiedBy") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].lastModifiedBy"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("results["+ i +"].comment") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("results["+ i +"].comment"), instanceOf(String.class));  
          }
    
                  }  
                MatcherAssert.assertThat(response.jsonPath().getList("results"), instanceOf(List.class));
  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Bad Request");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 401) {
					System.out.println("Description: Unauthorized");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 403) {
					System.out.println("Description: Forbidden");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 404) {
					System.out.println("Description: Not Found");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 405) {
					System.out.println("Description: Method Not allowed");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 409) {
					System.out.println("Description: Conflict");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 500) {
					System.out.println("Description: Internal Server Error");
    
              if (response.jsonPath().get("code") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("code"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("message") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("message"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("status"), instanceOf(String.class));  
          }
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
