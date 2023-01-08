package com.tmb.Constants;

import com.tmb.enums.ConfigProperty;
import com.tmb.util.ReadPropertyFile;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/test/resources/FrameworkConfig/config.properties";
	private static final int EXPLICITWAITTIME = 10;
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportFilePath = "";
	private static final String excelPath = System.getProperty("user.dir")+"/src/test/resources/testdata/testData.xlsx";
	

	public static String getExcelpath() {
		return excelPath;
	}

	public static String getExtentReportFilePath(){
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath()  {
		if (ReadPropertyFile.getValue(ConfigProperty.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTPATH + System.currentTimeMillis() + "/index.html";
		} else {
			return EXTENTREPORTPATH + "/index.html";
		}

	}

	public static int getExplicitwaittime() {
		return EXPLICITWAITTIME;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

}
