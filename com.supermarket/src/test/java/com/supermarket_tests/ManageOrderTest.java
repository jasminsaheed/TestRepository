package com.supermarket_tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.supermarket.constants.Constants;
import com.supermarket.extentreport.TestListener;
import com.supermarket_pages.LoginPages;
import com.supermarket_pages.ManageOrderPage;
import com.supermarket_utilities.ExcelUtil;
import com.supermarket_utilities.GeneralUtility;

public class ManageOrderTest extends BaseClass{
 
    GeneralUtility guobj;
	ExcelUtil excelobj;
	LoginPages loginobj;
	ManageOrderPage mobj;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
@Test(description="Validate ManageOrderPage",priority=1)
public void  manageOrderTest() throws IOException {
	    excelobj=new ExcelUtil();
		loginobj=new LoginPages(driver);
		loginobj.loginpage(excelobj.readDataFromExcel(0,2),excelobj.readDataFromExcel(1,2));
		mobj=new ManageOrderPage(driver);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
		mobj.manageOrders();
		Assert.assertTrue(mobj.isDemoLogoPresent());
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  
}
@Test(description="Validate ViewOrderDetails",priority=2,enabled=false)
public void  viewOrderTest() throws IOException, InterruptedException {
	
	    guobj=new GeneralUtility();
	    excelobj=new ExcelUtil();
	    mobj=new ManageOrderPage(driver);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
		mobj.viewOrder(mobj.rowstart,mobj.columnstart,3,7);
		guobj.generalSleep();
	    Assert.assertEquals(mobj.orderDetails(),Constants.expectedordermessage);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  
}
@Test(description="Validate ViewOrderDetails",priority=3,enabled=true)
public void  deliveryBoyTest() throws IOException, InterruptedException {
	
	    guobj=new GeneralUtility();
	    excelobj=new ExcelUtil();
	    mobj=new ManageOrderPage(driver);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
		mobj.assignDeliveryBoy(mobj.rowstart,mobj.columnstart,3,7,excelobj.readDataFromExcel(16, 1));
		guobj.generalSleep();
		System.out.println(mobj.updatedDeliveryBoyMessage());
	   // Assert.assertEquals(mobj.orderDetails(),Constants.expectedordermessage);
		extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  
}
}
