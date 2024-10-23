package playwright.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import playwright.base.BaseTest;
import playwright.constants.Constants;

public class HomePageTest extends BaseTest {
	

	@Test(priority=2)
	public void title()
	{
		String actualtitle=homepage.title();
		Assert.assertEquals(actualtitle, Constants.page_title);
	}
	@Test(priority=1)
	public void homePageurl()
	{
		String actualUrl=homepage.getHomePageUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("url"));
	}
	
	
	@DataProvider
	public Object getproductData()
	{
		return new Object[][] {
			{"MacBook"},
			{"Imac"},
			{"Samsung"}
		};
		
	}
	@Test(priority=3,dataProvider="getproductData")
	public void searchTest(String productName)
	{
		String actualHeader=homepage.doSearch(productName);
		Assert.assertEquals(actualHeader, "Search - "+productName);
	}
	
	@Test(priority=4)
	public void login()
	{
		homepage.login();;
		
	}
	
	
	
	


}
