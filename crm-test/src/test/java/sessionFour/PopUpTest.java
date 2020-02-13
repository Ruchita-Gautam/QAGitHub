package sessionFour;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpTest {
	
	@Test
	public void handlePopUp() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver(); //this instantiate the Chrome Driver. It launches the Chrome Driver.
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//  Go to Rediff Site
//  Click on the go button
//  Close the popup
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	
//  WebDriver Wait - Explicit Wait:
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@name='loginform']/descendant::input[@type='submit']")));

	
//  XPath:
//	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
//  XPath Axsis:
	driver.findElement(By.xpath("//form[@name='loginform']/descendant::input[@type='submit']")).click();
	Thread.sleep(3000);
	
//  How do you handle a Pop-Up? Ans: Driver.SwitchTo.
	driver.switchTo().alert().accept();
	}
}