package com.sfdc.training.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.sfdc.training.base.*;



public class LoginPage extends SfdcTrainingBasePage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='username']")
	WebElement loginusername;

	@FindBy(id="password")
	WebElement enterPassword;
	
	@FindBy(xpath="//input[@id='Login']")
	WebElement loginButton;

//	@FindBy(xpath="//input[@id='rememberUn']")
//	WebElement rememberMe;
	
//	@FindBy(xpath ="//input[@class='r4 fl mr8']")
//	WebElement rememberMe;
	
	@FindBy(id="rememberUn")
	WebElement rememberMe;
	
	
	public void enterIntoUsername(String username) {
		loginusername.sendKeys(username);
	}

	public void enterIntoPassword(String passowrd) {

		enterPassword.sendKeys(passowrd);
	}

	public void clickLoginButton() {

		loginButton.click();
	}

	public void chooseRememberMe() {

		rememberMe.click();
	}



}
