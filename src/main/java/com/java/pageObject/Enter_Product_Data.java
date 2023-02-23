package com.java.pageObject;

import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.java.testBase.TestBase;

public class Enter_Product_Data extends TestBase {

	@FindBy(id="startdate")
	WebElement date_startdate;
	
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;

	@FindBy(xpath = "//input[@name='Optional Products[]']/parent::label")
	List<WebElement> chc_optional_products;

	@FindBy(id = "nextselectpriceoption")
	WebElement btn_next;

	public Enter_Product_Data() {
		PageFactory.initElements(driver, this);
	}

	public void enterProductData(HashMap<String,String> testData) throws Exception {
		date_startdate.sendKeys(testData.get("Product_startdate").toString());
		cm.selectDropdownValue(dd_insurancesum, testData.get("Product_insurancesum"));
		cm.selectDropdownValue(dd_damageinsurance, testData.get("Product_damageinsurance"));
		cm.checkBoxSelection(chc_optional_products, testData.get("Product_OptionalProducts"));
		
	}
	

	public void clickNext() {
		btn_next.click();
	}

}
