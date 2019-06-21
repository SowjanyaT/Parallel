package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditPOM {
private WebDriver driver; 
	
	public EditPOM(WebDriver driver) {
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
	
	@FindBy(linkText="Edit your account information")
	private WebElement Editlink; 
	

	@FindBy(id="input-firstname")
	private WebElement FirstName; 
	
	@FindBy(id="input-lastname")
	private WebElement LastName; 
	
	@FindBy(id="input-email")
	private WebElement Iemail; 
	
	@FindBy(id="input-telephone")
	private WebElement Phone; 
	
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement Cont; 
	
	@FindBy(xpath="//*[@class='alert alert-success']")
	private WebElement success; 
	
	
	
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
	public void clickEditlink() {
		this.Editlink.click(); 
	}
	public void sendFirstName(String FirstName) {
		this.FirstName.clear(); 
		this.FirstName.sendKeys(FirstName);
	}
	public void sendLastName(String LastName) {
		this.LastName.clear(); 
		this.LastName.sendKeys(LastName);
	}
	public void sendIemail(String Iemail) {
		this.Iemail.clear(); 
		this.Iemail.sendKeys(Iemail);
	}
	public void sendPhone(String Phone) {
		this.Phone.clear(); 
		this.Phone.sendKeys(Phone);
	}
	public void clickCont() {
		this.Cont.click(); 
		String Actual;
		Actual=this.success.getText();
		System.out.println(Actual);
		String Expected="Success: Your account has been successfully updated.";
		Assert.assertEquals(Actual, Expected);
		
	}
}
