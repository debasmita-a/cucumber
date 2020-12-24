package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/*
	 * This method is used to initialize the ThreadLocal driver on the basis of browser name. 
	 * @param browser
	 * @return this will return tlDriver
	 */
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser is: "+ browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}else if(browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		}else {
			System.out.println("Please pass the correct browser name: "+ browser);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}
	
	//This method is used to get the driver with ThreadLocal
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
