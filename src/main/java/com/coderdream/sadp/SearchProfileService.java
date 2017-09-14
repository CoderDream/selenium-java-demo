package com.coderdream.sadp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProfileService extends BaseSadpService {

	public void searchByParams(WebDriver driver, String linkText, String skillName) {
		// String linkText = "人力看板--人力查询-按技能查询";
		// 根据传入的值选择下拉选单，点击该项目
		driver.findElement(By.linkText(linkText)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		snapshot(method, driver);

		// 绝对匹配
		driver.findElement(By.xpath("//label[text()='" + skillName + "']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);

		// query-condition-btn
		driver.findElement(By.id("profile-query-btn")).click();
		snapshot(method, driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);
	}
	
	// 
	
	public void selectProfileByName(WebDriver driver, String profileName) {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();

		// 绝对匹配
		driver.findElement(By.xpath("//span[text()='" + profileName + "']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);
	}

	public void myProfileBaseInfo(WebDriver driver) {
		String linkText = "基本信息";
		// 根据传入的值选择下拉选单，点击该项目
		driver.findElement(By.linkText(linkText)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		snapshot(method, driver);
	}

	public void updateMyProfileBaseInfo(WebDriver driver) {
		// // profile-update-btn
		// String linkText = "基本信息";
		// // 根据传入的值选择下拉选单，点击该项目
		// driver.findElement(By.linkText(linkText)).click();
		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		snapshot(method, driver);

		// 点击下拉选单
		driver.findElement(By.id("profile-update-btn")).click();
		snapshot(method, driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);

		// 点击确定按钮
		driver.findElement(By.xpath("//span[text()='确定']")).click();
		snapshot(method, driver);
	}

	/**
	 * 返回我的人力看板
	 * 
	 * @param driver
	 */
	public void returnMyProfile(WebDriver driver) {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		// 点击下拉选单
		driver.findElement(By.id("rtn-btn")).click();
		snapshot(method, driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);
	}

	// iOS
	public void editSkill(WebDriver driver, String skillName) {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		// 点击下拉选单
		driver.findElement(By.xpath("//span[text()='" + skillName + "']")).click();
		snapshot(method, driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);

		driver.findElement(By.id("skill-btn")).click();
		snapshot(method, driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);

		// 点击确定按钮
		driver.findElement(By.xpath("//span[text()='确定']")).click();
		snapshot(method, driver);
	}

	public void editDomain(WebDriver driver, String domainName) {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		// 点击下拉选单
		driver.findElement(By.xpath("//span[text()='" + domainName + "']")).click();
		snapshot(method, driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);

		driver.findElement(By.id("domain-btn")).click();
		snapshot(method, driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);

		// 点击确定按钮
		driver.findElement(By.xpath("//span[text()='确定']")).click();
		snapshot(method, driver);
	}
}
