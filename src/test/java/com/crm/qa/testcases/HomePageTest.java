package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FriendsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

//ctrl+shift+o shortcut for all the imports
public class HomePageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	FriendsPage fp;
	
	public HomePageTest() {
		super();
	}
	
	//***IMP : Test cases should be independent of each other**** that's why we open and close browser everytime for each testcases
	//before each test case -- launch the browser and log in 
	//@test -- execute test case
	//after each test case -- close the browser
	
	//here in this method we have to be logged in 
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		fp = new FriendsPage();
		hp = lp.facebookLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = hp.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook", "Home page title not matched"); //this assert message will be dispalyed only if our test fails
	}
	
	@Test(priority = 2)
	public void verifyCorrectUsernameTest() {
		Assert.assertTrue(hp.verifyCorrectUsername());
	}
	
	@Test(priority = 3)
	public void verifyClickOnFriendsLinkTest() {
		fp = hp.clickOnFriendsLink(); // click on friends link and close the browser
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();  // close browser this is to verify change in DealsPageBranch, GIT master/branch concept learn
	}
}
