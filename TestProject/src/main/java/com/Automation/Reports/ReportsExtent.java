package com.Automation.Reports;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsExtent {

	public static WebDriver driver = null;
	// Configuration of Extent Reports
	public ExtentHtmlReporter htmlReporter = null;
	public ExtentTest logger = null;
	public ExtentReports extent = null;

	//@BeforeSuite
	public void intiReport() {
		
		try {
			String reportPath = System.getProperty("user.dir") + "/TestData/StatusReport.html";
			File file = new File(reportPath);
			if(file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//Reports//TestReport.html");

		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "//Reports//Extent-Config.xml");

		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		
	}
	
	//@AfterSuite
	public void endReport() {
		
		extent.flush();
	}

}
