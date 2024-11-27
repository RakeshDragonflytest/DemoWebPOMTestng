package com.pom.demowebshopapp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.pom.demowebshopapp.base.ActionEngine;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class LoginPage extends ActionEngine {
	static {
		PageFactory.initElements(getWebDriver(),LoginPage.class);
	}
	
	@FindBy(xpath="//h1[text()='Welcome, Please Sign In!']")
	private static WebElement welcomeLoginMsg;
	
	@FindBy(xpath="//input[@id='Email']")
	private static WebElement Email;
	
	@FindBy(xpath="//input[@id='Password']")
	private static WebElement Password;
	
	@FindBy(xpath="//input[@value='Log in']")
	private static WebElement LoginBtn;

	@FindBy(xpath="//a[text()='Log out']")
	private static WebElement LogoutLink;
	
	@FindBy(xpath="//ul[@class='top-menu']/li[2]")
	private static WebElement Computers;
	
	@FindBys({@FindBy(xpath="(//ul[@class='sublist firstLevel'])[2]//li/a")})
	  private static List<WebElement> ComputersList;


	
	public static void validatewelcomeLoginMsg(String actualLoginMsg)
	{
		String expLoginMsg=welcomeLoginMsg.getText();
		System.out.println(expLoginMsg);
		System.out.println(actualLoginMsg);
		Assert.assertEquals(expLoginMsg, actualLoginMsg);
		
	}
	public static void enterEmail(String email)
	{
	enterData(email, Email, "Email");
	}
	public static void enterPassword(String password)
	{
	enterData(password, Password, "Email");
	}
	public static void clickLoginBtn()
	{
		clickWebElement(LoginBtn, "LoginButton");
	}
	public static void verifyLogOutBtnPresent()
	{
		verifyElementOnDOM(LogoutLink,"Logout");
		
	}
	public static void selectComputersDD()
	{
		mouseOverAction(Computers,"ComputersMenu");
	}
	public static void selectOptionDesktop(String data)
	{
		selectElementActionsKeys("computerList");
		//selectTextContains(ComputersList,data);
		
		
	}
}
	

