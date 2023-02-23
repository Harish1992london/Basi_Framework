package com.java.testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.java.pageObject.Enter_Insurant_Data;
import com.java.pageObject.Enter_Product_Data;
import com.java.pageObject.Enter_Vehicle_Data;
import com.java.pageObject.homePage;
import com.java.pageObject.selectPriceObject;
import com.java.reusableComponants.commonMethods;



public class ObjectRepo {

	public static homePage homepage;
	public static Enter_Vehicle_Data veh_data;
	public static Enter_Insurant_Data ins_data;
	public static Enter_Product_Data prod_data;
	public static selectPriceObject price_selection;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	

	public commonMethods cm = new commonMethods();
	

}
