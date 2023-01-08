package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentManager;
import com.tmb.reports.ExtentReport;

public final class LoginPage extends BasePage{

	private final By userNameTxtbx = By.xpath("//label[@for='username']/following-sibling::input[@id='username']");
	private final By passWordTxtbx = By.xpath("//label[@for='password']/following-sibling::input[@id='password']");
	private final By loginBtn = By.xpath("//button[@name='login']");

	public LoginPage enterUserName(String userName)  {
		
		
		doSendKeys(userNameTxtbx, userName,WaitStrategy.VISIBILITY, "UserName");

		return this;
	} 

	public LoginPage enterPassword(String passWord) {
	
		doSendKeys(passWordTxtbx, passWord,WaitStrategy.VISIBILITY, "Password");
		
		return this;
	}

	public AccountPage clickLoginBtn() {
		
		doClick(loginBtn,WaitStrategy.CLICKABLE, "Login Button" );
		return new AccountPage();
	}
}
