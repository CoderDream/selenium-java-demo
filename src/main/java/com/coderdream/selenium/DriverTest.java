package com.coderdream.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverTest {

	@Test
	public void testFireFox() {
		System.setProperty("webdriver.firefox.bin", "C:/Firefox/firefox.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://www.baidu.com/";
		driver.get(baseUrl);
		driver.quit();
	}

	@Test
	public void testChrome() {
		System.setProperty("webdriver.chrome.driver", "D:/Java/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.baidu.com/";
		driver.get(baseUrl);
		driver.quit();
	}
}
