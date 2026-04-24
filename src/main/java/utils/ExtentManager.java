package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
	 public static ExtentReports getReport() 
	 {
		 File folder = new File("reports");// create folder
	        if (!folder.exists()) {
	            folder.mkdir();
	        }


	        ExtentSparkReporter reporter =
	                new ExtentSparkReporter("reports/extentReport.html");

	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(reporter);

	        return extent;
	    }

}
