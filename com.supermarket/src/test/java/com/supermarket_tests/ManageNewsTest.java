package com.supermarket_tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket_pages.LoginPages;
import com.supermarket_pages.ManageContentPage;
import com.supermarket_pages.ManageNewsPage;
import com.supermarket_pages.ManageSliderPage;
import com.supermarket_pages.ManageUsersPage;
import com.supermarket_utilities.ExcelUtil;
import com.supermarket_utilities.GeneralUtility;

public class ManageNewsTest extends BaseClass {

	GeneralUtility guobj;
	ExcelUtil excelobj;
	LoginPages loginobj;
	ManageNewsPage mnobj;
	
    @Test(description="Validation of ManageNewspage",priority=1)
	  public void manageNewsTest() throws IOException
    {
    	
		    excelobj=new ExcelUtil();
			loginobj=new LoginPages(driver);
			loginobj.loginpage(excelobj.readDataFromExcel(0,2),excelobj.readDataFromExcel(1,2));
			mnobj=new ManageNewsPage(driver);
			mnobj.manageNews();
			Assert.assertTrue(mnobj.isDemoLogoPresent());
		  
	}
    @Test(description="Validation of Edit Button",enabled=false,priority=2)
    public void editTest() throws IOException, InterruptedException
    {
  	  guobj=new GeneralUtility();
  	  excelobj=new ExcelUtil();
  	  mnobj=new ManageNewsPage(driver);
  	  mnobj.editNews(mnobj.rowstart, mnobj.columnstart, 5,1,excelobj.readDataFromExcel(12, 1));
  	  guobj.generalSleep();
  	  Assert.assertEquals(mnobj.getNewsMessage(), Constants.expectednewsmessage);
  	 
    }
    @Test(description="Validation of Delete button",enabled=false,priority=3)
    public void deleteTest() throws IOException, InterruptedException
    {
  	  excelobj=new ExcelUtil();
  	  mnobj=new ManageNewsPage(driver);
  	  guobj=new GeneralUtility();
  	  mnobj.deleteItem(mnobj.rowstart,mnobj.columnstart ,3, 2);
  	  guobj.generalSleep();
  	  Assert.assertEquals(mnobj.getDeleteMessage(),Constants.expecteddeletenewsmessage );
  	  
  	  
  	  
    }
    @Test(description="Validation of Adding New News",enabled=false,priority=4)
    public void addTest() throws IOException, InterruptedException
    {
  	  excelobj=new ExcelUtil();
  	  mnobj=new ManageNewsPage(driver);
  	  guobj=new GeneralUtility();
  	  mnobj.addNews(excelobj.readDataFromExcel(13, 1));
  	  guobj.generalSleep();
  	  Assert.assertEquals(mnobj.getDeleteMessage(),Constants.expectednewsaddmessage );
  	  
  	  
  	  
    }
    @Test(description="Validation of Searching News",enabled=true,priority=5)
    public void searchTest() throws IOException, InterruptedException
    {
  	  excelobj=new ExcelUtil();
  	  mnobj=new ManageNewsPage(driver);
  	  guobj=new GeneralUtility();
  	  mnobj.searchNews(excelobj.readDataFromExcel(13, 1));
  	  guobj.generalSleep();
  	  Assert.assertEquals(mnobj.searchResults(),Constants.expectedsearchvalidationmessage);
  	  
  	  
  	  
    }
}
