package Umer_Automation_Playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class Capture_all_the_links {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Capture all the visible elements links appear in the web app
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.ebay.com/");
		List<String> LinkText=page.locator("a:visible").allInnerTexts();
		for(int i=0; i<=LinkText.size(); i++) {
			System.out.println(LinkText.get(i));
		}
				}

	}


