package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;

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
import utils.CommonUtils;

public class TC_RF_003 extends Base{
	WebDriver driver;
	Properties prop;

	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}	
	}
	
	@BeforeMethod
	public void setup() {
		
		driver = openBrowserAndApplication();
		prop=CommonUtils.loadProperties();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Test
	public void verifyRegisterAccountWithAllMandatoryFields() {
				
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
		
		String actualProperDetailOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDetailTwo ="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailThree ="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailFour ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		
		String expectedProperDetails = driver.findElement(By.id("content")).getText();
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailFour));
		
		
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}


}
