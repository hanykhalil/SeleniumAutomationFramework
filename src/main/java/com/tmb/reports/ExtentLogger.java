package com.tmb.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperty;
import com.tmb.util.ReadPropertyFile;
import com.tmb.util.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void pass(String message, boolean needScreenshot) throws Exception {
		if (ReadPropertyFile.getValue(ConfigProperty.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && needScreenshot) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}

	

	public static void fail(String message, boolean needScreenshot) throws Exception {
		if (ReadPropertyFile.getValue(ConfigProperty.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && needScreenshot) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
}
