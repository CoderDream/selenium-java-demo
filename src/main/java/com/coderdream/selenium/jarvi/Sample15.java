package com.coderdream.selenium.jarvi;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * <pre>
 * selenium webdriver学习（十五）------------如何处理FirefoxProfile
 * http://jarvi.iteye.com/blog/1482064
 * </pre>
 */
public class Sample15 {

	// private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
		// driver = new FirefoxDriver();
		baseUrl = "https://www.baidu.com";
	}

	/**
	 * <pre>
	 * 对下拉框进行操作时首先要定位到这个下拉框，new 一个Selcet对象，然后对它进行操作。
	 * </pre>
	 */
	@Test
	public void testGetPopupWindow() {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\coderdream\\selenium\\jarvi\\";
		File file = new File(path + "firebug-1.12.8-fx.xpi");
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		try {
			firefoxProfile.addExtension(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.12.8"); // 避免启动画面
		firefoxProfile.setEnableNativeEvents(true);
		WebDriver driver = new FirefoxDriver(firefoxProfile);
		
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setEnableNativeEvents(true);
//		driver = new FirefoxDriver(profile);

		driver.get(baseUrl);

		// driver.quit();
	}

	@Test
	public void testEnableNativeEvents() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
		WebDriver driver = new FirefoxDriver(profile);

		driver.get(baseUrl);

		// driver.quit();
	}

}