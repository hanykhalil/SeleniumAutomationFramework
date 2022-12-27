package com.tmb.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
	
	
	@Test
	public void test1() {
		
		
		 
		driver.findElement(By.xpath("//label[@for='username']/following-sibling::input[@id='username']")).sendKeys("singhabhi04");
		driver.findElement(By.xpath("//label[@for='password']/following-sibling::input[@id='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
	}
	

}
