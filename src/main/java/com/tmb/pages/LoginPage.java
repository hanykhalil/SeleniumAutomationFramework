package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class LoginPage extends BasePage{

	private final By userNameTxtbx = By.xpath("//label[@for='username']/following-sibling::input[@id='username']");
	private final By passWordTxtbx = By.xpath("//label[@for='password']/following-sibling::input[@id='password']");
	private final By loginBtn = By.xpath("//button[@name='login']");

	public LoginPage enterUserName(String userName) {
		doSendKeys(userNameTxtbx, userName,WaitStrategy.VISIBILITY);
		return this;
	} 

	public LoginPage enterPassword(String passWord) {
		doSendKeys(passWordTxtbx, passWord,WaitStrategy.VISIBILITY);
		return this;
	}

	public AccountPage clickLoginBtn() {
		doClick(loginBtn,WaitStrategy.CLICKABLE );
		return new AccountPage();
	}
}
