package Umer_Automation_Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Frame_Iframe_handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright= Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();
		/*
		 * page.navigate("http://londonfreelance.org/courses/frames/index.html"); String
		 * String page_header=page.frameLocator("frame[name='main']").locator("h2").textContent
		 * (); System.out.println(page_header);
		 */
		
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
	    page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-1").fill("umer automation");
	    
	}
	
	
	

}
