package base;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger Log=Logger.getLogger("Logger");
	
	
	@BeforeTest
	public void setUp() throws IOException {

		if(driver==null) {  
	fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
	config.load(fis);
	Log.info("Congfig file loaded");
	fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	OR.load(fis);
	Log.info("Object Repository file loaded");
	}
	
	if(config.getProperty("browser").equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		Log.info("Chrome launched");
			
	}
	if(config.getProperty("browser").equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
		driver = new FirefoxDriver();
		Log.info("Firefox launched");
			
	}
	if(config.getProperty("browser").equals("ie"))
	{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		Log.info("Internet Explorer launched");
			
	}
	driver.get(config.getProperty("url"));
	driver.manage().window().maximize();
	Log.info("Window maximized");
	driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	
	public String getScreenshotPath(String testcaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destnfile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destnfile));
		return destnfile;
	}
	
	@AfterTest
	public void tearDown() {
		if(driver!=null)
		{
		driver.close();
		}
		Log.info("Test execution completed");

	}
}
