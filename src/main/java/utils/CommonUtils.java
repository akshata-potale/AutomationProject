package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonUtils {
	
	public static String generateNewEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
	}
	
	public static boolean compareTwoScreenshots(String actualImagePath, String expectedImagePath) {
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
	
	public static Properties loadProperties() {
		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\projectdata.properties");
			prop.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	


}
