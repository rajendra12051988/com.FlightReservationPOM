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

public class BookingConfirmationPage extends TestNGListeners {
	//private Logger logger = Logger.getLogger("devpinoyLogger");
	
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//font[@size='+1']")
	private WebElement confText;
	
	
	public BookingConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String getConfirmationText() {
		try {
		logger.info("Fetching booking confirmation text");
		HighlightElement.highlihghtElement(driver, confText);
		logger.info("Fetched booking confirmation text successfully");
		return confText.getText().trim();
		
		}catch(NoSuchElementException ex) {
			logger.error("Exception occurred while fetching booking confirmation text : "+ex.getMessage());
			return null;
		}
	}

}
