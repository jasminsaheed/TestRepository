package com.supermarket_tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import com.supermarket.constants.Constants;
import com.supermarket_pages.LoginPages;
import com.supermarket_pages.ManageSliderPage;
import com.supermarket_utilities.ExcelUtil;
import com.supermarket_utilities.FileUploadAndDownloadUtility;
import com.supermarket_utilities.GeneralUtility;

public class ManageSliderTest extends BaseClass {

	
	GeneralUtility guobj;
	ExcelUtil excelobj;
	LoginPages loginobj;
	ManageSliderPage msobj;
	FileUploadAndDownloadUtility fileutil;
  @Test(description="Validate the ManageSliderPage",priority=1)
  public void manageSlider() throws IOException {
	    excelobj=new ExcelUtil();
		loginobj=new LoginPages(driver);
		loginobj.loginpage(excelobj.readDataFromExcel(0, 2),excelobj.readDataFromExcel(1, 2));
		msobj=new ManageSliderPage(driver);
		msobj.manageSlider();
		Assert.assertTrue(msobj.isDemoLogoPresent());
		

		
		 }
  @Test(description="Validation of Adding New Slider",priority=3,enabled=false)
  public void addSliderTest() throws IOException
  {
	  excelobj=new ExcelUtil();
	  msobj=new ManageSliderPage(driver);
	  guobj=new GeneralUtility();
	  msobj.addSlider(excelobj.readDataFromExcel(2, 1));
	  fileutil=new FileUploadAndDownloadUtility();
	  fileutil.upload(msobj.choosefile,Constants.image);
	  Assert.assertEquals(msobj.getMessage(), Constants.expectedmessage);
	  
  }
 
  @Test(description="Validation of Edit Button",enabled=true,priority=2,groups="sanity")
  public void editTest() throws IOException, InterruptedException
  {
	  guobj=new GeneralUtility();
	  excelobj=new ExcelUtil();
	  msobj=new ManageSliderPage(driver);
	  msobj.editItem( 3,4,excelobj.readDataFromExcel(3, 1));
	  guobj.generalSleep();
	  Assert.assertEquals(msobj.updateMessage(), Constants.updatemessage);
	 
  }
  
 
  @Test(description="Validation of StatusActive Button",enabled=false,priority=4)
  public void statusActive() throws IOException, InterruptedException
  {
	  excelobj=new ExcelUtil();
	  msobj=new ManageSliderPage(driver);
	  guobj=new GeneralUtility();
	  msobj.statusActive(msobj.rowstart,msobj.columnstart ,10, 2);
	  guobj.generalSleep();
	  Assert.assertEquals(msobj.statusMessage(),Constants.expectedstatusmessage);
	  
  }
  @Test(description="Validation of StatusInactive Button",enabled=false,priority=5)
  public void statusInactive() throws IOException, InterruptedException
  {
	  excelobj=new ExcelUtil();
	  msobj=new ManageSliderPage(driver);
	  guobj=new GeneralUtility();
      msobj.statusInactive(msobj.rowstart,msobj.columnstart ,2, 3);
	  guobj.generalSleep();
	  Assert.assertEquals(msobj.statusMessage(),Constants.expectedstatusmessage);
	  
  }

}
