package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InvalidCredentialsPOM {
private WebDriver driver; 
	
	public InvalidCredentialsPOM(WebDriver driver) {
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
	
	
	@FindBy(xpath="//*[@class='alert alert-danger']")
	private WebElement Warning; 
	
	
	
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
		String Actual;
		Actual=this.Warning.getText();
		System.out.println(Actual);
		String Expected="Warning: No match for E-Mail Address and/or Password.";
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);
	}
	public void clickAccount() {
		this.Account.click(); 
	}
	public void clickLogin() {
		this.Login.click(); 
		
		
	}
	
}
