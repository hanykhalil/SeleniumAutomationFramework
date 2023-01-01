package com.tmb.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public class ExplicitWaitFactory {

	public static void performExplicitwait(By by, WaitStrategy waitStrategy) {
		if (waitStrategy == WaitStrategy.CLICKABLE) {
			new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaittime()))
					.until(ExpectedConditions.elementToBeClickable(by));

		} else if (waitStrategy == WaitStrategy.VISIBILITY) {
			new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaittime()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaittime()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.NONE) {
			DriverManager.getDriver().findElement(by).click();
		}
	}
}
