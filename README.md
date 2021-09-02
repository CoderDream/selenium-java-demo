# selenium-java-demo
selenium-java-demo

 Selenium 版本 
----------
pom.xml文件中，版本选2.53.1 ，不要选3.x，否则报错

	<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
	<dependency>
		<groupId>org.seleniumhq.selenium</groupId>
		<artifactId>selenium-java</artifactId>
		<version>2.53.1</version>
	</dependency>

Firefox版本  
----------
27~46

通过下面的代码配置Firefox的安装路径：

	@Before
	public void setUp() throws Exception 
		System.setProperty("webdriver.firefox.bin", "D:\\Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.baidu.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}



ChromeDriver版本（失败，还没有有找到原因）
----------

v2.9.248315 on port 23485

![](https://github.com/CoderDream/selenium-java-demo/blob/master/snapshot/s_0001.png?raw=true)

![](https://github.com/CoderDream/selenium-java-demo/blob/master/snapshot/s_0002.png?raw=true)

定位方式 
----------
com.coderdream.selenium.Baidu.java

| 用例        | 方式           | 使用插件|
| ------------- |:-------------:|:-------------:|
| testBaidu_01      | By.id("kw") |Firebug|
| testBaidu_02      | By.name("wd") |Firebug|
| testBaidu_03      |By.className("s_ipt") | Firebug|
| testBaidu_04      | By.linkText("新闻") | Firebug|
| testBaidu_05      | By.partialLinkText("新") |Firebug|
| testBaidu_06      |By.xpath(".//*[@id='kw']") |Firepath(xpath)|
| testBaidu_07      |By.cssSelector("#kw") | Firepath(css)|

![](https://github.com/CoderDream/selenium-java-demo/blob/master/snapshot/s_0003.png?raw=true)


表格定位
----------

先通过findElement找到表格，然后通过findElements找到所有tr，再通过findElements找到所有td

    WebElement table = driver.findElement(By.tagName("table"));
    // findElement是定位单个元素的方法
    //table.findElement(By.tagName("tr"));
    
    // findElements是定位一组元素的方法
    String str1 = "第二行第2列";
    String str2 = "第三行第6列";
    List<WebElement> trs = table.findElements(By.tagName("tr"));
    for (WebElement tr : trs) {
    	List<WebElement> tds = tr.findElements(By.tagName("td"));
    	for (WebElement td : tds) {
    		//System.out.println(td.getText());
    		if(str1.equals(td.getText()) ||str2.equals(td.getText())) {
    			System.out.println(td.getText());
    		} else {
    			System.out.println("error");
    		}
    	}
    }



Selenium-webdriver学习教程 
----------
地址： [http://jarvi.iteye.com/category/203994](http://jarvi.iteye.com/category/203994)

    package com.coderdream.selenium.jarvi

| 序号        | 主题           | 链接|
| ------------- |:-------------|:-------------:|
| Sample01      | 快速开始|[http://jarvi.iteye.com/blog/1447389](http://jarvi.iteye.com/blog/1447389)|
| Sample02      | 对浏览器的简单操作|[http://jarvi.iteye.com/blog/1447672](http://jarvi.iteye.com/blog/1447672)|
| Sample03      | 执行js脚本|[http://jarvi.iteye.com/blog/1447755](http://jarvi.iteye.com/blog/1447755)|
| Sample04      | 定位页面元素|[http://jarvi.iteye.com/blog/1448025](http://jarvi.iteye.com/blog/1448025)|
| Sample05      | iframe的处理|[http://jarvi.iteye.com/blog/1450525](http://jarvi.iteye.com/blog/1450525)|
| Sample06      | 如何得到弹出窗口|[http://jarvi.iteye.com/blog/1450626](http://jarvi.iteye.com/blog/1450626)|
| Sample07      | 如何处理alert、confirm、prompt对话框|[http://jarvi.iteye.com/blog/1450750](http://jarvi.iteye.com/blog/1450750)|
| Sample08      | 如何操作select下拉框|[http://jarvi.iteye.com/blog/1450883](http://jarvi.iteye.com/blog/1450883)|
| Sample09      | 如何操作cookies|[http://jarvi.iteye.com/blog/1451019](http://jarvi.iteye.com/blog/1451019)|
| Sample10      | 如何把一个元素拖放到另一个元素里面（未实现）|[http://jarvi.iteye.com/blog/1452220](http://jarvi.iteye.com/blog/1452220)|
| Sample11      | 如何等待页面元素加载完成|[http://jarvi.iteye.com/blog/1453662](http://jarvi.iteye.com/blog/1453662)|
| Sample12      | 如何利用selenium-webdriver截图|[http://jarvi.iteye.com/blog/1464169](http://jarvi.iteye.com/blog/1464169)|
| Sample13      | 如何利用Actions类模拟鼠标和键盘的操作|[http://jarvi.iteye.com/blog/1468690](http://jarvi.iteye.com/blog/1468690)|
| Sample14      | 如何处理table|[http://jarvi.iteye.com/blog/1477837](http://jarvi.iteye.com/blog/1477837)|
| Sample15      | 如何处理FirefoxProfile（有问题）|[http://jarvi.iteye.com/blog/1482064](http://jarvi.iteye.com/blog/1482064)|





## Send Mail 错误

```
javax.mail.AuthenticationFailedException: 535 Error: authentication failed
```







# END