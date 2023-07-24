package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{

	@FindBy(name = "firstname")
	WebElement firstname;
	
	@FindBy(name = "lastname")
	WebElement lastname;
	
	@FindBy(name = "reg_email__")
	WebElement mobileNumber;
	
	@FindBy(name = "password_step_input")
	WebElement password;
	
	@FindBy(id = "month")
	WebElement monthDd;
	
	@FindBy(id = "day")
	WebElement dayDd;
	
	@FindBy(id = "year")
	WebElement yearDd;
	
	@FindBy(name = "websubmit")
	WebElement signUp;
	
	public SignUpPage() {
		
		PageFactory.initElements(driver, this);
	}
	
    public void createNewAccount() {
	// enter firstname
	firstname.sendKeys("lalla");
	
	//enter last name
	lastname.sendKeys("Patel");
	//System.out.println(driver.findElement(By.name("lastname")).getAttribute("value")); // reading patel
	
	//enter 10 digit mobile number
	mobileNumber.sendKeys("1245126161");
	
	//enter password
	password.sendKeys("ahasdgxsa");
	
	//======================== select july,10,2000 here before submitting=============================
	// each dropdown needs seperate webelemet
	//WebElement monthDd = driver.findElement(By.id("month"));
	Select m = new Select(monthDd);
	m.selectByIndex(6);
	
	//WebElement dayDd = driver.findElement(By.id("day"));
	Select d = new Select(dayDd);
	d.selectByValue("10");
	
	//WebElement yearDd = driver.findElement(By.id("year"));
	Select y = new Select(yearDd);
	y.selectByVisibleText("2000");
		
	List<WebElement> radio = driver.findElements(By.xpath("//span[@data-name='gender_wrapper']/span/label"));
	System.out.println(radio.size()); //3
	radio.get(1).click();
	
	//click on SignUP button
	signUp.click();
   }
}
