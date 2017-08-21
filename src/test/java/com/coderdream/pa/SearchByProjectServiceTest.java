package com.coderdream.pa;

import org.junit.Before;
import org.junit.Test;

public class SearchByProjectServiceTest extends BaseTest {

	private SearchByProjectService searchByProjectService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		searchByProjectService = new SearchByProjectService();
	}

	@Test
	public void testSearchByProject() {
		String roleName = "主管|领导";
		String staffName = "[B-15550]刘秋岭";
		searchByProjectService.login(driver, roleName, staffName);

		searchByProjectService.searchByProject(driver);

		String queryString = "HiSTB";
		String projectName = "HiSTB软件测试外包合作项目3期";
		searchByProjectService.setProjectInfoAndEnterToAuditPage(driver,
						queryString, projectName);
	}

}
