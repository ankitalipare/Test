package com.stepDefinations;

import com.config.Config;
import com.pages.CartPage;
import com.testframework.Keyword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddToCartSteps {

	Keyword key = new Keyword();

	/**
	 * This method is deprecated because we are launching browser from hooks
	 */
	@Deprecated
	@Given("browser is open")
	public void openBrowser() {

		key.openBrowser("chrome");
	}
	
	@Deprecated
	@And("app URL launch successfully in browser")
	public void openUrl() {

		Config con = new Config();
		key.openUrl(con.getAppUrl());
	}
	
	@Then("enter text on search box {string}")
	public void enterTextInSearch(String text) {

		CartPage cart =  new CartPage();
		cart.enterTextOnSearchBox(text);
	}
	
	@And("select product")
	public void selectProduct() {

		CartPage cart =  new CartPage();
		cart.SelectProduct();
	}
	
	@And("select size")
	public void selectSize() {

		CartPage cart =  new CartPage();
		cart.moveToNewTab();
		cart.selectSize();
	}
	
	@Then("click on ADD TO BAG button")
	public void clickAddToBagButton() {

		CartPage cart =  new CartPage();
		cart.clickAddToBagButton();
	}
	
	@Then("click on GO TO BAG button")
	public void clickOnGoToBagButton() {

		CartPage cart =  new CartPage();
		cart.clickOnGoToBagButton();
	}
	
	@And("select quantity")
	public void selectQuantity() {

		CartPage cart =  new CartPage();
		cart.clickQuantity();
	}
	
	@Then("click update button")
	public void clickUpdateButtonAndVerifyUpdatedPrice() {

		CartPage cart =  new CartPage();
		cart.clickPlusIconToIncreaseQuantity();
		cart.clickUpdateButton();
	}
	
	
}
