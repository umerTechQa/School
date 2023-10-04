package Umer_Automation_Playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class User_sso_Authentication_save_video_file_while_recording {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
              //Below is the browser context for user authentication to avoid maximum login/Logout.
			  Playwright playwright = Playwright.create();
			      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			      //BrowserContext context1 = browser.newContext();
			      BrowserContext context1 = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")));
                  
			      Page page1 = context1.newPage();
			      page1.navigate("https://practice.automationtesting.in/my-account/");
			      page1.locator("input#username").fill("umer@gmail.com");
			      page1.locator("input#password").fill("password@1234$");
			      page1.locator("input.woocommerce-Button button").click();
			     
			      //context1.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
			      //context1.close();
			     
			      
			      BrowserContext context2 = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("my2ndcontextvideo/")));

			      // page.locator("select#Form_getForm_Country:has(option[value='Pakistan'])")
			      Page page2 = context2.newPage();
			      page2.navigate("https://www.orangehrm.com/");
			      page2.locator("input#Form_submitForm_EmailHomePage").fill("demo purpose testing");
			     
			      
			      
			      
			      
			      //page1.locator("text=IB Contacts").click();
			      
			      
			      System.out.println("Done!!");
			      
			     
			    
			      //page1.close();
			      //page2.close();
			     
			      
			  }
	}


