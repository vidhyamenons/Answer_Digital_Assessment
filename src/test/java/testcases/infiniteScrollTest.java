package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.InfiniteScrollPage;
import base.TestBase;

public class infiniteScrollTest extends TestBase {

	InfiniteScrollPage infiniteScroll;
	
	@Test
	public void infinitescrollTest() throws InterruptedException {

		infiniteScroll=new InfiniteScrollPage(driver);
		
		infiniteScroll
			.goToInfiniteScrollPage()
			.scrollToBottom()
			.scrollToTop();
		
		Assert.assertEquals(infiniteScroll.getHeadingText(),"Infinite Scroll");
		Log.info("Window scrolled and text is asserted");
	
	
}
	
}