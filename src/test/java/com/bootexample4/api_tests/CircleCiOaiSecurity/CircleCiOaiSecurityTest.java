
package com.bootexample4.api_tests.CircleCiOaiSecurity;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleCiOaiSecurityTest {

	@Test
	void testAll() {
		String APIHOST = System.getenv().get("API_HOST");
		String AUTHUSERNAME = System.getenv().get("AUTH_USERNAME");
		String AUTHPASSWORD = System.getenv().get("AUTH_PASSWORD");
		String circletoken = System.getenv().get("circle-token");
		String CircleToken = System.getenv().get("Circle-Token");
		Results results = Runner.path("src/test/java/com/bootexample4/api_tests/CircleCiOaiSecurity")
			.systemProperty("API_HOST", APIHOST)
			.systemProperty("AUTH_USERNAME", AUTHUSERNAME)
			.systemProperty("AUTH_PASSWORD", AUTHPASSWORD)
			.systemProperty("circle-token", circletoken)
			.systemProperty("Circle-Token", CircleToken)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
