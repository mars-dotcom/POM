package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory - OR object Repository
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement cLoginBtn;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//span[contains(text(),'sign up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//header/div[1]/nav[1]/div[2]/div[1]/div[1]")
	WebElement crmLogo;
	
	//Initializing the page objects
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();	
	}
	
	public HomePage login(String eml, String pwd) {
		cLoginBtn.click();
		email.sendKeys(eml);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
}