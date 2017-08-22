package com.coderdream.sadp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SearchTaskServiceTest extends BaseTest {

	private SearchTaskService searchTaskService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		searchTaskService = new SearchTaskService();
	}

	@Test
	public void testSearchByParams_01() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		searchTaskService.login(driver, roleName, staffName);
		String skillName = "JAVA";
		String linkText = "任务看板--按技能查询任务";
		searchTaskService.searchByParams(driver, linkText, skillName);

		// String profileName = "[B-12122]于秋雪";
		// searchTaskService.selectProfileByName(driver, profileName);
	}

	@Test
	public void testSearchByParams_02() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		searchTaskService.login(driver, roleName, staffName);
		String domainName = "CRM";
		String linkText = "任务看板--按领域查询任务";
		searchTaskService.searchByParams(driver, linkText, domainName);

		// String profileName = "[B-10612]朱艳艳";
		// searchTaskService.selectProfileByName(driver, profileName);
	}

	@Test
	public void testSearchByParams_03() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		searchTaskService.login(driver, roleName, staffName);
		String workPlace = "武汉";
		String linkText = "任务看板--按工作城市查询任务";
		searchTaskService.searchByParams(driver, linkText, workPlace);

		// String profileName = "[B-10803]谢文晨";
		// searchTaskService.selectProfileByName(driver, profileName);
	}

}
