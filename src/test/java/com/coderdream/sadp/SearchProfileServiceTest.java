package com.coderdream.sadp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SearchProfileServiceTest extends BaseTest {

	private SearchProfileService searchProfileService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		searchProfileService = new SearchProfileService();
	}

	@Test
	public void testSearchByParams_01() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		searchProfileService.login(driver, roleName, staffName);
		String skillName = "JAVA";
		String linkText = "人力看板--人力查询-按技能查询";
		searchProfileService.searchByParams(driver, linkText, skillName);
		
		String profileName = "[B-12122]于秋雪";
		searchProfileService.selectProfileByName(driver, profileName);
	}
	
	@Test
	public void testSearchByParams_02() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		searchProfileService.login(driver, roleName, staffName);
		String domainName = "ERP";
		String linkText = "人力看板--人力查询-按领域查询";
		searchProfileService.searchByParams(driver, linkText, domainName);
		
		String profileName = "[B-10612]朱艳艳";
		searchProfileService.selectProfileByName(driver, profileName);
	}
	
	@Test
	public void testSearchByParams_03() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		searchProfileService.login(driver, roleName, staffName);
		String workPlace = "武汉";
		String linkText = "人力看板--人力查询-按工作城市查询";
		searchProfileService.searchByParams(driver, linkText, workPlace);
		
		String profileName = "[B-10803]谢文晨";
		searchProfileService.selectProfileByName(driver, profileName);
	}
	
	// 任务看板--按技能查询任务
	
	@Test
	public void testSearchByParams_04() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		searchProfileService.login(driver, roleName, staffName);
		String skillName = "JAVA";
		String linkText = "任务看板--按技能查询任务";
		searchProfileService.searchByParams(driver, linkText, skillName);
		
//		String profileName = "[B-12122]于秋雪";
//		searchProfileService.selectProfileByName(driver, profileName);
	}
	
	@Test
	public void testSearchByParams_05() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		searchProfileService.login(driver, roleName, staffName);
		String domainName = "ERP";
		String linkText = "任务看板--按领域查询任务";
		searchProfileService.searchByParams(driver, linkText, domainName);
		
		String profileName = "[B-10612]朱艳艳";
		searchProfileService.selectProfileByName(driver, profileName);
	}
	
	@Test
	public void testSearchByParams_06() {
		String roleName = "普通员工";
		String staffName = "[B-13416]王东霞";
		searchProfileService.login(driver, roleName, staffName);
		String workPlace = "武汉";
		String linkText = "人力看板--人力查询-按工作城市查询";
		searchProfileService.searchByParams(driver, linkText, workPlace);
		
		String profileName = "[B-10803]谢文晨";
		searchProfileService.selectProfileByName(driver, profileName);
	}


}
