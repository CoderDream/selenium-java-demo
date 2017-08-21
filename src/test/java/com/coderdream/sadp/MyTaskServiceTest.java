package com.coderdream.sadp;

import org.junit.Before;
import org.junit.Test;

public class MyTaskServiceTest extends BaseTest {

	private MyTaskService myTaskService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		myTaskService = new MyTaskService();
	}

	@Test
	public void testMyTask() {
		String roleName = "项目经理";
		String staffName = "B-10700[李玮颖]";
		myTaskService.login(driver, roleName, staffName);

		myTaskService.myTask(driver);
		

//		myTaskService.myProfileBaseInfo(driver);
//		
//		
//		myTaskService.updateMyProfileBaseInfo(driver);
//		
//
//		myTaskService.returnMyProfile(driver);
//		
//		String skillName = "iOS";
//		myTaskService.editSkill(driver, skillName);
	}
	

}
