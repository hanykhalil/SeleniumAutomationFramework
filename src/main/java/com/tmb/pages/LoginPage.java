package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class LoginPage extends BasePage{

	private final By userNameTxtbx = By.xpath("//label[@for='username']/following-sibling::input[@id='username']");
	private final By passWordTxtbx = By.xpath("//label[@for='password']/following-sibling::input[@id='password']");
	private final By loginBtn = By.xpath("//button[@name='login']");

	public LoginPage enterUserName(String userName) {
		doSendKeys(userNameTxtbx, userName);
		return this;
	} 

	public LoginPage enterPassword(String passWord) {
		doSendKeys(passWordTxtbx, passWord);
		return this;
	}

	public AccountPage clickLoginBtn() {
		doClick(loginBtn, "Clickable");
		return new AccountPage();
	}
}
