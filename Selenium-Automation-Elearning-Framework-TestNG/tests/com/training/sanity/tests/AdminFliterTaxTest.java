package com.training.sanity.tests;

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
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminFilterPOM;
import com.training.pom.AdminFilterTaxPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminFliterTaxTest {
	private WebDriver driver;
	private String baseUrl;
	private AdminFilterTaxPOM adminfiltertaxPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminfiltertaxPOM = new AdminFilterTaxPOM(driver); 
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
		
	
		adminfiltertaxPOM.sendusername("admin");
		adminfiltertaxPOM.sendPassword("admin@123");
		adminfiltertaxPOM.clickLoginBtn(); 
		adminfiltertaxPOM.clickReports();
		screenShot.captureScreenShot();
		Thread.sleep(3000);
		adminfiltertaxPOM.clickSales();
		screenShot.captureScreenShot();
		WebDriverWait mywait1=new WebDriverWait(driver,10);
		mywait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='collapse in']/li[1]/a[1]")));
		adminfiltertaxPOM.clickTax();
		Thread.sleep(3000);
		adminfiltertaxPOM.clickGroupby();
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
		adminfiltertaxPOM.clickFilter();
		
		screenShot.captureScreenShot();
		 
			
		
	}
}
