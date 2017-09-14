package com.coderdream.pa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchByAuditItemService extends BaseAuditService {

	public void searchByAuditItem(WebDriver driver, String auditItem) {
		driver.findElement(By.id("search_by_item")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);
		// 绝对匹配
		driver.findElement(By.xpath("//label[text()='" + auditItem + "']"))
						.click();

		snapshot(method, driver);
		
		
		// 提交
		driver.findElement(By.id("project-audit-query-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);
	}
	
	// 质量目标合理性

	public void enterToSearchAuditPage(WebDriver driver, String typeName) {
		// 链接文字
		driver.findElement(By.linkText(typeName)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot("pa_test_case_0301_my_audit.png", driver);
	}

//	public void addAudit(WebDriver driver, String value, String auditContent,
//					Boolean passFlag) {
//		Select selectRoleName = new Select(
//						driver.findElement(By.id("auditItem")));
//		selectRoleName.selectByValue(value);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		// 设置评价内容
//		driver.findElement(By.id("auditContent")).clear();
//		driver.findElement(By.id("auditContent")).sendKeys(auditContent);
//
//		// Select selectAuditState = new Select(
//		// driver.findElement(By.id("auditState")));
//
//		// List<WebElement> radios = driver.findElements(By.name("auditState"));
//		// for (int i = 0; i < radios.size(); i++) {
//		// WebElement webElement = radios.get(i);
//		// System.out.println("TagName: \t" + webElement.getTagName());
//		// System.out.println("name: \t" + webElement.getAttribute("name"));
//		// System.out.println("id: \t" + webElement.getAttribute("id"));
//		// }
//
//		// pass or fail 通过Label点击
//		if (passFlag) {
//			driver.findElement(By.id("label_pass")).click();
//		} else {
//			driver.findElement(By.id("label_fail")).click();
//		}
//
//		// 提交
//		driver.findElement(By.id("audit-btn")).click();
//
//		// 点击确定按钮
//		// 绝对匹配
//		driver.findElement(By.xpath("//span[text()='确定']")).click();
//
//		snapshot("pa_test_case_0301_my_audit.png", driver);
//	}

//	/**
//	 * 质量目标合理性
//	 * 
//	 * @param driver
//	 * @param auditItemName
//	 */
//	public void enterToEditAuditPage(WebDriver driver, String auditItemName) {
//		// 链接文字
//		driver.findElement(By.linkText(auditItemName)).click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		snapshot("pa_test_case_0401_my_audit.png", driver);
//	}

//	public void editAudit(WebDriver driver, String auditContent,
//					Boolean passFlag) {
//
//		// 设置评价内容
//		driver.findElement(By.id("auditContent")).clear();
//		driver.findElement(By.id("auditContent")).sendKeys(auditContent);
//
//		// Select selectAuditState = new Select(
//		// driver.findElement(By.id("auditState")));
//
//		// List<WebElement> radios = driver.findElements(By.name("auditState"));
//		// for (int i = 0; i < radios.size(); i++) {
//		// WebElement webElement = radios.get(i);
//		// System.out.println("TagName: \t" + webElement.getTagName());
//		// System.out.println("name: \t" + webElement.getAttribute("name"));
//		// System.out.println("id: \t" + webElement.getAttribute("id"));
//		// }
//
//		// pass or fail 通过Label点击
//		if (passFlag) {
//			driver.findElement(By.id("label_pass")).click();
//		} else {
//			driver.findElement(By.id("label_fail")).click();
//		}
//
//		// 提交
//		driver.findElement(By.id("audit-btn")).click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		// 点击确定按钮
//		// 绝对匹配
//		driver.findElement(By.xpath("//span[text()='确定']")).click();
//
//		snapshot("pa_test_case_0401_my_audit.png", driver);
//	}
//
//	/**
//	 * @param driver
//	 */
//	public void deleteAudit(WebDriver driver) {
//		// 提交
//		driver.findElement(By.id("delete-btn")).click();
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		snapshot("pa_test_case_0402_my_audit.png", driver);
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		// 点击确定按钮
//		// 绝对匹配
//		driver.findElement(By.xpath("//span[text()='确定']")).click();
//
//		snapshot("pa_test_case_0402_my_audit.png", driver);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void snapshot(String picname, WebDriver driver) {
//		// 这里等待页面加载完成
//		try {
//			// Thread.sleep(1000);
//
//			// 下面代码是得到截图并保存在D盘下
//			File screenShotFile = ((TakesScreenshot) driver)
//							.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(screenShotFile,
//							new File(System.getProperty("user.dir")
//											+ "\\snapshot\\" + picname));
//
//			// Thread.sleep(1000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// private void navigateToEvalPage() {
	// // 我的工作台
	// driver.findElement(By.xpath(".//*[@id='menulist']/li[3]/a/span[1]"))
	// .click();
	// // 我的项目评价
	// driver.findElement(By.xpath(".//*[@id='menulist']/li[3]/ul/li[2]/a"))
	// .click();
	//
	// // 进入id=""frame_content""的frame中
	// driver.switchTo().frame("frame_content");
	// snapshot("pa_test_case_0102_enter_evaluate_project_page.png");
	//
	// WebElement child = driver.findElement(By.linkText("P06211624"));
	// // System.out.println("child:\t" + child);
	//
	// WebElement parent = child.findElement(By.xpath("./.."));// 找到父元素
	// // System.out.println("parent:\t" + parent);
	// WebElement grandpa = parent.findElement(By.xpath("./.."));// 找到父元素
	// // System.out.println("grandpa:\t" + grandpa);
	// List<WebElement> brothers = grandpa.findElements(By.xpath("./*"));//
	// 找到所有子元素
	//
	// for (WebElement webElement : brothers) {
	// if (-1 != webElement.getText().indexOf("已分配")) {
	// // List<WebElement> evalBrothersWebElement =
	// // webElement.findElements(By.xpath("./*"));// 找到所有子元素
	// // for (WebElement webElement2 : evalBrothersWebElement) {
	// // // System.out.println(
	// // // "brothers webElement:\t" + webElement2.getText() + "\t" +
	// // // webElement2.getTagName());
	// // if (webElement2.getText().equals("评价")) {
	// // webElement2.click();
	// System.out.println("Find 已分配");
	// } else {
	// System.out.println("Not Find 已分配");
	// }
	// }
	//
	// try {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	//
	// }

}
