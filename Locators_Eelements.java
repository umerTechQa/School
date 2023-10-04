package Umer_Automation_Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Locators_Eelements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//how to create/handle  single and multiple webElement , Click on the elements using locators simple text
		  Playwright playwright = Playwright.create();
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://www.orangehrm.com/");
	      //below will work if button which you want to click has only one element
			/*
			 * Locator contactsale=page.locator("text= CONTACT SALES"); contactsale.hover();
			 * contactsale.click();
			 */
	      //If has more then one same element name and you want to click the first one do this
	      Locator contactsale= page.locator("text= CONTACT SALE").first();
	      contactsale.click();
	      //if you want to click on the last same element name do this
			/*
			 * Locator contactsale1= page.locator("text= CONTACT SALE").last();
			 * contactsale1.click();
			 */
	      
	      
	}

}
