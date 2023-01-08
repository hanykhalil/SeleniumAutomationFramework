package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.AccountPage;
import com.tmb.pages.LoginPage;
import com.tmb.util.DataProviderUtils;

public final class LoginPageTest extends BaseTest {
	private LoginPageTest() {

	}

	@FrameworkAnnotation(author = { "Abhishek" }, category = { CategoryType.SMOKE })
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void LoginLogOutTest(Map<String, String> data)  {

		LoginPage loginPage = new LoginPage();
		AccountPage accountPage = new AccountPage();
		String welcomeText = loginPage.enterUserName(data.get("username")).enterPassword(data.get("password"))
				.clickLoginBtn().getWelcomeText();
		Assertions.assertThat(welcomeText).contains("Hello singhabhi04");
		accountPage.clickLogout();

	}

}
