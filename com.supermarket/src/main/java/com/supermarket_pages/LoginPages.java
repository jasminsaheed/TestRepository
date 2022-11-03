package com.supermarket_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
	WebDriver driver;
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;
	@FindBy(xpath="//img[@class='img-circle elevation-2']")
	WebElement adminlogo;
	
	
	public void loginpage(String username1, String password1)
	{
		username.sendKeys(username1);
		password.sendKeys(password1);
		submit.click();
	}
	public void clearUserNameAndPassword()
	   {
		   username.clear();
		   password.clear();
	   }
	public String getErrorMessage()
	{
		
		return errorMessage.getText();
		
	}
	public boolean isAdminLogoPresent()
	{
		boolean flag=adminlogo.isDisplayed();
		return flag;
	}
	
	
	public  LoginPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	 

}
