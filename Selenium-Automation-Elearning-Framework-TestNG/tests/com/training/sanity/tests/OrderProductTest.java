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
import com.training.pom.OrderproductPOM;
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderProductTest {
	private WebDriver driver;
	private String baseUrl;
	private OrderproductPOM orderproductPOM;
	private static Properties properties;
	private ScreenShot screenShot;
    ExtentReports extent;
    ExtentTest logger;
	
	@BeforeTest
	public void extentreport()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/orderproductTets.html",true);
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
		orderproductPOM = new OrderproductPOM(driver); 
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
	public void validLoginTest() throws InterruptedException {
		logger=extent.startTest("OrderProductTest");
		orderproductPOM.clickAccount();
		orderproductPOM.clickLogin();
	
		orderproductPOM.sendemail("1234@gmail.com");
		orderproductPOM.sendPassword("Souji1210");
		orderproductPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Application opened");
		screenShot.captureScreenShot("Scrren1");
		
		orderproductPOM.clickOrderHistory();
		orderproductPOM.clickView();
		orderproductPOM.clickReturn();
		Thread.sleep(3000);
		orderproductPOM.clickReturnR();
		screenShot.captureScreenShot("Radio button for return");
		logger.log(LogStatus.PASS, "Selected Return Radio button");
		orderproductPOM.clickProductC();
		logger.log(LogStatus.PASS, "Selected Yes raio button");
		orderproductPOM.sendPlaceHolder("Incorrect Item");
		logger.log(LogStatus.PASS, "Value entered succesfully in PlaceHolder");
		orderproductPOM.clickagree();
		screenShot.captureScreenShot("agree");
		Thread.sleep(3000);
		
		orderproductPOM.clicksubmit();
		logger.log(LogStatus.PASS, "Clicked on agree");
		screenShot.captureScreenShot("submit");
		
		extent.endTest(logger);
		extent.flush();
		extent.close();
		
	}
}
