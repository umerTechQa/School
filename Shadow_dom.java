package Umer_Automation_Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Shadow_dom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Playwright playwright= Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();
		page.navigate("https://ibo--pspdevpro.sandbox.my.salesforce.com/");
	}
	

}
