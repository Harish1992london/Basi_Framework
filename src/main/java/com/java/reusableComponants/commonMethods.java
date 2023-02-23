package com.java.reusableComponants;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class commonMethods {

//	common method for values validation in drop-down
	public List<String> getDropdownOptions(WebElement webelement) {
		Select os = new Select(webelement);

		List<WebElement> ddOptions = os.getOptions();
		List<String> actualcontet = new ArrayList<String>();

		for (WebElement ref : ddOptions) {
			actualcontet.add(ref.getText());

		}

		return actualcontet;
	}

//	Common Drop-down selection by visible text
	public void selectDropdownValue(WebElement element, String valueToBeSelected) throws Exception {
		Select se = new Select(element);
		try {
			se.selectByVisibleText(valueToBeSelected);

		} catch (Exception e) {
			throw new Exception("Value is not present in dropdown for webelemtn: " + element + "Value to be selected"
					+ valueToBeSelected);

		}

	}

	public void radioButtonSelection(List<WebElement> element, String ValueToBeSelected) {
		for (WebElement ref : element) {
			if (ref.getText().equalsIgnoreCase(ValueToBeSelected)) {
				ref.click();
				break;
			}
		}
	}

	public void checkBoxSelection(List<WebElement> element, String check) {
		String[] checksArray = check.split(",");

		for (String str : checksArray) {

			for (WebElement ele : element) {

				if (ele.getText().equalsIgnoreCase(str)) {
					ele.click();
					break;
				}

			}
		}
	}
}
