package com.java.reusableComponants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.java.testBase.ObjectRepo;

public class ListinerImplimentation extends ObjectRepo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case: " + result.getMethod().getMethodName() + " is Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case: "+result.getMethod().getMethodName()+ " is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String screenShotPatch = System.getProperty("user.dir") 
				+ "/Reports/Screenshots/cylender_Failure" + actualDate + ".jpeg";
		
		File des = new File(screenShotPatch);
		
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShotPatch, "Test case Failure screenshot");
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

		extent = ExtentReportSetup.setupExtentReport();

	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

	}

}
