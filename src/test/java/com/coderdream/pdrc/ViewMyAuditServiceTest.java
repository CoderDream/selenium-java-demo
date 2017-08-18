package com.coderdream.pdrc;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ViewMyAuditServiceTest {

	private String baseUrl;

	private WebDriver driver;

	private ViewMyAuditService viewMyAuditService;

	@Before
	public void setUp() throws Exception {
		baseUrl = "http://10.50.20.123:8080/resource/mybrothers/";

		System.setProperty("webdriver.firefox.bin", "C:/Firefox/firefox.exe");
		driver = new FirefoxDriver();

		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// 自定义浏览器窗口大小
		driver.manage().window().setSize(new Dimension(720, 960));
		// 浏览器最大化
		// driver.manage().window().maximize();
		driver.get(baseUrl);

		viewMyAuditService = new ViewMyAuditService();
	}

	@Test
	public void testLogin01() {
		String roleName = "qapmoopt";
		String workId = "01bzNAVgXbhOoLmpVhhwc5f7B2jLDBCZKYG%2FYA6VNeg%3D";
		viewMyAuditService.login(driver, roleName, workId);
	}

	@Test
	public void testMyAudit01() {
		String roleName = "qapmoopt";
		String workId = "01bzNAVgXbhOoLmpVhhwc5f7B2jLDBCZKYG%2FYA6VNeg%3D";
		String projectName = "ISC+解决方案测试6-8月版本";
		viewMyAuditService.login(driver, roleName, workId);
		viewMyAuditService.myAudit(driver, projectName);
	}

	@Test
	public void testAddAudit01() {
		String roleName = "qapmoopt";
		String workId = "01bzNAVgXbhOoLmpVhhwc5f7B2jLDBCZKYG%2FYA6VNeg%3D";
		String projectName = "ISC+解决方案测试6-8月版本";
		viewMyAuditService.login(driver, roleName, workId);
		viewMyAuditService.myAudit(driver, projectName);

		String typeName = "目标合理性";
		viewMyAuditService.enterToAddAuditPage(driver, typeName);

		String value = "2";
		String auditContent = "非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理非常合理";
		Boolean passFlag = false;
		viewMyAuditService.addAudit(driver, value, auditContent, passFlag);
	}
	
	@Test
	public void testEditAudit01() {
		String roleName = "qapmoopt";
		String workId = "01bzNAVgXbhOoLmpVhhwc5f7B2jLDBCZKYG%2FYA6VNeg%3D";
		String projectName = "ISC+解决方案测试6-8月版本";
		viewMyAuditService.login(driver, roleName, workId);
		viewMyAuditService.myAudit(driver, projectName);

		String auditItemName = "质量目标合理性";
		viewMyAuditService.enterToEditAuditPage(driver, auditItemName);

		String auditContent = "非常合理";
		Boolean passFlag = true;
		viewMyAuditService.editAudit(driver, auditContent, passFlag);
	}
	
	@Test
	public void testDeleteAudit01() {
		String roleName = "qapmoopt";
		String workId = "01bzNAVgXbhOoLmpVhhwc5f7B2jLDBCZKYG%2FYA6VNeg%3D";
		String projectName = "ISC+解决方案测试6-8月版本";
		viewMyAuditService.login(driver, roleName, workId);
		viewMyAuditService.myAudit(driver, projectName);

		String auditItemName = "质量目标合理性";
		viewMyAuditService.enterToEditAuditPage(driver, auditItemName);

		viewMyAuditService.deleteAudit(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
