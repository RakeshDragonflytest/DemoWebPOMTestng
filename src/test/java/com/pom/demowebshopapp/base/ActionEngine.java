package com.pom.demowebshopapp.base;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

 public class ActionEngine extends BaseTest {
	//enter url by using get method.(driver.get)
	public static void enterUrl(String url) 
	{
		
		
		  try { getWebDriver().get(url);
		  getExtentTest().log(LogStatus.PASS,"url is enterd as: "+url);
		  
		  }catch(Exception exception) {
		  getExtentTest().log(LogStatus.FAIL,"url is  NOT enterd as: "+url); }
		 
	}
	//enter url by navigate method.(driver.navigate() with url as parameter)
	public static void enterUrl(URL url) 
	{
		try {
			getWebDriver().navigate().to(url);
			getExtentTest().log(LogStatus.PASS,"url is enterd as: "+url);
			
		}catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"url is  NOT enterd as: "+url);
		}
	}
	
	//enter url by navigate method(driver.navigate.to() with String as parameter.
	public static void navigateUrl(String url) 
	{
		try {
			getWebDriver().navigate().to(url);
			getExtentTest().log(LogStatus.PASS,"url is enterd as: "+url);
			
		}catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"url is  NOT enterd as: "+url);
		}
	}
	//Click on element with .click() method.
	public static void clickWebElement(WebElement webElement,String elementName)
	{
		
		Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
		//System.out.println("the element is found  "+webElement);
		getExtentTest().log(LogStatus.PASS,"Click action is done on: "+ webElement);
		webElement.click();
		}
	public static void clickWebElementActions(WebElement webElement,String elementName)
	{
		Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
		Actions actions=new Actions(getWebDriver());
		actions.click(webElement).build().perform();
		getExtentTest().log(LogStatus.PASS,"Click action is done on: "+ elementName);
		}
	public static void clickWebElementJS(WebElement webElement,String elementName)
	{
		try
		{
		Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
		
		getExtentTest().log(LogStatus.PASS,"Click action is done on: "+ elementName);
		webElement.click();
		
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"Element is NOT cleared: "+elementName);
			
		}
	}
	public static void verifyElementOnDOM(WebElement webElement,String elementName)
	{
		try
		{
			Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
		
		getExtentTest().log(LogStatus.PASS,"element is present: "+ webElement);
		
		
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"element is Not present: "+webElement);
			
		}
	}
	//enter textdata with sendKeys.
	public static void enterData(String testData,WebElement webElement,String elementName)
	{
			Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
			getExtentTest().log(LogStatus.PASS,"element is displayed "+elementName);
			webElement.clear();
			getExtentTest().log(LogStatus.PASS,"element is cleared "+elementName);
			webElement.sendKeys(testData);
			getExtentTest().log(LogStatus.PASS,"DTA is done on element :"+ elementName +" with test Data"+testData);
		}
	
	public static void enterData(CharSequence[] formattedTargetDate, WebElement webElement, String elementName) {
		Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
		getExtentTest().log(LogStatus.PASS,"element is displayed "+elementName);
		webElement.clear();
		getExtentTest().log(LogStatus.PASS,"element is cleared "+elementName);
		webElement.sendKeys(formattedTargetDate);
		getExtentTest().log(LogStatus.PASS,"DTA is done on element :"+ elementName +" with test Data"+formattedTargetDate);
		
	}
	public static void DTAActionsRobot(String testData,WebElement webElement,String elementName)
	{
		try
		{
			Actions actions=new Actions(getWebDriver());
			Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
			getExtentTest().log(LogStatus.PASS,"element is displayed "+elementName);
			actions.sendKeys(webElement).build().perform();
			actions.click(webElement).build().perform();
			getExtentTest().log(LogStatus.PASS,"Data typing Action is done on element :"+elementName+"with test Data"+testData);
		} catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"Element is Not Cleared: "+ elementName);
		}
	}
	public static void moveWebElementActions(WebElement webElement,String elementName)
	{
		Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
		Actions actions=new Actions(getWebDriver());
		actions.moveToElement(webElement).build().perform();
		getExtentTest().log(LogStatus.PASS,"move to action is done on: "+ elementName);
		}
	public static void selectElementActionsKeys(String elementName)
	{
		try {
	Actions actions=new Actions(getWebDriver());
	actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	getExtentTest().log(LogStatus.PASS,"Data typing Action is done on element :"+elementName);
	} 
	catch(Exception exception)
	{
		getExtentTest().log(LogStatus.FAIL,"Element is Not Cleared: "+ elementName);
	}
	}
	
	public static void switchToChildWindow(WebElement webElement,String elementName)
	{
		String parentWindowHandle = getWebDriver().getWindowHandle();

		// Click on a link that opens a new window
		//getWebDriver().findElement(By.linkText("Open new window")).click();

		// Get the window handles of all the windows that are currently open
		Set<String> allWindowHandles = getWebDriver().getWindowHandles();

		// Loop through the window handles to find the handle of the new window
		for (String windowHandle : allWindowHandles) {
		    if (!windowHandle.equals(parentWindowHandle)) {
		    	getWebDriver().switchTo().window(windowHandle);
		        break;
		    }
		    getWebDriver().switchTo().window(parentWindowHandle);
		}

		// Now we are in the child window, do some actions
		// ...

		// Switch back to the parent window
		getWebDriver().switchTo().window(parentWindowHandle);
		
		
		
		}
	public static void kbClickWebElementActions(WebElement webElement,String elementName)
	{
		try
		{
		Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
		Actions actions=new Actions(getWebDriver());
		actions.sendKeys(webElement, Keys.ENTER).build().perform();
		getExtentTest().log(LogStatus.PASS,"Click action is done on: "+ elementName);
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"Element is NOT cleared: "+elementName);
		}
	}
	public static void habdleDropDowns(WebElement webElement,String ddName,String how,String howValue)
	{
		Select select=new Select(webElement);
		try
		{
			if(how.equalsIgnoreCase("value"))
			{
				select.selectByValue(howValue);
				getExtentTest().log(LogStatus.PASS,"Drop Down selected based on:"+how+"with value"+ howValue);
			}
			else if(how.equalsIgnoreCase("text"))
			{
				select.selectByVisibleText(howValue);
				getExtentTest().log(LogStatus.PASS,"Drop Down selected based on:"+how+"with value"+ howValue);
			}
			else if(how.equalsIgnoreCase("index"))
			{
				int indx=Integer.parseInt(howValue);
				select.selectByIndex(indx);
				getExtentTest().log(LogStatus.PASS,"Drop Down selected based on:"+how+"with value"+ indx);
			}
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"Drop Down is Not selected by:");
		}

	}
	
	// select with excel data split and select one option method.
	public static void selectWithConatinsText(List<WebElement> webElements,String[] exceldata) throws EncryptedDocumentException, IOException
	{
		String[] data=exceldata;
		try
		{
		
		for(WebElement webElement1:webElements)
		  {
			 if(webElement1.getText().contains(data[2]))
			 {
				 webElement1.click();
			 }
		  }
		getExtentTest().log(LogStatus.PASS,"option selected with value=  : "+ data[2]);
	}
	
	catch(Exception exception)
	{
		getExtentTest().log(LogStatus.FAIL,"option NOT selected with value=  "+data[2]);
	}
	}
	//Split the String with commas 
	public static String[] splitTheValues(String datatest)
	{
		
		String[] data=datatest.split(",");
		for(int i=0;i<data.length;i++)
		{
			
			System.out.println(data[i]);
		}
		//int size=data.length;
		return data;
			
	}
	//select with contains method of an option
	public static void selectTextContains(List<WebElement> webElements,String data)
	{
	
			
		for(WebElement webElement1:webElements)
		  {
			System.out.println(data);
			String ComputerOptions=webElement1.getText();
			if(ComputerOptions.equalsIgnoreCase(data))
			 {
				 System.out.println("list of"+ComputerOptions);
				 webElement1.click();
			 }
		  }
		getExtentTest().log(LogStatus.PASS,"option selected with value=  : "+ data);
	
		//getExtentTest().log(LogStatus.FAIL,"option NOT selected with value=  "+data);
	
		
	}
	
	public static void switchToFrame(String how,String howValue)
	{
		try
		{
			if(how.equalsIgnoreCase("index")) 
			{
				int indx=Integer.parseInt(howValue);
				getWebDriver().switchTo().frame(indx);	
				getExtentTest().log(LogStatus.PASS,"switched to frame using :"+how+"with value"+ howValue);
				}
			else if(how.equalsIgnoreCase("frameId")||how.equalsIgnoreCase("frameName")) 
			{
				getWebDriver().switchTo().frame(howValue);	
				getExtentTest().log(LogStatus.PASS,"switched to frame using :"+how+"with value"+ howValue);
				}else if(how.equalsIgnoreCase("webelement")) 
						{
					getWebDriver().switchTo().frame(howValue);
					getExtentTest().log(LogStatus.PASS,"switched to frame using :"+how+"with value"+ howValue);
					}
				}
		catch (Exception exception ) {
			getExtentTest().log(LogStatus.FAIL,"switched to frame not Done");
		}
	}
	public static void mouseOverAction(WebElement webElement,String elementName)
	{
		try
		{
			Assert.assertTrue(webElement.isDisplayed()&&webElement.isEnabled());
			getExtentTest().log(LogStatus.PASS,"Element is displayed: "+ elementName);
			Actions actions=new Actions(getWebDriver());
			actions.moveToElement(webElement).build().perform();
			getExtentTest().log(LogStatus.PASS,"Mouse hover is  Displayed: "+ elementName);
			
		}catch (Exception exception) {
			getExtentTest().log(LogStatus.FAIL,"Mouse hover is Not Displayed: "+ elementName);
					}
	}
	public static void handleWindows()
	{
		try
		{
			Set <String> windows=getWebDriver().getWindowHandles();
			if(windows.size()>1)
			{
				String cuWinName=getWebDriver().getWindowHandle();
				for(String str:windows)
				{
					if(!str.equalsIgnoreCase(cuWinName))
					{
						getWebDriver().switchTo().window(str);
						getExtentTest().log(LogStatus.PASS,"Switched to new window"+str);
					}
				}
			}
			getExtentTest().log(LogStatus.PASS,"Less Number of windows are: "+windows.size());
		}
		catch (Exception e) {
			
		}

	}
	
	public static void handleWindows(int index)
	{
		try
		{
			Set <String> windows=getWebDriver().getWindowHandles();
			if(windows.size()>1)
			{
				List<String> list=new ArrayList<String>(windows);
				String window=list.get(index);
				getWebDriver().switchTo().window(window);
				getExtentTest().log(LogStatus.PASS,"Switched to new window: "+window);
			}
			getExtentTest().log(LogStatus.PASS,"Less Number of windows are: "+windows.size());
		}
		catch (Exception e) {
			
		}

	}
	
	public static String getTextWebElement(WebElement webElement)
	{
		String txt="";
		try {
			txt=webElement.getText();
			getExtentTest().log(LogStatus.PASS,"text is: "+ txt);
		}
		catch(Exception exception) {
			getExtentTest().log(LogStatus.FAIL,"text is : "+ txt);
		}
		return txt;
	}
	public static void waitForLoadWebelement(WebElement webelement,String webelementName)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(getWebDriver(),30);
			wait.until(ExpectedConditions.visibilityOf(webelement));
			webelement.click();
			getExtentTest().log(LogStatus.PASS,"wait with explicit by visibilityOf webelement done  :"+webelement.getText());
		System.out.println("wait performed in visibilityOf webelement.............");
		}
		catch(TimeoutException e) {
			
            System.out.println("TimeoutException: Element not visible within the given time.int testwait by method");
            getExtentTest().log(LogStatus.FAIL,"wait with explicit by visibilityOf webelement NOT done TimeoutException is raised by  :"+webelement.getText());
	}
	}
	public void waitForPageLoad()
	{
		
	}
	
	}
	
	

