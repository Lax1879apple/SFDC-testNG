package com.sfdc.training.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.sfdc.training.utilities.Constants.APPLICATION_PROPERTIES;
import static com.sfdc.training.utilities.Constants.USER_DIR;


public class CommonUtilities {

	public String getApplicationProperty(String key) throws IOException {
		
		// To access salesforce url from application properties file.
		Properties properties = new Properties();
		String filePath = USER_DIR;
		filePath = filePath + File.separator + APPLICATION_PROPERTIES;
		
		FileInputStream inputfile = new FileInputStream(filePath);
		String value ="";
		
		try {
			properties.load(inputfile);
			value = properties.getProperty(key);
		}finally {
			inputfile.close();
		}
		return value ;
	}

	
	
}
