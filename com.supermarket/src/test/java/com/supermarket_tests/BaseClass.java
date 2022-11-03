package com.supermarket_tests;

import org.testng.annotations.Test;

import com.supermarket.extentreport.ExtentManager;
import com.supermarket_utilities.GeneralUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	WebDriver driver;
	GeneralUtility guobj=new GeneralUtility();
   public static Properties po;
   public static void testBasic() throws Exception
   {
	   po=new Properties();
	   FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\propertyFile\\configuration.properties");
	   po.load(file);
	   }

  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() {
	  
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethods(ITestResult result) throws IOException 
  {
	  System.out.println("ITestResult.FAILURE"+ITestResult.FAILURE);
	  System.out.println("result.getStatus"+result.getStatus());
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  
		  String name=result.getName();
		  guobj.screenshotMethod(driver, name);
		  Date d= new Date();
		  String date=d.toString().replace(":","_").replace(" ","_")+".png";
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(source, new File("./Screenshot/"+result.getName()+date));
		  System.out.println("Screenshot Taken");
		  
	  }
  }
  
  
 @Parameters({"browser"})
  @BeforeClass(groups="sanity")
  public void beforeClass(String browser) throws Exception {
	 testBasic();
	
	driver=guobj.browserLaunch(browser,po.getProperty("URL"));
  }

  @AfterClass(groups="sanity",alwaysRun=true)
  public void afterClass() {
	  //driver.quit();
  }

  @BeforeTest(alwaysRun=true)
  public void beforeTest() {
  }

  @AfterTest(alwaysRun=true)
  public void afterTest() {
  }
  
  @BeforeSuite(alwaysRun=true)
  public void createReport(final ITestContext testContext) {
	  ExtentManager.createInstance().createTest(testContext.getName(), "message");
  }




  @AfterSuite(alwaysRun=true)
  public void afterSuite() {
  }

}
