package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_019 {
	
	WebDriver driver;
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void verifyLeadingAndTrailingSpacesWhileRegisteringAccount() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
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
		
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"), enteredFirstname.trim());
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"), enteredLastname.trim());
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("value"), enteredEmail.trim());
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"), enteredTelephone.trim());








	}
}
