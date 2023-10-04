package Umer_Automation_Playwright;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class data_provider_in_playwright {
	
    
	@Test(dataProvider="TestDataproviderplaywright")
	public static void main(String args)  {
		// TODO Auto-generated method stub

		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcontext= browser.newContext();
		Page page=brcontext.newPage();
		page.navigate("https://www.orangehrm.com/en/book-a-free-demo/");
		page.locator("#Form_getForm_FullName").fill(args);
		
	}
	

	@DataProvider(name="TestDataproviderplaywright")
	
		public Object[][] getdata() {
		Object[][] obj=new Object[][] {
			{"Test1"},
			{"Test2"},
			{"Test3"}
	};
	return obj;
		
	}
	

}
