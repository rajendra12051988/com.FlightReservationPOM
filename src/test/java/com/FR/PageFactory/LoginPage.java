package com.FR.PageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FR.Listeners.TestNGListeners;
import com.FR.Utility.HighlightElement;

public class LoginPage extends TestNGListeners {
	
	WebDriver driver;
	
	// private Logger logger = Logger.getLogger("devpinoyLogger");
	
	@FindBy(name="userName")
	private WebElement loginUserID;
	
	
	@FindBy(name="password")
	private WebElement loginPwd;
	
	@FindBy(name="login")
	private WebElement signIn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Enter UserName
	public void enterUserName(String username) {
		try {
		System.out.println(logger);
		logger.info("Entering '"+username+"' in the 'UserName' edit field");
		HighlightElement.highlihghtElement(driver, loginUserID);
		loginUserID.sendKeys(username);
		logger.info("Entered '"+username+"' in the 'UserName' edit field successfully");
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while entering '"+username+"' in the 'UserName' edit field : "+ex.getMessage());
		}
	}
	
	// Enter Password
	public void enterPassword(String pwd) {
		try {
		logger.info("Entering '"+pwd+"' in the 'Password' edit field");
		HighlightElement.highlihghtElement(driver, loginPwd);
		loginPwd.sendKeys(pwd);
		logger.info("Entered '"+pwd+"' in the 'Password' edit field successfully");
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while entering '"+pwd+"' in the 'Password' edit field : "+ex.getMessage());
		}
		
	}
	
	// Click on 'Sign In'
	public void clickOnSignIn() {
		try {
		logger.info("Clicking on 'Sign In'");
		HighlightElement.highlihghtElement(driver, signIn);
		signIn.click();
		logger.info("Clicked on 'Sign In' successfully");
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while Clicking on 'Sign In' : "+ex.getMessage());
		}
	}
	
	

}
