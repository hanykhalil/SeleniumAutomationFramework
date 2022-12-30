package com.tmb.tests;

import org.assertj.core.api.Assertions;

import org.testng.annotations.Test;

import com.tmb.pages.AccountPage;
import com.tmb.pages.LoginPage;

public final class LoginPageTest extends BaseTest {
	private LoginPageTest() {

	}

	@Test
	public void LoginLogOutTest() {
		LoginPage loginPage = new LoginPage();
		AccountPage accountPage = new AccountPage();
	String welcomeText=	loginPage.enterUserName("singhabhi04").enterPassword("Test@123").clickLoginBtn().getWelcomeText();
	Assertions.assertThat(welcomeText)
	.contains("Hello singhabhi04");
	accountPage.clickLogout();
	
	

	}

}
