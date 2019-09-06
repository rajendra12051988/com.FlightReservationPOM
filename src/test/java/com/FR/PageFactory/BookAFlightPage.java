package com.FR.PageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.FR.Listeners.TestNGListeners;
import com.FR.Utility.HighlightElement;

public class BookAFlightPage extends TestNGListeners {
	
	WebDriver driver;
	//private Logger logger = Logger.getLogger("devpinoyLogger");
	
	@FindBy(how=How.NAME,using="passFirst0")
	private WebElement firstName;
	
	@FindBy(how=How.NAME,using="passLast0")
	private WebElement lastName;
	
	@FindBy(how=How.NAME,using="creditnumber")
	private WebElement creditNumber;
	
	@FindBy(how=How.NAME,using="buyFlights")
	private WebElement securePurchase;
	
	
	public BookAFlightPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void enterFirstName(String firstname) {
		try {
		logger.info("Entering '"+firstname+"' in the 'First Name' edit field");	
		HighlightElement.highlihghtElement(driver, firstName);
		firstName.sendKeys(firstname);
		logger.info("Entered '"+firstname+"' in the 'First Name' edit field successfully");	
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while entering '"+firstname+"' in the 'First Name' edit field : "+ex.getMessage());	
		}
		
	}
	
	public void enterLastName(String lastname) {
		try {
		logger.info("Entering '"+lastname+"' in the 'Last Name' edit field");	
		HighlightElement.highlihghtElement(driver, lastName);
		lastName.sendKeys(lastname);
		logger.info("Entered '"+lastname+"' in the 'Last Name' edit field successfully");
		}catch(NoSuchElementException ex){
			logger.error("Exception ocuured while entering '"+lastname+"' in the 'Last Name' edit field : "+ex.getMessage());
		}
		
	}
	
	public void enterCreditNumber(String creditnumber) {
		try {
		logger.info("Entering '"+creditnumber+"' in the 'Credit Card Number' edit field");
		HighlightElement.highlihghtElement(driver, creditNumber);
		logger.info("Entered '"+creditnumber+"' in the 'Credit Card Number' edit field successfully");
		creditNumber.sendKeys(creditnumber);
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while entering '"+creditnumber+"' in the 'Credit Card Number' edit field : "+ ex.getMessage());
		}
		
	}
	
	public void clickOnBuyFlights() {
		try {
		HighlightElement.highlihghtElement(driver, securePurchase);
		securePurchase.click();
		}catch(Exception ex) {
			ex.getMessage();
		}
	}


}
