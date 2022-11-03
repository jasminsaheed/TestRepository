package com.supermarket_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket_utilities.GeneralUtility;

public class ManageNewsPage {
	WebDriver driver;
	GeneralUtility guobj;
	
	@FindBy(xpath="//p[text()='Manage News']")
	WebElement managenews;
	
	@FindBy(xpath="//p[contains(text(),'Manage Content')]")
	WebElement managecontent;
	
	@FindBy(xpath="//textarea[@id='news']")
	WebElement news;
	
	@FindBy(xpath="//button[@class='btn btn-danger'] ")
	WebElement update;
	
	@FindBy(xpath="//i[@class='fas fa-edit'] ")
	WebElement edit;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	public
	WebElement rowstart;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td")
	public	
	WebElement columnstart;
	
	@FindBy(xpath="	//div[@class='alert alert-success alert-dismissible']")
	WebElement newsmessage;
	
	@FindBy(xpath="	//i[@class='fas fa-trash-alt']")
	WebElement delete;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deletmessage;
	
	@FindBy(xpath="//img[@class='img-circle']")
	WebElement demologo;
	

	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newsn;
	
	@FindBy(xpath="//textarea[@id='news']")
	WebElement textarea;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement newsaddmessage;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement textarea1;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement search1;
	
	@FindBy(xpath="//h4[text()='Manage News']")
	WebElement searchvalidation;
	
	
	

	
	
	
	
	public void manageNews()
	{
		managecontent.click();
		managenews.click();
		
    }
	public boolean isDemoLogoPresent()
	{
		boolean flag=demologo.isDisplayed();
		return flag;
	}
	public void editNews(WebElement row1,WebElement col1,int rowloc,int colloc,String news1)
	{
		rowstart.getText();
		columnstart.getText();
		edit.click();
		news.clear();
		news.sendKeys(news1);
		update.click();
		
	}
	public String getNewsMessage()
	{
		return newsmessage.getText();
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
		return deletmessage.getText(); 
	}
	public void addNews(String news)
	{
		newsn.click();
		textarea.sendKeys(news);
		save.click();
		
		
	}
	public String getNewsAddMessage()
	{
		return newsaddmessage.getText();

	}
	public void searchNews(String news)
	{
		search.click();
		textarea1.sendKeys(news);
		search1.click();
		
	}
	public String searchResults()
	{
		return searchvalidation.getText();
	}

	 public  ManageNewsPage(WebDriver driver)
	 {
	 	this.driver=driver;
	 	PageFactory.initElements(driver, this);
	 }

}
