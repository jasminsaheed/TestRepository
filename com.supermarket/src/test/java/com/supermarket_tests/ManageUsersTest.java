package com.supermarket_tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.constants.Constants;
import com.supermarket_pages.LoginPages;
import com.supermarket_pages.ManageSliderPage;
import com.supermarket_pages.ManageUsersPage;
import com.supermarket_utilities.ExcelUtil;
import com.supermarket_utilities.GeneralUtility;

public class ManageUsersTest extends BaseClass {
	GeneralUtility guobj;
	ExcelUtil excelobj;
	LoginPages loginobj;
	ManageUsersPage muobj;
  @Test(description="Validate ManageUserPage",priority=1)
  public void manageUserTest() throws IOException {
	    excelobj=new ExcelUtil();
		loginobj=new LoginPages(driver);
		loginobj.loginpage(excelobj.readDataFromExcel(0,2),excelobj.readDataFromExcel(1,2));
		muobj=new ManageUsersPage(driver);
		muobj.manageUsers();
		Assert.assertTrue(muobj.isDemoLogoPresent());
	  
  }
  @Test(description="Validation of Search by Name",priority=2,enabled=false)
  public void searchUserTest() throws IOException
  {
	  excelobj=new ExcelUtil();
	  muobj=new ManageUsersPage(driver);
	  muobj.seachUser(excelobj.readDataFromExcel(4,1));
	  Assert.assertEquals(muobj.getSearchName(), Constants.expectedsearchuserdetails);
  }
  @Test(description="Validation of Search by email",priority=3,enabled=false)
  public void eMailTest() throws IOException
  {
	  excelobj=new ExcelUtil();
	  muobj=new ManageUsersPage(driver);
	  muobj.searchByEMail(excelobj.readDataFromExcel(6,1));
	  Assert.assertEquals(muobj.getSearchName(), Constants.expectedsearchuserdetails);
	  
  }
  @Test(description="Validation of Search by PhoneNumber",priority=4,enabled=false)
  public void phoneNumberTest() throws IOException
  {
	  excelobj=new ExcelUtil();
	  muobj=new ManageUsersPage(driver);
	  muobj.searchByPhonenumber(excelobj.readDataFromExcel(5,1));
	  Assert.assertEquals(muobj.getSearchName(), Constants.expectedsearchuserdetails);
	  
  }
  @Test(description="Validation of Search by Status",priority=5,enabled=false)
  public void statusTest() throws IOException
  {
	  excelobj=new ExcelUtil();
	  muobj=new ManageUsersPage(driver);
	  muobj.searchByStatus(excelobj.readDataFromExcel(7,1));
	  Assert.assertEquals(muobj.getSearchName(), Constants.expectedsearchuserdetails);
	  
  }
  @Test(description="User cannot search by inavalid credentials" ,enabled=false,priority=6)
  public void searchByInvalid() throws IOException
  {
	  excelobj=new ExcelUtil();
	  muobj=new ManageUsersPage(driver);
	  muobj.invalidNumber(excelobj.readDataFromExcel(8,1));
	  Assert.assertEquals(muobj.resultMessage(), Constants.expectedsearchuserresult);
	  
	 }
  @Test(description="Validation of ShowPasswordButton",enabled=true,priority=7)
  public void passwordActive() throws IOException, InterruptedException
  {
	  excelobj=new ExcelUtil();
	  muobj=new ManageUsersPage(driver);
	  guobj=new GeneralUtility();
	  muobj.showPassword(muobj.rowstart,muobj.columnstart ,3, 3);
	  guobj.generalSleep();
	  Assert.assertEquals(muobj.getPwdMessage(),Constants.expectedpwdmessage);
	  
  }
  @Test(description="Validation of Delete button",enabled=false,priority=8)
  public void deleteTest() throws IOException, InterruptedException
  {
	  excelobj=new ExcelUtil();
	  muobj=new ManageUsersPage(driver);
	  guobj=new GeneralUtility();
	  muobj.deleteItem(muobj.rowstart,muobj.columnstart ,3, 6);
	  guobj.generalSleep();
	  Assert.assertEquals(muobj.getDeleteMessage(),Constants.expecteddeletemessage );
	  
	  
  }
}
  

