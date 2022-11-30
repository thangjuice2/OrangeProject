package com.page;

import org.openqa.selenium.By;

import com.library.Base;

public class ClickingPages extends Base{
	public void clickAdmin() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a"));
	}

	public void clickPIM() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a"));
	}

	public void clickLeave() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(3) > a > span"));

	}

	public void clickTime() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(4) > a"));

	}

	public void clickRecruitment() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(5) > a > span"));

	}

	public void clickMyInfo() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(6) > a"));
											
	}

	public void clickPerformance() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(7) > a > span"));
	}

	public void clickDashBoard() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(8) > a"));
	}

	public void clickDirectory() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(9) > a > span"));
	}

	public void clickMaintenance() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(10) > a"));
	}

	public void clickBuzz() {
		myLibGS.clickElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(11) > a > span"));
	}
}
