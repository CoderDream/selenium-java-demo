package com.coderdream.selenium.jarvi;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * selenium webdriver学习（三）------------执行js脚本
 * http://jarvi.iteye.com/blog/1447755
 *
 */
public class Sample03 {

	@Test
	public void testExecuteScript_01() {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		WebDriver driver = new FirefoxDriver();
		((JavascriptExecutor) driver).executeScript("alert(\"hello,this is a alert!\")");
	}

	@Test
	public void testExecuteScript_02() {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com");
		String js = "var user_input = document.getElementById('setf').href;return user_input;";

		String title = (String) ((JavascriptExecutor) driver).executeScript(js);
		System.out.println("### href: \t" + title);
	}

}