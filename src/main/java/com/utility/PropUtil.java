package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * This class used to read properties file
 * 
 * @author
 */
public class PropUtil {

	private String filePath;

	public PropUtil(String locatorFile) {

		filePath = locatorFile;
	}

	public PropUtil() {

	}

	public String getValue(String filePath, String key) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
		}

		Properties prop = new Properties();
		try {
				prop.load(fis);
				
			} catch (IOException e) {

			}
		

		String value = prop.getProperty(key);
		return value;
	}
	
	public String getValue(String key) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			
		}
		return prop.getProperty(key);
	}
	
	
	
}
