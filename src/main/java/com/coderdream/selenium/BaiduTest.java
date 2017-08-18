package com.coderdream.selenium;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaiduTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		// System.setProperty("webdriver.firefox.bin",
		// "D:/Firefox/firefox.exe");
		// 打开指定路径的firefox,方法2
		File pathToFirefoxBinary = new File("C:\\Firefox\\firefox.exe");
		FirefoxBinary firefoxbin = new FirefoxBinary(pathToFirefoxBinary);
		driver = new FirefoxDriver(firefoxbin, null);
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
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBaidu_03() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.className("s_ipt")).sendKeys("test");
	}

	/**
	 * by linkText
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBaidu_04() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("新闻")).click();
	}

	/**
	 * by linkText
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBaidu_05() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.partialLinkText("新")).click();
	}

	/**
	 * by xpath
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBaidu_06() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("test");
	}

	/**
	 * by cssSelector
	 * 
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

}
