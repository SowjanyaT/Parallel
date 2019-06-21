package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.AdminCategoryPOM;
import com.training.pom.AdminFilterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminCategoryTest {
	private WebDriver driver;
	private String baseUrl;
	private AdminCategoryPOM admincategoryPOM;
	private static Properties properties;
	private ScreenShot screenShot; 
	ExtentReports extent;
    ExtentTest logger;
	
	@BeforeTest
	public void extentreport()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/AdminCategory.html",true);
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
		admincategoryPOM = new AdminCategoryPOM(driver); 
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
		
		logger=extent.startTest("AdminCategoryTest");
		admincategoryPOM.sendusername("admin");
		admincategoryPOM.sendPassword("admin@123");
		admincategoryPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Application opened");
		String title=driver.getTitle();
		logger.log(LogStatus.PASS, title);
		admincategoryPOM.clickCatalog();
		logger.log(LogStatus.PASS, "Clicked on Catalog");
		
		logger.log(LogStatus.PASS, "Catalogs opened succesfully and options link should get dispalyed in the list");
		screenShot.captureScreenShot("Catalog");
		Thread.sleep(3000);
		
		admincategoryPOM.clickCategory();
		logger.log(LogStatus.PASS, "Clicked on Category");
		Thread.sleep(3000);
		admincategoryPOM.clickAddNew();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Clicked on AddNew");
		admincategoryPOM.sendname("Blazers(3-5)");
		Thread.sleep(3000);
		admincategoryPOM.senddescription("Blazers for students");
		Thread.sleep(3000);
		admincategoryPOM.sendmetatag("BLZ 03");
		Thread.sleep(3000);
		screenShot.captureScreenShot("Metatag");
		admincategoryPOM.sendmetatagd("Blazers for primary class students");
		Thread.sleep(3000);
		admincategoryPOM.clickdata();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Clicked on Data tab");
		admincategoryPOM.sendparent("Parent Value");
		Thread.sleep(3000);
		screenShot.captureScreenShot("Parent");
		admincategoryPOM.clickDesign();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Clicked on Design tab");
		admincategoryPOM.clickLayout();
		Select D=new Select(driver.findElement(By.xpath("//*[@class='form-control' and @name='category_layout[0]']")));
		D.selectByVisibleText("Home");
		System.out.println(D);
		admincategoryPOM.clickSave();
		Thread.sleep(3000);
		screenShot.captureScreenShot("Save");
		extent.endTest(logger);
		extent.flush();
		extent.close();
		
		
		
	}
}
