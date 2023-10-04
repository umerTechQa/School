package Umer_Automation_Playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class Single_File_Uploads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		// TODO Auto-generated method stub
				Playwright playwright=Playwright.create();
				
			    Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
				BrowserContext brcontext=browser.newContext();
                
				brcontext.tracing().start(new Tracing.StartOptions()
					        .setScreenshots(true)
					        .setSnapshots(true)
					        .setSources(true));
				Page page=brcontext.newPage();
				page.navigate("file:///C:/Users/Omer.Ejaz/Desktop/onetime.html");
				
				page.setInputFiles("input#file_uploader",Paths.get("autologin.json"));
				page.locator("input#username").fill("umer@gmail.com");
				page.locator("input#password").fill("Password123");
				
				page.locator("input#button_value").click();
				System.out.println("Done");
				  brcontext.tracing().stop(new Tracing.StopOptions()
				 .setPath(Paths.get("trace.zip")));

				
				
				}
						
						
				
				//page.pause();
				//PWDEBUG Added in the env need to remove in normal execution
				
				
				
	}

























