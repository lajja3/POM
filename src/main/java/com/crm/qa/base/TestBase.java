package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

//parent class of all classes :- methods and all variables of this class can be used by any child class
public class TestBase {

	public static WebDriver driver; 
	public static Properties prop;
	
	  //create constructor for this class
	  public TestBase() {
		  try {
			    // need obj from properties class
			    prop = new Properties();  
			    //reading data from properties file
		        FileInputStream f = new FileInputStream("C:\\Users\\Lajja Patel\\OneDrive\\Desktop\\MySelenium57\\Selenium_WorkSpace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"); 
		        // adding our property file to inbuild properties class
		        prop.load(f); 
		  }
		  catch(FileNotFoundException e){
			  e.printStackTrace();
		  }
		  catch(IOException e){
			  e.printStackTrace();
		  }
	  }
	
	  public static void initialization() {
		     String browserName = prop.getProperty("browser");
		        if(browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver",  "C:\\Users\\Lajja Patel\\OneDrive\\Desktop\\MySelenium57\\SeleniumJars\\geckodriver.exe");
				    driver = new FirefoxDriver();
				}else {
					System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Lajja Patel\\OneDrive\\Desktop\\MySelenium57\\SeleniumJars\\chromedriver.exe");
					driver = new ChromeDriver();
				}
		        
		        driver.manage().window().maximize();
		        driver.manage().deleteAllCookies();
		        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		        
		        driver.get(prop.getProperty("url"));
	  }
	  
	  
	  
	
}
