package sessionFour;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleIFrame {
	@Test
	public void handleIFrame() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //this instantiate the Chrome Driver. It launches the Chrome Driver.
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		Thread.sleep(2000);	
		
		//To find out how many frames we have:
		//We don't know whether the developers are calling it frame or iframe
		//Use the codes below to know the number of frames and one of it will fail because the tagname is either frame or iframe
		//System.out.println(driver.findElement(By.tagName("iframe")).getSize());//This one failed so we know the tagname is not iframe
//		System.out.println(driver.findElement(By.tagName("frame")).getSize());//This is getting passed but it is still not giving us the correct number of frames we have.

//		driver.switchTo().frame(1);It has failed here, so we know Java Applet is not in frame number 1.
		
//		driver.switchTo().frame(2);//It has passed here, so we know Java Applet is frame number 2.
		
//      We can also use the name of the frames as mentioned in the DOM screen: It should be the unique names or IDs.
		driver.switchTo().frame("packageListFrame");
		Thread.sleep(2000);

//      Providing the explicit wait here:
		new WebDriverWait (driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("java.applet")));
		
		driver.findElement(By.linkText("java.applet")).click();
		
		driver.switchTo().defaultContent();
		
//		driver.switchTo().frame(1);
//	    using the name of the frames in the line below rather than the index numbers:
		driver.switchTo().frame("packageFrame");
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("AppletContext")).click();
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();		
	}
}