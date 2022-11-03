package com.supermarket_tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.supermarket.constants.Constants;
import com.supermarket.extentreport.TestListener;
import com.supermarket_pages.LoginPages;
import com.supermarket_pages.PushNotificationPage;
import com.supermarket_utilities.ExcelUtil;
import com.supermarket_utilities.GeneralUtility;

public class PushNotificationTest extends BaseClass {
	GeneralUtility guobj;
	ExcelUtil excelobj;
	LoginPages loginobj;
	PushNotificationPage pnobj;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
  @Test(description="Validate PushNotificationPage",priority=1)
  public void manageUserTest() throws IOException {
	    excelobj=new ExcelUtil();
		loginobj=new LoginPages(driver);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
		loginobj.loginpage(excelobj.readDataFromExcel(0,2),excelobj.readDataFromExcel(1,2));
		pnobj=new PushNotificationPage(driver);
		pnobj.pushNotifiation();
		Assert.assertTrue(pnobj.isDemoLogoPresent());
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  
  }
  @Test(description="Validate SendNotification",priority=2,enabled=false)
  public void sendNotificationTest() throws IOException {
	    excelobj=new ExcelUtil();
		pnobj=new PushNotificationPage(driver);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
		pnobj.addNotification(excelobj.readDataFromExcel(14, 1), excelobj.readDataFromExcel(15, 1));;
		AssertJUnit.assertEquals(pnobj.getSendMessage(),Constants.expectedsendmessage);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  
  }
  @Test(description="Validate ResetButton",priority=3,enabled=false)
  public void resetTest() throws IOException {
	    excelobj=new ExcelUtil();
		pnobj=new PushNotificationPage(driver);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
		pnobj.resetNotification(excelobj.readDataFromExcel(14, 1), excelobj.readDataFromExcel(15, 1));
		Assert.assertEquals(pnobj.getResetMessage(),Constants.expectedresetmessage);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  
  }
  @Test(description="Validate MandatoryField",priority=4,enabled=true)
  public void mandatoryTest() throws IOException {
	    excelobj=new ExcelUtil();
		pnobj=new PushNotificationPage(driver);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
		pnobj.mandatoryField(excelobj.readDataFromExcel(14, 1));
		Assert.assertEquals(pnobj.getErrorMessage(),Constants.expectederrormessage);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  
  }
}
