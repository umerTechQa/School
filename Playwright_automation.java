package Umer_Automation_Playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Playwright_automation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright=Playwright.create();
		
	    Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcontext=browser.newContext();
		Page page=brcontext.newPage();
		page.navigate("https://practice.automationtesting.in/my-account/");
		//page.pause();
		//PWDEBUG Added in the env need to remove in normal execution
		
		  page.locator("#username").fill("o.ejaz@plumlogix.com");
		  page.locator("#password").fill("Plumlogix@1234$$");
		  page.click("input[name='login']");

			System.out.println("Done");
	}
}
		 
		



















//BrowserContext brcontext=browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));
		//brcontext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("autologin.json")));
		
		
		
		
		


