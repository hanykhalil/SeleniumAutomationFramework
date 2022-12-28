package com.tmb.util;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
	 private ReadPropertyFile() {
		 
	 }
	 public static String getValue(String key) throws Exception {
		 String value="";
		 
		 Properties prop = new Properties();
		 FileInputStream fip =
				 new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/FrameworkConfig/config.properties");
		 prop.load(fip);
		 value =prop.getProperty(key);
		 if(Objects.isNull(value)) {
			 throw new Exception("Property Name "+key +" is not Found.Please check config.properties");
		 }
		 
		return value;
	 }
	 

}
