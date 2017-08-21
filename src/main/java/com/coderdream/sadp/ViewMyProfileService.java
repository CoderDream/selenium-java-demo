package com.coderdream.sadp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewMyProfileService extends BaseSadpService {

	public void myProfile(WebDriver driver) {
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
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);
	}

	public void updateMyProfileBaseInfo(WebDriver driver) {
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
		snapshot(method, driver);
	}

	/**
	 * 返回我的人力看板
	 * 
	 * @param driver
	 */
	public void returnMyProfile(WebDriver driver) {
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
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

}
