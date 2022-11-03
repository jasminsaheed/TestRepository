package com.supermarket_utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	WebDriver driver;

	@DataProvider(name="loginData")
	 public Object[][] getData() {
		 return new Object[][] {
		      new Object[] { "username", "username" },
		      new Object[] { "password", "password" },
		    };


}

}
