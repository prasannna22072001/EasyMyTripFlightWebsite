package Prasanna.TicketBookingWebsite;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {

	WebDriver driver;

	public HomePagePOM(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "FromSector_show")
	WebElement from;

	@FindBy(id = "a_FromSector_show")
	WebElement fromText;

	@FindBy(xpath = "//span[@class='flsctrhead']")
	List<WebElement> fromList;

	@FindBy(id = "a_Editbox13_show")
	WebElement toText;

	@FindBy(xpath = "(//div[@class='month2'])[1]")
	WebElement month;

	@FindBy(id = "img2Nex")
	WebElement clickbutton;

	@FindBy(xpath = "//div[@class='box']/div[@class='days']/ul/li[@onclick='SelectDate(this.id)']")
	List<WebElement> dates;

	@FindBy(id = "ptravlrNo")
	WebElement passengersbutton;

	@FindBy(xpath = "//div[@id='field1']/button[@id='add']")
	WebElement adults;

	@FindBy(xpath = "//div[@id='field2']/button[@id='add']")
	WebElement children;

	
	@FindBy(id="traveLer")
	WebElement DoneButton;
	
	
	@FindBy(xpath="//button[@class='srchBtnSe']")
	WebElement searchButton;
	
	public void travellingDe(String from_city , String to_city, String FromEnter, String ToEnter) throws InterruptedException {
		from.click();
		fromText.sendKeys(FromEnter);
		Thread.sleep(2000);

		WebElement fromcity = fromList.stream().filter(a -> a.getText().equalsIgnoreCase(from_city)).findFirst()
				.orElse(null);
		fromcity.click();

		toText.sendKeys(ToEnter);
		Thread.sleep(2000);
		WebElement tocity = fromList.stream().filter(w -> w.getText().contains(to_city)).findFirst().orElse(null);
		tocity.click();

	}

	public void calander(String monthnela , String date) throws InterruptedException {

		// String monthName = month.getText();

		while (!month.getText().equalsIgnoreCase(monthnela)) {

			clickbutton.click();

		}
		Thread.sleep(3000);

		List<String> alldates = dates.stream().map(e -> e.getText()).collect(Collectors.toList());
		alldates.forEach(r -> System.out.println(r));

		WebElement specificdate = dates.stream().filter(e -> e.getText().contains(date)).findFirst().orElse(null);
		specificdate.click();
	}

	public void passengers() throws InterruptedException {

		passengersbutton.click();
		Thread.sleep(3000);

		for (int i = 0; i < 3; i++) {
			adults.click();
			if (i < 2) {
				children.click();
			}
		}
		
		DoneButton.click();
		searchButton.click();
	}

}
