package com.cqu.waxxd.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyPropertyUtil {

	public static String getProperty(String pro, String key) {
		
		Properties properties = new Properties();
		InputStream resourceAsStream = MyPropertyUtil.class.getClassLoader().getResourceAsStream(pro);
		
		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String path = properties.getProperty(key);
		
		return path;
	}

}
