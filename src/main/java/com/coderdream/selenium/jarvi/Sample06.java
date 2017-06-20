package com.coderdream.selenium.jarvi;

import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <pre>
 * selenium webdriver学习（六）------------如何得到弹出窗口
 * http://jarvi.iteye.com/blog/1450626
 * </pre>
 */
public class Sample06 {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = System.getProperty("user.dir") + "\\src\\main\\java\\com\\coderdream\\selenium\\jarvi\\popup.html";
	}

	@Test
	public void testGetPopupWindow() {
		driver.get(baseUrl);
		WebElement webElement = driver.findElement(By.id("51"));
		webElement.click();
		// 得到当前窗口的句柄
		String currentWindow = driver.getWindowHandle();
		// 得到所有窗口的句柄
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle)) {
				continue;
			}
			WebDriver window = driver.switchTo().window(handle);
			System.out.println("title,url = " + window.getTitle() + "," + window.getCurrentUrl());
		}

		driver.quit();
	}

}