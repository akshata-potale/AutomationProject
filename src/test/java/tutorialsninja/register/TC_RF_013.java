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

public class TC_RF_013 extends Base{
	
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
	public void verifyPlaceHoldersOfTextFieldsInRegisterAccountPage() {
						
			String expectedFirstNamePlaceHolderText = "First Name";
			Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"), expectedFirstNamePlaceHolderText);
			
			String expectedLastNamePlaceHolderText = "Last Name";
			Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"), expectedLastNamePlaceHolderText);
			
			String expectedEmailPlaceHolderText = "E-Mail";
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"), expectedEmailPlaceHolderText);
		
			String expectedTelephonePlaceHolderText = "Telephone";
			Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"), expectedTelephonePlaceHolderText);
		
			String expectedPasswordPlaceHolderText = "Password";
			Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"), expectedPasswordPlaceHolderText);
			
			String expectedPasswordConfirmPlaceHolderText = "Password Confirm";
			Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"), expectedPasswordConfirmPlaceHolderText);
			
			driver.quit();
			
		}


}
