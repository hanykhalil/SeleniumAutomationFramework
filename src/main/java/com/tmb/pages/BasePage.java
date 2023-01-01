package com.tmb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;

public class BasePage {

	protected void doClick(By by, WaitStrategy waitStrategy) {
		ExplicitWaitFactory.performExplicitwait(by,waitStrategy);
		DriverManager.getDriver().findElement(by).click();
	}

	protected void doSendKeys(By by, String value,WaitStrategy waitStrategy) {
		ExplicitWaitFactory.performExplicitwait(by,waitStrategy);
		DriverManager.getDriver().findElement(by).clear();
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}

	protected String getText(By by) {
		return DriverManager.getDriver().findElement(by).getText();

	}

	
	
}
