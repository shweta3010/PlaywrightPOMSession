package playwright.testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import playwright.base.BaseTest;
import playwright.constants.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void navigatetoLoginPage() {
		loginpage= homepage.login();
		String actualtitle=loginpage.logintitle();
		Assert.assertEquals(actualtitle, Constants.Login_page_title);
		
	}
	
	@Test(priority=2)
	public void logintest()
	{
		loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
