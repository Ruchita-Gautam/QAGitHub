package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VariousElements {
	
	@Test //JUnit to run the test 
    public void exploreVariousElements () throws InterruptedException {
    	
		//Put codes in sequence!!
		
    	//Set Chrome Driver as you default Driver
    	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    	
    	//Create an object for Chrome Driver, i.e. instantiate ChromeDriver object. This will open the browser.
    	WebDriver driver = new ChromeDriver();
    	
    	//Implicit Wait
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	//Delete cookies and history
    	driver.manage().deleteAllCookies();
    	
    	//Maximize Browser Window
    	driver.manage().window().maximize();
    	
    	//How to go to a Website
    	driver.get("http://objectspy.space/");
    	
    	//Slow Down Java 1000 ms = 1 sec
    	Thread.sleep(3000); //it will wait for 3 seconds
    	
    	//Click on Radio Button Male // Finding it by ID:
    	driver.findElement(By.id("sex-0")).click();
    	Thread.sleep(3000); 
    	
    	//Type something in fields // Finding it by Input:
    	driver.findElement(By.name("firstname")).sendKeys("Ruchita");
    	Thread.sleep(3000); 
    	
    	//click on Link Text // Finding by Link Text:
//    	driver.findElement(By.linkText("Link Test : New Page")).click();
//    	Thread.sleep(3000); 
    	
    	//click on Partial Link // Finding by Partial Link Text:
    	driver.findElement(By.partialLinkText("OS-API Product FrontEnd")).click();
    	Thread.sleep(3000); 
    	
    	//click on ClassName // Finding by Class Name:
//    	driver.findElement(By.className("control-group")).click();
//    	Thread.sleep(3000); 
   	
    	//Close the browser
    	driver.close();
    	
    	//Quit the driver
    	driver.quit();
    	

    	
    	
    	
    	
    }
	
	
	
	

}