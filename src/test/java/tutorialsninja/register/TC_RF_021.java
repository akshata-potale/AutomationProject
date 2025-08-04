package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_021 {
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void verifyRegisteringAccountWithoutPrivacyPolicySelection() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Akshata");
		driver.findElement(By.id("input-lastname")).sendKeys("Potale");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9878776767");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String privacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), privacyPolicyWarning);
		
		


	}

}
