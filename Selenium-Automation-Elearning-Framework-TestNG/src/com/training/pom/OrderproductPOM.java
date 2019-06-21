package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderproductPOM {
private WebDriver driver; 
	
	public OrderproductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@class='caret']")
	private WebElement Account; 
	
	@FindBy(linkText="Login")
	private WebElement Login; 
	
	@FindBy(xpath="//*[@class='list-group']/a[6]")
	private WebElement OrderHistory; 
	

	@FindBy(xpath="//*[@data-toggle='tooltip']")
	private WebElement View; 
	
	
	@FindBy(xpath="//*[@class='table-responsive']/table/tbody/tr/td/a[2]")
	private WebElement Return; 
	
	
	@FindBy(xpath="//*[@name='return_reason_id' and @value='3']")
	private WebElement ReturnR; 
	
	
	@FindBy(xpath="//*[@name='opened' and @value='1']")
	private WebElement ProductC; 
	
	
	@FindBy(xpath="//*[@placeholder='Faulty or other details']")
	private WebElement PlaceHolder; 
	
	
	@FindBy(xpath="//*[@type='checkbox' and@name='agree']")
	private WebElement agree; 
	
	
	
	@FindBy(xpath="//*[@type='submit' and@value='Submit']")
	private WebElement submit; 
	
	
	@FindBy(xpath="//*[@id='content']/p")
	private WebElement SuccessText; 
	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void clickAccount() {
		this.Account.click(); 
	}
	public void clickLogin() {
		this.Login.click(); 
	}
	public void clickOrderHistory() {
		this.OrderHistory.click(); 
	}
	public void clickView() {
		this.View.click(); 
	}
	public void clickReturn() {
		this.Return.click(); 
	}
	public void clickReturnR() {
		this.ReturnR.click(); 
	}
	public void clickProductC() {
		this.ProductC.click(); 
	}
	public void sendPlaceHolder(String PlaceHolder) {
		this.PlaceHolder.clear(); 
		this.PlaceHolder.sendKeys(PlaceHolder); 
	}
	public void clickagree() {
		this.agree.click(); 
	}
	public void clicksubmit() {
		this.submit.click(); 
		String Actual;
		Actual=this.SuccessText.getText();
		System.out.println(Actual);
		String Expected="Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
		Assert.assertEquals(Actual, Expected);
	}
}
