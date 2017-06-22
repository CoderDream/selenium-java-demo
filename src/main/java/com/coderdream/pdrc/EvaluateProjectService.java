package com.coderdream.pdrc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EvaluateProjectService {

	private WebDriver driver;
	private String baseUrl;

	public EvaluateProjectService(String baseUrl) {
		System.setProperty("webdriver.firefox.bin", "C:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		// baseUrl = "http://test3.bill-jc.com/";
		// this.baseUrl = "http://localhost:1666/";
		this.setBaseUrl(baseUrl);
	}

	public void evaluateProject() {
		// 设置10秒
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// 浏览器最大化
		// driver.manage().window().maximize();
		driver.get(baseUrl);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("B-26050");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("123");
		driver.findElement(By.cssSelector("input.templatemo-blue-button.width-100")).click();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		navigateToEvalPage();

		// 添加成员
		driver.findElement(By.xpath(".//*[@id='a_add']")).click();

		driver.findElement(By.xpath(".//*[@id='ProjectBookDateTime_0']")).sendKeys("2017-06-22");
		driver.findElement(By.xpath(".//*[@id='ProjectReleaseDateTime_0']")).sendKeys("2017-06-22");

		driver.findElement(By.xpath(".//*[@id='grid1']/tbody/tr/td[5]/input")).sendKeys("0.9");

		// 添加成员
		driver.findElement(By.xpath(".//*[@id='s2id_option0']/a/div/b")).click();

		WebElement optionElement = driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input"));
		optionElement.click();
		optionElement.sendKeys("B-024");

		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li/div")).click();

		((JavascriptExecutor) driver).executeScript("document.getElementById('a_save').click()");

		driver.findElement(By.xpath("html/body/div[6]/div[2]/div/a")).click();

		// 跳出frame,进入default content;
		driver.switchTo().defaultContent();

		// 点击头像
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a/img")).click();

		// 点击注销
		driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/ul/li[3]/a")).click();

		driver.quit();
	}

	private void navigateToEvalPage() {
		// 1 运营管理 click
		driver.findElement(By.xpath(".//*[@id='menulist']/li[6]/a/span[1]")).click();
		// 2 立项管理 click
		driver.findElement(By.xpath(".//*[@id='menulist']/li[6]/ul/li[1]/a/span[1]")).click();
		// 3 项目立项 click
		driver.findElement(By.xpath(".//*[@id='menulist']/li[6]/ul/li[1]/ul/li[2]/a")).click();

		// 进入id=""frame_content""的frame中
		driver.switchTo().frame("frame_content");

		WebElement child = driver.findElement(By.linkText("P06211624"));
		System.out.println("child:\t" + child);

		WebElement parent = child.findElement(By.xpath("./.."));// 找到父元素
		System.out.println("parent:\t" + parent);
		WebElement grandpa = parent.findElement(By.xpath("./.."));// 找到父元素
		System.out.println("grandpa:\t" + grandpa);
		List<WebElement> brothers = grandpa.findElements(By.xpath("./*"));// 找到所有子元素

		for (WebElement webElement : brothers) {
			if (-1 != webElement.getText().indexOf("评价")) {
				List<WebElement> evalBrothersWebElement = webElement.findElements(By.xpath("./*"));// 找到所有子元素
				for (WebElement webElement2 : evalBrothersWebElement) {
					System.out.println(
							"brothers webElement:\t" + webElement2.getText() + "\t" + webElement2.getTagName());
					if (webElement2.getText().equals("评价")) {
						webElement2.click();
					}
				}
			}
		}

		try {
			Thread.sleep(10000);
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
