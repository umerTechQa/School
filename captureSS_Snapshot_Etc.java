package Umer_Automation_Playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class captureSS_Snapshot_Etc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		  Playwright playwright = Playwright.create();
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	      BrowserContext context = browser.newContext();
	    //Start tracing before creating / navigating a page.
	      context.tracing().start(new Tracing.StartOptions()
	        .setScreenshots(true)
	        .setSnapshots(true)
	        .setSources(true));
	      Page page1 = context.newPage();
	      // Start tracing before creating / navigating a page.
	      
	      page1.navigate("https://ibo--pspdevpro.sandbox.my.site.com/ibportal/IBPortalLogin");
	      page1.fill("#input-1", "pspformstest+hos070@gmail.com");
	      page1.fill("#input-2", "password1234");
	      
	      
	   // Stop tracing and export it into a zip archive.
	      context.tracing().stop(new Tracing.StopOptions()
	        .setPath(Paths.get("trace.zip")));

	      
	}

}
