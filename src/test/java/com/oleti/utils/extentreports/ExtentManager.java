package com.oleti.utils.extentreports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
	
	 public static final ExtentReports extentReports = new ExtentReports();
	    public synchronized static ExtentReports createExtentReports() {
	        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
	        reporter.config().setReportName("Sample Extent Report");
	        extentReports.attachReporter(reporter);
	        extentReports.setSystemInfo("Company Name", "Central");
	        extentReports.setSystemInfo("Author", "Shiva Oleti");
	        return extentReports;
}
}
