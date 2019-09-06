package com.FR.Listeners;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetUp {
	
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentTest logger = null;
	public static ExtentReports extent = null;
	
	
	
	public ExtentReports extentReportConfiguration(String browserType) {
		
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\extent-report\\TestExecutionReport.html"));
		
		// Configuration Settings
		htmlReporter.config().setDocumentTitle("Extent Report : Flight Reservation");
		htmlReporter.config().setReportName("E2E Regresstion Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		// Provide System Information
		extent.setSystemInfo("browser", browserType);
		extent.setSystemInfo("Project Name", "Flight Reservation");
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("OS",System.getProperty("os.name"));
		extent.setSystemInfo("user", System.getProperty("user.name"));
		InetAddress myhost;
		try {
			myhost = InetAddress.getLocalHost();
			extent.setSystemInfo("Host", myhost.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return extent;
		
	}

}
