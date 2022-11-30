package com.page;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.library.SeleniumSupport;

public class AddAndRemoveEmployees {

	
	SeleniumSupport myHelper = new SeleniumSupport();
	
	public void addEmployeeSave(By by, String fillIn) {
		
		//clicking addbutton
	//	WebElement addBttn = driver.findElement(By.cssSelector("div.orangehrm-header-container > button"));
	//	addBttn.click();
		myHelper.enterText(By.name("firstName"), fillIn);
		myHelper.enterText(By.name("middleName"), fillIn);
		myHelper.enterText(By.name("lastName"), fillIn);
		
		
		
	}
	public void upLoadImage(By by, String image) {
		//upload immage 
		myHelper.clickElement(By.className("oxd-icon bi-plus"));
		String fileFullPath = null;
		
		//WebElement uploadElem = driver.findElement(by);
		File file = new File(image);
		fileFullPath = file.getAbsolutePath();
		
	}
	
}
