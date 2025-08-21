package tutorialsninja.register;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.CommonUtils;

public class TC_RF_018 extends Base{
	
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
	public void veifyRegisteringAccountFieldsHeightWidthAllignment() throws IOException, InterruptedException {
		String browserName = "firefox";

		String expectedHeight = "34px";
		String expectedWidth = "701.25px";
		
		WebElement firstNameField = driver.findElement(By.id("input-firstname"));
		String actualFirstnameFieldHeight = firstNameField.getCssValue("height");
		String actualFirstnameFieldWidth = firstNameField.getCssValue("width");
		Assert.assertEquals(actualFirstnameFieldHeight, expectedHeight);
		Assert.assertEquals(actualFirstnameFieldWidth, expectedWidth);
		
		firstNameField.sendKeys("");
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueButton.click();
		String expectedWarning = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedWarning);

		firstNameField = driver.findElement(By.id("input-firstname"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		firstNameField.sendKeys("a");
		continueButton.click();
		try {
			  Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			  Assert.assertTrue(true);
		}
		
		firstNameField = driver.findElement(By.id("input-firstname"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		firstNameField.clear();
		firstNameField.sendKeys("abcdefghijklmnopabcdefghijklmnop");
		continueButton.click();
		try {
			  Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			  Assert.assertTrue(true);
		}		
		
		firstNameField = driver.findElement(By.id("input-firstname"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		firstNameField.clear();
		firstNameField.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedWarning);

		//-----------------------------------------------------
		WebElement lastnameField = driver.findElement(By.id("input-lastname"));
		String actualLastnameFieldHeight = lastnameField.getCssValue("height");
		String actualLastnameFieldWidth = lastnameField.getCssValue("width");
		Assert.assertEquals(actualLastnameFieldHeight, expectedHeight);
		Assert.assertEquals(actualLastnameFieldWidth, expectedWidth);
		
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastnameField.sendKeys("");
		continueButton.click();
		expectedWarning = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedWarning);

		lastnameField = driver.findElement(By.id("input-lastname"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastnameField.sendKeys("a");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
		lastnameField = driver.findElement(By.id("input-lastname"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastnameField.clear();
		lastnameField.sendKeys("abcdefghijklmnopabcdefghijklmnop");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
		lastnameField = driver.findElement(By.id("input-lastname"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		lastnameField.clear();
		lastnameField.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedWarning);

		//-----------------------------------------------------------
		
		WebElement emailField = driver.findElement(By.id("input-email"));
		String actualEmailFieldHeight = emailField.getCssValue("height");
		String actualEmailFieldWidth = emailField.getCssValue("width");
		Assert.assertEquals(actualEmailFieldHeight, expectedHeight);
		Assert.assertEquals(actualEmailFieldWidth, expectedWidth);
		
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		emailField.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz@gmail.com");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		//-----------------------------------------------------------
		
		WebElement telephoneField = driver.findElement(By.id("input-telephone"));
		String actualTelephoneFieldHeight = telephoneField.getCssValue("height");
		String actualTelephoneFieldWidth = telephoneField.getCssValue("width");
		Assert.assertEquals(actualTelephoneFieldHeight, expectedHeight);
		Assert.assertEquals(actualTelephoneFieldWidth, expectedWidth);
		Thread.sleep(2000);
//		
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.sendKeys("");
		continueButton.click();
		expectedWarning = "Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedWarning);

		telephoneField = driver.findElement(By.id("input-telephone"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.sendKeys("a");
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedWarning);
		
		telephoneField = driver.findElement(By.id("input-telephone"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("ab");
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedWarning);
		
		telephoneField = driver.findElement(By.id("input-telephone"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("abc");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		telephoneField = driver.findElement(By.id("input-telephone"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("abcdefghij");
		continueButton.click();
		
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
		telephoneField = driver.findElement(By.id("input-telephone"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("abcdefghijklmnopqrstuvwxyzabcdef");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
		telephoneField = driver.findElement(By.id("input-telephone"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		telephoneField.clear();
		telephoneField.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefgh");
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedWarning);

//		//------------------------------------------------------------------------
//		
		WebElement passwordField = driver.findElement(By.id("input-password"));
		String actualPasswordFieldHeight = passwordField.getCssValue("height");
		String actualPasswordFieldWidth = passwordField.getCssValue("width");
		Assert.assertEquals(actualPasswordFieldHeight, expectedHeight);
		Assert.assertEquals(actualPasswordFieldWidth, expectedWidth);
		
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("");
		continueButton.click();
		expectedWarning = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedWarning);

		passwordField = driver.findElement(By.id("input-password"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("a");
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedWarning);
		
		passwordField = driver.findElement(By.id("input-password"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("abc");
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedWarning);
		
		passwordField = driver.findElement(By.id("input-password"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("abcd");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
		passwordField = driver.findElement(By.id("input-password"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("abcde");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
		passwordField = driver.findElement(By.id("input-password"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("abcdefghij");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
		passwordField = driver.findElement(By.id("input-password"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("abcdefghijabcdefghi");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
		passwordField = driver.findElement(By.id("input-password"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("abcdefghijabcdefghij");
		continueButton.click();
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		
		passwordField = driver.findElement(By.id("input-password"));
		continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		passwordField.clear();
		passwordField.sendKeys("abcdefghijabcdefghijk");
		continueButton.click();
		boolean state = false;
		try {
			String actualWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
			
			if(actualWarning.equals(expectedWarning)) {
				state = true;
			}
		} catch (NoSuchElementException e) {
			state = false;
		}
		Assert.assertTrue(state);		
//		//------------------------------------------------------
//		
		String actualConfirmPasswordFieldHeight = driver.findElement(By.id("input-confirm")).getCssValue("height");
		String actualConfirmPasswordFieldWidth = driver.findElement(By.id("input-confirm")).getCssValue("width");
		Assert.assertEquals(actualConfirmPasswordFieldHeight, expectedHeight);
		Assert.assertEquals(actualConfirmPasswordFieldWidth, expectedWidth);
		
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir")+"\\Screenshots\\registerPageActualAllignment.png"));
		
		
		if(browserName.equals("chrome")) {
			Assert.assertFalse(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\registerPageActualAllignment.png",
					System.getProperty("user.dir")+"\\Screenshots\\registerPageExpectedAllignment.png"));

		}else if(browserName.equals("firefox")) {
			Assert.assertFalse(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\registerPageActualAllignment.png",
					System.getProperty("user.dir")+"\\Screenshots\\registerPageFirefoxExpectedAllignment.png"));

		}else if(browserName.equals("edge")) {
			Assert.assertFalse(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\registerPageActualAllignment.png",
					System.getProperty("user.dir")+"\\Screenshots\\registerPageEdgeExpectedAllignment.png"));

		}

		driver.quit();


	}

}
