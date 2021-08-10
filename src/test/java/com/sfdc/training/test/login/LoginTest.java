package com.sfdc.training.test.login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sfdc.training.base.SfdcTrainingBaseTest;
import com.sfdc.training.page.homescreen.HomeScreenPage;
import com.sfdc.training.page.login.LoginPage;
import com.sfdc.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

import static com.sfdc.training.utilities.Constants.SCREEN_SHOTPATH;
import static com.sfdc.training.utilities.Constants.APPLICATION_PROPERTIES;
import static com.sfdc.training.utilities.Constants.USER_DIR;
import static com.sfdc.training.utilities.Constants.EXTENT_REPORTPATH;

public class LoginTest extends SfdcTrainingBaseTest {

	
	WebDriver driver;
	LoginPage login;
	HomeScreenPage homescreen;
	CommonUtilities common = new CommonUtilities();
	
	//Extent report initialization for test report generation.
	ExtentTest test;
	ExtentReports reports;
	
	@BeforeMethod
	@Parameters({"Browsername"})
	public void beforeTest(String Browsername) throws IOException {
		
		driver = getDriver(Browsername);
		//To get the url
		String url = common.getApplicationProperty("url");
		driver.get(url);
		login = new LoginPage(driver);
		homescreen= new HomeScreenPage(driver);
		String filePath = EXTENT_REPORTPATH + "report.html";
		reports = new ExtentReports(filePath);
		test = reports.startTest("SFDCAutomation");
		//log = new Log
		
	}
	
	@Test(priority=0)
	public void validateLoginwithValidUser() {
		login.enterIntoUsername("lakshmann@gmail.com");
		test.log(LogStatus.PASS, "User name is entered successfully!");
		login.enterIntoPassword("Merotesting21");
		test.log(LogStatus.PASS, "Password is entered successfully!");
		login.chooseRememberMe();
		test.log(LogStatus.PASS, "Remember me is checked successfully!");
		login.clickLoginButton();
		test.log(LogStatus.PASS, "login button is clicked successfully!");
		
		
	}
	
	
	@Test(priority=1)
	public void validateLoginwithInvaliteUser() {
		login.enterIntoUsername("lakshmann@gmail");
		login.enterIntoPassword("TestMero");
		login.clickLoginButton();
		login.chooseRememberMe();
	}
	
	@AfterMethod
	public void teardown() throws IOException {
		takescreenshot(driver);
		reports.endTest(test);
		reports.flush();
		driver.close();
	}

	
}
