package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class LoginPage {

	private final By userNameTxtbx = By.xpath("//label[@for='username']/following-sibling::input[@id='username']");
	private final By passWordTxtbx = By.xpath("//label[@for='password']/following-sibling::input[@id='password']");
	private final By loginBtn = By.xpath("//button[@name='login']");

	public LoginPage enterUserName(String userName) {
		DriverManager.getDriver().findElement(userNameTxtbx).sendKeys(userName);
		return this;
	}

	public LoginPage enterPassword(String passWord) {
		DriverManager.getDriver().findElement(passWordTxtbx).sendKeys(passWord);
		return this;
	}

	public AccountPage clickLoginBtn() {
		DriverManager.getDriver().findElement(loginBtn).click();
		return new AccountPage();
	}
}
