package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends TestBase

{
	WebDriver driver;
	
	
	//Objects definition
	 By username = By.cssSelector(OR.getProperty("user"));
	 By password = By.cssSelector(OR.getProperty("passw"));
	 By loginButton = By.cssSelector(".radius");
	 By text = By.cssSelector(OR.getProperty("error"));

    public LoginPage(WebDriver driver)
    {

        this.driver = driver;
    }
		
	public LoginPage goToLoginPage()
	{
		driver.findElement(By.xpath(OR.getProperty("form"))).click();
		return this;
	}
	
	public LoginPage enterUserName(String usernamedata)
	{
		driver.findElement(username).sendKeys(usernamedata);
		return this;
	}
	
	public LoginPage enterPassword(String passworddata)
	{
		driver.findElement(password).sendKeys(passworddata);
		return this;
	}
	
	public LoginPage clickLoginButton()
	{
		driver.findElement(loginButton).click();
		return this;
	}
	
	public String getMessageText()
	{
		return driver.findElement(text).getText();
	}
}
