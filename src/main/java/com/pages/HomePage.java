package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testframework.Keyword;

public class HomePage {

	@FindBy(css = "span[aria-label='Sign In / Join Ajio']")
	public WebElement signinButton;
	
	@FindBy(css = "input[name=\"username\"]")
	public WebElement invalidContact;
	
	@FindBy(css = "input[value=\"Continue\"]")
	public WebElement continueButton;
	
	@FindBy(css = "div[id='error-msg']")
	public WebElement invalidContText;
	
	
	@FindBy(css = "div[class='btn-cart']")
	public WebElement cartButton;
	
	@FindBy(css = "span[aria-label=SAVETOWISHLIST]")
	public WebElement wishlistButton;
	
	@FindBy(css = "span[aria-label='WOMEN']")
	public WebElement womensTab;
	
	public HomePage() {

		PageFactory.initElements(Keyword.driver,this);
		
	}
	public void clickOnSigninButton() {

		signinButton.click();
	}
	public void enterInvalidContactNumber() {

		invalidContact.sendKeys("14587");
	}
	public void clickOnContinueButton() {

		continueButton.click();
	}
	public String getInvalidContactText() {

		String text = invalidContText.getText();
		return text;
	}
	
}
