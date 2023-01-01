package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class CheckoutPage extends BasePage{

	private final By firstName = By.xpath("//input[@id='billing_first_name']");
	private final By lastName = By.xpath("//input[@id='billing_last_name']");
	private final By billingAddress1 = By.xpath("//input[@id='billing_address_1']");
	private final By billingCity = By.xpath("//input[@id='billing_city']");
	private final By billingPostCode = By.xpath("//input[@id='billing_postcode']");
	private final By billingEmail = By.xpath("//input[@id='billing_email']");
	private final By placeOrderBtn = By.xpath("//button[text()='Place order']");

	
	public CheckoutPage enterFirstname(String firstname) {
		doSendKeys(firstName, firstname,WaitStrategy.VISIBILITY);
		return this;
	}
	public CheckoutPage enterLastName(String lastname) {
		doSendKeys(lastName, lastname,WaitStrategy.VISIBILITY);
		
		return this;
	}
	public CheckoutPage enterBillingAddress(String billingaddress) {
		doSendKeys(billingAddress1, billingaddress,WaitStrategy.VISIBILITY);
		return this;
	}
	public CheckoutPage enterBillingCity(String billingcity) {
		doSendKeys(billingCity, billingcity,WaitStrategy.VISIBILITY);
		return this;
	}
	public CheckoutPage enterBillingPostalCode(String postalCode) {
		doSendKeys(billingPostCode, postalCode,WaitStrategy.VISIBILITY);
		return this;
	}
	
	public CheckoutPage enterBillingEmail(String emailId) {
		doSendKeys(billingEmail, emailId,WaitStrategy.VISIBILITY);
		
		return this;
	}
	
	public void clickPlaceOrderBtn() {
		doClick(placeOrderBtn, WaitStrategy.CLICKABLE);
	}
}
