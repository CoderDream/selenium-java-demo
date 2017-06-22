package com.coderdream.pdrc;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ViewProjectEvaluationService {

	private WebDriver driver;
	private String baseUrl;

	public ViewProjectEvaluationService(String baseUrl) {
		System.setProperty("webdriver.firefox.bin", "C:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		this.setBaseUrl(baseUrl);
	}

	public void viewMyProjectEvaluation() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// 自定义浏览器窗口大小
		// driver.manage().window().setSize(new Dimension(1400, 1000));
		// 浏览器最大化
		driver.manage().window().maximize();
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-024");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot("case_0201_login.png");

		navigateToEvalPage();

		snapshot("case_0201_login_evaluate_page.png");

		// 跳出frame,进入default content;
		driver.switchTo().defaultContent();

		// 点击头像
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		snapshot("case_0203_quit_system.png");
		// 退出浏览器
		driver.quit();
	}

	private void snapshot(String picname) {
		// 这里等待页面加载完成
		try {
			// Thread.sleep(1000);

			// 下面代码是得到截图并保存在D盘下
			File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile, new File(System.getProperty("user.dir") + "\\snapshot\\" + picname));

			// Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void navigateToEvalPage() {
		// 我的工作台
		driver.findElement(By.xpath(".//*[@id='menulist']/li[3]/a/span[1]")).click();
		// 我的项目评价
		driver.findElement(By.xpath(".//*[@id='menulist']/li[3]/ul/li[2]/a")).click();

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");
		snapshot("case_0102_enter_evaluate_project_page.png");

		WebElement child = driver.findElement(By.linkText("P06211624"));
		// System.out.println("child:\t" + child);

		WebElement parent = child.findElement(By.xpath("./.."));// 找到父元素
		// System.out.println("parent:\t" + parent);
		WebElement grandpa = parent.findElement(By.xpath("./.."));// 找到父元素
		// System.out.println("grandpa:\t" + grandpa);
		List<WebElement> brothers = grandpa.findElements(By.xpath("./*"));// 找到所有子元素

		for (WebElement webElement : brothers) {
			if (-1 != webElement.getText().indexOf("已分配")) {
				// List<WebElement> evalBrothersWebElement =
				// webElement.findElements(By.xpath("./*"));// 找到所有子元素
				// for (WebElement webElement2 : evalBrothersWebElement) {
				// // System.out.println(
				// // "brothers webElement:\t" + webElement2.getText() + "\t" +
				// // webElement2.getTagName());
				// if (webElement2.getText().equals("评价")) {
				// webElement2.click();
				System.out.println("Find 已分配");
			} else {
				System.out.println("Not Find 已分配");
			}
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
