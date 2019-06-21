package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminFilterTaxPOM {
private WebDriver driver; 
	
	public AdminFilterTaxPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement username; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@class='fa fa-bar-chart-o fa-fw']")
	private WebElement Reports; 
	
		
	@FindBy(linkText="Sales")
	private WebElement Sales; 
	

	@FindBy(xpath="//*[@class='collapse in']/li[2]/a[1]")
	private WebElement Tax; 
	
	@FindBy(xpath="//*[@class='form-control' and @id='input-group']")
	private WebElement Groupby; 
	
	@FindBy(xpath="//*[@class='btn btn-primary pull-right']")
	private WebElement Filter; 
	
	
	
	
	
	
	public void sendusername(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void clickReports() {
		this.Reports.click(); 
	}
	public void clickSales() {
		this.Sales.click(); 
	}
	public void clickTax() {
		this.Tax.click(); 
	}
	public void clickFilter() {
		this.Filter.click(); 
	}
	public void clickGroupby() {
		this.Groupby.click(); 
	}
	
	
	
}
