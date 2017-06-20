package com.coderdream.selenium.jarvi;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <pre>
 * selenium webdriver学习（五）------------iframe的处理
 * http://jarvi.iteye.com/blog/1450525
 * </pre>
 */
public class Sample05 {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = System.getProperty("user.dir") + "\\src\\main\\java\\com\\coderdream\\selenium\\jarvi\\main.html";
	}

	/**
	 * 使用className进行定位 当所定位的元素具有class属性的时候我们可以通过classname来定位该元素。
	 */
	@Test
	public void testByClassName() {
		driver.get(baseUrl);
		// 在default content定位id="id1"的div
		driver.findElement(By.id("id1"));

		// 此时，没有进入到id="frame"的frame中时，以下两句会报错
		//driver.findElement(By.id("div1"));// 报错
		//driver.findElement(By.id("input1"));// 报错

		// 进入id="frame"的frame中，定位id="div1"的div和id="input1"的输入框。
		driver.switchTo().frame("frame");
		driver.findElement(By.id("div1"));
		driver.findElement(By.id("input1"));

		// 此时，没有跳出frame，如果定位default content中的元素也会报错。
		//driver.findElement(By.id("id1"));// 报错

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();
		driver.findElement(By.id("id1"));

		driver.quit();
	}

}