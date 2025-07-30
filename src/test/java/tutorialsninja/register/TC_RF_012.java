package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_012 {
	WebDriver driver;
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void verifyRegisteringAccountUsingKeyboardKeys() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Actions actions = new Actions(driver);
		
		for(int i=1;i<=23;i++) {
			actions.sendKeys(Keys.TAB).perform();
		}
		
		actions.sendKeys("Akshata").pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("Potale")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(2)).sendKeys(CommonUtils.generateNewEmail())
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("98989898989")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("akshata")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("akshata")
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER)
		.build().perform();
		
		Assert.assertTrue(driver.findElement(By.xpath("//aside[@id=\"column-right\"]/div/a[text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//li/a[text()='Success']")).isDisplayed());
		
	}
}
