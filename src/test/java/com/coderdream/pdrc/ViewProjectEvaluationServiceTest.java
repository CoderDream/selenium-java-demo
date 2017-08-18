package com.coderdream.pdrc;

import org.junit.Before;
import org.junit.Test;

public class ViewProjectEvaluationServiceTest {

	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		baseUrl = "http://test3.bill-jc.com/";
	}

	@Test
	public void testViewMyProjectEvaluation() {
		ViewProjectEvaluationService viewProjectEvaluationService = new ViewProjectEvaluationService(this.baseUrl);
		viewProjectEvaluationService.viewMyProjectEvaluation();
	}
}
