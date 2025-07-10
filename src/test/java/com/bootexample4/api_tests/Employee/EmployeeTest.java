
package com.bootexample4.api_tests.Employee;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

	@Test
	void testAll() {
		String APIHOST = System.getenv().get("API_HOST");
		Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Employee")
			.systemProperty("API_HOST", APIHOST)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
