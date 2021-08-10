package com.sfdc.training.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SfdcTrainingBasePage {

	protected WebDriver driver;
	
	public SfdcTrainingBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
