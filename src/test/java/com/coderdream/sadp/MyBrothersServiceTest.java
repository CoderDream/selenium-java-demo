package com.coderdream.sadp;

import org.junit.Before;
import org.junit.Test;

public class MyBrothersServiceTest extends BaseTest {

	private MyBrothersService myBrothersService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		myBrothersService = new MyBrothersService();
	}

	@Test
	public void testMyProfile() {
		String roleName = "团队经理";
		String staffName = "[B-13545]史磊";
		myBrothersService.login(driver, roleName, staffName);

		myBrothersService.myBrothers(driver);
		
		String profileName = "[B-10771]齐兆慧";
		myBrothersService.selectProfileByName(driver, profileName);
	}
	

}
