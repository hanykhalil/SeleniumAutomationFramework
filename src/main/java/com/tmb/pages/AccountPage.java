package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class AccountPage {

	private final By logOutLnk = By.xpath("//a[contains(text(),'Logout')]");
	private final By welcomeMsg = By.xpath("//p[contains(text(),'Hello')]");
	private final By accountHeaderLbl = By.xpath("//h1[text()='Account']");
	public String getWelcomeText() {

		return DriverManager.getDriver().findElement(welcomeMsg).getText();
	}
	
	public String getAccountHeader() {

		return DriverManager.getDriver().findElement(accountHeaderLbl).getText();
	}
	
	public LoginPage clickLogout() {
		DriverManager.getDriver().findElement(logOutLnk).click();
		return new LoginPage();
	}
}
