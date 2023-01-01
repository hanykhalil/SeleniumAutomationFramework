package com.tmb.driver;

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tmb.enums.ConfigProperty;
import com.tmb.util.ReadPropertyFile;

public final class Driver {
	private Driver() {

	}




	public static void initDriver() throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriver driver = new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperty.URL));
			DriverManager.getDriver().manage().window().maximize();
		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unLoad();
		}

	}
}
