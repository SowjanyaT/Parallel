package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformTest {
	private WebDriver driver;
	private String baseUrl;
	private UniformPOM uniformPOM;
	private static Properties properties;
	private ScreenShot screenShot;
    ExtentReports extent;
    ExtentTest logger;
	
	@BeforeTest
	public void extentreport()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/Uniform.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}
	
	@BeforeMethod
	@Parameters("mybrowser")
	public void setUp(String mybrowser) throws Exception {
		if(mybrowser.equalsIgnoreCase("Firefox"))
		{
			/*System.setProperty("webdriver.gecko.driver","C:\\Users\\SOWJANYATHATIKONDA\\Documents\\EFMS - A\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();*/
			driver=DriverFactory.getDriver(DriverNames.FIREFOX);
			
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			
		}
		else if(mybrowser.equalsIgnoreCase("Chrome"))
		{
			/*System.setProperty("webdriver.chrome.driver","C:\\Users\\SOWJANYATHATIKONDA\\Documents\\EFMS - A\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();*/
			driver=DriverFactory.getDriver(DriverNames.CHROME);
			driver.manage().window().maximize();
			Thread.sleep(3000);
		}
		
		uniformPOM = new UniformPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(1000);
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		logger=extent.startTest("Uniformtest");
		uniformPOM.clickAccount();
		uniformPOM.clickLogin();
	
		uniformPOM.sendemail("1234@gmail.com");
		uniformPOM.sendPassword("Souji1210");
		uniformPOM.clickLoginBtn(); 
		uniformPOM.clickOrderHistory();
		uniformPOM.clickView();
		screenShot.captureScreenShot();
		logger.log(LogStatus.PASS, "Application opened");
		String title=driver.getTitle();
		logger.log(LogStatus.PASS, title);
		logger.log(LogStatus.PASS, "Browser closed succesfully");
		extent.endTest(logger);
		extent.flush();
		extent.close();
		
	}
	
}
