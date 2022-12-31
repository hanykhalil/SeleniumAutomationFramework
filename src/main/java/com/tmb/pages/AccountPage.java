package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

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
		doClick(logOutLnk,"Presence");
		return new LoginPage();
	}
	public StorePage clickOnStoreMenu() {
		doClick(storeMenu, "Presence");
		
		return new StorePage();
	}
}
