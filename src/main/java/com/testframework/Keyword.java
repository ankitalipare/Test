package com.testframework;

import com.exception.InvalidBrowserNameError;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Keyword {

	public static RemoteWebDriver driver;
	public static FluentWait<RemoteWebDriver> wait;

	private static final Logger LOG = LogManager.getLogger(Keyword.class);

	public void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
			LOG.info("Launching chrome");
		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else {

			LOG.error("Invalid browser name");
			throw new InvalidBrowserNameError(browserName);
		}

		wait = new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(250));
		wait.ignoring(NoSuchElementException.class);
	}

	public void openUrl(String url) {

		driver.get(url);
		driver.manage().window().maximize();

	}

	public void closeBrowser() {

		driver.close();
	}

	public void quitBrowser() {

		driver.quit();
	}

	public void clickSigninButton(String signinbutton) {

		driver.findElement(By.cssSelector(signinbutton)).click();

	}

	public void enterContactNumber(String contactnum) {

		driver.findElement(By.cssSelector(contactnum)).sendKeys("9975277874");

	}

	public void clickContinueButton(String continuebutton) {

		driver.findElement(By.cssSelector(continuebutton)).click();

	}

	public void selectGender(String selectgender) {

		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("gender1")));
		// driver.findElement(By.cssSelector(selectgender)).click();
		WebElement female = driver.findElement(By.cssSelector(selectgender));
		female.click();

	}

	public void enterName(String registername) {

		driver.findElement(By.cssSelector(registername)).sendKeys("Ankita");

	}

	public void enterEmailId(String registeremail) {

		driver.findElement(By.cssSelector(registeremail)).sendKeys("ankita@gmail.com");

	}

	public void enterInviteCode(String registerinvitecode) {

		driver.findElement(By.cssSelector(registerinvitecode)).sendKeys("ankita@gmail.com");

	}

	public void clickTandC(String registertandc) {

		driver.findElement(By.cssSelector(registertandc)).click();

	}

	public void clickSendOTPButton(String sendotpbutton) {

		driver.findElement(By.cssSelector(sendotpbutton)).click();

	}

	public void enterInvalidContactNumber(String contactnum) {

		driver.findElement(By.cssSelector(contactnum)).sendKeys("25697");

	}

	public void clickContinueButtonForInvalidNum(String continuebutton) {

		driver.findElement(By.cssSelector(continuebutton)).click();

	}

	public void getInvalidContactText(String invalidconttext, String actText) {

		String currText = driver.findElement(By.cssSelector(invalidconttext)).getText();
		if (actText.contains(currText)) {

			LOG.info("Results Matched;Test Case Passed");
		} else {

			LOG.info("Results NotMatched;Test Case Failed");
		}

	}

	public void enterTextOnSearchBox(String searchbox,String text) {

		driver.findElement(By.cssSelector(searchbox)).sendKeys(text, Keys.ENTER);

	}

	public String getPageTitle(String searchedpagetitle) {

		 String expTitle = driver.findElement(By.cssSelector(searchedpagetitle)).getText();
		 return expTitle;
		
	}

	public void SelectProduct(String selectedwomendproduct) {

		driver.findElement(By.cssSelector(selectedwomendproduct)).click();
		

	}

	public void getWomenShoePageTitle(String productTitle, String actTitle) {

		String pWind = driver.getWindowHandle();
		Set<String> allWind = driver.getWindowHandles();
		allWind.remove(pWind);
		for (String handle : allWind) {

			driver.switchTo().window(handle);

		}
		String currTitle = driver.findElement(By.cssSelector(productTitle)).getText();
		if (actTitle.contains(currTitle)) {
			LOG.info("Results Matched;Test Case Passed");
		} else {
			LOG.info("Results NotMatched;Test Case Failed");
		}
	}

	public void selectSize(String size) {

		driver.findElement(By.cssSelector(size)).click();
		

	}

	public void clickAddToBagButton(String addtobagbutton) {

		driver.findElement(By.cssSelector(addtobagbutton)).click();
		

	}

	public void clickCartButton(String cartbutton) {

		driver.findElement(By.cssSelector(cartbutton)).click();

	}

	public String verifySelectedProductName(String cartproductname) {

		String currName = driver.findElement(By.cssSelector(cartproductname)).getText();
		return currName;
	}

	public void clickSaveToWishlistButton(String wishlist) {

		driver.findElement(By.cssSelector(wishlist)).click();

	}

	public void clickWishlistIcon(String wishlisticon) {

		driver.findElement(By.cssSelector(wishlisticon)).click();

	}

	public String getCartMessage(String emptycarttitle) {

		String currMsg = driver.findElement(By.cssSelector(emptycarttitle)).getText();
		return currMsg;
	}

	public void goToWomensTab(String womenstab) {

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector(womenstab))).perform();

	}

	public void selectOptionFromDropdown(String product) {

		
			driver.findElement(By.cssSelector(product)).click();
		

	}

	public void backToPreviousPage() {

		String parentWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) {

			driver.switchTo().window(windowHandle);

		}
		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void moveToNewTab() {

		String pWind = driver.getWindowHandle();
		Set<String> allWind = driver.getWindowHandles();
		for (String handle : allWind) {

			driver.switchTo().window(handle);

		}
	}

	public void getCurrpageTitle(String title, String actT) {

		String currT = driver.findElement(By.cssSelector(title)).getText();
		if (actT.contains(currT)) {
			LOG.info("Results Matched;Test Case Passed");
		} else {
			LOG.info("Results NotMatched;Test Case Failed");
		}
	}

	public void selectAnotherProduct(String secProduct) {

		driver.findElement(By.cssSelector(secProduct)).click();

	}

	public void clickOnGoToBagButton(String gotobag) {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(gotobag)));
		driver.findElement(By.cssSelector(gotobag)).click();
	}

	public void clickQuantity(String quantity) {

		driver.findElement(By.cssSelector(quantity)).click();

	}

	public void clickUpdateButton(String updatebutton) {

		driver.findElement(By.cssSelector(updatebutton)).click();

	}

	public String getPrice(String getproductprice) {

		String price = driver.findElement(By.cssSelector(getproductprice)).getText();
		return price;
	}

	public void clickPlusIconToIncreaseQuantity(String plusicon) {

		driver.findElement(By.cssSelector(plusicon)).click();
	}

	public void SelectAnotherProduct(String product) {

		driver.findElement(By.cssSelector(product)).click();

	}

	public void clickDeleteProduct(String removeproduct) {

		driver.findElement(By.cssSelector(removeproduct)).click();

	}

	public void confirmDelete(String removeproduct) {

		driver.findElement(By.cssSelector(removeproduct)).click();

	}

	public void delete() {

		List<WebElement> l = (List<WebElement>) driver.findElements(By.cssSelector("delete-btn"));

		for (WebElement iterable_element : l) {

			String n = iterable_element.getText();
			System.out.println(n);
		}
	}

	public void clickOnPincode(String pin) {

		driver.findElement(By.cssSelector(pin)).click();
	}

	public void enterPincodeOnTextBox(String pincodetextbox, String confirmbutton) {

		driver.findElement(By.cssSelector(pincodetextbox)).sendKeys("411033");
		driver.findElement(By.cssSelector(confirmbutton)).click();

	}
	public void enterPincodeOnTextBoxUsingDDT(String pincodetextbox, String confirmbutton,String pincode) {

		driver.findElement(By.cssSelector(pincodetextbox)).sendKeys(pincode);
		driver.findElement(By.cssSelector(confirmbutton)).click();

	}

	public void getDeliverydate(String deliverytxt) {

		/* List<WebElement> ele = driver.findElements(By.cssSelector(deliveryCol)); 
		 for (WebElement element : ele) {
			 
			 LOG.info(element.getText());
		}*/
		 
		String text = driver.findElement(By.cssSelector(deliverytxt)).getText();
		LOG.info(text);

	}

	public String displayLoginForm(String logintext) {

		String text = driver.findElement(By.xpath(logintext)).getText();
		return text;
	}

	public void getProductPrice(String productprice) {

		List<WebElement> elements = driver.findElements(By.cssSelector(productprice));
		for (WebElement element : elements) {

			LOG.info(element.getText());
		}
		
	}

	public String verifyTotalPrice(String totalprice) {

		String price = driver.findElement(By.cssSelector(totalprice)).getText();
		LOG.info(price);
		return price;
	}

	
}
