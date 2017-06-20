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
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.baidu.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testBaidu_01() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("kw")).sendKeys("selenium");
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testBaidu_02() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.name("wd")).sendKeys("webdriver");
	}
	
	/**
	 * by className
	 * @throws Exception
	 */
	@Test
	public void testBaidu_03() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.className("s_ipt")).sendKeys("test");
	}
	
	/**
	 * by linkText
	 * @throws Exception
	 */
	@Test
	public void testBaidu_04() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("新闻")).click();
	}
	
	/**
	 * by linkText
	 * @throws Exception
	 */
	@Test
	public void testBaidu_05() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.partialLinkText("新")).click();
	}

	/**
	 * by xpath
	 * @throws Exception
	 */
	@Test
	public void testBaidu_06() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("test");
	}
	
	/**
	 * by cssSelector
	 * @throws Exception
	 */
	@Test
	public void testBaidu_07() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.cssSelector("#kw")).sendKeys("css");
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
