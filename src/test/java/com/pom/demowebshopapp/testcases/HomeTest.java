package com.pom.demowebshopapp.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.demowebshopapp.base.ActionEngine;
import com.pom.demowebshopapp.pages.HomePage;
import com.pom.demowebshopapp.utilities.PojoReader;


public class HomeTest extends ActionEngine{
	@Test
	public static void testHomeDemoApp() throws IOException, InterruptedException
	{
		enterUrl(PojoReader.getPrConf().getValue("qa_url"));
		Thread.sleep(2000);
		
		  String actualTitle=PojoReader.getExcelObj().getCellData("sheetname","Sheet1",  0, 0);
		  //System.out.println("actual/...."+actualTitle);
		  HomePage.validateTitilOfHomePage(actualTitle);
		 
}

}