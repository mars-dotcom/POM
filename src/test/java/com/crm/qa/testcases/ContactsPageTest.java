package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	
	String sheetName="Contact";
	
	public ContactsPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil= new TestUtil();
		contactspage= new ContactsPage();
		loginPage = new LoginPage();
		homepage= loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactspage= homepage.clickOnContactsLink();
		
	}
	
	//@Test(priority=1)
	public void verifyContactLabel() {
		Assert.assertTrue(contactspage.verifyContactLabel(), "contact label is missing on the page");
	}
	
	
	@Test(priority=2)
	public void selectcontactTest() {
		contactspage.selectcontacts();
	}
	
	//@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	//@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname, String lastname, String company) {
		//contactspage.createNewContact("tom", "peter", "google");
		contactspage.createNewContact(firstname, lastname, company);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
