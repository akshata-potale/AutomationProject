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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import utils.CommonUtils;

public class TC_RF_019 extends Base{
	
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
	public void verifyLeadingAndTrailingSpacesWhileRegisteringAccount() {
		
		SoftAssert softassert  = new SoftAssert();
		String enteredFirstname = "     Akshata     ";
		driver.findElement(By.id("input-firstname")).sendKeys(enteredFirstname);
		String enteredLastname = "     Potale     ";
		driver.findElement(By.id("input-lastname")).sendKeys(enteredLastname);
		String enteredEmail = "     "+CommonUtils.generateNewEmail()+"      ";
		driver.findElement(By.id("input-email")).sendKeys(enteredEmail);
		String enteredTelephone = "     1234567789     ";
		driver.findElement(By.id("input-telephone")).sendKeys(enteredTelephone);
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();
		driver.findElement(By.linkText("Edit your account information")).click();
		
		softassert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"), enteredFirstname.trim());
		softassert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"), enteredLastname.trim());
		softassert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("value"), enteredEmail.trim());
		softassert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"), enteredTelephone.trim());
		softassert.assertAll();







	}
}
