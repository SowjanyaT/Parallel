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

import com.training.pom.AdminrewardsPointPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminRewardsPointTest {
	private WebDriver driver;
	private String baseUrl;
	private AdminrewardsPointPOM adminrewardspointPOM;
	private static Properties properties;
	private ScreenShot screenShot; 
	ExtentReports extent;
    ExtentTest logger;
	
	@BeforeTest
	public void extentreport()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/Adminrewards3.html",true);
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
		adminrewardspointPOM = new AdminrewardsPointPOM(driver); 
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
		
		logger=extent.startTest("AdminRewardsPointTest");
		adminrewardspointPOM.sendusername("admin");
		adminrewardspointPOM.sendPassword("admin@123");
		adminrewardspointPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Application opened");
		String title=driver.getTitle();
		logger.log(LogStatus.PASS, title);
		adminrewardspointPOM.clickCatalog();
		
		logger.log(LogStatus.PASS, "Catalogs opened succesfully and options link should get dispalyed in the list");
		screenShot.captureScreenShot("Catalog");
		Thread.sleep(3000);
		WebDriverWait mywait1=new WebDriverWait(driver,10);
		mywait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='catalog']/ul/li[2]")));
		
		adminrewardspointPOM.clickProducts();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "products opened succesfully and perfomed assertion ");
		screenShot.captureScreenShot("Products");
		Thread.sleep(3000);
		System.out.println("entering.....");
		WebDriverWait mywait=new WebDriverWait(driver,20);
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn btn-primary' and  @data-original-title='Add New']")));
		System.out.println("waiting to find element");
		adminrewardspointPOM.clickAddnew();
		logger.log(LogStatus.PASS, "Clicked on addnew Icon ");
		adminrewardspointPOM.sendproductname("Blazer Girls(7-8)");
		Thread.sleep(3000);
		
		logger.log(LogStatus.PASS, "Product name entered succesfully ");
		adminrewardspointPOM.sendmetatagtitle("Blazer for Girls");
		logger.log(LogStatus.PASS, "Meta Tag title name entered succesfully ");
		adminrewardspointPOM.clickData();
		screenShot.captureScreenShot("Data");
		Thread.sleep(3000);
		adminrewardspointPOM.sendmodel("BLG-112");
		logger.log(LogStatus.PASS, "Model name entered succesfully ");
		Thread.sleep(3000);
		adminrewardspointPOM.sendprice("3000");
		logger.log(LogStatus.PASS, "Price entered succesfully ");
		adminrewardspointPOM.sendquantity("100");
		Thread.sleep(3000);
		adminrewardspointPOM.clickLinks();
		logger.log(LogStatus.PASS, "Links tab fileds should displayed ");
		adminrewardspointPOM.sendcategories("School Uniforms");
		screenShot.captureScreenShot("Categories");
		adminrewardspointPOM.clickDiscounts();
		Thread.sleep(3000);
		adminrewardspointPOM.clickAddDiscounts();
		Thread.sleep(3000);
		adminrewardspointPOM.sendquantity1("5");
		Thread.sleep(3000);
		adminrewardspointPOM.sendprice1("200");
		Thread.sleep(3000);
		//adminrewardspointPOM.clickStartdate();
        adminrewardspointPOM.sendstartdate("2019-06-19");
		
		Thread.sleep(3000);
		adminrewardspointPOM.sendenddate("2019-06-20");
		logger.log(LogStatus.PASS,"Clikced on rewards point tab");
		adminrewardspointPOM.clickRewardspoint();
		Thread.sleep(3000);
		adminrewardspointPOM.sendpoints("20");
		Thread.sleep(3000);
		adminrewardspointPOM.clickAttribute();
		Thread.sleep(3000);
		adminrewardspointPOM.clickAttributeIcon();
		logger.log(LogStatus.PASS,"Clikced on Attributr Icon ");
		adminrewardspointPOM.sendattributetext("Test Message");
		adminrewardspointPOM.clickOptions();
		logger.log(LogStatus.PASS,"Clikced on Options tab");
		adminrewardspointPOM.sendoptionstext("123");
		adminrewardspointPOM.clickRecurring();
		Thread.sleep(3000);
		adminrewardspointPOM.clickRecurringIcon();
		
		adminrewardspointPOM.clickSpecial();
		Thread.sleep(3000);
		adminrewardspointPOM.clickSpecialIcon();
		adminrewardspointPOM.sendspecialp("123456");
		adminrewardspointPOM.clickImage();
		logger.log(LogStatus.PASS,"Clikced on Image tab");
		adminrewardspointPOM.clickImageIcon();
		adminrewardspointPOM.clickDesign();
		logger.log(LogStatus.PASS,"Clikced on Design tab");
		adminrewardspointPOM.senddesignname("Uniforms");
		
		adminrewardspointPOM.clickSubmit();
		
	
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
}
