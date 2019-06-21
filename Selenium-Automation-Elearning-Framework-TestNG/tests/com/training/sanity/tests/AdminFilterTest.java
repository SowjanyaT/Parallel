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
import com.training.pom.AdminFilterPOM;
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminFilterTest {
	private WebDriver driver;
	private String baseUrl;
	private AdminFilterPOM adminfilterPOM;
	private static Properties properties;
	private ScreenShot screenShot; 
	ExtentReports extent;
    ExtentTest logger;
	
	@BeforeTest
	public void extentreport()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/Adminfilter.html",true);
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
		adminfilterPOM = new AdminFilterPOM(driver); 
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
		
		logger=extent.startTest("AdminFilterTest");
		adminfilterPOM.sendusername("admin");
		adminfilterPOM.sendPassword("admin@123");
		adminfilterPOM.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Application opened");
		String title=driver.getTitle();
		logger.log(LogStatus.PASS, title);
		adminfilterPOM.clickReports();
		logger.log(LogStatus.PASS, "Reports opened succesfully");
		screenShot.captureScreenShot("Reports");
		Thread.sleep(3000);
		adminfilterPOM.clickSales();
		logger.log(LogStatus.PASS, "Sales opened succesfully");
		extent.endTest(logger);
		extent.flush();
		extent.close();
		
		screenShot.captureScreenShot("Sales");
		WebDriverWait mywait1=new WebDriverWait(driver,10);
		mywait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='collapse in']/li[1]/a[1]")));
		adminfilterPOM.clickOrders();
		Thread.sleep(3000);
		adminfilterPOM.clickGroupby();
		screenShot.captureScreenShot();
		Select Groupby=new Select(driver.findElement(By.xpath("//*[@class='form-control' and @id='input-group']")));
		List<WebElement> data = Groupby.getOptions();
		System.out.println(data.size());
		for (int i=0; i<data.size(); i++)
			
		{	
		System.out.println(data.get(i).getText());
		}
		Groupby.selectByIndex(3);

		screenShot.captureScreenShot();
		adminfilterPOM.clickFilter();
		logger.log(LogStatus.PASS, "Filter clicked succesfully");
		
		screenShot.captureScreenShot("Filter");
		 
			
		
	}
}
