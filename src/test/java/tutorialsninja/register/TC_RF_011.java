package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC_RF_011 {
	WebDriver driver;
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void verifyRegisteringAccountUsingInvalidPhoneNumber() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Akshata");
		driver.findElement(By.id("input-lastname")).sendKeys("Potale");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("abcdefg");
		driver.findElement(By.id("input-password")).sendKeys("Akshata@2202");
		driver.findElement(By.id("input-confirm")).sendKeys("Akshata@2202");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedTelephoneError = "Telephone number doesnot appear to be valid";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedTelephoneError);
	
		

	}
	public String generateNewEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
	}

}
