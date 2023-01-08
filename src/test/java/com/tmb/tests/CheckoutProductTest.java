package com.tmb.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.AccountPage;
import com.tmb.pages.CartPage;
import com.tmb.pages.CheckoutPage;
import com.tmb.pages.LoginPage;
import com.tmb.pages.StorePage;
import com.tmb.util.DataProviderUtils;

public final class CheckoutProductTest extends BaseTest{
	@FrameworkAnnotation(author = { "Abhishek" }, category = { CategoryType.SMOKE})
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void checkOutasRegUser(Map<String,String> data)  {
		LoginPage loginPage = new LoginPage();
		AccountPage accountPage = new AccountPage();
		StorePage storePage = new StorePage();
		CheckoutPage checkoutPage = new CheckoutPage();
		CartPage cartPage = new CartPage();
		loginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginBtn();
		accountPage.clickOnGlobalMenu(data.get("menuText"));
		storePage.enterTextToSearchFld(data.get("productSearch")).clickOnSearchBtn().clickOnAddToCartBtn().clickOnViewCart();
		cartPage.enterQuantity(data.get("quantity"));
		cartPage.clickOnProceedToCheckOutBtn();
		checkoutPage.enterFirstname(data.get("firstName")).enterLastName(data.get("lastName")).enterBillingAddress(data.get("billingAddress")).enterBillingCity(data.get("billingCity"))
		.enterBillingPostalCode(data.get("billingPostCode")).enterBillingEmail(data.get("billingEmail")).clickPlaceOrderBtn();
	}

}
