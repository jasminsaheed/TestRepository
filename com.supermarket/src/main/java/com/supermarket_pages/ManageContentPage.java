package com.supermarket_pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.supermarket_utilities.GeneralUtility;

public class ManageContentPage {
	
	WebDriver driver;
	GeneralUtility guobj;
	
	@FindBy(xpath="//p[contains(text(),'Manage Content')]")
	WebElement managecontent;
	
	@FindBy(xpath="//p[contains(text(),'Manage Contact')]")
	WebElement managecontact;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement edit;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneno;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='del_limit']")
	WebElement deliverychrg;
	
	@FindBy(xpath="//button[@name='Update']")
	public
	WebElement update;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement contactupdatemessage;
	
	@FindBy(xpath="//p[text()='Manage News']")
	WebElement managenews;
	
	@FindBy(xpath="//img[@class='img-circle']")
	WebElement demologo;

	
	
	
	
	
	public void manageContent()
	{
		managecontent.click();
		managecontact.click();
	}
	public boolean isDemologoPresent()
	{
		boolean flag=demologo.isDisplayed();
		return flag;
	}
	
	
	public void editContact(String phno,String mail,String chrg)
	{
		guobj=new GeneralUtility();
		edit.click();
		phoneno.clear();
		phoneno.sendKeys(phno);
		email.clear();
		email.sendKeys(mail);
		deliverychrg.clear();
		deliverychrg.sendKeys(chrg);
		 guobj.javaScriptExecutorClick(driver,update);
		
		
	}
	public String updatedMessage()
	{
		return contactupdatemessage.getText();
	}
	
	 public  ManageContentPage(WebDriver driver)
	 {
	 	this.driver=driver;
	 	PageFactory.initElements(driver, this);
	 }
	

}
