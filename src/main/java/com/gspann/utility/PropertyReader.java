package com.gspann.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by GSPANN
 */
public class PropertyReader {
	
	private static final String path="./src/main/resources/config/";
	private static Properties prop = new Properties();
	/***
	 * It initialize the property file.
	 * @param fileName
	 */
	public PropertyReader(String fileName) {
	   InputStream input = null;
		try {
			input = new FileInputStream(path+fileName);
			prop.load(input);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	public void setProperty(String key, String value) {
		prop.setProperty(key, value);
	}	
}