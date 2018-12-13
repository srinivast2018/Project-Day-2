package com.ibm.dynamictable;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ibm.initialization.LaunchWebDriver;
import com.ibm.tablepages.CompaniesPage;
import com.ibm.tablepages.ContinuePage;
import com.ibm.tablepages.NewsPage;
import com.ibm.tablepages.StockQuotesPage;

public class DisplayLinks extends LaunchWebDriver {

	// To display all the links and link text
	@Test
	public void printLinks() {
		String url = data.get("urlmoneycontrol");
		String expectedTitle = data.get("exptitle");
		// To launch money control web application
		driver.get(url);

		NewsPage newspage = new NewsPage(driver, wait);

		// To click on stocks link
		newspage.clickOnStocks();

		StockQuotesPage quotespage = new StockQuotesPage(driver, wait);

		// To click on A link
		quotespage.clickOnA();

		CompaniesPage companypage = new CompaniesPage(driver, wait);

		// To print links and link text of companies
		System.out.println(data.get("linksconsole"));
		companypage.printLinks();
		String actualTitle = companypage.clickonCompany();
		System.out.println("Title is  " + actualTitle);

		// Assertion of title of the page
		Assert.assertTrue(actualTitle.contains(expectedTitle), "Assertion on page title");

	}

}
