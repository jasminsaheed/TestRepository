package com.supermarket_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket_utilities.GeneralUtility;

public class ManageOrderPage {
	WebDriver driver;
	GeneralUtility guobj;
	
	@FindBy(xpath="//p[text()='Manage Orders']")
	WebElement manageorder;
	
	@FindBy(xpath="//a[@class='btn btn-block btn-outline-info btn-sm']")
	WebElement view;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement orderdetails;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement back;
	

	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	public
	WebElement rowstart;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td")
	public	
	WebElement columnstart;
	
	@FindBy(xpath="//a[@class='btn btn-warning btn-sm']")
	WebElement deliveryboy;
	
	@FindBy(xpath="//select[@id='delivery_boy_id']")
	WebElement deliveryboyid;
	
	@FindBy(xpath="//img[@class='img-circle']")
	WebElement demologo;
	
	@FindBy(xpath="//button[@class='btn btn-info']")
	WebElement update;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deliveryboyassignmessage;
	
	
	
	
	
	
	
	public void manageOrders()
	{
		manageorder.click();
	}
	public boolean isDemoLogoPresent()
	{
		boolean flag=demologo.isDisplayed();
		return flag;
	}
	public void viewOrder(WebElement row1,WebElement col1,int rowloc,int columnloc)
	{
		rowstart.getText();
		columnstart.getText();
		view.click();
		back.click();
	}
	public String orderDetails()
	{
		return orderdetails.getText();
	}
	public void assignDeliveryBoy(WebElement row1,WebElement col1,int rowloc,int columnloc,String name)
	{
		guobj=new GeneralUtility();
		rowstart.getText();
		columnstart.getText();
		deliveryboy.click();
		guobj.selectByVisibleText(deliveryboyid, name);
		guobj.javaScriptExecutorClick(driver, update);
		
	}
	public String updatedDeliveryBoyMessage()
	{
		return deliveryboyassignmessage.getText();
	}
	 public  ManageOrderPage(WebDriver driver)
	 {
	 	this.driver=driver;
	 	PageFactory.initElements(driver, this);
	 }
	
	
	
}
