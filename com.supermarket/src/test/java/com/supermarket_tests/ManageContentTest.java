package com.supermarket_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.supermarket.constants.Constants;
import com.supermarket.extentreport.TestListener;
import com.supermarket_pages.LoginPages;
import com.supermarket_pages.ManageContentPage;
import com.supermarket_pages.ManageUsersPage;
import com.supermarket_utilities.ExcelUtil;
import com.supermarket_utilities.GeneralUtility;

public class ManageContentTest extends BaseClass {
	
	GeneralUtility guobj;
	ExcelUtil excelobj;
	LoginPages loginobj;
	ManageContentPage mcobj;
	//ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
  @Test(description="Validation of Managecontentpage",priority=1)
  public void manageContentTest() throws IOException {
	    excelobj=new ExcelUtil();
		loginobj=new LoginPages(driver);
		//extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
		loginobj.loginpage(excelobj.readDataFromExcel(0,2),excelobj.readDataFromExcel(1,2));
		mcobj=new ManageContentPage(driver);
		mcobj.manageContent();
		Assert.assertTrue(mcobj.isDemologoPresent());
		//extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");	  
	  }
 
  @Test(description="Validation of Edit Button",priority=3,enabled=true)
  public void editTest() throws IOException, InterruptedException
  {
	  excelobj=new ExcelUtil();
	  guobj=new GeneralUtility();
	  mcobj=new ManageContentPage(driver);
	  //extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  mcobj.editContact(excelobj.readDataFromExcel(9,1),excelobj.readDataFromExcel(10, 1),excelobj.readDataFromExcel(11,1));
	  guobj.generalSleep();
	  Assert.assertEquals(mcobj.updatedMessage(), Constants.expectedcontactupdatemessage);
	 // extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
  }
	 
	
}