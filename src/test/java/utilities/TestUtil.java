package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import base.TestBase;

public class TestUtil extends TestBase {
	public WebDriver driver;
	
	@DataProvider(name="Login Test Data")
	public Object[][] loginTestData() 
	{
		return new Object[][]
				{
					{ "tomsmith", "SuperSecretPassword", "IncorrectPassword"},
					{ "tmsmith", "SuperSecretPassword!", "IncorrectUserName"},
					{ "tomsmith", "SuperSecretPassword!", "AllPositive"}
				};
	}
	
	@DataProvider(name="keys")
	public Object[] getkeys() 
	{
		return new Object[][] 
				{
					{ Keys.NUMPAD6, "NUMPAD6"},
					{ Keys.chord("Q"), "Q"},
					{ Keys.chord("3"), "3"},
					{ Keys.ARROW_DOWN, "DOWN"}
				};
	}
}
