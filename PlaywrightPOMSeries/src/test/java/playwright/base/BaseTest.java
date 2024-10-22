package playwright.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import playwright.factory.PlaywrightFactory;
import playwright.pages.HomePage;
import playwright.pages.LoginPage;

public class BaseTest {
	PlaywrightFactory pf;
	Page page;
	protected HomePage homepage;
	protected LoginPage loginpage;
	protected Properties prop;
	
	@BeforeTest
	public void setup()
	{
		pf= new PlaywrightFactory();
		prop=pf.init_prop();
		page= pf.initBrowser(prop);
		homepage =new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
