package com.coderdream.pa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewMyAuditService extends BaseAuditService {

	public void myAudit(WebDriver driver) {
		driver.findElement(By.id("my_audit")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String method = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
		snapshot(method, driver);
	}

}
