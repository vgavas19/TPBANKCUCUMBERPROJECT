package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties init_prop() {

		prop=new Properties();

		try {

			String projectpath= System.getProperty("user.dir");
			FileInputStream ip=new FileInputStream(projectpath+"/src/test/resources/config/config.properties");
			prop.load(ip);
		}
		catch(Exception E)
		{
			E.getMessage();
			E.getStackTrace();
		}
		return prop;
	}


}
