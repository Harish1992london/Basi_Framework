package com.java.pageObject;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.java.testBase.TestBase;

public class Enter_Vehicle_Data extends TestBase {

	@FindBy(id="make")
	WebElement dd_make;

	@FindBy(id="model")
	WebElement dd_model;

	@FindBy(xpath="//input[@id='cylindercapacity']")
	WebElement txt_cylindercapacity;

	@FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement error_cylinderCapacity;

	@FindBy(id="engineperformance")
	WebElement txt_engineperformance;

	@FindBy(id="dateofmanufacture")
	WebElement date_dateofmanufacture;

	@FindBy(id="numberofseatsmotorcycle")
	WebElement dd_numberofseats;

	@FindBy(id="listprice")
	WebElement txt_listprice;

	@FindBy(id="annualmileage")
	WebElement txt_annualmileage;

	@FindBy(id="nextenterinsurantdata")
	WebElement btn_Next;

	///init
	public Enter_Vehicle_Data() {
		PageFactory.initElements(driver, this);
	}

	public void enterCylinderCapacity(String cylinderCap) {
		txt_cylindercapacity.sendKeys(cylinderCap);
	}

	public String getErrorMessageOnCylinderCapacity() {
		return error_cylinderCapacity.getText();
	}
	
	public List<String> getDropdownOption_model() {
		return cm.getDropdownOptions(dd_model);
	}
	
	
	//enter vehicle data
	public void enterVehicleData(HashMap<String, String> testData) throws Exception {
		cm.selectDropdownValue(dd_make, testData.get("Vehicle_Make"));
		cm.selectDropdownValue(dd_model, testData.get("Vehicle_Model"));
		txt_cylindercapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
		txt_engineperformance.sendKeys(testData.get("Vehicle_Enging Performance"));
		date_dateofmanufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
		cm.selectDropdownValue(dd_numberofseats, testData.get("Vehicle_No of Seats_motorcycle"));
		txt_listprice.sendKeys(testData.get("Vehicle_List Price"));
		txt_annualmileage.sendKeys(testData.get("Vehicle_Annual Mileage"));
	}
	
	public void clickNext() {
		btn_Next.click();
		
		
	}

}
