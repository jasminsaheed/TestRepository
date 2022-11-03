package com.supermarket_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket_utilities.ExcelUtil;
import com.supermarket_utilities.GeneralUtility;

 public class ManageSliderPage {
	 WebDriver driver;
	 GeneralUtility guobj;
	 
	@FindBy(xpath="//i[@class='nav-icon fas fa-window-restore']")
	WebElement manageslider;
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	public
	WebElement newslider;
	
	@FindBy(xpath="//input[@name='main_img']")
	public
	WebElement choosefile;
	
	@FindBy(xpath="//input[@id='link']")
	public
	WebElement link;
	
	@FindBy(xpath="//button[@name='create']")
	public
	WebElement save;
	
	@FindBy(xpath="//i[@class='fas fa-bars']")
	WebElement delete;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement message;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	public	
	WebElement edit;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	public	
	WebElement update;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	public
	WebElement rowstart;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td")
	public	
	WebElement columnstart;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement delete1;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updatemessage;
	
	@FindBy(xpath="//span[@class='badge bg-warning']")
	WebElement inactive;
	
	
	@FindBy(xpath="//span[@class='badge bg-success']")
	public
	WebElement active;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement statusmessage;
	

	@FindBy(xpath="//img[@class='img-circle']")
	WebElement demologo;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deletemessage;
	
	
	
	
	
	
	
	public void manageSlider()
	{
		manageslider.click();
		
		
	}
	public boolean isDemoLogoPresent()
	{
		boolean flag=demologo.isDisplayed();
		return flag;
	}
	
	public void addSlider(String title)
	{
		newslider.click();
		link.sendKeys(title);
		save.click();
	}
	
	public String getMessage()
	{
		return message.getText();
	}
	public void editItem(int rowelement,int columnelement,String link1)
	{
		guobj=new GeneralUtility();
		rowstart.getText();
		columnstart.getText();
		edit.click();
		link.clear();
		link.sendKeys(link1);
		update.click();
		
	}
	public String updateMessage()
	{
		return updatemessage.getText();
	}
	
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
 public void statusActive(WebElement rowstart1,WebElement Columnstart1 ,int rowelement,int columnelement)
 {   guobj=new GeneralUtility();
	 rowstart.getText();
	 columnstart.getText();
	 guobj.javaScriptExecutorClick(driver, active);
	 
	
 }
 
 public String statusMessage()
 {
	 return statusmessage.getText();
 }
 public void  statusInactive( WebElement rowstart1,WebElement Columnstart1 ,int rowelement,int columnelement)
 {
	 guobj=new GeneralUtility();
	 rowstart.getText();
	 columnstart.getText();
	 guobj.javaScriptExecutorClick(driver,inactive);
    
 }
	
 public  ManageSliderPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}




	

}

 