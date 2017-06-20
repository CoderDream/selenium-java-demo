package com.coderdream.selenium.jarvi;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <pre>
 * selenium webdriver学习（十二）------------如何利用selenium-webdriver截图
 * http://jarvi.iteye.com/blog/1464169
 * 
 * </pre>
 */
public class Sample12 {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.baidu.com/";
	}

	/**
	 * <pre>
	 * </pre>
	 */
	@Test
	public void testTakesScreenshot() {
		driver.get(baseUrl);
		// 这里等待页面加载完成
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 下面代码是得到截图并保存在D盘下
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\coderdream\\selenium\\jarvi\\test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

}