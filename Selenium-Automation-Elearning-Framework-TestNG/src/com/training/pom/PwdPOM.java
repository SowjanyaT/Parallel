package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PwdPOM {
private WebDriver driver; 
	
	public PwdPOM(WebDriver driver) {
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
	
	@FindBy(linkText="Change your password")
	private WebElement pwd; 
	

	@FindBy(xpath="	//*[@name='password']")
	private WebElement pwd1; 
	
	
	@FindBy(xpath="//*[@name='confirm']")
	private WebElement Cpwd1; 
	
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement Continue; 
	
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
	public void clickpwd() {
		this.pwd.click(); 
	}
	public void sendpwd1(String pwd1) {
		this.pwd1.clear(); 
		this.pwd1.sendKeys(pwd1);
	}
	public void sendCpwd1(String Cpwd1) {
		this.Cpwd1.click(); 
		this.Cpwd1.sendKeys(Cpwd1);
	}
	public void clickcontinue() {
		this.Continue.click(); 
		String Actual;
		Actual=this.success.getText();
		System.out.println(Actual);
		String Expected="Success: Your account has been successfully updated.";
		Assert.assertEquals(Actual, Expected);
		
	}
	
}
