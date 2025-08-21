package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import utils.CommonUtils;

public class TC_RF_017 extends Base{
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
	
	@Test (dataProvider="PasswordProvider")
	public void verifyRegisteringAccountAndCheckingPasswordComplexityStandards(String passwordText) {
		driver.findElement(By.id("input-firstname")).sendKeys("Akshata");
		driver.findElement(By.id("input-lastname")).sendKeys("Potale");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9878776767");
		driver.findElement(By.id("input-password")).sendKeys(passwordText);
		driver.findElement(By.id("input-confirm")).sendKeys(passwordText);
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String warningMessage = "Password entered doesnot match with Complexity Standards";
		
		Boolean state = false;
		try {
			String actualWarningMessage = driver.findElement(By.xpath("//input[@id=\"input-password\"]/following-sibling::div")).getText();
			if(actualWarningMessage.equals(warningMessage)) {
				state = true;
			}
		}catch(NoSuchElementException e) {
			state = false;
		}
		Assert.assertTrue(state);
		Assert.assertFalse(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
	}
	
	@DataProvider(name = "PasswordProvider")
	public Object[][] supplyPasswords() {
		
		Object[][] data = {{"12345"},{"abcdefghi"},{"abcd1234"},{"abcde123#"},{"ABCDE123@"}};
		return data;
		
	}

}
