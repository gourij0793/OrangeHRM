package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;
import utils.ScreenshotUtil;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    public static ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite
    public void setupReport()
    {
    	extent= utils.ExtentManager.getReport();
    }
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) 
    {
    	if (result.getStatus() == ITestResult.FAILURE) {
    		System.out.println("Test failed, capturing screenshot...");
    	    ScreenshotUtil.captureScreenshot(driver, result.getName());
    	}

    	driver.quit();
    	  	
    }
    @AfterSuite
    public void tearDownReport()
    {
    	extent.flush();
    }
}