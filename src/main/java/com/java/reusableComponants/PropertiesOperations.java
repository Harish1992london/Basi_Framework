package com.java.reusableComponants;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {
	
	static Properties prop = new Properties();
	
	public static String getpropertievaluebykey(String key) throws Exception {
//		Load Data from properties
		String proFilePath = System.getProperty("user.dir")+("\\src\\test\\resources\\config.properties");
		FileInputStream fis = new FileInputStream(proFilePath);
		prop.load(fis);
		
//		read data
		String value = prop.get(key).toString();
		
		if (StringUtils.isEmpty(value)) {
			throw new Exception("No Value found");
			
		}
		
		return value;
		
	}

}
