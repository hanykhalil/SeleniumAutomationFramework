package com.tmb.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;

public final class LoginPageTest extends BaseTest {
	private LoginPageTest() {

	}

	@Test
	public void Login() {

		Driver.driver.findElement(By.xpath("//label[@for='username']/following-sibling::input[@id='username']"))
				.sendKeys("singhabhi04");
		Driver.driver.findElement(By.xpath("//label[@for='password']/following-sibling::input[@id='password']"))
				.sendKeys("Test@123");
		Driver.driver.findElement(By.xpath("//button[@name='login']")).click();

	}

}
