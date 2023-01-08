package com.tmb.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {
		
	}
	

	
	@BeforeMethod
	protected void setUp(Object[] data)  {
	@SuppressWarnings("unchecked")
	Map<String,String> map =	(Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"));
		
	}
	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
