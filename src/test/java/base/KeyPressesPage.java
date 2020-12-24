package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class KeyPressesPage extends TestBase

{
	WebDriver driver;
	
	
	//Objects definition
	 By keyInput = By.xpath((OR.getProperty("editbox"))); 
	 By keyResult = By.xpath((OR.getProperty("msg")));
	 By keyPressesPage = By.xpath((OR.getProperty("key")));

	public KeyPressesPage(WebDriver driver)
	{
	
	        this.driver = driver;
	
	}
	
	public KeyPressesPage goToKeyPressesPage()
	{
		driver.findElement(keyPressesPage).click();
		return this;
	}
	
	public KeyPressesPage enterKey(String keyValue) throws InterruptedException
	{
		driver.findElement(keyInput).sendKeys(keyValue);
		Thread.sleep(100);
		return this;
	}
	
	public KeyPressesPage clearKey()
	{
		driver.findElement(keyInput).clear();
		return this;
	}
	
	public String getResultText()
	{
		return driver.findElement(keyResult).getText();
	}
}
