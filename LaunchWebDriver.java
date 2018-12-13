package com.ibm.initialization;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.ibm.utilities.PropertiesFileHandler;

public class LaunchWebDriver {
	public WebDriver driver;
	public WebDriverWait wait;
	public PropertiesFileHandler propFileHandler;
	public HashMap<String, String> data;

	@BeforeSuite
	public void preSetForTest() throws IOException {
		String file = "./TestData/dynamictable.properties";
		propFileHandler = new PropertiesFileHandler();
		data = propFileHandler.getPropertiesAsMap(file);
	}
	
	//Setting path for webdriver and launching web application
	@BeforeMethod
	public void initializeDriver()
	
	{
				//Setting path for Firefox Driver
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait = new WebDriverWait(driver, 60);
				driver.manage().window().maximize();
			
		
	}
	
	//To close the webdriver
	@AfterMethod
	public void close()
	{
		
		driver.close();
	}


}
