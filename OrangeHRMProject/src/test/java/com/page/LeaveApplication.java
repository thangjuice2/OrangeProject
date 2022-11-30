package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.library.SeleniumSupport;

public class LeaveApplication extends SeleniumSupport{

	SeleniumSupport myHelper = new SeleniumSupport();
	
	public void clickOnLeave() {
		myHelper.clickElement(By.xpath("//a[normalize-space()='']"));
	}
}
