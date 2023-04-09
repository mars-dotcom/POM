package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;




public class HomePage extends TestBase {
	
	@FindBy(xpath="//b[contains(text(),'Mars')]")
	WebElement UserNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	//@FindBy(xpath="//button[@class='ui linkedin button' and contains(text(),'Save')]")    
	//WebElement NewContact;
	
	@FindBy(xpath="//button[contains(text(),'Create')]") 
	WebElement NewContact;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement TaskLink;
	
	//Initializing the page objects
	
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyusername() {
		return UserNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		 ContactsLink.click();
		 return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		DealsLink.click();
		 return new DealsPage();
	}
	
	public TaskPage clickTaskLink() {
		TaskLink.click();
		 return new TaskPage();
	}
	
	public void clickOnNewContactlink() throws InterruptedException  {
	/*	Actions action= new Actions(driver);
		action.click(ContactsLink).build().perform();
		action.moveToElement(NewContact).build().perform();
		Thread.sleep(5000);
		action.click(NewContact).build().perform();    */
		
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByClassName('plus inverted icon')[1].click()");
	}
	
	
	
	
	
	
	

}
