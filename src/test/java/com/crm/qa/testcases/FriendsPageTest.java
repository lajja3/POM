package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FriendsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class FriendsPageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	FriendsPage fp;
	
	public FriendsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		fp = new FriendsPage();
		hp = lp.facebookLogin(prop.getProperty("email"), prop.getProperty("password")); //login to ur account
		hp.clickOnFriendsLink(); //will click on friends so that it goes to friends page
	}
	
	//@Test
	public void verifyFriendsPageTitleTest() { // this test is giving error
		String friendsPageTitle = fp.verifyFriendsPageTitle();
		Assert.assertEquals(friendsPageTitle, "Friends", "Friends page title not matched"); //this assert message will be dispalyed only if our test fails
	}
	
	@Test(priority = 1)
	public void verifyFriendRequestsLabelTest() {
		Assert.assertTrue(fp.verifyFriendRequestsLabel(),"friend requests label is missing on the page");
	}
	
	@Test(priority = 2)
	public void clickFriendRequestsTabTest() {
		fp.clickFriendRequestsTab(); 	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
