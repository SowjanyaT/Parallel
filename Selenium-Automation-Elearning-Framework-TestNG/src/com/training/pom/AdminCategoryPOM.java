package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdminCategoryPOM {
private WebDriver driver; 
	
	public AdminCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement username; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@class='fa fa-tags fa-fw']")
	private WebElement Catalog; 

	@FindBy(xpath="//*[@id='catalog']/ul/li[1]")
	private WebElement Categories; 
	
	
	@FindBy(xpath="//*[@data-toggle='tooltip' and @data-original-title='Add New']")
	private WebElement AddNew; 
	
	@FindBy(xpath="//*[@name='category_description[1][name]']")
	private WebElement Name; 
	
	
	@FindBy(xpath="//*[@class='note-editable panel-body']")
	private WebElement Description; 
	
	@FindBy(xpath="//*[@name='category_description[1][meta_title]']")
	private WebElement MetaTag; 
	
	
	@FindBy(xpath="//*[@name='category_description[1][meta_description]']")
	private WebElement MetaTagD; 
	
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[2]")
	private WebElement Data; 
	
	
	@FindBy(xpath="//*[@placeholder='Parent']")
	private WebElement Parent; 
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[3]")
	private WebElement Design; 
	
	
	@FindBy(xpath="//*[@class='form-control' and @name='category_layout[0]']")
	private WebElement Layout; 
	
	
	@FindBy(xpath="//*[@type='submit' and @data-original-title='Save']")
	private WebElement Save; 
	
	
	@FindBy(xpath="//*[@class='alert alert-success']")
	private WebElement Success; 
	
	
	
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
	public void clickCatalog() {
		this.Catalog.click(); 
		System.out.println(this.Catalog.getAttribute("ahref"));
	}
	public void clickCategory() {
		this.Categories.click(); 
	}
	
	
	public void clickAddNew() {
		this.AddNew.click(); 
	}
	public void sendname(String name) {
		this.Name.clear();
		this.Name.sendKeys(name);
	
	}
	public void senddescription(String description) {
		this.Description.clear();
		this.Description.sendKeys(description);

	}
	public void sendmetatag(String metatag) {
		this.MetaTag.clear();
		this.MetaTag.sendKeys(metatag);
	
	}
	public void sendmetatagd(String metatagd) {
		this.MetaTagD.clear();
		this.MetaTagD.sendKeys(metatagd);

	}
	public void clickdata() {
		this.Data.click(); 
	}
	public void sendparent(String parent) {
		this.Parent.clear();
		this.Parent.sendKeys(parent);

	}
	public void clickDesign() {
		this.Design.click(); 
	}
	public void clickLayout() {
		this.Layout.click(); 
		
	}
	public void clickSave() {
		this.Save.click(); 
		
	}
	public void clickSuccess() {
		this.Success.click(); 
		String Actual,Actual_Str;
		Actual_Str=this.Success.getText();
		Actual=Actual_Str.replace("\n", "");
		Actual=Actual.replace("×", "");
		String Expected="Success: You have modified categories!";
		Assert.assertEquals(Actual,Expected);
		
	}
	
}
