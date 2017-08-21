package com.coderdream.pdrc;

import org.junit.Before;
import org.junit.Test;

public class ViewMyAuditServiceTest extends BaseTest {

	private ViewMyAuditService viewMyAuditService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		viewMyAuditService = new ViewMyAuditService();
	}

	// @Test
	// public void testAddAudit02() {
	// // get()打开一个站点
	// driver.get("https://www.baidu.com");
	// //getTitle()获取当前页面title的值
	// System.out.println("当前打开页面的标题是： "+ driver.getTitle());
	//
	// //关闭并退出浏览器
	// driver.quit();
	// }

	@Test
	public void testViewMyAudit01() {
		String roleName = "QA|PMO|运营";
		String staffName = "[B-7382]全荃";
		viewMyAuditService.login(driver, roleName, staffName);

		viewMyAuditService.myAudit(driver);

		String projectName = "供应_DF_流通子产品2017年7月版本";
		viewMyAuditService.enterToAuditPage(driver, projectName);

		String typeName = "操作规范性";
		viewMyAuditService.enterToAddAuditItemPage(driver, typeName);

		String auditItemName = "立项结项及时性";
		String auditContent = "非常及时";
		Boolean passFlag = true;
		viewMyAuditService.addAuditItem(driver, auditItemName, auditContent,
						passFlag);

		viewMyAuditService.enterToEditAuditItemPage(driver, auditItemName);

		String newAuditContent = "再次审核发现不及时";
		Boolean newPassFlag = false;
		viewMyAuditService.editAuditItem(driver, newAuditContent, newPassFlag);

		viewMyAuditService.enterToEditAuditItemPage(driver, auditItemName);
		viewMyAuditService.deleteAuditItem(driver);
	}

}
