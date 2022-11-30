package com.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.library.Base;

public class ClickOrFilling extends Base {

	public void Street1(String fillIn) {
		myLibGS.enterText(
				By.cssSelector("form > div:nth-child(3) > div > div:nth-child(1) > div > div:nth-child(2) > input"),
				fillIn);
//		WebElement Strt1 = driver.findElement(
//				By.cssSelector("form > div:nth-child(3) > div > div:nth-child(1) > div > div:nth-child(2) > input"));
//		Strt1.click();
//		Strt1.clear();
//		Strt1.sendKeys(fillIn);
		myLibGS.customWait(1);
	}

	public void City(String fillIn) {
		WebElement city = driver.findElement(
				By.cssSelector("div:nth-child(3) > div > div:nth-child(3) > div > div:nth-child(2) > input"));
		city.click();
		city.clear();
		city.sendKeys(fillIn);
		myLibGS.customWait(1);
	}

	public void stateProvince(String fillIn) {

		WebElement state = driver
				.findElement(By.cssSelector("div > div:nth-child(4) > div > div:nth-child(2) > input"));
		state.click();
		state.clear();
		state.sendKeys(fillIn);
		myLibGS.customWait(1);
	}

	public void Zip(String fillIn) {
		myLibGS.enterText(By.cssSelector("div:nth-child(5) > div > div:nth-child(2) > input"), fillIn);
//		WebElement zip = driver.findElement(By.cssSelector("div:nth-child(5) > div > div:nth-child(2) > input"));
//		zip.click();
//		zip.clear();
//		zip.sendKeys(fillIn);
		myLibGS.customWait(1);
	}

	public void SelectCountry() {

	}

	public void Country(String selectCountry) {
		try {
			List<WebElement> country = driver.findElements(By.className("oxd-select-option"));
			myLibGS.selectOptionFromDropDown(country, selectCountry);
			myLibGS.customWait(1);
		} catch (Exception e) {

		}

	}

	public void clickCountry() {
		myLibGS.clickElement(By.className("oxd-select-text oxd-select-text--active"));
		myLibGS.customWait(1);
		myLibGS.clickElement(By.cssSelector("div:nth-child(22)"));
		myLibGS.customWait(1);
	}

	public ClickOrFilling selectCountry(String selectCountry) {
		try {
			List<WebElement> country = driver.findElements(By.className("oxd-select-option"));
			myLibGS.selectOptionFromDropDown(country, selectCountry);
			myLibGS.customWait(1);
		} catch (Exception e) {

		}
		return this;

	}

	public void selectDropDownOptions() {
		Select select = new Select(driver.findElement(By.className("oxd-select-option")));
		List<WebElement> options = select.getOptions();
//		select.getAllSelectedOptions();
//		select.getOptions();

		for (WebElement e : options) {
			System.out.println(e);
		}
	}

	public void printOutText() {
		myLibGS.findAllLinks();
	}

	public void home(String homeNumber) {

		WebElement home = driver.findElement(
				By.cssSelector("div:nth-child(6) > div > div:nth-child(1) > div > div:nth-child(2) > input"));
		home.click();
		home.clear();
		home.sendKeys(homeNumber);
		myLibGS.customWait(1);

	}

	public void mobile(String mobileNumber) {
		WebElement home = driver.findElement(
				By.cssSelector("form > div:nth-child(6) > div > div:nth-child(2) > div > div:nth-child(2) > input"));
		home.click();
		home.clear();
		home.sendKeys(mobileNumber);
		myLibGS.customWait(1);
	}

	public void work(String workNumber) {
		WebElement home = driver.findElement(
				By.cssSelector("form > div:nth-child(6) > div > div:nth-child(3) > div > div:nth-child(2) > input"));
		home.click();
		home.clear();
		home.sendKeys(workNumber);
		myLibGS.customWait(1);
	}

	public void saveContact(boolean save) {
		save = true;
		if (save == true) {
			// clicking save (only if you need to)
			myLibGS.clickElement(By.cssSelector(
					"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div.oxd-form-actions > button"));
			myLibGS.customWait(1);
		} else {
			// do nothing
		}
	}

	public void savePersonalPage() {
		myLibGS.clickElement(By.cssSelector(
				"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-navigation > div.orangehrm-tabs > div:nth-child(1) > a"));
		myLibGS.customWait(1);
		myLibGS.clickElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/button"));
		myLibGS.customWait(1);
	}

	public void addEmployeeInfoFirstName(String firstname) {
		myLibGS.enterText(By.name("firstName"), firstname);
		myLibGS.customWait(1);
	}

	public void addEmployeeInfoMiddleName(String middlename) {
		myLibGS.enterText(By.name("middleName"), middlename);
		myLibGS.customWait(1);
	}

	public void addEmployeeInfoLastName(String lastname) {
		myLibGS.enterText(By.name("lastName"), lastname);
		myLibGS.customWait(1);
	}

	public void employeeIDAdd(String id) {

		myLibGS.enterText(
				By.cssSelector("div.oxd-grid-2.orangehrm-full-width-grid > div > div > div:nth-child(2) > input"), id);
		myLibGS.customWait(1);
	}

	public void addCommentsOnLeave(String comment) {
		myLibGS.enterText(By.cssSelector("div > div:nth-child(2) > textarea"), comment);
		myLibGS.customWait(1);
	}

	public void functiontTestFromClock() {
		// click up on hour
		myLibGS.clickElement(By.cssSelector("div:nth-child(3) > div > div:nth-child(2) > div > div:nth-child(2) > div > div > i"));
		myLibGS.customWait(1);
		// up on hour
		myLibGS.clickElement(By.cssSelector("i.oxd-icon.bi-chevron-up.oxd-icon-button__icon.oxd-time-hour-input-up"));
		myLibGS.customWait(1);
		// click up on minutes
		myLibGS.clickElement(By.cssSelector("i.oxd-icon.bi-chevron-up.oxd-icon-button__icon.oxd-time-minute-input-up"));
		myLibGS.customWait(1);
		// click down on minutes
		myLibGS.clickElement(By.cssSelector("i.oxd-icon.bi-chevron-down.oxd-icon-button__icon.oxd-time-minute-input-down"));
		myLibGS.customWait(1);
		// click PM
		myLibGS.clickElement(By.cssSelector("div:nth-child(2) > input[type=radio]"));
		myLibGS.customWait(1);
		//click AM
		myLibGS.clickElement(By.cssSelector("div:nth-child(1) > input[type=radio]"));
		
	}
	public void customizeFromTime(String time) {
		myLibGS.enterText(By.cssSelector("div:nth-child(3) > div > div:nth-child(2) > div > div:nth-child(2) > div > div > input"), time);
		myLibGS.customWait(1);
	}
	public void customizeToTime(String time) {
		myLibGS.enterText(By.cssSelector("div:nth-child(3) > div > div:nth-child(3) > div > div:nth-child(2) > div > div > input"), time);
		myLibGS.customWait(1);
	}
	
	public void employeeName(String name){
		myLibGS.enterText((By.cssSelector("div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > div > div > input")), name);
		myLibGS.customWait(1);
}
	public void supervisorName(String name){
		myLibGS.enterText((By.cssSelector("div:nth-child(5) > div > div:nth-child(2) > div > div > input")), name);
		myLibGS.customWait(1);
}
	

}
