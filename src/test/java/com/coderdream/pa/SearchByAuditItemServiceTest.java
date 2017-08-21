package com.coderdream.pa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchByAuditItemServiceTest extends BaseTest {

	private SearchByAuditItemService searchByAuditItemService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		searchByAuditItemService = new SearchByAuditItemService();
	}

	@Test
	public void testSearchByAuditItem() {
		String roleName = "主管|领导";
		String staffName = "[B-15550]刘秋岭";
		searchByAuditItemService.login(driver, roleName, staffName);

		String auditItem = "质量目标合理性";

		searchByAuditItemService.searchByAuditItem(driver, auditItem);

		String projectName = "icaptain-v3.1.6-2017-06";
		searchByAuditItemService.enterToAuditPage(driver, projectName);
	}
	
	@Test
	public void testSearchByAuditItem_02() {
		String roleName = "主管|领导";
		String staffName = "[B-15550]刘秋岭";
		searchByAuditItemService.login(driver, roleName, staffName);

		String auditItem = "质量评价数据填报准确性";

		searchByAuditItemService.searchByAuditItem(driver, auditItem);

		String projectName = "icaptain-v3.1.6-2017-06";
		searchByAuditItemService.enterToAuditPage(driver, projectName);
	}


	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
