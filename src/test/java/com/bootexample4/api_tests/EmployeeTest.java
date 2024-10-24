
  package com.bootexample4.api_tests;

  import com.intuit.karate.Results;
  import com.intuit.karate.Runner;
  // import com.intuit.karate.http.HttpServer;
  // import com.intuit.karate.http.ServerConfig;
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  class EmployeeTest {

      @Test
      void testAll() {
          String apiHostServer = System.getenv().getOrDefault("jcbkjqcvkjqc_URL_BASE", "http://localhost:4010");
String jcbkjqcvkjqcauthtoken = System.getenv().getOrDefault("jcbkjqcvkjqc_AUTH_TOKEN", "dummy_jcbkjqcvkjqc_AUTH_TOKEN");
String apiHostServer = System.getenv().getOrDefault("jcbkjqcvkjqc_URL_BASE", "http://localhost:4010");
String jcbkjqcvkjqcauthtoken = System.getenv().getOrDefault("jcbkjqcvkjqc_AUTH_TOKEN", "dummy_jcbkjqcvkjqc_AUTH_TOKEN");
String apiHostServer = System.getenv().getOrDefault("jcbkjqcvkjqc_URL_BASE", "http://localhost:4010");
String jcbkjqcvkjqcauthtoken = System.getenv().getOrDefault("jcbkjqcvkjqc_AUTH_TOKEN", "dummy_jcbkjqcvkjqc_AUTH_TOKEN");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Employee")
                  .systemProperty("jcbkjqcvkjqc_URL_BASE", apiHostServer)
.systemProperty("jcbkjqcvkjqc_AUTH_TOKEN", jcbkjqcvkjqcauthtoken)
.systemProperty("jcbkjqcvkjqc_URL_BASE", apiHostServer)
.systemProperty("jcbkjqcvkjqc_AUTH_TOKEN", jcbkjqcvkjqcauthtoken)
.systemProperty("jcbkjqcvkjqc_URL_BASE", apiHostServer)
.systemProperty("jcbkjqcvkjqc_AUTH_TOKEN", jcbkjqcvkjqcauthtoken)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
