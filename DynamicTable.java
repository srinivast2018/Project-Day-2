package com.ibm.dynamictable;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ibm.initialization.LaunchWebDriver;
import com.ibm.tablepages.MainPage;

public class DynamicTable extends LaunchWebDriver {

	
//To display the employee names with age >=50 and salary >=200000	
@Test
public void printName()
{
	String url = data.get("url");
	driver.get(url);
	System.out.println(data.get("message"));

	MainPage page=new MainPage(driver,wait);
	
	//Displaying the employee names 
	page.employeeNames();
	
	//To click on Next link
	page.nextLink();
	
	page.employeeNames();
}

}

