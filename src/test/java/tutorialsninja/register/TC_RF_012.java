package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.CommonUtils;

public class TC_RF_012 extends Base{
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
	public void verifyRegisteringAccountUsingKeyboardKeys() {
				
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
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).pause(Duration.ofSeconds(3))
		.build().perform();
		
		

		Assert.assertTrue(driver.findElement(By.xpath("//aside[@id='column-right']/div/a[text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//li/a[text()='Success']")).isDisplayed());
		
	}
}
