package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	//Locators
	
	By username= By.name("username");
	By password= By.name("password");
	By loginBtn= By.xpath("//button[@type='submit']");
	By dashboardText= By.xpath("//h6[text()='Dashboard']");
	By profileMenu =By.xpath("//p[@class='oxd-userdropdown-name']");
	By logoutBtn =By.xpath("//a[text()='Logout']");
	//constructor
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		
	}
	
	//Action
	public void enterUsername(String user)
	{
		driver.findElement(username).sendKeys(user);
	}
	public void enterPassword(String pass) 
	{
		driver.findElement(password).sendKeys(pass);
	}

	public void clickLogin() 
	{
		driver.findElement(loginBtn).click();
	}
	
	public boolean isDashboardDisplayed() 
	{
		return driver.findElement(dashboardText).isDisplayed();
		
	}
	public void logout()
	{
		driver.findElement(profileMenu).click();
		driver.findElement(logoutBtn).click();
	}
	//combined method
	public void login(String user, String pass)
	{
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
	}
	
}
