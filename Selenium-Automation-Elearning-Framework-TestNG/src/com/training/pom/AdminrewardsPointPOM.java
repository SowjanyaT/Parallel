package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdminrewardsPointPOM {

private WebDriver driver; 
	
	public AdminrewardsPointPOM(WebDriver driver) {
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
	
		
	@FindBy(xpath="//*[@id='catalog']/ul/li[2]")
	private WebElement Products; 
	
	@FindBy(xpath="//*[@class='panel-title']")
	private WebElement Panel; 
	
	

	@FindBy(xpath="//*[@class='btn btn-primary' and  @data-original-title='Add New']")
	private WebElement Addnew; 
	
	@FindBy(xpath="//*[@id='input-name1' and @class='form-control']")
	private WebElement ProductName; 
	
	@FindBy(xpath="//*[@id='input-meta-title1' and @class='form-control']")
	private WebElement MetaTagTitle; 
	
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[2]")
	private WebElement Data; 
	
	
	@FindBy(xpath="//*[@id='input-model']")
	private WebElement Model; 
	

	@FindBy(xpath="	//*[@id='input-price']")
	private WebElement Price; 
	
	
	@FindBy(xpath="	//*[@id='input-quantity']")
	private WebElement Quantity; 
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[3]")
	private WebElement Links; 
	
	
	@FindBy(xpath="//*[@class='form-control' and @id='input-category']")
	private WebElement Categories; 
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[7]")
	private WebElement Discounts; 
	
	
	@FindBy(xpath="//*[@class='btn btn-primary' and  @data-original-title='Add Discount']")
	private WebElement AddDiscounts;
	
	
	@FindBy(xpath="//*[@name='product_discount[0][quantity]' and  @class='form-control']")
	private WebElement Quantity1;
	
	
	@FindBy(xpath="//*[@name='product_discount[0][priority]' and  @class='form-control']")
	private WebElement Price1;
	
	
	/*@FindBy(xpath="//*[@id='discount-row0']/td[5]/div/span/button/i")
	private WebElement Startdate;*/
	
	@FindBy(xpath="//*[@name='product_discount[0][date_start]']")
	private WebElement Startdate;
	
	@FindBy(xpath="//*[@name='product_discount[0][date_end]']")
	private WebElement Enddate;
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[10]")
	private WebElement Rewardspoint; 
	
	
	@FindBy(xpath="//*[@class='form-control' and @name='points']")
	private WebElement Points; 
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[4]")
	private WebElement Attribute; 
	
	
	@FindBy(xpath="//*[@onclick='addAttribute();']")
	private WebElement AttributeIcon;
	
	
	@FindBy(xpath="//*[@name='product_attribute[0][product_attribute_description][1][text]']")
	private WebElement Attributetext;
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[5]")
	private WebElement Options;
	
	
	
	@FindBy(xpath="//*[@name='option']")
	private WebElement Optionstext;
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[6]")
	private WebElement Recurring;
	
	
	@FindBy(xpath="//*[@onclick='addRecurring()']")
	private WebElement RecurringIcon;
	
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[8]")
	private WebElement Special;
	
	
	@FindBy(xpath="//*[@onclick='addSpecial();']")
	private WebElement SpecialIcon;
	
	
	@FindBy(xpath="//*[@name='product_special[0][priority]']")
	private WebElement SpecialP;
	
	@FindBy(xpath="//*[@class='nav nav-tabs']/li[9]")
	private WebElement Image;
	
		@FindBy(xpath="//*[@onclick='addImage();']")
	private WebElement ImageIcon;
		
		@FindBy(xpath="//*[@class='nav nav-tabs']/li[11]")
		private WebElement Design;
		
		@FindBy(xpath="//*[@name='product_layout[0]']")
		private WebElement DesignName;
		
		
		@FindBy(xpath="//*[@data-toggle='tooltip' and @type='submit']")
		private WebElement Submit;
		
		
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
	}
	public void clickProducts() {
		this.Products.click();
		/*Actions act=new Actions(driver);
		act.moveToElement(this.Catalog).build().perform();
		act.sendKeys(this.Products,Keys.ENTER).build().perform();
		this.Products.click();
		System.out.println("products clicked");
		String Actual;
		Actual=this.Panel.getText();
		System.out.println(Actual);
		String Expected="Product List";
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);*/
		
	}
	public void clickAddnew() {
		this.Addnew.click(); 
	}
	public void sendproductname(String productname) {
		this.ProductName.clear();
		this.ProductName.sendKeys(productname);
		this.ProductName.getText();
		System.out.println(this.ProductName.getText());
	}
	
	public void sendmetatagtitle(String metatagtitle) {
		this.MetaTagTitle.clear();
		this.MetaTagTitle.sendKeys(metatagtitle);
		
		System.out.println(this.MetaTagTitle.getText());
	}
	
	public void sendmodel(String model) {
		this.Model.clear();
		this.Model.sendKeys(model);
		
		System.out.println(this.Model.getText());
	}
	public void sendprice(String price) {
		this.Price.clear();
		this.Price.sendKeys(price);
		
		System.out.println(this.Model.getText());
	}
	
	public void sendquantity(String quantity) {
		this.Quantity.clear();
		this.Quantity.sendKeys(quantity);
		
	}	
	public void clickData() {
		this.Data.click(); 
	}
	public void clickLinks() {
		this.Links.click(); 
	}
	public void sendcategories(String categories) {
		this.Categories.clear();
		this.Categories.sendKeys(categories);
		
		System.out.println(this.Categories.getText());
	}
	public void clickDiscounts() {
		this.Discounts.click(); 
	}
	public void clickAddDiscounts() {
		this.AddDiscounts.click(); 
	}
	public void sendquantity1(String quantity1) {
		this.Quantity1.clear();
		this.Quantity1.sendKeys(quantity1);
		
	}
	public void sendprice1(String price1) {
		this.Price1.clear();
		this.Price1.sendKeys(price1);
		
	}
	
	
	public void sendstartdate(String startdate) {
		this.Startdate.clear();
		this.Startdate.sendKeys(startdate);
	}
	public void sendenddate(String enddate) {
		this.Enddate.clear();
		this.Enddate.sendKeys(enddate);
	}
	public void clickRewardspoint() {
		this.Rewardspoint.click(); 
	}
	public void sendpoints(String points) {
		this.Points.clear();
		this.Points.sendKeys(points);
		
	}
	public void clickAttribute() {
		this.Attribute.click(); 
	}
	public void clickAttributeIcon() {
		this.AttributeIcon.click(); 
	}
	public void sendattributetext(String attributetext) {
		this.Attributetext.clear();
		this.Attributetext.sendKeys(attributetext);
		
	}
	public void clickOptions() {
		this.Options.click(); 
	}
	public void sendoptionstext(String optionstext) {
		this.Optionstext.clear();
		this.Optionstext.sendKeys(optionstext);
		
	}
	public void clickRecurring() {
		this.Recurring.click(); 
	}
	public void clickRecurringIcon() {
		this.RecurringIcon.click(); 
	}
	
	public void clickSpecial() {
		this.Special.click(); 
	}
	public void clickSpecialIcon() {
		this.SpecialIcon.click(); 
	}
	public void sendspecialp(String specialp) {

		this.SpecialP.sendKeys(specialp);
		
	}
	public void clickImage() {
		this.Image.click(); 
	}
	public void clickImageIcon() {
		this.ImageIcon.click(); 
	}
	public void clickDesign() {
		this.Design.click(); 
	}
	public void senddesignname(String designname) {

		this.DesignName.sendKeys(designname);
		
	}
	public void clickSubmit() {
		this.Submit.click(); 
		String Actual,Actual_str;
		Actual_str=this.Success.getText();
		Actual=Actual_str.replace("\n", "");
		Actual=Actual.replace("×", "");
		System.out.println(Actual);
		
		String Expected="Success: You have modified products!";
		System.out.println(Expected);
		Assert.assertEquals(Actual, Expected);
	}
}
