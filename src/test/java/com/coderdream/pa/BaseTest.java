package com.coderdream.pa;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	String baseUrl;

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		baseUrl = "http://10.50.20.123:8080/resource/mybrothers/";

		System.setProperty("webdriver.firefox.bin", "C:/Firefox/firefox.exe");
		driver = new FirefoxDriver();

		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// 自定义浏览器窗口大小
		driver.manage().window().setSize(new Dimension(540, 720));
		// 浏览器最大化
		// driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
