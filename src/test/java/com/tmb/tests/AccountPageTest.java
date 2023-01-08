package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.AccountPage;
import com.tmb.pages.LoginPage;
import com.tmb.util.DataProviderUtils;

public final class AccountPageTest extends BaseTest {
	private AccountPageTest() {

	}
	@FrameworkAnnotation(author = { "Abhishek" }, category = { CategoryType.REGRESSION })
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void validateAccountHeader(Map<String,String> data)  {

		LoginPage loginPage = new LoginPage();
		AccountPage accountPage = new AccountPage();
		String accountHeader = loginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginBtn()
				.getAccountHeader();
		Assertions.assertThat(accountHeader).isEqualTo("Account");
		accountPage.clickLogout();
		
	}

}
