package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.Constants.FrameworkConstants;
import com.tmb.enums.CategoryType;

public class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;

	public static void initReports()  {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("TMB Report");
			spark.config().setReportName("Automation Execution Report");
			extent.attachReporter(spark);
		}

	}

	public static void flushReports()  {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unLoad();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void createTest(String testcasename) {
		System.out.println("step 2");
		ExtentTest test = extent.createTest(testcasename);
		
		ExtentManager.setExtentTest(test);
		
	}
	public static void addAuthors(String[] authors) {
		for(String author:authors) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}
	}
public static void addCategories(CategoryType[] categories) {
	for(CategoryType category:categories) {
		ExtentManager.getExtentTest().assignCategory(category.toString());
	}
	}
}
