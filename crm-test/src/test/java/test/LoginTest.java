package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LoginTest {
	
	@Test
	public void validUsersShouldBeAbleToLogin () throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://techfios.com/test/billing/?ng=login/");

//      Codes written on Saturday 01/25/2020 class:
    	
//    	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("techfiosdemo@gmail.com");
//    	Thread.sleep(2000);
//    	
//    	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("abc123");
//    	Thread.sleep(2000);
//    	
//    	driver.findElement(By.xpath("//button[@type='submit']")).click();
//    	Thread.sleep(2000);
   

//      Codes written on Sunday 01/26/2020 class:
    	
        //* example in Xpath
    	driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
    	
    	//contains () example in Xpath
    	driver.findElement(By.xpath("//*[contains(@placeholder, 'assword') and contains(@class,'form-')]")).sendKeys("abc123");
    	
    	//text () example in Xpath
    	driver.findElement(By.xpath("//*[contains(text(), 'Sign in') and @name='login']")).click();
    	Thread.sleep(3000);
    	
    	//this is our element and we put it in the container called dashBoardTitleXpath
    	String dashboardTitleXpath = "//div[@id='page-wrapper']//descendant::h2[contains(text(), 'Dashboard')]";
    	
    	Thread.sleep(3000);
    	
    	//To check whether expected title and actual title are same or not...
    	String expectedTitle = "Dashboard- TechFios Test Application - Billing";
    	
    	String actualTitle = driver.getTitle();
    	
//    	if(expectedTitle.equalsIgnoreCase(actualTitle)) {
//    		
//    		System.out.println("Test Passed!!");
//    	}else {
//    		
//    		System.out.println("Dashboard did not display!");
//    		
//    		throw new RuntimeException("Test Failed!");
//    	}
    	
    	//The code below is doing the same thing as the above if-else statement, but this code is using the class 
    	//called Assert.
    	Assert.assertEquals("Dashboard did not display!", expectedTitle, actualTitle);
    	
    	
    	//Explicit Wait:
    	WebDriverWait wait = new WebDriverWait(driver,10); 	
    	
    	//This code is checking whether the Dashboard title is visible or not...
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardTitleXpath)));
    	
    	//below code is for achieving the same results as above but it does not work for some reason..
//    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(dashboardTitleXpath))));
    	
    	//below code is same as the one in line number 52...where we are instantiating WeBDriverWait in the same line...
//    	new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath( dashBoardTitleXpath)));
    	
    	Thread.sleep(3000);
    	driver.close();
    	driver.quit();
		
	}

}
