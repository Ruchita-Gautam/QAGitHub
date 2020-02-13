package test; //Home Work - Assignment Number 2:

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.Assert;

public class UserCanMakeDeposits {
	@Test
	public void UserCanMakeDeposit () throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://techfios.com/test/billing/?ng=admin/");
    	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("techfiosdemo@gmail.com");
    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
    	driver.findElement(By.xpath("//button[@name='login']")).click();
    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();
    	driver.findElement(By.xpath("//a[contains(text(), 'Add Deposit')]")).click();
    	
    	//Line below is for selecting an option from the drop-down box:
    	driver.findElement(By.xpath("//option[@value='saving123']")).click();
    	
    	driver.findElement(By.xpath("//input[@id='description']")).sendKeys("My House-Loan Payment!!");	
    	driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("2000");
    	driver.findElement(By.xpath("//button[@id='submit']")).click();
    	
    	String depositValidatorXpath = "//a[contains(text(), 'My House-Loan Payment!!')]";	
    	String expectedTitle = "My House-Loan Payment!!";
    	String actualTitle = driver.findElement(By.xpath(depositValidatorXpath)).getText();
    	
    	Assert.assertEquals("No Deposit Made!", expectedTitle, actualTitle);
    	
    	WebDriverWait wait = new WebDriverWait (driver, 10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(depositValidatorXpath)));
    		
    	Thread.sleep(5000);
    	driver.close();
    	driver.quit();   	
	}	
}