package com.rueggerllc.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Utils {
	
	private static Map<String,String> uploadDirectories;
	
	static {
		uploadDirectories = new HashMap<String,String>();
		uploadDirectories.put(Constants.OS_NAME_MAC, Constants.IMAGES_DIR_MAC);
		uploadDirectories.put(Constants.OS_NAME_LINUX, Constants.IMAGES_DIR_LINUX);
	}
	
	public static boolean isBlank(String value) {
		return value == null || value.trim().equals("");
	}
	
	public static String getOSName() {
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");
		return osName;
	}
	
	public static String getImagesDirectory() {
		String osName = getOSName();
		if (isBlank(osName)) {
			return "ERROR";
		}
		
		return uploadDirectories.get(osName);

	}
	

}
