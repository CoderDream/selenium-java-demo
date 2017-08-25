package com.coderdream.sadp;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfileService extends BaseSadpService {

	public Map<String, String> myProfile(WebDriver driver) {
		String linkText = "人力看板--我的人力档案";
		// 根据传入的值选择下拉选单，点击该项目
		driver.findElement(By.linkText(linkText)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		String fileName = snapshot(method, driver);
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("登陆【我的人力档案】页面", fileName);
		return map;
	}

	public Map<String, String> myProfileBaseInfo(WebDriver driver) {
		String linkText = "基本信息";
		// 根据传入的值选择下拉选单，点击该项目
		driver.findElement(By.linkText(linkText)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		String fileName = snapshot(method, driver);
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("登陆【基本信息】页面", fileName);
		return map;
	}

	public Map<String, String> updateMyProfileBaseInfo(WebDriver driver) {
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);

		// 点击下拉选单
		driver.findElement(By.id("profile-update-btn")).click();
		Map<String, String> map = new LinkedHashMap<String, String>();
		String fileName = snapshot(method, driver);
		map.put("登陆【基本信息】页面", fileName);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);

		// 点击确定按钮
		driver.findElement(By.xpath("//span[text()='确定']")).click();
		String fileName2 = snapshot(method, driver);
		map.put("点击【确定】按钮", fileName2);

		return map;
	}

	/**
	 * 修改技能
	 * 
	 * @param driver
	 * @param skillName
	 * @return
	 */
	public Map<String, String> editSkill(WebDriver driver, String skillName) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		// 点击下拉选单
		driver.findElement(By.xpath("//span[text()='" + skillName + "']"))
						.click();
		String fileName1 = snapshot(method, driver);
		map.put("点击技能", fileName1);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// snapshot(method, driver);

		driver.findElement(By.id("skill-btn")).click();
		String fileName2 = snapshot(method, driver);
		map.put("点击【修改】按钮", fileName2);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// snapshot(method, driver);

		// 点击确定按钮
		driver.findElement(By.xpath("//span[text()='确定']")).click();
		String fileName3 = snapshot(method, driver);
		map.put("点击【确定】按钮", fileName3);

		return map;
	}

	public Map<String, String> editDomain(WebDriver driver, String domainName) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		// 点击下拉选单
		driver.findElement(By.xpath("//span[text()='" + domainName + "']"))
						.click();
		String fileName1 = snapshot(method, driver);
		map.put("点击领域", fileName1);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);

		driver.findElement(By.id("domain-btn")).click();
		String fileName2 = snapshot(method, driver);
		map.put("点击【修改】按钮", fileName2);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);

		// 点击确定按钮
		driver.findElement(By.xpath("//span[text()='确定']")).click();
		String fileName3 = snapshot(method, driver);
		map.put("点击【确定】按钮", fileName3);

		return map;
	}
}
