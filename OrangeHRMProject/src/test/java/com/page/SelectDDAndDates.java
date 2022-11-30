package com.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.library.Base;

public class SelectDDAndDates extends Base {

	public void OnLeave() {

		myLibGS.clickElement(By.cssSelector("div.oxd-select-text--after > i"));
		myLibGS.customWait(1);
		myLibGS.clickElement(By.cssSelector("div.oxd-select-dropdown.--positon-bottom > div:nth-child(2)"));
		myLibGS.customWait(1);

	}

	public void EmploymentStatus(int dd) {
		myLibGS.customWait(1);
		myLibGS.selectDropDown(By.cssSelector(
				"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(3) > div > div:nth-child(2)"),
				dd);

	}

	public void selectFromDateOnLeave(String date) {
		myLibGS.enterText(By.cssSelector("div:nth-child(1) > div > div:nth-child(2) > div > div > input"), date);
	}

	public void selectToDateOnLeave(String date) {
		myLibGS.enterText(By.cssSelector("div:nth-child(2) > div > div:nth-child(2) > div > div > input"), date);
	}

	public void durationSelectSpecificTime() {
		myLibGS.clickElement(By.cssSelector(
				"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(3) > div > div > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i"));
		myLibGS.customWait(1);
		myLibGS.clickElement(By.cssSelector(
				"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(3) > div > div > div > div:nth-child(2) > div > div.oxd-select-dropdown.--positon-bottom > div:nth-child(4)"));
	}

	public void selectEmployeementStatusDropD(String input) {

		try {

			System.out.println("Click on 'Employee Stauts' dropdown and select from the option provided ...");

			By empStatusDropDCss = By
					.cssSelector("div:nth-child(3) > div > div:nth-child(2) > div > div > div.oxd-select-text--after");
			By dropDownOptions = By.cssSelector("div[role='option'][class='oxd-select-option']");

			myLibGS.selectFromDropDownFromList(empStatusDropDCss, dropDownOptions, input);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);

		}

	}

	public void selectIncludeOnPIM(String input) {
		try {

			System.out.println("Click on 'Include' dropdown and select from the option provided ...");

			By empStatusDropDCss = By.cssSelector(
					" div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(4) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i");
			By dropDownOptions = By.className("oxd-select-option");

			myLibGS.selectFromDropDownFromList(empStatusDropDCss, dropDownOptions, input);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}

	}

	public void selectJobTitleOnPIM(String input) {
		try {

			System.out.println("Click on 'Job Title' dropdown and select from the option provided ...");

			By empStatusDropDCss = By.cssSelector(
					" div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(6) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i");
			By dropDownOptions = By.className("oxd-select-option");

			myLibGS.selectFromDropDownFromList(empStatusDropDCss, dropDownOptions, input);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}
	public void selectSubUnitOnPIM(String input) {
		try {

			System.out.println("Click on 'SubUnit' dropdown and select from the option provided ...");

			By empStatusDropDCss = By.cssSelector(
					" div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(7) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i");
			By dropDownOptions = By.className("oxd-select-option");

			myLibGS.selectFromDropDownFromList(empStatusDropDCss, dropDownOptions, input);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}
	public void selectState(String input) {
		try {

			System.out.println("Click on 'State' dropdown and select from the option provided ...");
			//this is where you click for drop down
			By empStatusDropDCss = By.cssSelector(
					"div:nth-child(2) > div > div > div.oxd-select-text--after > i");
			//this is where the list of elements is
			By dropDownOptions = By.className("oxd-select-option");

			myLibGS.selectFromDropDownFromList(empStatusDropDCss, dropDownOptions, input);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}
	

}
