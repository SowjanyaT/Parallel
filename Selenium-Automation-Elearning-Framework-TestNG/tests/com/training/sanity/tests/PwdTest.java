package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.PwdPOM;
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PwdTest {
	private WebDriver driver;
	private String baseUrl;
	private PwdPOM pwdPOM;
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
		pwdPOM = new PwdPOM(driver); 
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
		pwdPOM.clickAccount();
		pwdPOM.clickLogin();
	
		pwdPOM.sendemail("1234@gmail.com");
		pwdPOM.sendPassword("Souji1210");
		pwdPOM.clickLoginBtn(); 
		pwdPOM.clickpwd();
		Thread.sleep(3000);
		pwdPOM.sendpwd1("Vissu1210");
		pwdPOM.sendCpwd1("Vissu1210");
		pwdPOM.clickcontinue();
		Thread.sleep(3000);
		screenShot.captureScreenShot();
	}
}
