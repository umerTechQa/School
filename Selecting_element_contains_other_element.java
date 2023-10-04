package Umer_Automation_Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Selecting_element_contains_other_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      Playwright playwright= Playwright .create();
      Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      Page page= browser.newPage();
      page.navigate("https://www.orangehrm.com/");
     page.locator("button:has-text('Book a Free Demo')").last().click();
      //page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book a Free Demo")).click();
    //selecting an element contains other element
      
      page.locator("select#Form_getForm_Country:has(option[value='Pakistan'])").selectOption("Pakistan");
      //page.getByLabel("Country").selectOption("Pakistan");
      Locator loc=  page.locator("select#Form_getForm_Country:has(option[value='Pakistan'])");
      loc.allInnerTexts().forEach(e->System.out.println(e));
      
      
      
      
	}

}
