package sessionFour;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleNewTab {
	
	WebDriver driver;	
	@Before
	public void launchBrowser () {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver(); //this instantiate the Chrome Driver. It launches the Chrome Driver.
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get("https://www.yahoo.com/");
	}
	@Test
	public void searchForXpathInYahoo () {
		By SEARCH_FIELD_LOCATOR = By.xpath("//input[@id='header-search-input']");
		By W3_LINK_LOCATOR = By.linkText("XPath Tutorial - w3schools.com");
		By SQL_LINK_LOCATOR = By.linkText("SQL");
	//  OR
	//	By SEARCH_FIELD_LOCATOR = By.cssSelector("input#header-search-input");
	//  Xpath refers to the specific location of the element.
	//  That is why if we need to get to something specific we would be doing the linkTest
		driver.findElement(SEARCH_FIELD_LOCATOR).sendKeys("Xpath");
		driver.findElement(SEARCH_FIELD_LOCATOR).sendKeys(Keys.ENTER);	
		
        new WebDriverWait (driver, 10).until(ExpectedConditions.elementToBeClickable(W3_LINK_LOCATOR));
	
		driver.findElement(W3_LINK_LOCATOR).click();
		
		System.out.println(driver.getWindowHandle());
		
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
		
		driver.findElement(SQL_LINK_LOCATOR).click();	
		
		
	}
	@After
	public void closeEverything () {
//	driver.close();
//	driver.quit();
	}
}