package com.tmb.tests;

import org.testng.annotations.Test;

import com.tmb.pages.AccountPage;
import com.tmb.pages.CartPage;
import com.tmb.pages.CheckoutPage;
import com.tmb.pages.LoginPage;
import com.tmb.pages.StorePage;

public final class CheckoutProductTest extends BaseTest{
	
	@Test
	public void checkOutasRegUser()  {
		LoginPage loginPage = new LoginPage();
		AccountPage accountPage = new AccountPage();
		StorePage storePage = new StorePage();
		CheckoutPage checkoutPage = new CheckoutPage();
		CartPage cartPage = new CartPage();
		loginPage.enterUserName("singhabhi04").enterPassword("Test@123").clickLoginBtn();
		accountPage.clickOnStoreMenu();
		storePage.enterTextToSearchFld("Blue").clickOnSearchBtn().clickOnAddToCartBtn().clickOnViewCart();
		cartPage.enterQuantity("1");
		cartPage.clickOnProceedToCheckOutBtn();
		checkoutPage.enterFirstname("Demo Name").enterLastName("Demo Last Name").enterBillingAddress("ABC Address").enterBillingCity("Demo City")
		.enterBillingPostalCode("765507").enterBillingEmail("test@test.com").clickPlaceOrderBtn();
	}

}
