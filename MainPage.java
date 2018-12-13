package com.ibm.tablepages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	@FindBy(xpath="//select[@name='example_length']")
	WebElement selectEntries;
	
	@FindBy(xpath="//a[@id='example_next']")
	WebElement nextLink;
	
	/*Locating the total numer of rows in the table
		@FindAll(@FindBy(xpath="//table[@id='example']/tbody/tr"))*/
		List<WebElement> rows;
		List<WebElement> cols;
		int rowTotal;
		int salary,age;
		WebDriverWait wait;
		WebDriver driver;
	
	public MainPage(WebDriver driver,WebDriverWait wait)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait=wait;
	}
	
//To display the names of empoyees
	public void employeeNames()
	{
		Select entryElt=new Select(selectEntries);
		entryElt.selectByVisibleText("50");
		
		//To find total number of rows on page
		rows = (List<WebElement>) driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		rowTotal = rows.size();
		
		//To find total number of columns on page
		cols=(List<WebElement>) driver.findElements(By.xpath("//table[@id='example']/tbody/tr[1]/td"));
		
		int j=0;
		
		for (int i = 1; i <= rowTotal; i++) {
			j = i + 1;
			// To locate and click on the name element value in each row
			WebElement nameCell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[1]"));
			nameCell.click();

			// Locating salary element value
			//WebElement salElt = driver.findElement(By.xpath("(//table[@id='example']/tbody/tr[" + j + "]/td[1]/descendant::span)[2]"));
			WebElement salElt=driver.findElement(By.xpath("//span[@class='dtr-data']"));

			// Replacing the special characters $ , with empty value in a string
			String salValue = salElt.getText().trim().replace("$", "").replace(",", "");
			salary=Integer.parseInt(salValue);
				
			//To locate Age element
			WebElement ageElt=driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[4]"));
			String agevalue=ageElt.getText();			
			age=Integer.parseInt(agevalue);
			
			// To click on name element value again
			nameCell.click();
			if (age>=50 && salary>=200000)
			{
				String name=nameCell.getText().toString();
				System.out.println(name);
			}
			
		
		}
	
	}

	
	public void nextLink()
	{
		nextLink.click();
		
	}
	
}
