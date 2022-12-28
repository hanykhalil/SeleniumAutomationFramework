package com.tmb.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;

public final class AccountPageTest extends BaseTest {
	private AccountPageTest() {

	}
	@Test
public void validateAccountHeader() {
	String accountHeader =Driver.driver.findElement(By.xpath("//h1[text()='Account']")).getText();
	System.out.println(accountHeader);
	Assert.assertEquals("Account", accountHeader);
}

}
