package Prasanna.TicketBookingWebsite;

import org.testng.Assert;
import org.testng.annotations.Test;

import Prasanna.TestComponents.BaseTest;

public class HomePageTest extends BaseTest {

	String FlightNumber="AI-502";
	String month ="MAR 2024";
	String date = "18";
	String FromCity = "New Delhi(DEL)";
	String ToCity = "(BLR)";
	
	@Test(priority = 1)
	public void testcase1() throws InterruptedException {

		HomePagePOM HPage = new HomePagePOM(driver);
		HPage.travellingDe(FromCity,ToCity);
		HPage.calander(month,date);
		HPage.passengers();

	}

	@Test(priority = 2)
	public void testcase2() {

		FlightBooklingPOM flightBook = new FlightBooklingPOM(driver);
		flightBook.flights();
		flightBook.clickflight(FlightNumber);
	}
	
	
	
	@Test(priority=3)
	public void testcase3() {
		
		FlightDetailsPagePOM flightDetails = new FlightDetailsPagePOM(driver);
		String Fnumber = flightDetails.flightFullDetails();
		Assert.assertEquals(Fnumber, FlightNumber);
		
		flightDetails.coupons();
	
	}
	
}
