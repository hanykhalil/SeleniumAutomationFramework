package com.tmb.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.enums.ConfigProperty;
import com.tmb.exceptions.PropertyFileUsageException;

public final class ReadPropertyFile {
	private ReadPropertyFile() {

	}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {

		try (FileInputStream fip = new FileInputStream(FrameworkConstants.getConfigFilePath())) {

			prop.load(fip);

			for (Map.Entry<Object, Object> entry : prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

		} catch (IOException e) {

			e.printStackTrace();
			System.exit(0);

		}

	}

	public static String getValue(ConfigProperty key) {

		if (Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) || Objects.isNull(key)) {
			throw new PropertyFileUsageException(
					"Property Name " + key + " is not Found.Please check config.properties");
		}

		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
