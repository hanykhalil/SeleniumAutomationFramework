package com.tmb.Constants;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/test/resources/FrameworkConfig/config.properties";
	private static final int EXPLICITWAITTIME = 10;

	public static int getExplicitwaittime() {
		return EXPLICITWAITTIME;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

}
