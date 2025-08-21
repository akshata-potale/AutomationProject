package tutorialsninja.register;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

public class TC_RF_026 extends Base{
	
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
	public void verifyUIOfregisterAccountPage() {
	
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterPageUi.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterPageUi.png", System.getProperty("user.dir")+"\\Screenshots\\expectedRegisterPageUi.png"));

		driver.quit();

	}

}
