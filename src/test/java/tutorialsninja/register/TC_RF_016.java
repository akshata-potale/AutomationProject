package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_016 {
	
	@Test
	public void verifyingRegisteringWithOnlySpace() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys(" ");
		driver.findElement(By.id("input-lastname")).sendKeys(" ");
		driver.findElement(By.id("input-email")).sendKeys(" ");
		driver.findElement(By.id("input-telephone")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.id("input-confirm")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualFirstNameError = "First Name must be between 1 and 32 characters!";
		String actualLastNameError ="Last Name must be between 1 and 32 characters!";
		String actualEmailerror="E-Mail Address does not appear to be valid!";
		String actualTelephoneError ="Telephone must be between 3 and 32 characters!";
		String actualPasswordError = "Password must be between 4 and 20 characters!";
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-firstname\"]/following-sibling::div")).getText(), actualFirstNameError);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-lastname\"]/following-sibling::div")).getText(), actualLastNameError);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-email\"]/following-sibling::div")).getText(), actualEmailerror);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-telephone\"]/following-sibling::div")).getText(), actualTelephoneError);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"input-password\"]/following-sibling::div")).getText(), actualPasswordError);
		
		driver.quit();






	}

}
