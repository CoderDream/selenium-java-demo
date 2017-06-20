package com.coderdream.selenium.jarvi;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * <pre>
 * selenium webdriver学习（八）------------如何操作select下拉框
 * http://jarvi.iteye.com/blog/1450883
 * </pre>
 */
public class Sample08 {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = System.getProperty("user.dir") + "\\src\\main\\java\\com\\coderdream\\selenium\\jarvi\\select.html";
	}

	/**
	 * <pre>
	 * 对下拉框进行操作时首先要定位到这个下拉框，new 一个Selcet对象，然后对它进行操作。
	 * </pre>
	 */
	@Test
	public void testGetPopupWindow() {
		driver.get(baseUrl);
		// 通过下拉列表中选项的索引选中第二项，即2011年
		Select selectAge = new Select(driver.findElement(By.id("cars")));
		selectAge.selectByIndex(2);

		// 通过下拉列表中的选项的value属性选中"上海"这一项
		Select selectShen = new Select(driver.findElement(By.id("User_Shen")));
		selectShen.selectByValue("Shanghai");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 通过下拉列表中选项的可见文本选 中"浦东"这一项
		Select selectTown = new Select(driver.findElement(By.id("User_Town")));
		selectTown.selectByVisibleText("浦东");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 这里只是想遍历一下下拉列表所有选项，用click进行选中选项
		Select selectCity = new Select(driver.findElement(By.id("User_City")));
		for (WebElement webElement : selectCity.getOptions()) {
			webElement.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		driver.quit();
	}

}