package com.java.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.java.testBase.TestBase;

public class homePage extends TestBase {

	@FindBy(id = "nav_automobile")
	WebElement link_atomobile;

	@FindBy(id = "nav_truck")
	WebElement link_ruck;

	@FindBy(id = "nav_motorcycle")
	WebElement link_motorcycle;

	@FindBy(id = "nav_camper")
	WebElement link_camper;

	public homePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMOtorcycle() {
		link_motorcycle.click();
	}

}
