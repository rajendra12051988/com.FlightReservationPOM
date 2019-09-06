package com.FR.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class TakeScreenshot {
	

	
	public static String getScreenshotPath(WebDriver driver, String screenshotName) {
		
		TakesScreenshot srcShot = (TakesScreenshot)driver;
		
		String dateFormat = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss").format(new Date());
		
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+screenshotName+"_"+dateFormat+".png";
		File destFile = new File(destination);
		
		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination;
		
	}

}
