package com.FR.TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.FR.ExcelInteraction.ExcelInteraction;
import com.FR.Listeners.TestNGListeners;
import com.FR.PageFactory.BookAFlightPage;
import com.FR.PageFactory.BookingConfirmationPage;
import com.FR.PageFactory.FindAFlightPage;
import com.FR.PageFactory.LoginPage;
import com.FR.PageFactory.ReserveAFlightPage;
import com.FR.Utility.Constant;

public class ExecuteTest extends TestNGListeners{
	
	LoginPage loginPage;
	FindAFlightPage findAFlightPage;
	ReserveAFlightPage reserveAFlightPage;
	BookAFlightPage bookAFlightPage;
	BookingConfirmationPage bookingConfirmationPage;
	ExcelInteraction excel;
	
	
	@Test(priority=0)
	public void verifyLaunchApplication() {
		System.out.println(driver);		
		driver.get(p.getProperty("url"));
		excel = new ExcelInteraction(Constant.testDataPath,Constant.testDataFile);
		String expTitle = excel.getCellData("LaunchApplication", 1, 0);
		Assert.assertEquals(driver.getTitle(), expTitle);
		excel.closeInputStream();
		excel.closeWorkbook();
		
	}
	
	@Test(priority=0)
	public void verifylogin() {
		excel = new ExcelInteraction(Constant.testDataPath,Constant.testDataFile);
		String username = excel.getCellData("Login", 1, 0);
		String password = excel.getCellData("Login", 1, 1);
		String expTitle = excel.getCellData("Login", 1, 2);
		loginPage = new LoginPage(driver);
		// ENter UserName
		loginPage.enterUserName(username);
		// Enter Password
		loginPage.enterPassword(password);
		// Click on Sign In
		loginPage.clickOnSignIn();
		// Verify Page Title
		Assert.assertEquals(driver.getTitle(),expTitle);
		}
	
	@Test(priority=2)
	public void verifyTicketBooking() {
		excel = new ExcelInteraction(Constant.testDataPath,Constant.testDataFile);
		String flyfrom = excel.getCellData("BookATicket", 1, 0);
		String flyto = excel.getCellData("BookATicket", 1, 1);
		String airlinePref = excel.getCellData("BookATicket", 1, 2);
		String firstname = excel.getCellData("BookATicket", 1, 3);
		String lastname = excel.getCellData("BookATicket", 1, 4);
		String ccnumber = excel.getCellData("BookATicket", 1, 5);
		String confText = excel.getCellData("BookATicket", 1, 6);
		
		findAFlightPage = new FindAFlightPage(driver);
		// Select Trip Type
		findAFlightPage.selectTripType();
		// Select Departure From
		findAFlightPage.selectDepatingFrom(flyfrom);
		// Select Arrival To
		findAFlightPage.selectArrivingIn(flyto);
		// Select Class Preference
		findAFlightPage.selectClassPreference();
		// Select Airline Preference
		findAFlightPage.selectAirlinePreference(airlinePref);
		// Click on 'CONTINUE'
		findAFlightPage.clickOnFindFlights();
		
		reserveAFlightPage = new ReserveAFlightPage(driver);
		// Reserve A Flight
		reserveAFlightPage.clickOnReserveFlight();
		
		bookAFlightPage = new BookAFlightPage(driver);
		// Enter First Name
		bookAFlightPage.enterFirstName(firstname);
		// ENter Last Name
		bookAFlightPage.enterLastName(lastname);
		// Enter Credit Card Number
		bookAFlightPage.enterCreditNumber(ccnumber);
		// Click on 'SECURE PURCHASE'
		bookAFlightPage.clickOnBuyFlights();
		
		// Verify Booking Confirmation Text
		bookingConfirmationPage = new BookingConfirmationPage(driver);
		Assert.assertTrue(bookingConfirmationPage.getConfirmationText().contains(confText));
		
		
		
	}
	
	

}
