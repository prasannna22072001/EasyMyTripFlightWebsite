package Prasanna.TicketBookingWebsite;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightDetailsPagePOM extends AbsrtactComponent {

	WebDriver driver;
	String details;
	
	public FlightDetailsPagePOM(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@ng-bind=\"l.airCode+'-'+l.fltNum\"])[1]")
	WebElement flightNumber;

	
	@FindBy(id="easeFareDetails1_promodiv")
	WebElement content;
	
	
	
	public String flightFullDetails() {
		
		String Flight_number = flightNumber.getText();
		return Flight_number;
	}
	
	public void coupons() {
		
		for(int i =1; i<=4; i++) {
			 if (i == 3) {
	                // Skip this iteration
	                continue;
	            }
			driver.findElement(By.xpath("(//span[@class='coupn_checkmark'])["+i+"]")).click();
			String CouponContent = content.getText();
			System.out.println(CouponContent);
		}
	}
	
	

	
}
