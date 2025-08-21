package tutorialsninja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utils.CommonUtils;

public class TC_RF_010 extends Base{
	
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
		prop = CommonUtils.loadProperties();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}


	@Test
	public void verifyRegisteringAccountUsingInvalidEmailAddress() throws IOException, InterruptedException {
		
		String browserName = "firefox";
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailOne"));
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(2000);		
		if(browserName.equals("chrome")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("validationMessage"), "Please include an '@' in the email address. 'akshatap261' is missing an '@'.");
		}else if(browserName.equals("edge")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("validationMessage"), "Please include an '@' in the email address. 'akshatap261' is missing an '@'.");
		}else if(browserName.equals("firefox")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("validationMessage"), "Please enter an email address.");
		}
		
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailTwo"));
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		if(browserName.equals("chrome")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("validationMessage"), "Please enter a part following '@'. 'akshatap261@' is incomplete.");
		}else if(browserName.equals("edge")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("validationMessage"), "Please enter a part following '@'. 'akshatap261@' is incomplete.");
		}else if(browserName.equals("firefox")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("validationMessage"), "Please enter an email address.");
		}
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailThree"));
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), "E-Mail Address does not appear to be valid!");
		
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailFour"));
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		if(browserName.equals("chrome")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("validationMessage"), "'.' is used at a wrong position in 'gmail.'.");
		}else if(browserName.equals("edge")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("validationMessage"), "'.' is used at a wrong position in 'gmail.'.");
		}else if(browserName.equals("firefox")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("validationMessage"), "Please enter an email address.");
		}
		
		driver.quit();
				
	}
	

}
