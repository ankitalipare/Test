package com.stepDefinations;

import org.testng.Assert;

import com.config.Config;
import com.pages.HomePage;
import com.testframework.Keyword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {

	Keyword key = new Keyword();

	@Deprecated
	@Given("open browser")
	public void openBrowser() {

		key.openBrowser("chrome");
	}
	
	@Deprecated
	@And("app URL launch successfully")
	public void openUrl() {

		Config con = new Config();
		key.openUrl(con.getAppUrl());
	}
	
	@Then("click on singin button")
	public void clickOnSinginButton() {

		HomePage home = new HomePage();
		home.clickOnSigninButton();
		
	}
	
	@When("user enter invalid number")
	public void enterInvalidContNumber() {

		HomePage home = new HomePage();
		home.enterInvalidContactNumber();
		home.clickOnContinueButton();
	}
	
	@Then("user should get error message")
	public void getText() {

		String actText = "Your mobile number should be of 10 digits. Please also ensure it does not start with 0 or +91.";
		HomePage home = new HomePage();
		String text = home.getInvalidContactText();
		Assert.assertEquals(actText, text);

	}



}
