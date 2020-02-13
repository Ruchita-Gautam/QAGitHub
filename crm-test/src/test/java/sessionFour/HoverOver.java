package sessionFour;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverOver {
	WebDriver driver;	
	@Before
	public void launchBrowser () {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver(); //this instantiate the Chrome Driver. It launches the Chrome Driver.
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get("https://www.dell.com/en-us");
	}
	@Test
	public void hoverOverTest () throws InterruptedException {
		
//      Example: By locator = By.xpath ("aajakk");
//      driver.findElement(locator).click();
	    
//	    ELEMENT LIBRARY:
//      driver.findElement gets stored in a WebElement variable   
	    WebElement DEALS_MENU_ELEMENT = driver.findElement(By.xpath("//button[@id='l1_4']"));
	    By WORKSTATION_DEALS_LOCATOR = By.linkText("Workstation Deals");
	    
//      to use HoverOver we need to use class called Actions.
	    Actions action = new Actions (driver);   
		action.moveToElement(DEALS_MENU_ELEMENT).build().perform();
		
		driver.findElement(WORKSTATION_DEALS_LOCATOR).click();
		Thread.sleep(2000);	
	}	
	@After
	public void closeEverything () {
	driver.close();
	driver.quit();
	}
}