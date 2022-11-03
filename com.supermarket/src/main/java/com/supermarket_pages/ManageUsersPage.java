package com.supermarket_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket_utilities.GeneralUtility;

public class ManageUsersPage {
	
	GeneralUtility guobj;
	
	 WebDriver driver;
	 @FindBy(xpath="//i[@class='nav-icon fas fa-user']")
	 WebElement users;
	 
	 @FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	 WebElement searchuser;
	 
	 @FindBy(xpath="//input[@id='un']")
	 WebElement name;
	 
	 @FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	 WebElement searchbutton;
	
	 @FindBy(xpath="//input[@id='ut']")
	 WebElement email;
	 
	 @FindBy(xpath="//input[@id='ph']")
	 WebElement phoneno;
	 
	 
	 @FindBy(xpath="//select[@id='st']")
	 WebElement status;
	
	 @FindBy(xpath="//span[@id='res']")
	 WebElement resultnotfound;
	
	 @FindBy(xpath="//div[@class='action-buttons']")
	 WebElement showpwdbutton;
	 
	 @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
		public
		WebElement rowstart;
		
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td")
		public	
		WebElement columnstart;
		
	 @FindBy(xpath="//div[@class='profile-info-name']")
	 WebElement pwdmessage;
	
	 @FindBy(xpath="//i[@class='fas fa-trash-alt']")
	 WebElement delete;
	
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	 WebElement deletemessage;
	 
	 @FindBy(xpath="//img[@class='img-circle']")
	 WebElement demologo;
	 
	 
		
	   public void manageUsers()
	 {
		 users.click();
	 }
	 public boolean isDemoLogoPresent()
    {
			boolean flag=demologo.isDisplayed();
			return flag;
	}
	 public void seachUser(String user)
	 {
		 searchuser.click();
		 name.sendKeys(user);
		 searchbutton.click();
	 }
	 public String getSearchName()
	 {
		 return rowstart.getText();
	 }
	 public void searchByEMail(String mail)
	 {
		 searchuser.click();
	     email.sendKeys(mail);
	     searchbutton.click();
		 
	 }
	 public void searchByPhonenumber(String no)
	 {
		 searchuser.click();
	     phoneno.sendKeys(no);
	     searchbutton.click();
		 
	 }
	 public void searchByStatus(String act)
	 {
		 searchuser.click();
	     status.sendKeys(act);
	     searchbutton.click();
		 
	 }
	 public void invalidNumber(String wno)
	 {
		 searchuser.click();
		 phoneno.sendKeys(wno);
		 searchbutton.click();
	 }
	 public String resultMessage()
	 {
		 return resultnotfound.getText();
	 }
	public void  showPassword(WebElement rowstart1,WebElement Columnstart1,int rowelement,int columnelement)
	{	
			guobj=new GeneralUtility();
			rowstart.getText();
			columnstart.getText();
			showpwdbutton.click();
	}
	public String getPwdMessage()
	{
		return  pwdmessage.getText();
	}
	public void  deleteItem(WebElement rowstart1,WebElement Columnstart1,int rowelement,int columnelement)
	{
	
		guobj=new GeneralUtility();
		rowstart.getText();
		columnstart.getText();
		delete.click();
		guobj.acceptAlert(driver);
	}
	public String getDeleteMessage()
	{
		return deletemessage.getText();
	}
	 
	 public  ManageUsersPage(WebDriver driver)
	 {
	 	this.driver=driver;
	 	PageFactory.initElements(driver, this);
	 }
	

}
