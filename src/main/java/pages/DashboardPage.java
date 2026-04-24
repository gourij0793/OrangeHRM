package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage
{

	WebDriver driver;
	
	By dashboardHeader = By.xpath("//h6[contains(text(),'Dashboard')]");
	public DashboardPage(WebDriver driver)
	{
		this.driver= driver;
		
	}
	public boolean isDashboardDisplayed() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	

    return wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h6[text()='Dashboard']")
        )
    ).isDisplayed();
	
	}
}
