package com.supermarket_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//p[text()='Push Notifications']")
	WebElement pushnotification;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement description;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	WebElement send;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	WebElement reset;
	
	@FindBy(xpath="//img[@class='img-circle']")
	WebElement demologo;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement sendmessage;
	
	@FindBy(xpath="//h3[@class='card-title']")
	WebElement resetvalidation;
	

	@FindBy(xpath="//span[@class='error']")
	WebElement errormessage;
	
	
	
	
	
	public void pushNotifiation()
	{
		pushnotification.click();
	}
	public boolean isDemoLogoPresent()
	{
		boolean flag=demologo.isDisplayed();
		return flag;
	}
	public void addNotification(String title1,String description1)
	{
		title.sendKeys(title1);
		description.sendKeys(description1);
		send.click();
	}
	public String getSendMessage()
	{
		return sendmessage.getText();
	}
	public void resetNotification(String title1,String description1)
	{
		title.sendKeys(title1);
		description.sendKeys(description1);
		reset.click();
	}
	public String getResetMessage()
	{
		return resetvalidation.getText();
	}
	public void mandatoryField(String title1)
	{
		title.sendKeys(title1);
		send.click();
	}
	public String getErrorMessage()
	{
		return errormessage.getText();
	}
	 public  PushNotificationPage(WebDriver driver)
	 {
	 	this.driver=driver;
	 	PageFactory.initElements(driver, this);
	 }
	

}
