package com.pom.demowebshopapp.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pom.demowebshopapp.base.BaseTest;


public interface ScreenShotUtility {
	public static String takeScreenshot() throws IOException
	{
		TakesScreenshot takesScreenshot=(TakesScreenshot)BaseTest.getWebDriver();
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String imagePath=BaseTest.getcurDir()+"\\Screenshots\\"+BaseTest.gettcName()+".jpeg";
		//System.out.println("tc name is  "+imagePath);
		FileUtils.copyFile(file,new File(imagePath));
		return imagePath;
		
	}
	 public static String takeScreenshot(String tcName) throws IOException 
	 
		{
		 System.out.println("the tc name is faled.... +"+tcName);
			TakesScreenshot takesScreenshot=(TakesScreenshot)BaseTest.getWebDriver();
			File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String imagePath=BaseTest.getcurDir()+"\\Screenshots\\"+tcName+".jpeg";
			System.out.println("the tst status is  "+BaseTest.gettcName());
				FileUtils.copyFile(file,new File(imagePath));
			return imagePath;
			
		}
}
