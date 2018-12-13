package com.ibm.tablepages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompaniesPage {

	WebDriverWait wait;
	WebDriver driver;

	@FindAll(@FindBy(tagName = "a"))
	List<WebElement> linksAll;

	@FindBy(xpath = "//a[@title='Ashok Leyland']")
	WebElement companylink;

	public CompaniesPage(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	// To print links and link text
	public void printLinks() {
		// Finding the total number of rows in the table.
		List<WebElement> rows = (List<WebElement>) driver
				.findElements(By.xpath("//table[@class='pcq_tbl MT10']/tbody/tr"));
		int rowTotal = rows.size();
		
		
		List<WebElement> columns = (List<WebElement>) driver
				.findElements(By.xpath("//table[@class='pcq_tbl MT10']/tbody/tr[2]/td"));
		int colTotal = columns.size();
		
		System.out.println();
		for (int i = 2; i <= rowTotal; i++) {

			for (int j = 1; j <= colTotal; j++) {

				WebElement companyElt = driver.findElement(
						By.xpath("//table[@class='pcq_tbl MT10']/tbody/tr[" + i + "]/td[" + j + "]/descendant::a"));

				System.out.println(companyElt.getText().toString());
				System.out.println(companyElt.getAttribute("href"));

			}

		}

	}

	// To click on Ashok Leyland company
	public String clickonCompany()

	{
		companylink.click();
		return driver.getTitle();
	}

}
