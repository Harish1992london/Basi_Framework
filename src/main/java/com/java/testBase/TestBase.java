package com.java.testBase;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.java.pageObject.Enter_Insurant_Data;
import com.java.pageObject.Enter_Product_Data;
import com.java.pageObject.Enter_Vehicle_Data;
import com.java.pageObject.homePage;
import com.java.pageObject.selectPriceObject;
import com.java.reusableComponants.PropertiesOperations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends ObjectRepo{

	

	@SuppressWarnings("deprecation")
	public void LaunchBrowser() throws Exception {

		String browser = PropertiesOperations.getpropertievaluebykey("browser");
		String url = PropertiesOperations.getpropertievaluebykey("url");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(url);

	}

	@BeforeMethod
	public void SteupMethod() throws Exception {
		LaunchBrowser();
		homepage = new homePage();
		veh_data = new Enter_Vehicle_Data();
		ins_data = new Enter_Insurant_Data();
		prod_data = new Enter_Product_Data();
		price_selection = new selectPriceObject();

	}

	@AfterMethod
	public void cleanUp() {

//		driver.quit();
	}

}
