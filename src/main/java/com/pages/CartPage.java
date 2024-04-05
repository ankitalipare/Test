package com.pages;

import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.base.TestBase;
import com.testframework.Keyword;

public class CartPage extends TestBase {

	private static final Logger LOG = LogManager.getLogger(Keyword.class);

	@FindBy(css = "input[placeholder*='Search AJIO']")
	public WebElement searchBox;

	@FindBy(css = "div[aria-label*='Women Downshifter 13 Lace-Up Running Shoes']")
	public WebElement womenProduct;

	@FindBy(css = "div[class='slick-slide slick-active size-swatch'][data-index='3']")
	public WebElement selectSize;

	@FindBy(css = "span[aria-label=\"ADD TO BAG\"]")
	public WebElement addTOBagButton;

	@FindBy(css = "span[aria-label=Qty]")
	public WebElement quantityButton;

	@FindBy(css = "button[class='increment button']")
	public WebElement plusIcon;

	@FindBy(css = "button[id='updateQuantity']")
	public WebElement updateButton;

	@FindBy(css  = "span[aria-label='GO TO BAG']")
	public WebElement goToBag;

	@FindBy(css = "span[class='price-value bold-font']")
	public WebElement totalPrice;

	public CartPage() {

		PageFactory.initElements(Keyword.driver, this);

	}

	public void enterTextOnSearchBox(String string) {

		searchBox.sendKeys(string, Keys.ENTER);
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

	public void clickQuantity() {

		quantityButton.click();
	}

	public void clickPlusIconToIncreaseQuantity() {

		plusIcon.click();
	}

	public void clickUpdateButton() {

		updateButton.click();
	}

	public String verifyTotalPrice() {

		String price = totalPrice.getText();
		LOG.info(price);
		return price;
	}


}
