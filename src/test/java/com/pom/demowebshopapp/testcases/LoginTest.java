package com.pom.demowebshopapp.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.demowebshopapp.base.ActionEngine;
import com.pom.demowebshopapp.pages.HomePage;
import com.pom.demowebshopapp.pages.LoginPage;
import com.pom.demowebshopapp.utilities.PojoReader;

public class LoginTest extends ActionEngine{
	@Test
	public void testLoginHomePage() throws IOException, InterruptedException
	{
		enterUrl(PojoReader.getPrConf().getValue("qa_url"));
		Thread.sleep(2000);
		String actualTitle=PojoReader.getExcelObj().getCellData("sheetname","Sheet1", 0, 0);
		//System.out.println("actual/...."+actualTitle);
		HomePage.validateTitilOfHomePage(actualTitle);
		HomePage.clickHomePageLoginLink();
		String actualLoginMsg=PojoReader.getExcelObj().getCellData("sheetname","Sheet1", 1, 0);
		LoginPage.validatewelcomeLoginMsg(actualLoginMsg);
		String Email=PojoReader.getExcelObj().getCellData("sheetname","Sheet1", 3, 0);
		String Password=PojoReader.getExcelObj().getCellData("sheetname","Sheet1", 3, 1);
		LoginPage.enterEmail(Email);
		LoginPage.enterPassword(Password);
		LoginPage.clickLoginBtn();
		LoginPage.verifyLogOutBtnPresent();
		LoginPage.selectComputersDD();
		String comptersOptions=PojoReader.getExcelObj().getCellData("sheetname","Sheet1", 4,0);
		LoginPage.selectOptionDesktop(comptersOptions);
		Thread.sleep(2000);
		
		
	}

}
