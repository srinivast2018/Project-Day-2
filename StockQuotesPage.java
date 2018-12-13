package com.ibm.tablepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StockQuotesPage {

	// Locating A link
	@FindBy(xpath = "//a[@title='A']")
	WebElement linkA;
	WebDriverWait wait;
	WebDriver driver;

	public StockQuotesPage(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	// To click on A link
	public void clickOnA() {
		linkA.click();

	}

}
