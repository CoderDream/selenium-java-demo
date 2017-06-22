package com.coderdream.selenium.jarvi;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <pre>
 * selenium webdriver学习（四）------------定位页面元素
 * http://jarvi.iteye.com/blog/1448025 frame_login_user frame_login_label_user
 * 
 * <input autocomplete="off" maxlength="255" value="" class="s_ipt" name="wd" id
="kw">
 * </pre>
 */
public class Sample04 {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
	}

	/**
	 * 使用className进行定位 当所定位的元素具有class属性的时候我们可以通过classname来定位该元素。
	 */
	@Test
	public void testByClassName() {
		driver.get("https://www.baidu.com");
		WebElement element = driver.findElement(By.className("s_ipt"));
		System.out.println(element.getTagName());
		driver.quit();
	}

	/**
	 * 使用id属性定位 在下面的例子中我们用id定位这个输入框，并输出其maxlength和autocomplete,借此也可以验证代码是否工作正常
	 */
	@Test
	public void testById() {
		driver.get("https://www.baidu.com");
		WebElement element = driver.findElement(By.id("kw"));
		System.out.println(element.getAttribute("maxlength"));
		System.out.println(element.getAttribute("autocomplete"));
		driver.quit();
	}

	/**
	 * 定位多个元素 上面提到findElements()方法可以返回一个符合条件的元素List组。看下面例子。
	 */
	@Test
	public void findElements() {
		driver.get("http://www.51.com");

		// 定位到所有<input>标签的元素，然后输出他们的id
		List<WebElement> element = driver.findElements(By.tagName("input"));
		for (WebElement e : element) {
			System.out.println(e.getAttribute("id"));
		}

		driver.quit();
	}

	@Test
	public void findLayerLocator() {
		driver.get("http://www.51.com");

		// 定位class为"login"的div，然后再取得它下面的所有label，并打印出他们的值
		WebElement element = driver.findElement(By.className("login"));
		List<WebElement> el = element.findElements(By.tagName("label"));
		for (WebElement e : el) {
			System.out.println(e.getText());
		}

		driver.quit();
	}

}