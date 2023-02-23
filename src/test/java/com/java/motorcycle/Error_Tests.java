package com.java.motorcycle;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.java.testBase.TestBase;

public class Error_Tests extends TestBase {

	@Test(enabled = false)
	public void error_Message_Cylinder_Capacity() {

		homepage.clickOnMOtorcycle();
		veh_data.enterCylinderCapacity("33333");
		test.log(Status.PASS, "Cylender Capacity filled with 33333");
		String actualErrorMessage = veh_data.getErrorMessageOnCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 2000";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"The error message is not matching with the expected results");

	}

	@Test(enabled = false)
	public void error_Message_Cylinder_Capacity2() {

		homepage.clickOnMOtorcycle();
		veh_data.enterCylinderCapacity("33333");
		test.log(Status.PASS, "Cylender Capacity filled with 33333");
		String actualErrorMessage = veh_data.getErrorMessageOnCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 1000";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"The error message is not matching with the expected results");

	}

	@Test(enabled = true)

	private void DDOptionsVerification() {

		homepage.clickOnMOtorcycle();

		List<String> actualValue = veh_data.getDropdownOption_model();
		test.log(Status.INFO, "Actual content for model dropdown: " + actualValue);

		List<String> expectedValues = Arrays.asList("– please select –", "Scooter", "Three-Wheeler", "Moped",
				"Motorcycle");
		test.log(Status.INFO, "Expected content for model dropdown: " + expectedValues);
		Assert.assertEquals(actualValue, expectedValues, "Error in dropdown vaues");

	}

}
