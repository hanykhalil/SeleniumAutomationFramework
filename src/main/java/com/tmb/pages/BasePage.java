package com.tmb.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;

public class BasePage {

	protected void doClick(By by, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitwait(by, waitStrategy);
		DriverManager.getDriver().findElement(by).click();
		try {
			ExtentLogger.pass(elementName + " is Clicked",true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	protected void doSendKeys(By by, String value, WaitStrategy waitStrategy, String elementName)  {
		ExplicitWaitFactory.performExplicitwait(by, waitStrategy);
		DriverManager.getDriver().findElement(by).clear();
		DriverManager.getDriver().findElement(by).sendKeys(value);
		try {
			ExtentLogger.pass(value + " is entered in text field " + elementName + " successfully",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected String getText(By by) {
		return DriverManager.getDriver().findElement(by).getText();

	}

	protected void assertText(String actual ,String expected) {
		if (actual.equals( expected)) {
			ExtentLogger.pass("Account Header Validation Successfull!! as Actual value "+actual+" matches with the expected value "+expected,true);
		}
		else {
			ExtentLogger.fail("Account Header Validation failed as Actual value "+actual+" does not matches with the expected value "+expected,true);

		}
	}

}
