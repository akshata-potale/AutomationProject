package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_014 {
	
	@Test
	public void verifyMandatoryFieldsSymbolAndColorInRegisterAccountPage() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for=\"input-firstname\"]"));
		String expectedFnContent = "\"* \"";
		
		
		String expectedFnColor = "rgb(255, 0, 0)";
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String fnContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstNameLabel);
		System.out.println(fnContent);
		
		String fnColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
		System.out.println(fnColor);
		
		Assert.assertEquals(fnContent, expectedFnContent);
		Assert.assertEquals(fnColor, expectedFnColor);
		
		driver.quit();


		
		
	}

}
