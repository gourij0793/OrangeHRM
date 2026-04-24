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
	
		LoginPage loginPage= new LoginPage(driver);
		loginPage.login("Admin", "admin123");
	
		
		//Assertion verify dashboard
		/*String currentUrl= driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("dashboard"), "Login failed!");*/
		
		String title= driver.getTitle();
		Assert.assertTrue(title.contains("OrangeHRM"), "Login Failed!");
		DashboardPage dashboard = new DashboardPage(driver);

	    Assert.assertTrue(dashboard.isDashboardDisplayed(), "Dashboard not visible!");
		
		
	}
	@Test
	public void testLogout() {

	    LoginPage loginPage = new LoginPage(driver);

	    loginPage.login("Admin", "admin123");
	    loginPage.logout();

	    Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Logout failed!");
	}
	

}
