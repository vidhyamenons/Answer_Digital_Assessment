package testcases;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import base.LoginPage;
import utilities.TestUtil;

public class formAuthenticationTest extends TestBase 
{
	
	LoginPage login;
	
	@BeforeTest
	public void before()
	{
		login=new LoginPage(driver);
		
		login.goToLoginPage();
	}
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="Login Test Data")
	public void formauthenticationTest(String usernamedata, String passworddata, String testType) throws InterruptedException 
	{
		login=new LoginPage(driver);
		
		login
			.enterUserName(usernamedata)
			.enterPassword(passworddata)
			.clickLoginButton();
		
		String text = login.getMessageText();
		
		if(testType.equals("AllPositive"))
		{
			Assert.assertTrue(text.contains("You logged into a secure area!"));
			Log.info(usernamedata+" "+"and"+" "+passworddata+" "+"are valid credentials");
		}		
		else if(testType.equals("IncorrectUserName")) 
		{
			Assert.assertTrue(text.contains("Your username is invalid!"));
			Log.info(usernamedata + " is invalid username");
		}
		else if(testType.equals("IncorrectPassword")) 
		{
			Assert.assertTrue(text.contains("Your password is invalid!"));
			Log.info(passworddata + " is invalid password");
		}
	}
	
}
