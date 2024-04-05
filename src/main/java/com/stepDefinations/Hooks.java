package com.stepDefinations;

import com.config.Config;
import com.testframework.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	Keyword key = new Keyword();
	
	@Before
	public void launchBrowserAndAppUrl() {

		Config con =  new Config();
		key.openBrowser(con.getbrowserName());
		key.openUrl(con.getAppUrl());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		key.quitBrowser();
	}
}
