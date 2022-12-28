package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Driver {
	private Driver() {
		
	}

	private static WebDriver driver;
	

	public static void initDriver() {
		if (Objects.isNull(driver)) {
			driver = new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get("https://askomdch.com/account/");
		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(driver)) {
			DriverManager.getDriver().quit();
			DriverManager.unLoad();
		}

	}
}
