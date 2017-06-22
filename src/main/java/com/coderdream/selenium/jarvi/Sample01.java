package com.coderdream.selenium.jarvi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * selenium webdriver学习（一）------------快速开始
 * http://jarvi.iteye.com/blog/1447389
 *
 */
public class Sample01 {

	@Test
	public void openUrl() {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		WebElement element = driver.findElement(By.name("wd"));
		element.sendKeys("hello Selenium!");
		element.submit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Page title is: " + driver.getTitle());

		driver.quit();
	}

}
