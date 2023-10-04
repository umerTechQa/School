package Umer_Automation_Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Commaseperated_css_selector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		//Comma seperated selector, If in future devs change the event name
		Playwright playwright= Playwright.create();
		Browser browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();
		page.navigate("https://www.amazon.com/");
		page.locator("span:has-text('Sign in'), span:has-text('Log in')").first().click();
		System.out.println("Done");
		
		 
	}

}
