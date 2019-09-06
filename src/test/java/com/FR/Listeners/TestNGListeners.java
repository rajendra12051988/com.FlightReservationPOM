package com.FR.Listeners;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.FR.Utility.BrowserUtility;
import com.FR.Utility.ReadConfiguration;
import com.FR.Utility.TakeScreenshot;

public class TestNGListeners extends ExtentReportSetUp implements ITestListener {

	public ExtentReports extent = null;
	public static WebDriver driver;
	public static Properties p;
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		logger = extent.createTest(result.getName());
		System.out.println(logger);
		logger.info(MarkupHelper.createLabel(result.getName()+" ---> Started", ExtentColor.CYAN));
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		

		logger.pass(MarkupHelper.createLabel(result.getName()+" ---> Passed", ExtentColor.GREEN));
		try {
			logger.addScreenCaptureFromPath(TakeScreenshot.getScreenshotPath(driver, result.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		logger.fail(MarkupHelper.createLabel(result.getName()+" ---> Failed", ExtentColor.RED));
		logger.fail(result.getThrowable());
		try {
			logger.addScreenCaptureFromPath(TakeScreenshot.getScreenshotPath(driver,result.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		logger.skip(MarkupHelper.createLabel(result.getName()+" ---> Skipped", ExtentColor.YELLOW));
		logger.skip(result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		try {
			p = ReadConfiguration.getTestData();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		extent = extentReportConfiguration(p.getProperty("browser"));
		System.out.println(p.getProperty("browser"));
		driver = BrowserUtility.browserSetup(p.getProperty("browser"));
		System.out.println(driver);
		
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		driver.quit();
		logger.info(MarkupHelper.createLabel("Test Execution Completed", ExtentColor.TRANSPARENT));
		extent.flush();
	}

}
