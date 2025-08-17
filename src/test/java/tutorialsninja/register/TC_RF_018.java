package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_018 {
	
	@Test
	public void veifyRegisteringAccountFieldsHeightWidthAllignment() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
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

		firstNameField.sendKeys("a");
		continueButton.click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		
		firstNameField.sendKeys("abcdefghijklmnopabcdefghijklmnop");
		continueButton.click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		
		
		firstNameField.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedWarning);

		//-----------------------------------------------------
		WebElement lastnameField = driver.findElement(By.id("input-lastname"));
		String actualLastnameFieldHeight = lastnameField.getCssValue("height");
		String actualLastnameFieldWidth = lastnameField.getCssValue("width");
		Assert.assertEquals(actualLastnameFieldHeight, expectedHeight);
		Assert.assertEquals(actualLastnameFieldWidth, expectedWidth);
		
		lastnameField.sendKeys("");
		continueButton.click();
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedLastNameWarning);

		lastnameField.sendKeys("a");
		continueButton.click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
		
		lastnameField.sendKeys("abcdefghijklmnopabcdefghijklmnop");
		continueButton.click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		
		
		lastnameField.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
		continueButton.click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedLastNameWarning);

		//-----------------------------------------------------------
		
		WebElement emailField = driver.findElement(By.id("input-email"));
		String actualEmailFieldHeight = emailField.getCssValue("height");
		String actualEmailFieldWidth = emailField.getCssValue("width");
		Assert.assertEquals(actualEmailFieldHeight, expectedHeight);
		Assert.assertEquals(actualEmailFieldWidth, expectedWidth);
		
		emailField.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz@gmail.com");
		continueButton.click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());

		//-----------------------------------------------------------
		//----------------------
		String actualTelephoneFieldHeight = driver.findElement(By.id("input-telephone")).getCssValue("height");
		String actualTelephoneFieldWidth = driver.findElement(By.id("input-telephone")).getCssValue("width");
		Assert.assertEquals(actualTelephoneFieldHeight, expectedHeight);
		Assert.assertEquals(actualTelephoneFieldWidth, expectedWidth);
		
		String actualPasswordFieldHeight = driver.findElement(By.id("input-password")).getCssValue("height");
		String actualPasswordFieldWidth = driver.findElement(By.id("input-password")).getCssValue("width");
		Assert.assertEquals(actualPasswordFieldHeight, expectedHeight);
		Assert.assertEquals(actualPasswordFieldWidth, expectedWidth);
		
		
		String actualConfirmPasswordFieldHeight = driver.findElement(By.id("input-confirm")).getCssValue("height");
		String actualConfirmPasswordFieldWidth = driver.findElement(By.id("input-confirm")).getCssValue("width");
		Assert.assertEquals(actualConfirmPasswordFieldHeight, expectedHeight);
		Assert.assertEquals(actualConfirmPasswordFieldWidth, expectedWidth);
		driver.quit();


	}

}
