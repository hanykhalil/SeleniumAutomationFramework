package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;
import com.tmb.pages.AccountPage;
import com.tmb.pages.LoginPage;
import com.tmb.reports.ExtentLogger;
import com.tmb.util.DataProviderUtils;

public final class AccountPageTest extends BaseTest {
	private AccountPageTest() {

	}

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void validateAccountHeader(Map<String,String> data) throws Exception {

		LoginPage loginPage = new LoginPage();
		AccountPage accountPage = new AccountPage();
		String accountHeader = loginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginBtn()
				.getAccountHeader();
		Assertions.assertThat(accountHeader).isEqualTo("Account");
		accountPage.clickLogout();
		
	}

}
