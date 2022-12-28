package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	public static WebDriver driver;

	public static void initDriver() {
		if (Objects.isNull(driver)) {
			driver = new ChromeDriver();
			driver.get("https://askomdch.com/account/");
		}
		
	}

	public static void quitDriver() {
		if(Objects.nonNull(driver)) {
			driver.quit();
			driver= null;
		}
		
	}
}
