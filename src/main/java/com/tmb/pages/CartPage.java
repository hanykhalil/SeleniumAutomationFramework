package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public class CartPage extends BasePage{
	
	private final By quantityTxtbx = By.xpath("//input[@title='Qty']");
	private final By proccedToCheckOutBtn = By.xpath("//a[contains(text(),'Proceed to checkout')]");
	
	public CartPage enterQuantity(String quantity) {
		doSendKeys(quantityTxtbx, quantity);
		return this;
		
	}
	public CartPage clickOnProceedToCheckOutBtn() {
		doClick(proccedToCheckOutBtn, "Presence");
		return this;
		
	}

}
