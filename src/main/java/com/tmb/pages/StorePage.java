package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class StorePage extends BasePage {

	private final By searchFld = By.xpath("//input[@placeholder='Search products…']");
	private final By searchBtn = By.xpath("//button[text()='Search']");
	private final By addToCartBtn = By.xpath("//h2[text()='Blue Shoes']/../../a[text()='Add to cart']");
	private final By viewCartBtn = By.xpath("//h2[text()='Blue Shoes']/../../a[text()='View cart']");

	public StorePage enterTextToSearchFld(String seachText) {
		doSendKeys(searchFld, seachText, WaitStrategy.PRESENCE, "Product Search field");

		return new StorePage();
	}

	public StorePage clickOnSearchBtn() {
		doClick(searchBtn, WaitStrategy.CLICKABLE, " Search Button");
		return new StorePage();
	}

	public StorePage clickOnAddToCartBtn() {
		doClick(addToCartBtn, WaitStrategy.CLICKABLE, "Add To Cart Button");
		return new StorePage();
	}

	public void clickOnViewCart() {
		doClick(viewCartBtn, WaitStrategy.PRESENCE, "View Cart");
	}

}
