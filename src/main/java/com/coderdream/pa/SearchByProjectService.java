package com.coderdream.pa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchByProjectService extends BaseAuditService {

	public void searchByProject(WebDriver driver) {
		driver.findElement(By.id("search_by_project")).click();

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
