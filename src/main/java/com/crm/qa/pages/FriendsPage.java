package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class FriendsPage extends TestBase{
	
	// define page factory/obj
	@FindBy(xpath = "//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 x1120s5i'][contains(text(),'Friend requests')]")
	WebElement friendRequests;
	
	@FindBy(xpath = "//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lkfr7t x1lbecb7 xk50ysn xzsf02u'][contains(text(),'Friend requests')]")
	WebElement friendRequestsTab;
	
	//1. initialize the page object
	public FriendsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//2. actions on friends page
	public String verifyFriendsPageTitle() { // we will not use this test here it's giving error
		return driver.getTitle();
	}

	public boolean verifyFriendRequestsLabel() {
		return friendRequests.isDisplayed();
	}
	
	public void clickFriendRequestsTab() {
		friendRequestsTab.click();
	}
	
}
