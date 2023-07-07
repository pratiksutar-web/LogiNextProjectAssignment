package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.GMapLandingPage;
import resources.Base;
import resources.WriteToExcelFile;


public class GoogleMapRouteTest extends Base {
	WebDriver driver;

	
	@BeforeMethod
	public void openApplication() throws IOException {
		driver = intializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test 
	public void gMapRoute() throws IOException, InterruptedException, AWTException {
		
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		
		GMapLandingPage gmaplpage = new GMapLandingPage(driver);
		gmaplpage.directionsButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(gmaplpage.startingPointField()));
		gmaplpage.startingPointField().sendKeys(prop.getProperty("startingPoint"));
		Thread.sleep(3000);
		gmaplpage.startingPointField().sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(gmaplpage.destinationField()));
		gmaplpage.destinationField().sendKeys(prop.getProperty("destinationPoint"));
		Thread.sleep(5000);
		gmaplpage.destinationField().sendKeys(Keys.DOWN);
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(gmaplpage.firstSearchResultOption()));
		gmaplpage.firstSearchResultOption().click();
		Thread.sleep(4000);
		gmaplpage.printOptionButton().click();
		gmaplpage.printInclMapButton().click();
		gmaplpage.bodyText().getText();
		
		String content = gmaplpage.bodyText().getText();
		Thread.sleep(3000);
		
		WriteToExcelFile excelFile = new WriteToExcelFile(content);
		excelFile.WriteDataToExcelFile();
		
		
		
		


		
	
		
	}
	
	
	@AfterMethod
	public void closeApplication() throws IOException {
		File srcPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\screenshots\\GMapRoute.png";
		FileUtils.copyFile(srcPath, new File(destinationPath));
		
		driver.close();
	}
	
}
