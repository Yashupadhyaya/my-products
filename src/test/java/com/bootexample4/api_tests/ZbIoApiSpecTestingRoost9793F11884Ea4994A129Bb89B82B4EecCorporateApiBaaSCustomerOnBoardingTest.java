
  package com.bootexample4.api_tests;

  import com.intuit.karate.Results;
  import com.intuit.karate.Runner;
  // import com.intuit.karate.http.HttpServer;
  // import com.intuit.karate.http.ServerConfig;
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  class ZbIoApiSpecTestingRoost9793F11884Ea4994A129Bb89B82B4EecCorporateApiBaaSCustomerOnBoardingTest {

      @Test
      void testAll() {
          String urlbase = System.getenv().getOrDefault("url.base", "dummy_url.base");
String authtoken = System.getenv().getOrDefault("AUTH_TOKEN", "dummy_AUTH_TOKEN");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests/ZbIoApiSpecTestingRoost9793F11884Ea4994A129Bb89B82B4EecCorporateApiBaaSCustomerOnBoarding")
                  .systemProperty("url.base", urlbase)
.systemProperty("AUTH_TOKEN", authtoken)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
