package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class AccountPage extends BasePage {

	private final By logOutLnk = By.xpath("//a[contains(text(),'Logout')]");
	private final By welcomeMsg = By.xpath("//p[contains(text(),'Hello')]");
	private final By accountHeaderLbl = By.xpath("//h1[text()='Account']");
	private final By storeMenu = By.xpath("(//a[text()='Store'])[1]");

	public String getWelcomeText() {

		return getText(welcomeMsg);
	}

	public String getAccountHeader() {

		return getText(accountHeaderLbl);
	}

	public LoginPage clickLogout() {
		doClick(logOutLnk, WaitStrategy.CLICKABLE, "Logout Link");
		return new LoginPage();
	}

	public StorePage clickOnStoreMenu() {
		doClick(storeMenu, WaitStrategy.PRESENCE, " Store Menu");

		return new StorePage();
	}

	public AccountPage validateAccountHeader(String actual, String expected) throws Exception {
		assertText(actual, expected);

		return this;
	}
}
