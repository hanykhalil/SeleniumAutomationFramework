package com.tmb.util;

public final class DyanamicXpathUtils {
	private DyanamicXpathUtils() {

	}

	public static String getXpath(String xpath, String value) {

		return String.format(xpath, value);

	}
}
