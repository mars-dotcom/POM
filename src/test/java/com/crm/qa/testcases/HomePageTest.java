package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage; 
	
	public HomePageTest(){
		super();
	}
	// test cases should be seperated or independent from each other
	//before each test case--- launch the browser
	//@Test--- execute test
	//after each test case--- close the browser
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil= new TestUtil();
		contactspage= new ContactsPage();
		loginPage = new LoginPage();
		homepage= loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepagetitle= homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM", "Home Page Title not Matched");
	}
	
	@Test(priority=2)
	public void verifyusernameTest() {
		Assert.assertTrue(homepage.verifyusername());
	}
	
	@Test(priority=3)
	public void verifyContacLinktTest() {
		contactspage= homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
