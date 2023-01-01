package com.tmb.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.enums.ConfigProperty;

public final class ReadPropertyFile {
	private ReadPropertyFile() {

	}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		FileInputStream fip;
		try {
			fip = new FileInputStream(FrameworkConstants.getConfigFilePath());
			prop.load(fip);

			for (Map.Entry<Object, Object> entry : prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static String getValue(ConfigProperty key) throws Exception {

		if (Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) || Objects.isNull(key)){
			throw new Exception("Property Name " + key + " is not Found.Please check config.properties");
		}

		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
