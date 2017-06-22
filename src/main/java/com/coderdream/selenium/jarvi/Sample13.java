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
 * selenium webdriver学习（十三）------------如何利用Actions类模拟鼠标和键盘的操作
 * http://jarvi.iteye.com/blog/1468690
 * 
 * </pre>
 */
public class Sample13 {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "C:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.baidu.com/";
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
		WebElement element = driver.findElement(By.id("kw"));
		WebElement element1 = driver.findElement(By.id("su"));
		element.sendKeys("test");
		element1.click();
		// 这里等待页面加载完成
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

	/**
	 * <pre>
	 * 单一的操作
	 * 单一的操作是指鼠标和键盘的一个操作。如鼠标左键按下、弹起或输入一个字符串等。
	 * 	  用Actions类就可以这样实现：
	 * </pre>
	 */
	@Test
	public void testSimpleAction_02() {
		driver.get(baseUrl);

		// 新建一个action
		Actions action = new Actions(driver);
		// 操作
		WebElement element = driver.findElement(By.id("kw"));
		WebElement element1 = driver.findElement(By.id("su"));
		action.sendKeys(element, "Selenium Actions").perform();
		action.moveToElement(element1);
		action.click().perform();
		// 这里等待页面加载完成
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

	/**
	 * <pre>
	 * 组合操作
	组合操作就是几个动作连在一起进行操作。如对一个元素的拖放。
	Java代码  收藏代码
	(new Actions(dr)).dragAndDrop(dr.findElement(By.id(item)), target).perform();    
	可以直接调用dragAndDrip()方法，也可以像下面濱示的一样把几个操作放一起实现
	Java代码  收藏代码
	Action dragAndDrop = builder.clickAndHold(someElement)  
	   .moveToElement(otherElement)  
	   .release(otherElement)  
	   .build().perform();  
	其他鼠标或键盘操作方法可以具体看一下API里面的org.openqa.selenium.interactions.Actions类
	 * 
	 * </pre>
	 */

}