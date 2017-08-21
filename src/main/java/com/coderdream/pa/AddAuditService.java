package com.coderdream.pa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAuditService extends BaseAuditService {

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


}
