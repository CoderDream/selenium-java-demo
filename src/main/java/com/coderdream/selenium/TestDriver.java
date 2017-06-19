package com.coderdream.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDriver {

	public static void main(String[] args) {
		testFireFox();
		//testChrome();
	}

	private static void testFireFox() {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://test3.bill-jc.com/";
		driver.get(baseUrl);
		driver.quit();
	} 
	
	
	private static void testChrome() {
		System.setProperty("webdriver.chrome.driver", "D:/Java/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.baidu.com/";
		driver.get(baseUrl);
		driver.quit();
	}

}
