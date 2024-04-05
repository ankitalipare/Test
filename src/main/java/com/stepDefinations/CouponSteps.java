package com.stepDefinations;

import com.pages.CouponPage;
import com.testframework.Keyword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CouponSteps {

	Keyword key = new Keyword();

	@Then("enter text search box {string}")
	public void enterTextOnSearchField(String text) {

		CouponPage coupon = new CouponPage();
		coupon.enterTextOnSearchBox(text);
	}
	
	@And ("select a product")
	public void selectProduct() {

		CouponPage coupon = new CouponPage();
		coupon.SelectProduct();
	}
	
	@And ("select a size")
	public void selectSize() {

		CouponPage coupon = new CouponPage();
		coupon.moveToNewTab();
		coupon.selectSize();
	}
	
	@Then ("click on ADD TO BAG")
	public void clickAddToBag() {

		CouponPage coupon = new CouponPage();
		coupon.clickAddToBagButton();
	}
	
	@Then ("click on GO TO BAG")
	public void clickGoToBag() {

		CouponPage coupon = new CouponPage();
		coupon.clickOnGoToBagButton();

	}
	
	@Then ("enter coupon code")
	public void enterCouponCode() {

		CouponPage coupon = new CouponPage();
		coupon.enterCouponCode();

	}
	
	@Then ("enter coupon code {string}")
	public void enterCouponCode(String codes) {

		CouponPage coupon = new CouponPage();
		coupon.enterCouponCodeDDT(codes);

	}
	
	@And ("click on apply button")
	public void clickApplyButton() {

		CouponPage coupon = new CouponPage();
		coupon.clickOnApplyButton();

	}
	
	@Then ("verify error msg")
	public void verifyErrorMsg() {

		CouponPage coupon = new CouponPage();
		coupon.getErrorMsg();
	}






}
