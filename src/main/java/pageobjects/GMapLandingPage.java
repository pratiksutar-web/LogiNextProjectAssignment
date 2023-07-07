package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GMapLandingPage {

	WebDriver driver;

	public GMapLandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='eYqqWd vF7Cdb']")
	WebElement directionsButton;

	@FindBy(xpath = "(//input[@class='tactile-searchbox-input'])[1]")
	WebElement startingPointField;

	@FindBy(xpath = "(//input[@class='tactile-searchbox-input'])[2]")
	WebElement destinationField;
	
	@FindBy(css="h1[id='section-directions-trip-title-0']")
	WebElement firstSearchResultOption;

	@FindBy(css="button[class='J45yZc Jb8x7e']")
	WebElement printOptionButton;
	
	@FindBy(xpath="//button[@class='XFJTCb'][1]")
	WebElement printInclMapButton;
	
	@FindBy(css="button[class='L6gKoc Ab1Xue IdAxLe']")
	WebElement finalPrintButton;
	
	@FindBy(xpath="//html/body")
	WebElement bodyText;
	
	
	public WebElement directionsButton() {

		return directionsButton;

	}

	public WebElement startingPointField() {

		return startingPointField;

	}

	public WebElement destinationField() {

		return destinationField;

	}
	public WebElement firstSearchResultOption() {

		return firstSearchResultOption;

	}

	public WebElement printOptionButton() {

		return printOptionButton;

	}
	
	public WebElement printInclMapButton() {
		return printInclMapButton;
	}
	
	public WebElement finalPrintButton() {
		return finalPrintButton;
	}
	
	public WebElement bodyText() {
		return bodyText;
		
	}
}
