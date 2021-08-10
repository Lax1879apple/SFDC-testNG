package com.sfdc.training.utilities;

import java.io.File;

public class Constants {
	

	public static final String APPLICATION_PROPERTIES = "properties" + File.separator + "application.properties";
	
	
	public static final String USER_DIR =System.getProperty("user.dir");
	
	public static final String SCREEN_SHOTPATH = USER_DIR + File.separator + "screenshots" + File.separator ;
	public static final String EXTENT_REPORTPATH = USER_DIR + File.separator + "extentreports" + File.separator ;
	
	// Instead using webdrivermanager, if we are looking for exe file, we can make the above code changes as shown below
	public static final String FIREFOX_DRIVER = "driver" + File.separator + "firefox.exe"; // this code is not used now, just an example.
}
