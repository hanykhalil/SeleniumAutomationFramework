package com.tmb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.driver.DriverManager;

public class BasePage {

	protected void doClick(By by, String waitStrategy) {
		if (waitStrategy.equalsIgnoreCase("Clickable")) {
			explicitlyWaitForElementToBeClickable(by);
		}

		if (waitStrategy.equalsIgnoreCase("Presence")) {
			explicitlyWaitForElementToBePresent(by);
		}
		DriverManager.getDriver().findElement(by).click();
	}

	protected void doSendKeys(By by, String value) {
		explicitlyWaitForElementToBeClickable(by);
		DriverManager.getDriver().findElement(by).clear();
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}

	protected String getText(By by) {
		return DriverManager.getDriver().findElement(by).getText();

	}

	private void explicitlyWaitForElementToBeClickable(By by) {

		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaittime()))
				.until(ExpectedConditions.elementToBeClickable(by));

	}

	private void explicitlyWaitForElementToBePresent(By by) {

		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaittime()))
				.until(ExpectedConditions.presenceOfElementLocated(by));

	}
}
