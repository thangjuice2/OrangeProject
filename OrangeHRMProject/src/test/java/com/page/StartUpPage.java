package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.library.Base;

public class StartUpPage extends Base{
	
	
	public void StartUpPageLogIn() {
	
	String OrangeURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	driver.get(OrangeURL);
	
	myLibGS.enterText(By.name("username"), "Admin");
	myLibGS.enterText(By.name("password"), "admin123");
	myLibGS.clickElement(By.cssSelector("div.oxd-form-actions.orangehrm-login-action > button"));
	
}




}
