package com.coderdream.pa;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.util.Constants;

public class BaseAuditService {

	private static Logger logger = LoggerFactory
					.getLogger(BaseAuditService.class);

	/**
	 * @param driver
	 * @param roleName
	 * @param staffName
	 */
	public void login(WebDriver driver, String roleName, String staffName) {
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();

		// 点击下拉选单
		driver.findElement(By.id("roleName")).click();
		snapshot(method, driver);
		snapshot(method, driver);
		snapshot(method, driver);
		snapshot(method, driver);
		snapshot(method, driver);

		new SnapThread("A", method, driver).start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new SnapThread("A", method, driver).start();
		snapshot(method, driver);

		// 根据传入的值选择下拉选单，点击该项目
		driver.findElement(By.xpath("//option[text()='" + roleName + "']"))
						.click();

		new SnapThread("A", method, driver).start();
		snapshot(method, driver);
		// 设置值
		Select selectRoleName = new Select(
						driver.findElement(By.id("roleName")));
		snapshot(method, driver);
		selectRoleName.selectByVisibleText(roleName);

		new SnapThread("A", method, driver).start();
		snapshot(method, driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);

		// 点击下拉选单
		driver.findElement(By.id("staff")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 根据传入的值选择下拉选单，点击该项目
		driver.findElement(By.xpath("//option[text()='" + staffName + "']"))
						.click();
		// 设置值
		Select selectUser = new Select(driver.findElement(By.id("staff")));
		selectUser.selectByVisibleText(staffName);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);

		driver.findElement(By.id("submit")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);
	}

	public void enterToAddAuditPage(WebDriver driver) {
		driver.findElement(By.id("new_audit")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);
	}

	public void enterToAuditPage(WebDriver driver, String projectName) {
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		// 绝对匹配
		driver.findElement(By.xpath("//span[text()='" + projectName + "']"))
						.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);
	}

	/**
	 * @param driver
	 * @param queryString
	 * @param projectName
	 */
	public void setProjectInfoAndEnterToAuditPage(WebDriver driver,
					String queryString, String projectName) {
		// 清空输入框
		driver.findElement(By.id("autocomplete_input_project")).clear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 输入查询条件
		driver.findElement(By.id("autocomplete_input_project"))
						.sendKeys(queryString);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);

		// 选择查询结果
		driver.findElement(By.xpath("//li[text()='" + projectName + "']"))
						.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);

		// 点击查询按钮
		driver.findElement(By.id("project-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);
	}

	/**
	 * 根据审计类型名称，进入新增审计科目页面
	 * 
	 * @param driver
	 * @param typeName
	 */
	public void enterToAddAuditItemPage(WebDriver driver, String typeName) {
		// 链接文字
		driver.findElement(By.linkText(typeName)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);
	}

	public void addAuditItem(WebDriver driver, String auditItemName,
					String auditContent, Boolean passFlag) {
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		// 点击下拉选单
		driver.findElement(By.id("auditItem")).click();
		snapshot(method, driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		snapshot(method, driver);

		// 根据传入的值选择下拉选单，点击该项目
		driver.findElement(By.xpath("//option[text()='" + auditItemName + "']"))
						.click();
		snapshot(method, driver);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 设置值
		Select selectRoleName = new Select(
						driver.findElement(By.id("auditItem")));
		selectRoleName.selectByVisibleText(auditItemName);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);

		// 设置评价内容
		driver.findElement(By.id("auditContent")).clear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("auditContent")).sendKeys(auditContent);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);

		// pass or fail 通过Label点击
		if (passFlag) {
			driver.findElement(By.id("label_pass")).click();
		} else {
			driver.findElement(By.id("label_fail")).click();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);

		// 提交
		driver.findElement(By.id("audit-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);

		// 点击确定按钮
		driver.findElement(By.xpath("//span[text()='确定']")).click();
		snapshot(method, driver);
	}

	/**
	 * 质量目标合理性
	 * 
	 * @param driver
	 * @param auditItemName
	 */
	public void enterToEditAuditItemPage(WebDriver driver,
					String auditItemName) {
		// 链接文字
		driver.findElement(By.linkText(auditItemName)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);
	}

	public void editAuditItem(WebDriver driver, String auditContent,
					Boolean passFlag) {
		// 设置评价内容
		driver.findElement(By.id("auditContent")).clear();
		driver.findElement(By.id("auditContent")).sendKeys(auditContent);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);

		// pass or fail 通过Label点击
		if (passFlag) {
			driver.findElement(By.id("label_pass")).click();
		} else {
			driver.findElement(By.id("label_fail")).click();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);

		// 提交
		driver.findElement(By.id("audit-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);

		// 点击确定按钮
		// 绝对匹配
		driver.findElement(By.xpath("//span[text()='确定']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		snapshot(method, driver);
	}

	/**
	 * @param driver
	 */
	public void deleteAuditItem(WebDriver driver) {
		// 提交
		driver.findElement(By.id("delete-btn")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 点击确定按钮
		// 绝对匹配
		driver.findElement(By.xpath("//span[text()='确定']")).click();

		snapshot(method, driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snapshot(method, driver);
	}
	
	

	public void snapshot(String picname, WebDriver driver) {
		SimpleDateFormat sf = new SimpleDateFormat(
						Constants.COMPLEX_DATE_FORMAT2);
		picname = sf.format(new Date()) + "_" + picname + ".png";
		logger.debug("picname\t {}", picname);

		// 这里等待页面加载完成
		try {
			// Thread.sleep(1000);

			// 下面代码是得到截图并保存在D盘下
			File screenShotFile = ((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile,
							new File(System.getProperty("user.dir")
											+ "\\snapshot\\" + picname));

			// Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class SnapThread extends Thread {

	private static Logger logger = LoggerFactory.getLogger(SnapThread.class);

	private String picname;
	private WebDriver driver;

	public SnapThread(String threadName, String picname, WebDriver driver) {
		super(threadName);
		this.picname = picname;
		this.driver = driver;
	}

	public void run() {
		System.out.println(getName() + " 线程运行开始!");
		SimpleDateFormat sf = new SimpleDateFormat(
						Constants.COMPLEX_DATE_FORMAT2);
		picname = sf.format(new Date()) + "_" + picname + ".png";
		logger.debug("picname\t {}", picname);

		// 这里等待页面加载完成
		try {
			// Thread.sleep(1000);

			// 下面代码是得到截图并保存在D盘下
			File screenShotFile = ((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile,
							new File(System.getProperty("user.dir")
											+ "\\snapshot\\" + picname));

			// Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(getName() + " 线程运行结束!");
	}
}