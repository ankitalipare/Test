package com.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.config.Config;
import com.testframework.Keyword;

public class TestBase {

	public final static Keyword key = new Keyword();

	@BeforeMethod
	public void setup() {

		Config config = new Config();
		key.openBrowser(config.getbrowserName());
		key.openUrl(config.getAppUrl());
	}

	@AfterMethod
	public void tearDown() throws Exception {

		key.quitBrowser();
	}
}
