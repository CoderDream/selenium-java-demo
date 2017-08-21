package com.coderdream.pa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddAuditServiceTest extends BaseTest {

	private AddAuditService addAuditService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		addAuditService = new AddAuditService();
	}

	@Test
	public void testEnterToAddAuditPage() {
		String roleName = "QA|PMO|运营";
		String staffName = "[B-7382]全荃";
		addAuditService.login(driver, roleName, staffName);
		//
		addAuditService.enterToAddAuditPage(driver);

		//
		String queryString = "HiSTB";
		String projectName = "HiSTB软件测试外包合作项目3期";
		addAuditService.setProjectInfoAndEnterToAuditPage(driver, queryString,
						projectName);

		String typeName = "目标合理性";
		addAuditService.enterToAddAuditItemPage(driver, typeName);

		String auditItemName = "质量目标合理性";
		String auditContent = "非常合理";
		Boolean passFlag = true;
		addAuditService.addAuditItem(driver, auditItemName, auditContent,
						passFlag);

		addAuditService.enterToEditAuditItemPage(driver, auditItemName);

		String newAuditContent = "SAI值不合格";
		Boolean newPassFlag = false;
		addAuditService.editAuditItem(driver, newAuditContent, newPassFlag);

		// 删除审计科目
		addAuditService.enterToEditAuditItemPage(driver, auditItemName);
		addAuditService.deleteAuditItem(driver);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
