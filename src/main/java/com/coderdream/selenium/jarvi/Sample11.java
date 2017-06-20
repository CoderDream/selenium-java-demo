package com.coderdream.selenium.jarvi;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * <pre>
 * selenium webdriver学习（十一）------------如何等待页面元素加载完成
 * http://jarvi.iteye.com/blog/1453662
 * 
 * web的自动化测试中，我们经常会遇到这样一种情况：当我们的程序执行时需要页面某个元素，而此时这个元素还未加载完成，这时我们的程序就会报错。
 * 怎么办？等待。等待元素出现后再进行对这个元素的操作。
 * 在selenium-webdriver中我们用两种方式进行等待：明确的等待和隐性的等待。
 * </pre>
 */
public class Sample11 {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = System.getProperty("user.dir") + "\\src\\main\\java\\com\\coderdream\\selenium\\jarvi\\wait.html";
	}

	/**
	 * <pre>
	 * 明确的等待
	 * 	明确的等待是指在代码进行下一步操作之前等待某一个条件的发生。最不好的情况是使用Thread.sleep()去设置一段确认的时间去等待。
	 * 但为什么说最不好呢？因为一个元素的加载时间有长有短，你在设置sleep的时间之前要自己把握长短，太短容易超时，太长浪费时间。
	 * selenium webdriver提供了一些方法帮助我们等待正好需要等待的时间。利用WebDriverWait类和ExpectedCondition接口就能实现这一点。
	 * 	下面的html代码实现了这样的一种效果：点击click按钮5秒钟后，页面上会出现一个红色的div块。
	 * 我们需要写一段自动化脚本去捕获这个出现的div，然后高亮之。
	 * </pre>
	 */
	@Test
	public void testWait_01() {
		driver.get(baseUrl);
		// 等待10秒
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("b")).click();
		WebElement wl = wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.cssSelector(".red_box"));
			}
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid yellow'", wl);

		driver.quit();
	}

	/**
	 * <pre>
	 * 隐性的等待
	 * 隐性的等待其实就相当于设置全局的等待，在定位元素时，对所有元素设置超时时间。
	 * </pre>
	 */
	@Test
	public void testWait_02() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.findElement(By.id("b")).click();

		WebElement wl = driver.findElement(By.cssSelector(".red_box"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid yellow'", wl);

		driver.quit();
	}

}