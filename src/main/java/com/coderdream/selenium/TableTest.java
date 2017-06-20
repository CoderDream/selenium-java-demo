package com.coderdream.selenium;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableTest {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = System.getProperty("user.dir") + "\\src\\main\\java\\com\\coderdream\\selenium\\table.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testTable_01() throws Exception {
		driver.get(baseUrl);
		System.out.println(driver.findElement(By.tagName("table")).getClass());
		//class "org.openqa.selenium.remote.RemoteWebElement"
	}
	
	@Test
	public void testTable_02() throws Exception {
		driver.get(baseUrl);
		//System.out.println(driver.findElement(By.tagName("table")).getClass());
		//class "org.openqa.selenium.remote.RemoteWebElement"
		WebElement table = driver.findElement(By.tagName("table"));
		// findElement是定位单个元素的方法
		//table.findElement(By.tagName("tr"));
		
		// findElements是定位一组元素的方法
		String str1 = "第二行第2列";
		String str2 = "第三行第6列";
		List<WebElement> trs = table.findElements(By.tagName("tr"));
		for (WebElement tr : trs) {
			List<WebElement> tds = tr.findElements(By.tagName("td"));
			for (WebElement td : tds) {
				//System.out.println(td.getText());
				if(str1.equals(td.getText()) ||str2.equals(td.getText())) {
					System.out.println(td.getText());
				} else {
					System.out.println("error");
				}
			}
		}
	}
	
	@Test
	public void testTable_03() throws Exception {
		System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径 
	}
	
	
	
	

}
