package com.tmb.Constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
private static final String CONFIGFILEPATH =System.getProperty("user.dir") + "/src/test/resources/FrameworkConfig/config.properties";

public static String getConfigFilePath() {
	return CONFIGFILEPATH;
}

}
