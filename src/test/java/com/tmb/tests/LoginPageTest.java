package com.tmb.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class LoginPageTest extends BaseTest {
	private LoginPageTest() {

	}

	@Test
	public void Login() {

		DriverManager.getDriver().findElement(By.xpath("//label[@for='username']/following-sibling::input[@id='username']"))
		.sendKeys("singhabhi04");
		DriverManager.getDriver().findElement(By.xpath("//label[@for='password']/following-sibling::input[@id='password']"))
		.sendKeys("Test@123");
		DriverManager.getDriver().findElement(By.xpath("//button[@name='login']")).click();

	}

}
