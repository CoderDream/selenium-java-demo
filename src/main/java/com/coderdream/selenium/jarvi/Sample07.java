package com.coderdream.selenium.jarvi;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <pre>
 * selenium webdriver学习（七）------------如何处理alert、confirm、prompt对话框
 * http://jarvi.iteye.com/blog/1450750
 * </pre>
 */
public class Sample07 {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = System.getProperty("user.dir") + "\\src\\main\\java\\com\\coderdream\\selenium\\jarvi\\dialog.html";
	}

	/**
	 * <pre>
	 * 从以上代码可以看出driver.switchTo().alert();
	 * 这句可以得到alert\confirm\prompt对话框的对象，然后运用其方法对它进行操作。对话框操作的主要方法有：
	 * 	getText()     得到它的文本值
	 * 	accept()      相当于点击它的"确认"
	 * 	dismiss()     相当于点击"取消"或者叉掉对话框
	 * 	sendKeys()    输入值，这个alert\confirm没有对话框就不能用了，不然会报错。
	 * </pre>
	 */
	@Test
	public void testGetPopupWindow() {
		driver.get(baseUrl);
		// 点击第一个按钮，输出对话框上面的文字，然后叉掉
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		alert.dismiss();	

		// 点击第二个按钮，输出对话框上面的文字，然后点击确认
		driver.findElement(By.id("confirm")).click();
		Alert confirm = driver.switchTo().alert();
		String text1 = confirm.getText();
		System.out.println(text1);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		confirm.accept();
		
		// 点击第三个按钮，输入你的名字，然后点击确认，最后
		driver.findElement(By.id("prompt")).click();
		Alert prompt = driver.switchTo().alert();
		String text2 = prompt.getText();
		System.out.println(text2);
		prompt.sendKeys("jarvi");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		prompt.accept();
		
		driver.quit();
	}

}