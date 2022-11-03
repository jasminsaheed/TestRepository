package com.supermarket_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploadAndDownloadUtility {
	public void upload(WebElement element,String image)
	{

	   element.sendKeys(image);
	   }
	public void download(WebElement element)
	{
		element.click();
	}
}
