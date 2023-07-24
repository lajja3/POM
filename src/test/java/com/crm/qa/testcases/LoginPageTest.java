package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	
	//this class constructor
	public LoginPageTest() {
		super();  //super is called so that base class constructor is called
		// super is constructor it will initialize property file first before initializing initialization();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization(); // initializing all webelements created in parent class
		lp = new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = lp.validateLoginPageTitle();
		//System.out.println(title); getting error after writing this line
		Assert.assertEquals(title, "Facebook - log in or sign up"); // might not work,, assertion is most imp to check test pass or fail
	}
	
	//@Test
	/*
	public void crmLogoImageTest() {
		boolean flag = lp.validateCRMImage(); //this method was in LoginPage if image is present it will return true otherwise false
		Assert.assertTrue(flag); // if flag gives true this test will pass otherwise fail
	}*/
	
	@Test(priority=2)
	public void loginTest() {
		hp = lp.facebookLogin(prop.getProperty("email"), prop.getProperty("password")); // as input in this leads us to homepage thus we are saving the value in obj of homepage
	    //System.out.println("Successfully logged in to Facebook"); got error
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit(); //close browser
	}
}
