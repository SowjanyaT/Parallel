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
import com.training.pom.EditPOM;
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditTest {
	private WebDriver driver;
	private String baseUrl;
	private EditPOM editPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent;
    ExtentTest logger;
	
	@BeforeTest
	public void extentreport()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/Edittest.html",true);
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
		editPOM = new EditPOM(driver); 
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
		logger=extent.startTest("EditTest");
		editPOM.clickAccount();
		editPOM.clickLogin();
	
		editPOM.sendemail("tsoujanya1210@gmail.com");
		editPOM.sendPassword("Souji1210");
		editPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Login");
		logger.log(LogStatus.PASS, "Application opened");
		editPOM.clickEditlink();
		logger.log(LogStatus.PASS, "Edit link opened");
		screenShot.captureScreenShot("Editlink");
		editPOM.sendFirstName("Vishrudh");
		editPOM.sendLastName("E");
		editPOM.sendemail("1234@gmail.com");
		editPOM.sendPhone("111111");
		editPOM.clickCont();
		logger.log(LogStatus.PASS, "updated all the account fields");
		
		screenShot.captureScreenShot("final");
	}

}
