package com.coderdream.sadp;

import org.junit.Before;
import org.junit.Test;

public class ViewMyProfileServiceTest extends BaseTest {

	private ViewMyProfileService viewMyProfileService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		viewMyProfileService = new ViewMyProfileService();
	}

	@Test
	public void testMyProfile() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		viewMyProfileService.login(driver, roleName, staffName);

		viewMyProfileService.myProfile(driver);
	}

}
