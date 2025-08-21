package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_016 extends Base{
	
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}	
	}
	
	@BeforeMethod
	public void setup() {
		
		driver = openBrowserAndApplication();
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	@Test
	public void verifyingRegisteringWithOnlySpace() {
		
		driver.findElement(By.id("input-firstname")).sendKeys(" ");
		driver.findElement(By.id("input-lastname")).sendKeys(" ");
		driver.findElement(By.id("input-email")).sendKeys(" ");
		driver.findElement(By.id("input-telephone")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.id("input-confirm")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualFirstNameError = "First Name must be between 1 and 32 characters!";
		String actualLastNameError ="Last Name must be between 1 and 32 characters!";
		String actualEmailerror="E-Mail Address does not appear to be valid!";
		String actualTelephoneError ="Telephone must be between 3 and 32 characters!";
		String actualPasswordError = "Password must be between 4 and 20 characters!";
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-firstname\"]/following-sibling::div")).getText(), actualFirstNameError);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-lastname\"]/following-sibling::div")).getText(), actualLastNameError);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-email\"]/following-sibling::div")).getText(), actualEmailerror);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-telephone\"]/following-sibling::div")).getText(), actualTelephoneError);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-password\"]/following-sibling::div")).getText(), actualPasswordError);
		
		driver.quit();






	}

}
