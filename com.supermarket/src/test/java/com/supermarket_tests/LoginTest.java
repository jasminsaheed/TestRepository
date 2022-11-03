package com.supermarket_tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.supermarket.constants.Constants;
import com.supermarket.extentreport.TestListener;
import com.supermarket_pages.LoginPages;
import com.supermarket_utilities.DataProviderUtility;
import com.supermarket_utilities.ExcelUtil;
import com.supermarket_utilities.GeneralUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class LoginTest extends BaseClass {
	GeneralUtility guobj;
	ExcelUtil excelobj;
	LoginPages loginobj;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	
	@Test(description="validate the login page with valid credentials",retryAnalyzer= com.supermarket_utilities.RetryAnalyzerUtil.class)
	public void validateWithValidCredentials() throws IOException
	{
		excelobj=new ExcelUtil();
		loginobj=new LoginPages(driver);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
		loginobj.clearUserNameAndPassword();
		loginobj.loginpage(excelobj.readDataFromExcel(0, 2),excelobj.readDataFromExcel(1, 2));
		Assert.assertTrue(loginobj.isAdminLogoPresent());
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");

	 
		
	}
	
  @Test(dataProvider = "loginData",dataProviderClass=DataProviderUtility.class)
  public void validateWithInvalidCredential(String username,String password) {
	  LoginPages loginobj=new LoginPages(driver);
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  loginobj.clearUserNameAndPassword();
	  loginobj.loginpage(username,password);
	  AssertJUnit.assertEquals(loginobj.getErrorMessage(), Constants.expectedErrorMessage);
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	
	  
	
	  
  }



}
