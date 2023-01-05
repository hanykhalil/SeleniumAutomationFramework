package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;

import org.testng.annotations.Test;

import com.tmb.pages.AccountPage;
import com.tmb.pages.LoginPage;
import com.tmb.reports.ExtentReport;
import com.tmb.util.DataProviderUtils;

public final class LoginPageTest extends BaseTest {
	private LoginPageTest() {

	}

	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void LoginLogOutTest(Map<String,String> data) throws Exception {

		LoginPage loginPage = new LoginPage();
		AccountPage accountPage = new AccountPage();
		String welcomeText = loginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginBtn()
				.getWelcomeText();
		Assertions.assertThat(welcomeText).contains("Hello singhabhi04");
		accountPage.clickLogout();

	}

}
