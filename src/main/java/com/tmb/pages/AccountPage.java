package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.util.DyanamicXpathUtils;

public final class AccountPage extends BasePage {

	private final By logOutLnk = By.xpath("//a[contains(text(),'Logout')]");
	private final By welcomeMsg = By.xpath("//p[contains(text(),'Hello')]");
	private final By accountHeaderLbl = By.xpath("//h1[text()='Account']");
	private String globalMenus = "//div[@id='ast-desktop-header']//li/a[text()='%s']";

	public void clickOnGlobalMenu(String menu) {
		String newXpath = DyanamicXpathUtils.getXpath(globalMenus, menu);
		doClick(By.xpath(newXpath), WaitStrategy.CLICKABLE, " Store");
	}

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

	public AccountPage validateAccountHeader(String actual, String expected)  {
		assertText(actual, expected);

		return this;
	}
}
