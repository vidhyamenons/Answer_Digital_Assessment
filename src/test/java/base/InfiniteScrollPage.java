package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class InfiniteScrollPage extends TestBase

{
	WebDriver driver;
	JavascriptExecutor js;
	
	
		 //Objects definition
		 By pageH2 = By.xpath(OR.getProperty("text"));
		 By scrollpage = By.xpath(OR.getProperty("scroll"));
	
    public InfiniteScrollPage(WebDriver driver)
	{
		 this.driver = driver;
		 js = (JavascriptExecutor) driver;
	}		 
	
	public InfiniteScrollPage goToInfiniteScrollPage()
	{	
		driver.findElement(scrollpage).click();
		return this;
	}
	 
	public InfiniteScrollPage scrollToBottom() throws InterruptedException
	{
		
		
		for(int j=0;j<2;j++)
		{	
			Thread.sleep(1000);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			Thread.sleep(1000);
		}
		
		return this;
	}
	
	public InfiniteScrollPage scrollToTop() throws InterruptedException
	{
		
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		return this;
	}
	
	public String getHeadingText()
	{
		return driver.findElement(pageH2).getText();
	}
	
}
