package com.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.base.TestBase;
import com.testframework.Keyword;

public class CouponPage extends TestBase{

	@FindBy(css = "input[placeholder*='Search AJIO']")
	public WebElement searchBox;

	@FindBy(css = "div[aria-label*='Women Downshifter 13 Lace-Up Running Shoes']")
	public WebElement womenProduct;

	@FindBy(css = "div[class='slick-slide slick-active size-swatch'][data-index='3']")
	public WebElement selectSize;

	@FindBy(css = "span[aria-label=\"ADD TO BAG\"]")
	public WebElement addTOBagButton;
	
	@FindBy(css  = "span[aria-label='GO TO BAG']")
	public WebElement goToBag;
	
	@FindBy(css = "input[id='couponCodeInput']")
	public WebElement couponfield;
	
	@FindBy(css = "button[aria-label='Apply']")
	public WebElement coupnApplyButton;
	
	@FindBy(css = "span[class='voucher-error error-message info']")
	public WebElement coupnErrorMsg;
	
	
	public CouponPage() {

		PageFactory.initElements(Keyword.driver, this);

	}
	
	
	public void enterTextOnSearchBox(String string) {

		searchBox.sendKeys(string,Keys.ENTER);		
	}


	public void SelectProduct() {

		womenProduct.click();		
	}


	public void moveToNewTab() {

		String pWind = Keyword.driver.getWindowHandle();
		Set<String> allWind = Keyword.driver.getWindowHandles();
		for (String handle : allWind) {

			Keyword.driver.switchTo().window(handle);

		}		
	}


	public void selectSize() {

		selectSize.click();		
	}


	public void clickAddToBagButton() {

		addTOBagButton.click();		
	}


	public void clickOnGoToBagButton() {

		Keyword.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label='GO TO BAG']")));
		goToBag.click();
	}


	public void enterCouponCode() {

		couponfield.sendKeys("wel");		
	}
	
	public void enterCouponCodeDDT(String codes) {

		couponfield.sendKeys(codes);		
	}


	public void clickOnApplyButton() {

		coupnApplyButton.click();		
	}


	public String getErrorMsg() {

		Keyword.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='voucher-error error-message info']")));
		String text = coupnErrorMsg.getText();	
		return text;
	}

}
