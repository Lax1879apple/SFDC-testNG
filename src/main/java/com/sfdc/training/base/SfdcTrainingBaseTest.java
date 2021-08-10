package com.sfdc.training.base;

import static com.sfdc.training.utilities.Constants.APPLICATION_PROPERTIES;
import static com.sfdc.training.utilities.Constants.USER_DIR;
import static com.sfdc.training.utilities.Constants.SCREEN_SHOTPATH;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;


public class SfdcTrainingBaseTest {


	protected WebDriver driver;

	public WebDriver getDriver(String Browsername) {

		if(Browsername.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeDriverManager.chromedriver();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notification");
			driver = new ChromeDriver(chromeOptions);

		}else if(Browsername.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxDriverManager.firefoxdriver();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable-notification");
			driver = new FirefoxDriver(firefoxOptions);

		}
		return driver;
	}

	public void takescreenshot(WebDriver driver) throws IOException {

		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		//call getScreenshotAs method to create image file
		File sourceFile = scrShot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		System.out.println(date);
		String timestamp = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss").format(new Date());
		System.out.println("Timestamp  is : " + timestamp);
		String fileName = "ScreenShot_" + timestamp + ".PNG";
		System.out.println("File name to be generated : " + fileName);
		//Move image file to new destination
		String filePath = SCREEN_SHOTPATH + fileName;
		System.out.println("File Path : " + filePath);
		File DestFile = new File(filePath);
		//Copy file at destionation
		FileUtils.copyFile(sourceFile, DestFile);
	}

}
