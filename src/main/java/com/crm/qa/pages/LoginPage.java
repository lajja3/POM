package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
//In Page object model u create separate java class for each and every page
//creating parent(TestBase) - child(LoginPage) relationship between LoginPage and TestBase
//use extends keyword followed by parentclass name
public class LoginPage extends TestBase{

	// define pagefactory or object repository(OR)
	
	//1. ELEMENT - email
	//driver.findElement(By.name("email")).sendKeys("hdfcbej");
	@FindBy(name = "email")
	WebElement email;
	
	//2. ELEMENT - password
	//driver.findElement(By.name("pass")).sendKeys("hvfjkdhv");
	@FindBy(name = "pass")
	WebElement password;
	
	//3. ELEMENT - login button
	//driver.findElement(By.tagName("button")).click();
	@FindBy(tagName="button")
	WebElement LogIn;
	
	//4. ELEMENT - create new account
	//driver.findElement(By.linkText("Create new account")).click();
	@FindBy(linkText = "Create new account")
	WebElement CreateNewAccount;
	
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);//this means pointing to current class object
		//select 3rd option in initElements()
	}
	
	//Actions:-
	public String validateLoginPageTitle() { 
		return driver.getTitle(); //Facebook - log in or sign up should come.. might not come see html code
	}
	
	//this is the page library we have created for home page
	//u can add as many methods as u want
	public HomePage facebookLogin(String em, String pwd) {
		email.sendKeys(em);
		password.sendKeys(pwd);
		LogIn.click();
		
		return new HomePage(); //return u obj of homepage
	}
	
	public void clickOnCreatNewAccount() {
		CreateNewAccount.click();
	}
	
}
