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

