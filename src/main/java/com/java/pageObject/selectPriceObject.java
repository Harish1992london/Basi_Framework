package com.java.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.java.testBase.TestBase;

public class selectPriceObject extends TestBase {
	
	@FindBy(id="nextsendquote")
	WebElement btn_Next;
	
	//init
	public selectPriceObject() {
		PageFactory.initElements(driver, this);
	}
	
	//to get price based on selected option / plan
	public String getPriceForSelectedOption(String plan) {
		String dataXpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
		return driver.findElement(By.xpath(dataXpath)).getText();
	}
	
	public void selectPriceOption(String plan) {
		String dataXpath = "//input[@name='Select Option' and @value='"+plan+"']/parent::label";
		driver.findElement(By.xpath(dataXpath)).click();
	}
	
	public void clickNext() {
		btn_Next.click();
	}

}
