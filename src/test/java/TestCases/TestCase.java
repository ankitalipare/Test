package TestCases;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.listeners.TakeScreenShotFailure;
import com.pages.CartPage;
import com.pages.CouponPage;
import com.pages.HomePage;
import com.pages.ProductPage;
import com.testframework.Locator;
import com.utility.PropUtil;

import dataProvider.ExcelTestData;
import dataProvider.ExcelTestDataInvalidPincode;

@Listeners(TakeScreenShotFailure.class)
public class TestCase extends TestBase {
	

	@Test
	public void verifyUserRegistrationProcess() {

		key.clickSigninButton(Locator.SIGNINBUTTON);
		key.enterContactNumber(Locator.CONTACTNUM);
		key.clickContinueButton(Locator.CONTINUEBUTTON);
		key.selectGender(Locator.SELECTGENDER);
		key.enterName(Locator.REGISTERNAME);
		key.enterEmailId(Locator.REGISTEREMAIL);
		key.enterInviteCode(Locator.REGISTERINVITECODE);
		key.clickTandC(Locator.REGISTERTANDC);
		key.clickSendOTPButton(Locator.SENDOTPBUTTON);
	}

	@Test
	public void verifySigninInvalidContactNumber() {

		String actText = "Your mobile number should be of 10 digits. Please also ensure it does not start with 0 or +91.";
		key.clickSigninButton(Locator.SIGNINBUTTON);
		key.enterInvalidContactNumber(Locator.INVALIDCONTACTNUM);
		key.clickContinueButton(Locator.CONTINUEBUTTON);
		key.getInvalidContactText(Locator.INVALIDCONTTEXT, actText);

	}

	@Test
	public void verifyCorrectProductIsDisplayAfterSearch() {

		String actTitle = "Shoes For Women";
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		String currTitle = key.getPageTitle(Locator.SEARCHEDPAGETITLE);
		Assert.assertEquals(actTitle, currTitle);

	}

	@Test
	public void verifyAddToBagButton() {

		String actText = "Item(s) added to your bag";
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		key.SelectProduct(Locator.SELECTEDWOMENDPRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickAddToBagButton(Locator.ADDTOBAGBUTTON);
	
	}

	@Test
	public void verifyProductIsSuccessfullyAddedToCart() {

		String actName = "NIKE -Women Downshifter 13 Lace-Up Running Shoes";
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		key.SelectProduct(Locator.SELECTEDWOMENDPRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickAddToBagButton(Locator.ADDTOBAGBUTTON);
		key.clickOnGoToBagButton(Locator.GOTOBAG);
		String currTitle = key.verifySelectedProductName(Locator.CARTPRODUCTNAME);
		Assert.assertEquals(actName, currTitle);
	}

	@Test
	public void verifyWithoutSignupSaveToWistlistFuctionalityDisplayLoginForm() {

		String actText = "Join / Sign In using";
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		key.SelectProduct(Locator.SELECTEDWOMENDPRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickSaveToWishlistButton(Locator.WISHLIST);
		String text = key.displayLoginForm(Locator.LOGINTEXT);
		Assert.assertEquals(actText, text);
	}

	@Test
	public void verifyCartPageDisplaysAsEmptyBeforeUserLogsIn() {

		String actMsg = "Your Shopping Bag is Empty!!";
		key.clickWishlistIcon(Locator.CARTICON);
		String msg = key.getCartMessage(Locator.EMPTYCARTTITLE);
		Assert.assertEquals(actMsg, msg);
	}

	@Test
	public void VerifyAddingMultipleProductsToCartTotalAmountDisplayedCorrectly() {
		
		String actPrice = "₹4,987";
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		key.SelectProduct(Locator.SELECTEDWOMENDPRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickAddToBagButton(Locator.ADDTOBAGBUTTON);
		//key.backToPreviousPage();
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"heels for women");
		key.selectAnotherProduct(Locator.SEC_PRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickAddToBagButton(Locator.ADDTOBAGBUTTON);
		key.clickOnGoToBagButton(Locator.GOTOBAG);
		key.getProductPrice(Locator.PRODUCTPRICE);
		String currPrice = key.verifyTotalPrice(Locator.TOTALPRICE);
		Assert.assertEquals(actPrice, currPrice);

	}

	@Test
	public void VerifySelectedOptionFromDropdownDisplaySame() {

		String actT = "Unisex Polarized and UV Protected Wayfarer Sunglasses -VC S13820";
		key.goToWomensTab(Locator.WOMENSTAB);
		key.selectOptionFromDropdown(Locator.SELECTPRODUCT);
		key.getCurrpageTitle(Locator.TITLE, actT);

	}

	@Test
	public void verifyTotalPriceReflectingCorrectlyIfUserIncreaseQuantityOnCart() {

		String price = "₹7,474";
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		key.SelectProduct(Locator.SELECTEDWOMENDPRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickAddToBagButton(Locator.ADDTOBAGBUTTON);
		key.clickOnGoToBagButton(Locator.GOTOBAG);
		key.clickQuantity(Locator.QUANTITYBUTTON);
		key.clickPlusIconToIncreaseQuantity(Locator.PLUSICON);
		key.clickUpdateButton(Locator.UPDATEBUTTON);
		String currPrice = key.verifyTotalPrice(Locator.TOTALPRICE);
		Assert.assertEquals(price, currPrice);
	}

	@Test
	public void verifyTotalPriceReflectingCorrectlyIfUserRemoveProductOnCart() {

		String price = "₹3,737";
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		key.SelectProduct(Locator.SELECTEDWOMENDPRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickAddToBagButton(Locator.ADDTOBAGBUTTON);
		key.clickOnGoToBagButton(Locator.GOTOBAG);
		key.clickDeleteProduct(Locator.REMOVEPRODUCT);
		key.confirmDelete(Locator.REMOVEPRODUCT);
		String currPrice = key.verifyTotalPrice(Locator.TOTALPRICE);
		Assert.assertEquals(price, currPrice);

	}
	
	@Test
	public void verifyDeliveryDateDisplayForValidPincode() {
			
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		key.SelectProduct(Locator.SELECTEDWOMENDPRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickOnPincode(Locator.PINCODE);
		key.enterPincodeOnTextBox(Locator.PINCODETEXTBOX,Locator.CONFIRMPINCODEBUTTON);
		key.getDeliverydate(Locator.DELIVERDATETEXT);
		

	}
	
	@Test(dataProvider = "pincodes_data",dataProviderClass = ExcelTestData.class)
	public void verifyDeliveryDateDisplayForValidPincodeUsingDataProvider(String pincode) {
			
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		key.SelectProduct(Locator.SELECTEDWOMENDPRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickOnPincode(Locator.PINCODE);
		key.enterPincodeOnTextBoxUsingDDT(Locator.PINCODETEXTBOX,Locator.CONFIRMPINCODEBUTTON,pincode);
		key.getDeliverydate(Locator.DELIVERDATETEXT);
		
	}
	
	@Test(dataProvider = "pincodes_data_invalid",dataProviderClass = ExcelTestDataInvalidPincode.class)
	public void verifyErrorMessageDisplayForInvalidPincodeUsingDataProvider(String pincode) {
		
		key.enterTextOnSearchBox(Locator.SEARCHBOX,"Shoes for women");
		key.SelectProduct(Locator.SELECTEDWOMENDPRODUCT);
		key.moveToNewTab();
		key.selectSize(Locator.SIZE);
		key.clickOnPincode(Locator.PINCODE);
		key.enterPincodeOnTextBoxUsingDDT(Locator.PINCODETEXTBOX,Locator.CONFIRMPINCODEBUTTON,pincode);
		key.getDeliverydate(Locator.DELIVERDATETEXT);

	}

	@Test
	public void verifySigninInvalidContactNumberUsingPropertiesFile() {

		String actText = "Your mobile number should be of 10 digits. Please also ensure it does not start with 0 or +91.";
		String dir = System.getProperty("user.dir");
		String filePath = dir + "/src/test/resources/Locators.properties";
		PropUtil prop = new PropUtil(filePath);
		key.clickSigninButton(prop.getValue("SIGNINBUTTON"));
		key.enterInvalidContactNumber(prop.getValue("INVALIDCONTACTNUM"));
		key.clickContinueButton(prop.getValue("CONTINUEBUTTON"));
		key.getInvalidContactText(prop.getValue("INVALIDCONTTEXT"), actText);

	}

	@Test
	public void verifySigninInvalidContactNumberUsingPOM() {

		HomePage home = new HomePage();
		String actText = "Your mobile number should be of 10 digits. Please also ensure it does not start with 0 or +91.";
		home.clickOnSigninButton();
		home.enterInvalidContactNumber();
		home.clickOnContinueButton();
		
		String text = home.getInvalidContactText();
		System.out.println(text);
		Assert.assertEquals(actText, text);
	}
	
	@Test
	public void verifyAddToCartProductPOM() {

		ProductPage product = new ProductPage();
		product.enterTextOnSearchBox("shoe for women");
		product.SelectProduct();
		product.moveToNewTab();
		product.selectSize();
		product.clickAddToBagButton();
		
	}
	
	@Test
	public void verifyTotalPriceReflectingCorrectlyIfUserIncreaseQuantityOnCartUsingPOM() {

		String price = "₹7,474";
		CartPage cart = new CartPage();
		cart.enterTextOnSearchBox("shoe for women");
		cart.SelectProduct();
		cart.moveToNewTab();
		cart.selectSize();
		cart.clickAddToBagButton();
		cart.clickOnGoToBagButton();
		cart.clickQuantity();
		cart.clickPlusIconToIncreaseQuantity();
		cart.clickUpdateButton();
		String currPrice = cart.verifyTotalPrice();
		Assert.assertEquals(price, currPrice);
	}
	
	@Test
	public void verifyErrorMessageWhenUserEnterInvalidCouponCode() {

		CouponPage coupon = new CouponPage();
		String actText = "Invalid coupon";
		coupon.enterTextOnSearchBox("shoe for women");
		coupon.SelectProduct();
		coupon.moveToNewTab();
		coupon.selectSize();
		coupon.clickAddToBagButton();
		coupon.clickOnGoToBagButton();
		coupon.enterCouponCode();
		coupon.clickOnApplyButton();
		String text = coupon.getErrorMsg();
		Assert.assertEquals(actText, text);
	}
	
}
