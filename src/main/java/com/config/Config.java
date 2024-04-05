package com.config;

import com.utility.PropUtil;

public class Config {

	public String getbrowserName() {

		String baseDir = System.getProperty("user.dir");
		PropUtil prop = new PropUtil(baseDir+"/src/main/resources/Config.properties");
		String browserName = null;
		browserName = prop.getValue("browser_name");
		return browserName;
	}
	public String getAppUrl() {

		String baseDir = System.getProperty("user.dir");
		PropUtil prop = new PropUtil(baseDir+"/src/main/resources/Config.properties");
		String appUrl = null;
		appUrl = prop.getValue("app_url");
		return appUrl;
	}
}
