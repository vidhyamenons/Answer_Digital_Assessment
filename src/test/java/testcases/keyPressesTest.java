package testcases;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.TestBase;
import base.KeyPressesPage;
import utilities.TestUtil;

public class keyPressesTest extends TestBase 
{
	KeyPressesPage keyPressesPage;
	
	@BeforeTest
	public void before()
	{
		keyPressesPage=new KeyPressesPage(driver);
		
		keyPressesPage
			.goToKeyPressesPage();
	}
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="keys")
	public void keypressTest(Object keyValue, String keyString) throws InterruptedException 
	{
		keyPressesPage=new KeyPressesPage(driver);
		
		keyPressesPage
				.enterKey(keyValue.toString()).clearKey();
		
		Assert.assertTrue(keyPressesPage.getResultText().contentEquals("You entered: "+keyString));
		Log.info("Key press"+" "+keyString+" "+"asserted");
	}	
}
