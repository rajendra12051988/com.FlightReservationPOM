package com.FR.PageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.FR.Listeners.TestNGListeners;
import com.FR.Utility.HighlightElement;

public class FindAFlightPage extends TestNGListeners {
	
	WebDriver driver;
	//private Logger logger = Logger.getLogger("devpinoyLogger");
	
	@FindBy(how=How.XPATH,using="//input[@name='tripType'][@value='oneway']")
	private WebElement oneWayTrip;
	
	@FindBy(how=How.NAME,using="fromPort")
	private WebElement departureFrom;
	
	@FindBy(how=How.NAME,using="toPort")
	private WebElement arrivalTo;
	
	@FindBy(how=How.XPATH,using="//input[@name='servClass'][@value='First']")
	private WebElement firstClass;
	
	@FindBy(how=How.NAME,using="airline")
	private WebElement airlinePref;
	
	@FindBy(how=How.NAME,using="findFlights")
	private WebElement continue1;
	
	
	public FindAFlightPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectTripType() {
		try {
		logger.info("Selecting 'one way' trip type");
		HighlightElement.highlihghtElement(driver, oneWayTrip);
		oneWayTrip.click();
		logger.info("Selected 'one way' trip type successfully");
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while selecting 'one way' trip type : "+ex.getMessage());
		}
	}
	
	public void selectDepatingFrom(String flyfrom) {
		try {
		logger.info("Selecting '"+flyfrom+"' from 'Departing From' drop down");
		HighlightElement.highlihghtElement(driver, departureFrom);
		Select flyFrom = new Select(departureFrom);
		flyFrom.selectByVisibleText(flyfrom);
		logger.info("Selected '"+flyfrom+"' from 'Departing From' drop down successfully");
		}catch(NoSuchElementException ex) {
			logger.error(" Exception occurred while selecting '"+flyfrom+"' from 'Departing From' drop down : "+ex.getMessage());
		}
	}
	
	public void selectArrivingIn(String flyto) {
		try {
		logger.info("Selecting '"+flyto+"' from 'Arriving In' drop down");
		HighlightElement.highlihghtElement(driver, arrivalTo);
		Select flyTo = new Select(arrivalTo);
		flyTo.selectByVisibleText(flyto);
		logger.info("Selected '"+flyto+"' from 'Arriving In' drop down successfully");
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while selecting '"+flyto+"' from 'Arriving In' drop down : "+ex.getMessage());
		}
	}
	
	
	public void selectClassPreference() {
		try {
		logger.info("Selecting 'First' class preference");
		HighlightElement.highlihghtElement(driver, firstClass);
		firstClass.click();
		logger.info("Selected 'First' class preference successfully");
		}catch(Exception ex) {
			logger.error("Exception occurred while selecting 'First' class preference : "+ex.getMessage());
		}
	}
	
	public void selectAirlinePreference(String airline) {
		try {
		logger.info("Selecting '"+airline+"' from 'Airline' drop down");
		HighlightElement.highlihghtElement(driver, airlinePref);
		Select airlinePreference = new Select(airlinePref);
		airlinePreference.selectByVisibleText(airline);
		logger.info("Selected '"+airline+"' from 'Airline' drop down successfully");
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while selecting '"+airline+"' from 'Airline' drop down : "+ex.getMessage());
		}
	}
	
	public void clickOnFindFlights() {
		try {
		logger.info("Clicking on 'Find Flights'");
		HighlightElement.highlihghtElement(driver, continue1);
		continue1.click();
		logger.info("Clicked on 'Find Flights' successfully");
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while clicking on 'Find Flights' : "+ex.getMessage());
		}
	}
	
	
	
	
}
