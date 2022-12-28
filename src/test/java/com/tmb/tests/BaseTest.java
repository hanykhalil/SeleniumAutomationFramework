package com.tmb.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {
		
	}
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		Driver.initDriver();
		
	}
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}

}
