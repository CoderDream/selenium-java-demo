package com.coderdream.pdrc;

import org.junit.Before;
import org.junit.Test;

public class EvaluateProjectServiceTest {

	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		baseUrl = "http://localhost:1666/";
	}

	@Test
	public void testEvaluateProject() {
		EvaluateProjectService evaluateProjectService = new EvaluateProjectService(this.baseUrl);
		evaluateProjectService.evaluateProject();
	}

}
