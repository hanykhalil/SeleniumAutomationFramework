package com.tmb.driver;

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.tmb.enums.ConfigProperty;
import com.tmb.util.ReadPropertyFile;

public final class Driver {
	private Driver() {

	}




	public static void initDriver(String browser)  {
		if (Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				//WebDriver driver = new ChromeDriver();
				DriverManager.setDriver(new ChromeDriver());
			}
			else if(browser.equalsIgnoreCase("Edge")) {
				DriverManager.setDriver(new EdgeDriver());
			}
			
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
