package com.tmb.reports;

import java.awt.Desktop;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.Constants.FrameworkConstants;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;
	

	public static void initReports() throws Exception {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("TMB Report");
			spark.config().setReportName("Automation Execution Report");
			extent.attachReporter(spark);
		}

	}

	public static void flushReports() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}

		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
	}

	public static void createTest(String testcasename) {
		ExtentTest test = extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
}
