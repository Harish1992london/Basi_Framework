package com.java.motorcycle;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.java.reusableComponants.ExcelOperations;
import com.java.testBase.TestBase;

public class E2E_Test_Case extends TestBase {

	ExcelOperations excel = new ExcelOperations("InsurancePremium");

	@Test(dataProvider = "vehData")
	public void insurance_Calculate(Object obj1) throws Exception {

		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		test.log(Status.INFO, "Test data used for execution is: " + testData);
		homepage.clickOnMOtorcycle();
		veh_data.enterVehicleData(testData);
		veh_data.clickNext();
		ins_data.enterInsurantData(testData);
		ins_data.clcikNext();
		prod_data.enterProductData(testData);
		prod_data.clickNext();

		/*
		 * Assert.assertEquals(price_selection.getPriceForSelectedOption("Silver"),
		 * testData.get("PriceValidation_Silver"),
		 * "Pricing for silver plan is not matching.");
		 * Assert.assertEquals(price_selection.getPriceForSelectedOption("Gold"),
		 * testData.get("PriceValidation_Gold"),
		 * "Pricing for gold plan is not matching.");
		 * Assert.assertEquals(price_selection.getPriceForSelectedOption("Platinum"),
		 * testData.get("PriceValidation_Platinum"),
		 * "Pricing for platimum plan is not matching.");
		 * Assert.assertEquals(price_selection.getPriceForSelectedOption("Ultimate"),
		 * testData.get("PriceValidation_Ultimate"),
		 * "Pricing for ultimate plan is not matching.");
		 */

		price_selection.selectPriceOption(testData.get("SelectOption"));
		price_selection.clickNext();

	}

	// Dataprovider method --> return object array
	@DataProvider(name = "vehData")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;

	}
}
