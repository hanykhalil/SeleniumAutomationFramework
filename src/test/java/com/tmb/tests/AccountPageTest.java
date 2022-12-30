package com.tmb.tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;
import com.tmb.pages.AccountPage;
import com.tmb.pages.LoginPage;

public final class AccountPageTest extends BaseTest {
	private AccountPageTest() {

	}
	@Test
	public void validateAccountHeader() {
		
		LoginPage loginPage = new LoginPage();
		AccountPage accountPage = new AccountPage();
		String accountHeader =loginPage.enterUserName("singhabhi04").enterPassword("Test@123").clickLoginBtn().getAccountHeader();
		Assertions.assertThat(accountHeader)
		.isEqualTo("Account");
		accountPage.clickLogout();
	}

}
