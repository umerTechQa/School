package Umer_Automation_Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Dynamic_Webtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Playwright playwright=Playwright.create();
		Browser browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://ibo--pspdevpro.sandbox.my.salesforce.com/");
		page.locator("#username").fill("omer.ejaz@ibo.org.pspdevpro");
		page.locator("#password").fill("Plumlogix@1234$");
		page.locator("#Login").click();
		page.locator("span:has-text('IB Contacts')").first().click();
		Locator row= page.locator("table.uiVirtualDataTable");
		row.locator(":scope", new Locator.LocatorOptions().setHasText("Brenda HOS28")).locator("a:has-text('Brenda HOS28')").click();
		row.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));
		
		
		
	}

}
