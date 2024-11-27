package com.pom.demowebshopapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.demowebshopapp.base.ActionEngine;

public class DestTopPage extends ActionEngine {
	static {
		PageFactory.initElements(getWebDriver(),DestTopPage.class);
	}
	
	@FindBy(xpath="//h1[text()='Desktops']")
	private static WebElement welcomeLoginMsg;

	
	
	
}
