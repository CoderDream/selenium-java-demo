package com.coderdream.selenium.jarvi;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * <pre>
 * selenium webdriver学习（十）------------如何把一个元素拖放到另一个元素里面
 * http://jarvi.iteye.com/blog/1452220
 * </pre>
 */
public class Sample10 {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\coderdream\\selenium\\jarvi\\drag-drop.html";
	}

	/**
	 * <pre>

	 * </pre>
	 */
	@Test
	public void testGetPopupWindow() {
		driver.get(baseUrl);
		// 首先new出要拖入的页面元素对象和目标对象，然后进行拖入。
		WebElement element = driver.findElement(By.id("drag1"));
		WebElement target = driver.findElement(By.id("div2"));
		(new Actions(driver)).dragAndDrop(element, target).perform();

		// 利用循环把其它item也拖入
//		String id = "item";
//		for (int i = 2; i <= 6; i++) {
//			String item = id + i;
//			(new Actions(driver)).dragAndDrop(driver.findElement(By.id(item)), target).perform();
//		}
//
//		
//
//		driver.quit();
	}

}