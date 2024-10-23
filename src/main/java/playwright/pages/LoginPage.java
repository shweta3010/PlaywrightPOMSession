package playwright.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
private Page page;
	
	private String email=	"#input-email";
	private String password="#input-password";
	private String loginbtn="//input[@type='submit']";
	private String logout="//div/a[contains(text(),'Logout')]";
	
	public LoginPage(Page page) {
		 
		this.page=page;
	}
	
	public String logintitle()
	{
		return page.title();
		
	}
	
	public boolean dologin(String username, String passwordb) {
		
		page.fill(email, username);
		page.fill(password, passwordb);
		page.click(loginbtn);
		if(page.isVisible(logout))
		{
			return true;
		}
		return false;
	}
	

}
