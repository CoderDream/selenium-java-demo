package com.coderdream.selenium;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableTest {
	private WebDriver driver;
	private String baseUrl;


	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "C:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = System.getProperty("user.dir")
						+ "\\src\\main\\java\\com\\coderdream\\selenium\\table.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testTable_01() throws Exception {
		driver.get(baseUrl);
		System.out.println(driver.findElement(By.tagName("table")).getClass());
		// class "org.openqa.selenium.remote.RemoteWebElement"
	}

	/**
	 * <pre>
	 * findElement是定位单个元素的方法
	 * findElements是定位一组元素的方法
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTable_02() throws Exception {
		driver.get(baseUrl);
		WebElement table = driver.findElement(By.tagName("table"));

		// findElements是定位一组元素的方法
		String str1 = "第二行第2列";
		String str2 = "第三行第6列";
		List<WebElement> trs = table.findElements(By.tagName("tr"));
		for (WebElement tr : trs) {
			List<WebElement> tds = tr.findElements(By.tagName("td"));
			for (WebElement td : tds) {
				// System.out.println(td.getText());
				if (str1.equals(td.getText()) || str2.equals(td.getText())) {
					System.out.println(td.getText());
				} else {
					System.out.println("error");
				}
			}
		}
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
