package com.supermarket_utilities;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtility{

	WebDriver driver;
	

	public WebDriver browserLaunch(String browser,String url)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		return driver;
	}
	
	public void clickCommand(WebElement element)
	{
		element.click();
	}
	public void sendKeysCommand(WebElement element,String text)
	{
		
		element.sendKeys(text);
	}
	public void clearCommand(WebElement element)
	{
		element.clear();
	}
	public void selectByVisibleText(WebElement element,String text)
	{
	
		Select obj=new Select(element);
		obj.selectByVisibleText(text);
	}
	public void selectByVisibleValue(WebElement element,String text)
	{
		Select obj=new Select (element);
		obj.selectByValue(text);
	}
	public void selectByIndex(WebElement element,int index)
	{
		Select obj=new Select(element);
		obj.selectByIndex(index);
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
     public void mouseHoverAndClick(WebElement element)
    {
	 Actions action=new Actions(driver);
	 action.moveToElement(element).click().build().perform();
	}
     public void generalSleep() throws InterruptedException
     {
    	 Thread.sleep(5000);
    	 
     }
     public void javaScriptExecutorClick(WebDriver driver, WebElement element) {
 		JavascriptExecutor js = (JavascriptExecutor) driver;
 		js.executeScript("arguments[0].click()", element);
 	}

     public void isSelected(WebElement element)
    {
    	 element.click();
    	 boolean opt1=element.isSelected(); 
	 
    }
   
	public String dynamicWebTable(WebDriver driver,WebElement row2,WebElement column2,int rowloc,int columnloc) {
    	 String webdata=null;
    	
	List<WebElement> rows1 = (List<WebElement>)row2;
   	  int rowcount=rows1.size();
	List<WebElement> column1=(List<WebElement>)column2;
   	  int columncount=column1.size();
   	  for(int i=1;i<=rowcount;i++)
   	  {
   		  for(int j=1;j<=columncount;j++)
   		  {
   			  if((i==rowloc)&&(j==columnloc))
   			  {
   			  WebElement element=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr["+i+"]/td["+j+"]"));
   		       webdata=element.getText();
   			  return webdata;
   			 
   			  }
   		  }
   		  System.out.println();
   		  
   		 }
   	 return webdata;
   	  
   	  }
	
	 public void screenshotMethod(WebDriver driver,String name1) throws IOException
	 
	 {
			  Date d= new Date();
			  String date=d.toString().replace(":","_").replace(" ","_")+".png";
			  TakesScreenshot ts=(TakesScreenshot)driver;
			  File source=ts.getScreenshotAs(OutputType.FILE);
			  FileHandler.copy(source, new File("./Screenshot/"+name1+date));
			  System.out.println("Screenshot Taken");
			  
			
	
	 }
}

    
      	  
      	  

    
    	 
     


	
	





