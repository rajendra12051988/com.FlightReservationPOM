package com.FR.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtility {
	
	public static WebDriver driver;
	
	public static WebDriver browserSetup(String browser) {
		
		System.out.println(browser);
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",Constant.chromeDriverPath);
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",Constant.geckoDriverPath);
			driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.ie.driver",Constant.ieDriverPath);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	
	

}
