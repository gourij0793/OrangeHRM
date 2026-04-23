package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest
{
	@Test
	public void testLogin() 
	{
	
		LoginPage loginPage= new LoginPage(driver);
		loginPage.login("Admin", "admin123");
		loginPage.logout();
		
		//Assertion verify dashboard
		/*String currentUrl= driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("dashboard"), "Login failed!");*/
		
		String title= driver.getTitle();
		Assert.assertTrue(title.contains("OrangeHRM"), "Login Failed!");
		Assert.assertTrue(loginPage.isDashboardDisplayed(), "Login failed!");
	}
	

}
