package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformPOM {
private WebDriver driver; 
	
	public UniformPOM(WebDriver driver) {
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
	

	@FindBy(xpath="	//*[@class='fa fa-eye']")
	private WebElement View; 
	
	@FindBy(linkText="Logout")
	private WebElement logout; 
	
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
	public void clickLogout() {
		this.logout.click(); 
	}
	
}


