package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.InvalidCredentialsPOM;
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class InvalidCredentialsTest {
	private WebDriver driver;
	private String baseUrl;
	private InvalidCredentialsPOM invalidcredentilasPOM;
	private static Properties properties;
	private ScreenShot screenShot;
    ExtentReports extent;
    ExtentTest logger;
	
	@BeforeTest
	public void extentreport()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/InvalidCredentials.html",true);
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
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		invalidcredentilasPOM = new InvalidCredentialsPOM(driver); 
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
		logger=extent.startTest("InvalidCredentialsTest");
		invalidcredentilasPOM.clickAccount();
		invalidcredentilasPOM.clickLogin();
		invalidcredentilasPOM.sendemail("tsoujanya1210@gmail.com");
		logger.log(LogStatus.PASS, "entered username");
		invalidcredentilasPOM.sendPassword("Souj1210");
		logger.log(LogStatus.PASS, "Entered Invalid Password");
		invalidcredentilasPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "It will dispaly warning message");
		screenShot.captureScreenShot();

		driver.close();
				extent.endTest(logger);
		extent.flush();
		extent.close();
		
	}
}
