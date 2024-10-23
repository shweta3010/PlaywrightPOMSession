package playwright.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	private String search=	"input[name='search']";
	private String searchIcon="button.btn-lg";
	private String searchPageHeader="div#content h1";
	
	//login
	private String login="//a[contains(text(),'Login')]";
	
	private String myAccount="//span[contains(text(),'My Account')]";
	
	
	
	
	
	//Page constructor is used so that driver instanc remains same accroos all classes
	public HomePage(Page page)
	{
		this.page=page;
	}
	
	public String title()
	{
		return page.title();
		
	}
	
	public String getHomePageUrl() {
		System.out.println(page.url());
		return page.url();
	}
	
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		return page.textContent(searchPageHeader);
		
	}
	public LoginPage login() {
		page.click(myAccount);
		page.click(login);
		return new LoginPage(page);
	}
	

}
