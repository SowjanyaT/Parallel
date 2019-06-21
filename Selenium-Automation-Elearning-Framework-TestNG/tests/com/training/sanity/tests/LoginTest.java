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

public class LoginTest {
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
	
	public void setUp() throws Exception {
		
		driver=DriverFactory.getDriver(DriverNames.CHROME);
		driver.manage().window().maximize();
		uniformPOM = new UniformPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(1000);
	}
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
	@Test(groups = {"LoginTest"},priority=1)
	public void validLoginTest() throws InterruptedException  {
		driver=DriverFactory.getDriver(DriverNames.CHROME);
		driver.manage().window().maximize();
		uniformPOM = new UniformPOM(driver); 
		driver.get("http://uniform.upskills.in/");
	
		// open the browser 
		
		Thread.sleep(1000);
		uniformPOM.clickAccount();
		uniformPOM.clickLogin();
	
		uniformPOM.sendemail("1234@gmail.com");
		uniformPOM.sendPassword("Souji1210");
		uniformPOM.clickLoginBtn(); 
		
		
	}
	
}
