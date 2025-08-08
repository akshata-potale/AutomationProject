package tutorialsninja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 {
	@Test
	public void verifyRegisteringAccountUsingInvalidEmailAddress() throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Akshata");
		driver.findElement(By.id("input-lastname")).sendKeys("Potale");
		driver.findElement(By.id("input-email")).sendKeys("akshatap261");
		driver.findElement(By.id("input-telephone")).sendKeys("9786565434342");
		driver.findElement(By.id("input-password")).sendKeys("Akshata@2202");
		driver.findElement(By.id("input-confirm")).sendKeys("Akshata@2202");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(2000);		
		File srcScreenshot1 = driver.findElement(By.xpath("//form[@class=\"form-horizontal\"]")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
				
		Assert.assertFalse(compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png", System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email")));
		emailField.clear();
		
		Thread.sleep(2000);		
		driver.findElement(By.id("input-email")).sendKeys("akshatap261@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(2000);		
		File srcScreenshot2 = driver.findElement(By.xpath("//form[@class=\"form-horizontal\"]")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot2, new File(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png"));
		Assert.assertFalse(compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png", System.getProperty("user.dir")+"\\Screenshots\\sc2Expected.png"));
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("akshatap261@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		
		String expectedWarningMessage = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), expectedWarningMessage);
		
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("akshatap261@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(2000);		
		File srcScreenshot3 = driver.findElement(By.xpath("//form[@class=\"form-horizontal\"]")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot3, new File(System.getProperty("user.dir")+"\\Screenshots\\sc3Actual.png"));
		
				
		Assert.assertFalse(compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc3Actual.png", System.getProperty("user.dir")+"\\Screenshots\\sc3Expected.png"));

		driver.quit();
				
	}
	
	public boolean compareTwoScreenshots(String actualImagePath, String expectedImagePath) {
		BufferedImage actualBImg=null;
		BufferedImage expectedBImg = null;
		try {
			actualBImg = ImageIO.read(new File(actualImagePath));
			expectedBImg = ImageIO.read(new File(expectedImagePath));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(expectedBImg, actualBImg);
		
		return imgDifference.hasDiff();

	}

}
