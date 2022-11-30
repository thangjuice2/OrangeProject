package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.Base;

public class ClickButtons extends Base {

	public void clickEmployeeID(String fillIn) {
		myLibGS.enterText(By.cssSelector(
				"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(2) > div > div:nth-child(2) > input"),
				fillIn);
		myLibGS.customWait(1);
	}

	public void clickSearchOnPIM() {
		myLibGS.clickElement(By.cssSelector("button[type='submit']"));
		myLibGS.customWait(1);
	}

	public void clickOnFirstPerson() {
		myLibGS.clickElement(By.cssSelector("div.oxd-table-body > div > div > div:nth-child(3) > div"));
		myLibGS.customWait(1);
	}

	public void clickContactDetails() {
		myLibGS.clickElement(By.cssSelector("div.orangehrm-tabs > div:nth-child(2) > a"));
		myLibGS.customWait(1);
	}

	public void clickAddBtnOnPIMPage() {
		WebElement addBttn = driver.findElement(By.cssSelector("div.orangehrm-header-container > button"));
		addBttn.click();
	}

	public void clickAddPhotoOnPIM() {
		myLibGS.clickElement(By.cssSelector(
				"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-image > div > div:nth-child(2) > div > button > i"));

	}

	public void uploadImage(String jpn) {
		myLibGS.fileUpload(By.cssSelector("div.orangehrm-employee-image > div > div:nth-child(2) > input"), jpn);
		myLibGS.customWait(2);

	}
	public void uploadOnContacts(String jpn) {
		myLibGS.clickElement(By.cssSelector("div.orangehrm-horizontal-padding.orangehrm-vertical-padding > div > button"));
		myLibGS.customWait(1);
		myLibGS.fileUpload(By.cssSelector("div > div.oxd-file-button"), jpn);
		myLibGS.customWait(1);
	}
	


	public void addEmployeeSaveBtn() {
		myLibGS.clickElement(
				By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		myLibGS.customWait(1);
	}

	public void clickApplyOnLeave() {
		myLibGS.clickElement(By.cssSelector("nav > ul > li:nth-child(1)"));
		myLibGS.customWait(1);
	}
	public void clickEmploymentStatus() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(3) > div > div:nth-child(2)"));
		myLibGS.customWait(1);
	}
	public void saveBtnOnApplyLeave() {
		myLibGS.clickElement(By.cssSelector("form > div.oxd-form-actions > button"));
		myLibGS.customWait(1);
	}
//	public void clickUpLoadOnContacts() {
//		myLibGS.clickElement(By.cssSelector("div:nth-child(2) > div > div.oxd-file-button"));
//		myLibGS.customWait(1);
//	}
	
	
	
	
	
}


