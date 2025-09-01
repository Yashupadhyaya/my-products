
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
          String apiHostServer = System.getenv().getOrDefault("acbakcvioqjcvq_URL_BASE", "http://localhost:4010");
String acbakcvioqjcvqauthtoken = System.getenv().getOrDefault("acbakcvioqjcvq_AUTH_TOKEN", "dummy_acbakcvioqjcvq_AUTH_TOKEN");
String apiHostServer = System.getenv().getOrDefault("acbakcvioqjcvq_URL_BASE", "http://localhost:4010");
String acbakcvioqjcvqauthtoken = System.getenv().getOrDefault("acbakcvioqjcvq_AUTH_TOKEN", "dummy_acbakcvioqjcvq_AUTH_TOKEN");
String apiHostServer = System.getenv().getOrDefault("acbakcvioqjcvq_URL_BASE", "http://localhost:4010");
String acbakcvioqjcvqauthtoken = System.getenv().getOrDefault("acbakcvioqjcvq_AUTH_TOKEN", "dummy_acbakcvioqjcvq_AUTH_TOKEN");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Employee")
                  .systemProperty("acbakcvioqjcvq_URL_BASE", apiHostServer)
.systemProperty("acbakcvioqjcvq_AUTH_TOKEN", acbakcvioqjcvqauthtoken)
.systemProperty("acbakcvioqjcvq_URL_BASE", apiHostServer)
.systemProperty("acbakcvioqjcvq_AUTH_TOKEN", acbakcvioqjcvqauthtoken)
.systemProperty("acbakcvioqjcvq_URL_BASE", apiHostServer)
.systemProperty("acbakcvioqjcvq_AUTH_TOKEN", acbakcvioqjcvqauthtoken)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
