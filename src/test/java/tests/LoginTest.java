package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest
{
	@Test
	public void testLogin() 
	{
		 test = extent.createTest("Login Test");
	
		LoginPage loginPage = new LoginPage(driver);

		 test.info("Entering username and password");
		 
		 loginPage.login("Admin", "admin123"); // correct credentials
	   
	     test.info("Login action performed");

	    DashboardPage dashboard = new DashboardPage(driver);

	    Assert.assertTrue(dashboard.isDashboardDisplayed(), "Dashboard not visible!");
	    
	    test.pass("Login successful");
		
	}
	@Test
	public void testInvalidLogin() {
		 test = extent.createTest("Login Test");

	    LoginPage loginPage = new LoginPage(driver);
	    test.info("Entering wrong credentials");

	    loginPage.login("Admin", "wrong123");
	   
	    test.fail("Login failed as expected");

	    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login should fail");
	}
	@Test
	public void testLogout() {

	    LoginPage loginPage = new LoginPage(driver);
	    
	    
	    loginPage.login("Admin", "admin123");
	    loginPage.logout();

	    Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Logout failed!");
	}
	

}
