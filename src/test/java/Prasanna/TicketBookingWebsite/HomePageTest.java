package Prasanna.TicketBookingWebsite;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Prasanna.TestComponents.BaseTest;

public class HomePageTest extends BaseTest {

//	String FlightNumber="AI-502";
//	String month ="MAR 2024";
//	String date = "18";
//	String FromCity = "New Delhi(DEL)";
//	String ToCity = "(BLR)";
//	
	
	
	
	@Test(priority = 1,dataProvider="getData")
	public void testcase1(HashMap<String,String> input) throws InterruptedException {

		HomePagePOM HPage = new HomePagePOM(driver);
		HPage.travellingDe(input.get("FromCity"),input.get("ToCity"),input.get("FromEnter"),input.get("ToEnter"));
		HPage.calander(input.get("month"),input.get("date"));
		
//		HPage.travellingDe(FromCity,ToCity);
//		HPage.calander(month,date);
		HPage.passengers();


		FlightBooklingPOM flightBook = new FlightBooklingPOM(driver);
		flightBook.flights();
		flightBook.clickflight(input.get("FlightNumber"));
		
	
	
		
		FlightDetailsPagePOM flightDetails = new FlightDetailsPagePOM(driver);
		String Fnumber = flightDetails.flightFullDetails();
		Assert.assertEquals(Fnumber, input.get("FlightNumber"));
		
		flightDetails.coupons();
	
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List <HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Prasanna\\Data\\DataProviders.json");
		return new Object[][] {{data.get(0)} , {data.get(1)} };
	}

}
