package com.sfdc.login.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_LogInPageTest {
	
	static WebDriver driver;
	
	@Test(priority=1)
	public static void lunchSFDCApp() {
		
		WebDriverManager.firefoxdriver().setup(); // setting up webDriverManger for firefox driver.
		driver = new FirefoxDriver(); // setting up firefox driver.
		
		driver.get("https://mycompany521-dev-ed.my.salesforce.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}
	@Test(priority=2)
	public static void logInToPortal() {
		WebElement userField = driver.findElement(By.id("username"));
		userField.sendKeys("lakshmann@gmail.com");
		
	}
	

}
