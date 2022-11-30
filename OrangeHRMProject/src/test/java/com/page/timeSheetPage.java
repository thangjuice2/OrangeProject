package com.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.library.Base;

public class timeSheetPage extends Base{
	
	
	public void checkEmployeeNameOnTime(String name) {
	//	myLibGS.enterText(By.cssSelector("div > div > div:nth-child(2) > div > div > input"), name);
		myLibGS.customWait(1);
		myLibGS.sendKeysDownEnter(By.cssSelector("div > div > div:nth-child(2) > div > div > input"), name);
		myLibGS.customWait(1);
		myLibGS.clickElement(By.cssSelector("div.oxd-form-actions > button"));
		myLibGS.customWait(1);
	}
	public void clickView1Btn() {
		//clicking on the first view on list
	myLibGS.clickElement(By.cssSelector("div:nth-child(1) > div > div:nth-child(3) > div > button"));
	}
	
	public void clickEditBtnOnTimeSheets() {
		myLibGS.clickElement(By.cssSelector("div.orangehrm-timesheet-footer--options > button"));
	}
	
	public void clickOnViewEmployee(String name){
		List<WebElement> options = driver.findElements(By.className("oxd-table-card"));
		myLibGS.selectOptionFromDropDown(options, name);
	}
	public void addRow() {
		myLibGS.clickElement(By.cssSelector("tr:nth-child(5) > td > button > i"));
	}
	public void addProjectName(String name) {
		myLibGS.enterText(By.cssSelector("tr:nth-child(5) > td:nth-child(1) > div > div:nth-child(2) > div > div > input"), name);
	}
	public void editComment() {
		myLibGS.clickElement(By.cssSelector("tr:nth-child(1) > td:nth-child(3) > button"));
		myLibGS.customWait(1);
		
	}
	
	public void firstRow(String mon, String tues, String wed, String thur, String fri, String sat, String sun) {
		
		myLibGS.enterText(By.cssSelector(""), mon);
	}
	
}
