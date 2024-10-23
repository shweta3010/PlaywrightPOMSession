package playwright.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browsername)
	{
		pf= new PlaywrightFactory();
		prop=pf.init_prop();
		if(browsername!=null) {
			prop.setProperty("browser", browsername);
			
		}
		page= pf.initBrowser(prop);
		homepage =new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
