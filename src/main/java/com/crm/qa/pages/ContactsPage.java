package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//span[contains(@class,'selectable')]")
	WebElement ContactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement Lastname;
	
	@FindBy(xpath="@FindBy(xpath=\"//span[contains(@class,'selectable')]\")\r\n"
			+ "	WebElement ContactsLabel;")
	WebElement CompanyName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement Save;
	
	
	//Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean verifyContactLabel() {
		return ContactsLabel.isDisplayed();
	}

	public void selectcontacts() {
		driver.findElement(By.xpath("//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']/div[@class='table-wrapper']/table[@class='ui celled definition sortable striped table custom-grid']/tbody/tr[1]/td[1]/div[1]/input[1]")).click();		
		
	}
	
	public void createNewContact(String ftname, String ltname, String company) {
		
		firstname.sendKeys(ftname);
		Lastname.sendKeys(ltname);
		CompanyName.sendKeys(company);
		Save.click();
	}
	
	
	
	
}
