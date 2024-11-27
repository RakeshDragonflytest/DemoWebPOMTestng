package com.pom.demowebshopapp.utilities;

import com.pom.demowebshopapp.base.BaseTest;

public interface DriverPaths {
	String ieKey="webdriver.ie.driver";
	String ieValue=BaseTest.getcurDir()+"\\Drivers\\IEDriverServer.exe";
	String chromeKey="webdriver.chrome.driver";
	String chromeValue=BaseTest.getcurDir()+"\\Drivers\\chromedriver.exe";
	String firefoxKey="webdriver.ie.driver";
	String firefoxValue=BaseTest.getcurDir()+"\\Drivers\\geckodriver.exe";
	String edgeKey="webdriver.ie.driver";
	String edgeValue=BaseTest.getcurDir()+"\\Drivers\\msedgedriver.exe";

}
