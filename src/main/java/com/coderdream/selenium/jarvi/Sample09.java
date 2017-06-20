package com.coderdream.selenium.jarvi;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <pre>
 * selenium webdriver学习（九）------------如何操作cookies
 * http://jarvi.iteye.com/blog/1451019
 * </pre>
 */
public class Sample09 {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.baidu.com/";
	}

	/**
	 * <pre>
	 * 对下拉框进行操作时首先要定位到这个下拉框，new 一个Selcet对象，然后对它进行操作。
	 * </pre>
	 */
	@Test
	public void testCookie() {
		driver.get(baseUrl);
		// 增加一个name = "name",value="value"的cookie
		Cookie cookie = new Cookie("name", "value");
		driver.manage().addCookie(cookie);

		// 得到当前页面下所有的cookies，并且输出它们的所在域、name、value、有效日期和路径
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(String.format("Domain -> name -> value -> expiry -> path"));
		for (Cookie c : cookies) {
			System.out.println(String.format("%s -> %s -> %s -> %s -> %s", c.getDomain(), c.getName(), c.getValue(),
					c.getExpiry(), c.getPath()));
		}

		// 删除cookie有三种方法
		// 第一种通过cookie的name
		driver.manage().deleteCookieNamed("CookieName");
		// 第二种通过Cookie对象
		driver.manage().deleteCookie(cookie);
		// 第三种全部删除
		driver.manage().deleteAllCookies();

		driver.quit();
	}

}