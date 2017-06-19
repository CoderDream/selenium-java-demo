package com.coderdream.selenium;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baidu {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {// D:\Firefox\firefox.exe
		// C:\Program Files (x86)\Mozilla Firefox\firefox.exe
		System.setProperty("webdriver.firefox.bin", "D:\\Firefox\\firefox.exe");
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");  
		
		//System.setProperty("webdriver.gecko.driver", "D://Java//geckodriver-v0.17.0-win64");
		driver = new FirefoxDriver();
		baseUrl = "https://www.baidu.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testBaidu() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("kw")).click();
		driver.findElement(By.id("kw")).click();
		driver.findElement(By.id("kw")).click();
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys("https://www.baidu.com/");
		driver.findElement(By.id("su")).click();
		driver.findElement(By.id("kw")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
