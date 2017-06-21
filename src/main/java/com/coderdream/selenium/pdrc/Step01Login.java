package com.coderdream.selenium.pdrc;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过

		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		driver.quit();
	}

	@Test
	public void testSimpleAction_02() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		// ASP.NET_SessionId=otno02xpryeg2qktbsufoobr; path=/; domain=test3.bill-jc.com; HttpOnly
		// 增加一个name = "name",value="value"的cookie pzhlkc2js2xalixqknayam1z
		//Cookie cookie = new Cookie("ASP.NET_SessionId", "pzhlkc2js2xalixqknayam1z");
		//driver.manage().addCookie(cookie);
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		


		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过

		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		//driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		//driver.quit();
	}

	@Test
	public void testSimpleAction_03() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过

		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		driver.quit();
	}

	@Test
	public void testSimpleAction_04() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过

		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		driver.quit();
	}

	@Test
	public void testSimpleAction_05() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过

		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		driver.quit();
	}

	@Test
	public void testSimpleAction_06() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过

		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		driver.quit();
	}

	@Test
	public void testSimpleAction_07() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过

		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		driver.quit();
	}

	@Test
	public void testSimpleAction_08() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过

		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		driver.quit();
	}

	@Test
	public void testSimpleAction_09() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过

		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();
		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		driver.quit();
	}

	@Test
	public void testSimpleAction_10() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26026");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='FirstShow']"));
		checkBoxElement.click();
		System.out.println("checkBoxElement:\t" + checkBoxElement.isSelected());

		driver.findElement(By.className("ZebraDialog_Button_0")).click();

		// 跳过
		driver.findElement(By.xpath("html/body/div[5]/div/div[5]/a[1]")).click();

		driver.findElement(By.xpath(".//*[@id='NoShow']")).click();

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/a")).click();

		// 跳出frame,进入default content;重新定位id="id1"的div
		driver.switchTo().defaultContent();

		// 点击头像 xpath html/body/div[1]/div/div/ul/li[3]/a/img
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		// 关闭浏览器
		driver.quit();
	}

}