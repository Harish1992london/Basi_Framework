package com.java.reusableComponants;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.java.testBase.ObjectRepo;

public class ExtentReportSetup extends ObjectRepo {

	public static ExtentReports setupExtentReport() {

			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
			Date date = new Date();
			String actualDate = format.format(date);
	
			String source = System.getProperty("user.dir") 
					+ "/Reports/Reports/ExecutionReport_" + actualDate + ".html";
	
			ExtentSparkReporter sparkReport = new ExtentSparkReporter(source);
	
			extent = new ExtentReports();
			extent.attachReporter(sparkReport);
	
			sparkReport.config().setDocumentTitle("DocumentTitle");
			sparkReport.config().setTheme(Theme.DARK);
			sparkReport.config().setReportName("ReportName");
	
			return extent;
		}
		

		/*SimpleDateFormat formate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		String actualDate = formate.format(date);
		String source = System.getProperty("user.dir") 
		+ "//Reports//Executionreports_" + actualDate + ".html";

		ExtentSparkReporter sparkreport = new ExtentSparkReporter(source);
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);

		sparkreport.config().setDocumentTitle("document tittle");
		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setReportName("Reportname");

		return extent;

	}*/


}
