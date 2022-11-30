package com.tests;

import org.testng.annotations.Test;

import com.library.Base;
import com.library.LocatorMap;
import com.page.AddAndRemoveEmployees;
import com.page.ClickButtons;
import com.page.ClickOrFilling;
import com.page.ClickingPages;
import com.page.SelectDDAndDates;
import com.page.StartUpPage;
import com.page.timeSheetPage;

public class OrangeHRMTest extends Base {
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	LocatorMap map = new LocatorMap("src/test/resources/locatormap.properties");
	SelectDDAndDates DropDown = new SelectDDAndDates();
	AddAndRemoveEmployees addRemoveEmployees = new AddAndRemoveEmployees();
	ClickOrFilling FillingIn = new ClickOrFilling();
	ClickButtons clickButtons = new ClickButtons();
	ClickingPages clickPage = new ClickingPages();
	timeSheetPage timeTest = new timeSheetPage();
	StartUpPage LogIn = new StartUpPage();

	// SUCCESS!!!
	@Test(enabled = true)
	public void searhEditPeople() {
		String ID = "0221";
		String Street = "Lighter";
		String City = "Baltimore";
		String State = "Maryland";
		String Zip = "45960";
		String Country = "United States";
		String homeNum = "4105407779";
		String workNum = "4105407779";
		String mobileNum = "4105407779";

		LogIn.StartUpPageLogIn();
		clickPage.clickPIM();
		clickButtons.clickEmployeeID(ID);
		clickButtons.clickSearchOnPIM();
		clickButtons.clickOnFirstPerson();
		clickButtons.clickContactDetails();
		FillingIn.Street1(Street);
		FillingIn.City(City);
		FillingIn.stateProvince(State);
		FillingIn.Zip(Zip);
		DropDown.selectState(Country);
		FillingIn.home(homeNum);
		FillingIn.work(workNum);
		FillingIn.mobile(mobileNum);
		FillingIn.saveContact(true);

	}

	@Test(enabled = true)
	public void addAnEmployee() {
		LogIn.StartUpPageLogIn();
		clickPage.clickPIM();
		clickButtons.clickAddBtnOnPIMPage();
		FillingIn.addEmployeeInfoFirstName("Ichigo");
		FillingIn.addEmployeeInfoMiddleName("");
		FillingIn.addEmployeeInfoLastName("Kurosaki");
		FillingIn.employeeIDAdd("1");
		clickButtons.uploadImage("src/test/resources/Ichigo Kurosaki.jpg");
		clickButtons.addEmployeeSaveBtn();

	}

	@Test(enabled = true)
	public void applyOnLeave() {
		LogIn.StartUpPageLogIn();
		clickPage.clickLeave();
		clickButtons.clickApplyOnLeave();
		DropDown.OnLeave();
		DropDown.selectFromDateOnLeave("2023-06-01");
		DropDown.selectToDateOnLeave("");
		DropDown.durationSelectSpecificTime();
		FillingIn.functiontTestFromClock();
		FillingIn.customizeFromTime("04:00 PM");
		FillingIn.customizeToTime("05:00 PM");
		FillingIn.addCommentsOnLeave("Needs to take a month off to drink a lot of beer, thanks!");
		clickButtons.saveBtnOnApplyLeave();

	}

	@Test(enabled = true)
	public void editJob() {
		LogIn.StartUpPageLogIn();
		// write a code where you can edit whatever time of the week
		clickPage.clickTime();
		timeTest.clickView1Btn();
		timeTest.clickEditBtnOnTimeSheets();
		timeTest.firstRow(url, url, url, url, url, url, url);
		
		
		
		timeTest.addRow();
		timeTest.addProjectName("Internal - General HR Tasks");
	}

	@Test
	public void searchUpPeopleInPIM() {
		String ID = "0038";
		String name = "";
		String supervisorName = "";
		
		LogIn.StartUpPageLogIn();
		clickPage.clickPIM();
		FillingIn.employeeName(name);
		clickButtons.clickEmployeeID(ID);
		DropDown.selectEmployeementStatusDropD("Freelance");
		DropDown.selectIncludeOnPIM("Past Employees Only");
		FillingIn.supervisorName(supervisorName);
		DropDown.selectJobTitleOnPIM("");
		
	}


}
