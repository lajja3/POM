 package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT =10;
	
	//if u have frame present in ur element u need to use this method
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
}
