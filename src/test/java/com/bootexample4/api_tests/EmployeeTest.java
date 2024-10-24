
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
          String apiHostServer = System.getenv().getOrDefault("hxtxuxux_URL_BASE", "http://localhost:4010");
String hxtxuxuxauthtoken = System.getenv().getOrDefault("hxtxuxux_AUTH_TOKEN", "dummy_hxtxuxux_AUTH_TOKEN");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Employee")
                  .systemProperty("hxtxuxux_URL_BASE", apiHostServer)
.systemProperty("hxtxuxux_AUTH_TOKEN", hxtxuxuxauthtoken)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
