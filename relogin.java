package Umer_Automation_Playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class relogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright=Playwright.create();
		
	    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcontext=browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));

	    
		Page page=brcontext.newPage();
		page.navigate("https://ibo--pspdevpro.sandbox.my.salesforce.com/");
		System.out.println("Done");
	}

}
