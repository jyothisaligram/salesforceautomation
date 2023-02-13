package com.Jan23.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	
	public static String readPropertyData(String key) throws IOException {
	String curdir = System.getProperty("user.dir");
	FileInputStream fis = new FileInputStream(curdir+"/src/test/resources/testData.properties");
	Properties ob = new Properties();
	ob.load(fis);
	String value = ob.getProperty(key);
	return value;

}
}
