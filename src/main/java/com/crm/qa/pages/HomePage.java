package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//span[contains(text(),'Lajja Patel')]")
	WebElement userLoggedIn;
	
	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement friends;
	
	//1.initializing the page objects
		public HomePage() {
			PageFactory.initElements(driver, this);//this means pointing to current class object
			//select 3rd option in initElements()
		}
	
   //2.Actions on home page
	public String verifyHomePageTitle(){
	  return driver.getTitle();	
	}
	
	public boolean verifyCorrectUsername() {
		return userLoggedIn.isDisplayed();  // Lajja Patel should be displayed
	}
	//after we reach homepage we want to click friends link
	//after clicking friends page it should return next landing (Friends) Page object
	//this page library we have created for home page
	//u can add more methods like this
	public FriendsPage clickOnFriendsLink() {
		friends.click();
		return new FriendsPage();
	}
}
