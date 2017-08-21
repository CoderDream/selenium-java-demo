package com.coderdream.sadp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBrothersService extends BaseSadpService {
	
	public void myBrothers(WebDriver driver) {
		String linkText = "人力看板--我的汇报线";
		// 根据传入的值选择下拉选单，点击该项目
		driver.findElement(By.linkText(linkText)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		snapshot(method, driver);
		
		// 
	}

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
}
