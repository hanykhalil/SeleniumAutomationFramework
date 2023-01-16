package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	
	private ExtentManager() {
		
	}
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	 static ExtentTest getExtentTest() {
		
		return extentTest.get();
	}

	 static void setExtentTest(ExtentTest test) {
		 System.out.println("step 3");
		extentTest.set(test);
	}

	 static void unLoad() {
		extentTest.remove();
	
}
}
