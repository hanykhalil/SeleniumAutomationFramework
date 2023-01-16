package com.tmb.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {

		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {

		ExtentReport.flushReports();

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("step 1");
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentLogger.info(result.getMethod().getMethodName() + " Test Case Execution Started");
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);

		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
	}

}
