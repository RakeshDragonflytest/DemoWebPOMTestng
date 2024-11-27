package com.pom.demowebshopapp.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.pom.demowebshopapp.customisedexceptions.FrameworkException;
import com.pom.demowebshopapp.utilities.DriverPaths;
import com.pom.demowebshopapp.utilities.ScreenShotUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.Allure;

public class BaseTest {
	private static WebDriver webDriver;
	private static String curDir;
	private static String tcName;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	private static Allure alluri;
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(@Optional("chrome")String browser)
	{
		 curDir=System.getProperty("user.dir");
		 if(browser.equalsIgnoreCase("chrome"))
			{
			
			 System.setProperty(DriverPaths.chromeKey, DriverPaths.chromeValue);
				
				webDriver=new ChromeDriver();
				init();
			}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty(DriverPaths.firefoxKey,DriverPaths.firefoxValue);
			webDriver=new FirefoxDriver();
			init();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			
			System.setProperty(DriverPaths.edgeKey, DriverPaths.edgeValue);
			webDriver=new EdgeDriver();
			init();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty(DriverPaths.ieKey,DriverPaths.ieValue);
			webDriver=new InternetExplorerDriver();
			init();
		}
	}
	private void init()
	{
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		webDriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	@BeforeTest
	public void initReports()
	{
		 extentReports=new ExtentReports(curDir+"\\Reports\\report.html");
		 
	}
	@BeforeMethod
	public void beforeTCExecution(Method method)
	{
		tcName=method.getName();
		extentTest=extentReports.startTest(tcName);
		extentTest.log(LogStatus.PASS,"Current Test Case name is : "+tcName);
		
	}
	@AfterTest
	public void closeReports() //throws FrameworkException
	{
		if(extentReports!=null)
		{
			extentReports.close();
		}
		else
		{
			FrameworkException exception=new FrameworkException();
			//FrameworkException exception=new FrameworkException("Extent reports is pointing to null");
			//throw exception;
		}
	}
	@AfterMethod
	public void afterTCExecution(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS,"Test Case name is Passed : "+tcName);
		
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			
			String imagePath=ScreenShotUtility.takeScreenshot();
			extentTest.log(LogStatus.FAIL," Test Case name is Failed : "+tcName);
			extentTest.log(LogStatus.FAIL,result.getThrowable());
			extentTest.addScreenCapture(imagePath);
			}
		else if(result.getStatus()==ITestResult.SKIP) {
			
			String imagePath=ScreenShotUtility.takeScreenshot(tcName);
			extentTest.log(LogStatus.SKIP,"Test Case name is Skipped : "+tcName);
			extentTest.log(LogStatus.SKIP,result.getThrowable());
			extentTest.addScreenCapture(imagePath);
		}
		extentReports.flush();
		extentReports.endTest(extentTest);
		
	}
	@AfterSuite
	public void closeBrowser()
	{
		if(webDriver!=null)
		{
			webDriver.close();
		}
		else
		{
			System.out.println("Webdriver is pointing to null");
		}
	}
	public static WebDriver getWebDriver()
	{
		return webDriver;
	}
	public static String getcurDir()
	{
		return curDir;
	}
	public static String gettcName()
	{
		return tcName;
	}
	public static ExtentTest getExtentTest() {
		return extentTest;
	}
	


}
