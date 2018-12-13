package com.ibm.tablepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {

	// Locating continue link
	@FindBy(xpath = "//a[@title='Stocks']")
	WebElement stocksEle;

	By stocks = By.xpath("//a[@title='Stocks']");

	WebDriverWait wait;
	WebDriver driver;

	public NewsPage(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	// To click on Stocks link
	public void clickOnStocks()

	{
		stocksEle.click();

	}

}
