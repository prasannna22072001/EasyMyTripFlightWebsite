package Prasanna.TicketBookingWebsite;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBooklingPOM extends AbsrtactComponent {

	WebDriver driver;
	String details;
	
	public FlightBooklingPOM(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='loading']")
	WebElement loadingImg;

	@FindBy(id = "spnCpMsg")
	WebElement text1;

	@FindBy(xpath = "//span[@class='txt-r5']")
	List<WebElement> flightNumber;

	@FindBy(xpath = "//div[@class='txt-r6-n ng-scope']/span")
	List<WebElement> flightCost;

	public void flights() {

		waitForElementToDisappear(loadingImg);

		List<String> FNumber = flightNumber.stream().map(a -> a.getText()).collect(Collectors.toList());

		List<String> CostNumber = flightCost.stream().map(r -> r.getText()).collect(Collectors.toList());

		for (int i = 0; i <= FNumber.size() - 1; i++) {

			details = "Flight number is " + FNumber.get(i) + " and it costs ruppes " + CostNumber.get(i);
			System.out.println(details);
		}
		
	}
	
	public void clickflight(String FlightNumber) {
		
		WebElement flight = flightNumber.stream().filter(p->p.getText().equalsIgnoreCase(FlightNumber)).findFirst().orElse(null);
		flight.findElement(By.xpath("parent::div/parent::div/parent::div/following-sibling::div[5]/button[@ng-click='SelectedFlight_L(s)']")).click();
	}

}
