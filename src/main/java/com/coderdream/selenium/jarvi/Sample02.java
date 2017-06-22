package com.coderdream.selenium.jarvi;

import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * selenium webdriver学习（二）————对浏览器的简单操作
 * http://jarvi.iteye.com/blog/1447672
 *
 */
public class Sample02 {

	@Test
	public void openUrl() {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		String url = "https://www.baidu.com";
		WebDriver driver = new FirefoxDriver();

		// 用get方法
		driver.get(url);

		// 用navigate方法，然后再调用to方法
		driver.navigate().to(url);
	}

	@Test
	public void closeBrowser_01() {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		String url = "https://www.baidu.com";
		WebDriver driver = new FirefoxDriver();

		// 用get方法
		driver.get(url);

		// 用quit方法
		driver.quit();
	}

	@Test
	public void closeBrowser_02() {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		String url = "https://www.baidu.com";
		WebDriver driver = new FirefoxDriver();

		// 用get方法
		driver.get(url);

		// 用close方法
		driver.close();
	}

	@Test
	public void testGetUrlAndTitle() {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		String url = "https://www.baidu.com";
		WebDriver driver = new FirefoxDriver();
		driver.get(url);

		// 得到title
		String title = driver.getTitle();

		// 得到当前页面url
		String currentUrl = driver.getCurrentUrl();

		// 输出title和currenturl
		System.out.println(title + "\n" + currentUrl);

		// 其他方法
		// getWindowHandle() 返回当前的浏览器的窗口句柄
		// getWindowHandles() 返回当前的浏览器的所有窗口句柄
		// getPageSource() 返回当前页面的源码
		System.out.println(driver.getWindowHandle());
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			System.out.println(string);
		}
		System.out.println(driver.getPageSource());
	}
}