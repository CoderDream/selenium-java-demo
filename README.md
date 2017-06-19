# selenium-java-demo
selenium-java-demo

 selenium 版本 
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
