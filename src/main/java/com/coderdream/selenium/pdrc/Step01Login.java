package com.coderdream.selenium.pdrc;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Step01Login {

	/**
	 * <pre>
	 * selenium webdriver学习（十三）------------如何利用Actions类模拟鼠标和键盘的操作
	 * http://jarvi.iteye.com/blog/1468690
	 * 
	 * </pre>
	 */

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://test3.bill-jc.com/";
	}

	/**
	 * <pre>
	 * 单一的操作
	 * 单一的操作是指鼠标和键盘的一个操作。如鼠标左键按下、弹起或输入一个字符串等。
	 * 	 * 前面涉及到鼠标键盘操作的一些方法，都可以使用actions类中的方法实现，比如：click，sendkeys。
	 * </pre>
	 */
	@Test
	public void testSimpleAction_01() {
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-13685");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		// 这里等待页面加载完成
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// FirstShow
		// WebElement firstShowElement = driver.findElement(By.id("FirstShow"));
		// if (null != firstShowElement) {
		// ZebraDialog_Button_0

		// <a class="introjs-button introjs-skipbutton"
		// href="javascript:void(0);">跳过</a>

		// <input type="checkbox" style="margin-top:-1px;" id="NoShow">

		// <a href="javascript:void(0)" class="ZebraDialog_Button_0">确定</a>
		// }

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		// http://test3.bill-jc.com/Logins/Login
		// driver.quit();
	}

	/**
	 * <pre>
	 * 单一的操作
	 * 单一的操作是指鼠标和键盘的一个操作。如鼠标左键按下、弹起或输入一个字符串等。
	 * 	  用Actions类就可以这样实现：
	 * </pre>
	 */
	//
	// @Test
	// public void testSimpleAction_02() {
	// driver.get(baseUrl);
	//
	// // 新建一个action
	// Actions action = new Actions(driver);
	// // 操作
	// WebElement element = driver.findElement(By.id("kw"));
	// WebElement element1 = driver.findElement(By.id("su"));
	// action.sendKeys(element, "Selenium Actions").perform();
	// action.moveToElement(element1);
	// action.click().perform();
	// // 这里等待页面加载完成
	// try {
	// Thread.sleep(5000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	//
	// driver.quit();
	// }

}