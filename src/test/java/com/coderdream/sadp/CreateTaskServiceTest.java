package com.coderdream.sadp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CreateTaskServiceTest extends BaseTest {

	private CreateTaskService createTaskService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		createTaskService = new CreateTaskService();
	}

	@Test
	public void testCreateTaskByParams() {
		String roleName = "项目经理";
		String staffName = "B-14640[严伟]";//
		createTaskService.login(driver, roleName, staffName);

		createTaskService.enterToTaskPage(driver);

		String taskName = "区域工具_终端样机_10月版本前台开发";
		String taskDescription = "区域工具_终端样机_10月版本登陆页面优化";
		String acceptanceStandard = "华为验收标准";
		String queryCondition = "区域工具_终端样机";
		String projectName = "区域工具_终端样机_10月版本";
		createTaskService.createTaskByParams(driver, taskName, taskDescription,
						queryCondition, projectName, acceptanceStandard);
	}

}
