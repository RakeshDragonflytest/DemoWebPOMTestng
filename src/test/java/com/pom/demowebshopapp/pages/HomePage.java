package com.pom.demowebshopapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pom.demowebshopapp.base.ActionEngine;



public class HomePage extends ActionEngine {
	static
	{
		PageFactory.initElements(getWebDriver(),HomePage.class);
	}
	@FindBy(xpath="//title[text()='Demo Web Shop']")
	private static WebElement title_homepage;
	
	@FindBy(xpath="//a[text()='Log in']")
	private static WebElement LoginLink_homepage;
	
	
	public static void validateTitilOfHomePage(String actualtitle)
	{
		//System.out.println("in the metho  "+actualtitle);
		
		String expectedTitle=getWebDriver().getTitle();
		//System.out.println("expected title is/........"+expectedTitle);
		Assert.assertEquals(actualtitle, expectedTitle);
	}
	public static void clickHomePageLoginLink()
	{
		clickWebElement(LoginLink_homepage, "LoginLink");
		
	}

}
