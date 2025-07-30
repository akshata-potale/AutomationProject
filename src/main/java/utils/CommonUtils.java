package utils;

import java.util.Date;

public class CommonUtils {
	
	public static String generateNewEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
	}

}
