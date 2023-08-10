package SchoolPackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;



 class school_pyp_Programme {
  WebDriver driver;
    @BeforeTest
	  public void   Browser() throws InterruptedException{
    	
			
    		System.setProperty("webdriver.chrome.driver", "C://Users//Admin//Downloads//chromedriver.exe");
    		 driver= new ChromeDriver();
    		 
    		String baseURL= "https://ibo--pspdev2.sandbox.my.site.com/ibportal/IBPortalLogin";
    		 this.driver.get(baseURL);
    		 driver.manage().window().maximize();
    		 
    		 System.out.println("Chrome Browser open successfully.");
    		 Thread.sleep(3000);
    		
    	}

    @Test (dataProvider="LoginDataProvider",dataProviderClass= Login_Credentials.class) 
    public void Login_1(String username, String password) {
		 
			try 
			{
				//WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("PimsLogin:IBPortalSiteTemplate:loginForm:username")));

               Thread.sleep(1000);
				 
				driver.findElement(By.id("PimsLogin:IBPortalSiteTemplate:loginForm:username")).sendKeys(username);
				Thread.sleep(2000);
				driver.findElement(By.id("PimsLogin:IBPortalSiteTemplate:loginForm:password")).sendKeys(password);
				Thread.sleep(2000);
				driver.findElement(By.id("PimsLogin:IBPortalSiteTemplate:loginForm:loginButton")).click();
				Thread.sleep(2000);
				
				System.out.println("IB login successfully!");
				Thread.sleep(3000);
				 driver.get("https://ibo--pspdev2.sandbox.my.site.com/pims/PimsDashboard");
				 Thread.sleep(4000);
			}
				
				catch(Exception e) {
					System.out.println("IB Failed to login!");
				}
		}
     @Test
     public void dashboard() throws InterruptedException {
    	 JavascriptExecutor scroll_down = (JavascriptExecutor)driver;
	     scroll_down.executeScript("window.scrollBy(0,250)");
	     
    	    
	    
    	     driver.findElement(By.xpath("//a[@href=\"/pims/PimsApplicationRedirect?id=a1R7E000002yxhZUAQ&type=can\"]")).click();
    	     Thread.sleep(3000);
    	    
    	   driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/div[1]/div[1]/div[1]/div[3]/div[3]/lightning-button[1]/button[1]")).click();
    	     
    	     
    	   driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/div[1]/div[1]/div[1]/div[3]/div[3]/lightning-button[1]/button[1]")).click();
  	     
    	     
    	     
    	     //driver.findElement(By.xpath("//span[@data-section-id=\"a5S7E000000NqgiUAC\"]")).click();
    		 
    	      }	 	 
    
     @Test
     public void next_button() throws InterruptedException {
    	
    	 
    	 //driver.findElement(By.xpath("//button[@title=\"Next\"]")).click();
    	 
    	

    	 
    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-textarea[1]/div[1]/textarea[1]")).sendKeys("school PSP");
    	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-textarea[2]/div[1]/textarea[1]")).sendKeys("school DPS");
    	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-textarea[3]/div[1]/textarea[1]")).sendKeys("school ACCOUNT");
    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath("//button[@title=\"Save the Form\"]")).click();
    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath("//button[@title=\"Save the Form\"]")).click();

    	 
     }
     @Test
     public void student_support_pyp() throws InterruptedException {
    	
    		 Thread.sleep(15000);
    		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		 
    		 Thread.sleep(2000);
    		 String Env_student_support_text_expected= "Learning environments in IB World Schools support student success.";
    		//div[contains(text(),Learning environments in IB World Schools support student success')]
      	 
    		 WebElement Env_student_support_text_Actual=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/div[3]"));
    		 
    		 String actaul_value=Env_student_support_text_Actual.getText();
    		 
    		 if(Env_student_support_text_Actual.isEnabled() && actaul_value.contains("Learning environments in IB World Schools support student success."))
    		 {
    			 System.out.println("Text verified successfully.");
    	 }
     
    		 else{
    		 System.out.println("Text verified failed.");
    	 }
    		 Thread.sleep(3000);
    		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		 
    		 ////span[contains(text(),'1. Does the school ensure that all teachers meet the local/state/national and any other relevant requirements for the roles to which they have been appointed?')]
//    	 driver.findElement(By.xpath("//span[@title=\"Student support 1: The school provides relevant human, natural, built and virtual resources to implement its IB programme(s). (0202-01)\"]")).click();
    	 Thread.sleep(6000);
    	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[1]/h3[1]/button[1]/span[1]")).click();
    	 
    	 String txt1= "1. Does the school ensure that all teachers meet the local/state/national and any other relevant requirements for the roles to which they have been appointed?";
    	 
    	 WebElement el12= driver.findElement(By.xpath("//span[contains(text(),'1. Does the school ensure that all teachers meet the local/state/national and any other relevant requirements for the roles to which they have been appointed?')]"));
    	
    	 String abc=el12.getAttribute("textContent");
    	 if(el12.isEnabled() && abc.contains("1. Does the school ensure that all teachers meet the local/state/national and any other relevant requirements for the roles to which they have been appointed?"));
    	 { 
    		 System.out.println("Text student support successfully verified.");
    	 }
     
    	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-radio-group[1]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     }
    
     @Test
     public void teacher_support_next() throws InterruptedException {
    	 
    	 Thread.sleep(3000);
    	 driver.findElement(By.xpath("//button[@title=\"Save the Form\"]")).click();
    	 
    	 
    	 String teacher_support_text= "Learning environments in IB World Schools support and empower teachers.";
    	WebElement teacher_txt= driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/div[3]"));
        String teacher_s_txt=teacher_txt.getAttribute("textContent");
        if(teacher_txt.isEnabled() && teacher_s_txt.contains("Learning environments in IB World Schools support and empower teachers."));
        System.out.println("Learning text catched and passed.");
     
     }
     
     @Test
     public void Culture() throws InterruptedException
     {   Thread.sleep(8000);
     driver.findElement(By.xpath("//button[@title=\"Save the Form\"]")).click();
     String culture_txt_title= "Schools develop, implement, communicate and review effective policies that help to create a school culture in which IB philosophy can thrive.";
     WebElement culture_text= driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/div[3]")); 
    	 
     String cul= culture_text.getAttribute("textContent");
     if(culture_text.isEnabled() && cul.contains("Schools develop, implement, communicate and review effective policies that help to create a school culture in which IB philosophy can thrive."));
     System.out.println("culture title text is passed.");
     Thread.sleep(2000);
     
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[1]/h3[1]/button[1]/span[1]")).click();
    	 
     String culture1="Schools should seek to make their IB programme(s) available to as many students as possible, ensuring equality of access to the curriculum and providing students with the support they need to set and meet appropriately challenging educational goals. For more information on admission, access and inclusion in the IB, please consult the From principles into practice publication for the relevant programme(s). These publications are available on the IB programme resource centre.";
     
     WebElement culture1_text=driver.findElement(By.xpath("//i[contains(text(),'Schools should seek to make their IB programme(s) available to as many students as possible, ensuring equality of access to the curriculum and providing students with the support they need to set and meet appropriately challenging educational goals. For more information on admission, access and inclusion in the IB, please consult the')]"));
     String culturemain_italic =culture1_text.getAttribute("textContent");
     
    if(culture1_text.isEnabled() && culturemain_italic.contains("Schools should seek to make their IB programme(s) available to as many students as possible, ensuring equality of access to the curriculum and providing students with the support they need to set and meet appropriately challenging educational goals. For more information on admission, access and inclusion in the IB, please consult the From principles into practice publication for the relevant programme(s). These publications are available on the IB programme resource centre."));
    System.out.println("culture italic text is passed.");
    
    
    
    driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-textarea[1]/div[1]/textarea[1]")).sendKeys("Culture randome text adding...!!");
    	 
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@title=\"Save the Form\"]")).click();

    	 
    	 
    	 
     }
     @Test
     public void Budget_select_year() throws InterruptedException {
    	 Thread.sleep(4000);
    	 Select budget_select= new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/lightning-combobox[1]/div[1]/lightning-base-combobox[1]/div[1]/div[1]/button[1]")));
         budget_select.selectByValue("2023");
         Thread.sleep(2000);
         driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[2]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
         driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[3]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
         driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[4]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
         driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[5]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
         driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[6]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
         
         driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[3]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[4]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[5]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[6]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[2]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[3]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[4]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[5]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[6]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("100");
     
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[6]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[2]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[3]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[4]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[5]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[6]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[2]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[3]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[4]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[5]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[6]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[2]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[3]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[4]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[5]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[6]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[2]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[3]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[4]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[5]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[6]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[2]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[3]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[4]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[5]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[6]/div[1]/lightning-input[1]/div[1]/input[1]")).sendKeys("");
       Thread.sleep(4000);
       driver.findElement(By.xpath("//button[@title=\"Save the Form\"]")).click();
       
     
     }
     @Test
     public void Document() throws InterruptedException {
    	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-documents-section[1]/div[3]/div[2]/lightning-button[1]/button[1]")).click();
    	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-documents-section[1]/c-custom-modal[1]/div[1]/section[1]/div[1]/footer[1]/lightning-button[2]/button[1]")).click();
    	Thread.sleep(2000);
    	String error_msg="Please select the file first.";
    	WebElement error= driver.findElement(By.xpath("//div[@role=\"alert\"]"));
    	String doc_error=error.getAttribute("textContent");
    	if(error.isEnabled() && doc_error.contains("Please select the file first."));
    	
    	System.out.println("error message found, empty can not be uploaded.");
    			
    	Thread.sleep(6000);
    	WebElement upload= driver.findElement(By.xpath("//span[@class='slds-file-selector__button slds-button slds-button_neutral']"));
    	upload.sendKeys("C:\\bug_img.png");
    	Thread.sleep(3000);
    	 Select doc_select= new Select(driver.findElement(By.xpath("//button[@aria-haspopup='listbox' ]")));
         doc_select.deselectByIndex(0);
         driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-documents-section[1]/c-custom-modal[1]/div[1]/section[1]/div[1]/footer[1]/lightning-button[2]/button[1]")).click();
         
     }
 }
         /*driver.findElement(By.xpath("//input[@id=\"input-64\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-65\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-66\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-67\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-57\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-71\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-72\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-73\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-74\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-75\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-78\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-79\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-80\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-81\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-82\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-85\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-86\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-87\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-88\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-89\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-92\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-93\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-94\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-95\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-96\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-99\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-100\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-101\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-102\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-103\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-106\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-107\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-108\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-109\"]")).sendKeys("100");
         driver.findElement(By.xpath("//input[@id=\"input-110\"]")).sendKeys("100");8/
         
         teacher_support_next();
         Thread.sleep(5000);
         
         
         
         
         
         
         
         
     }
 }
 
     
     /*
     @Test(dataProvider="Schoolprofilefirsttime", dataProviderClass= School_profile_first_time.class)
     public void legalRegister_name(String schoolname, String website, String phone) throws InterruptedException {
    	 
    		 Thread.sleep(3000);
    		 
    		 driver.findElement(By.xpath("//input[@id=\"input-11\"]")).sendKeys(schoolname);
    		 Thread.sleep(2000);
    		 JavascriptExecutor js= (JavascriptExecutor)driver;
    		 js.executeScript("window.scrollBy(0,950)");
    	 
    	 
    		 driver.findElement(By.xpath("/html/body/div[4]/c-ib-school-profile/lightning-layout/slot/lightning-layout-item[2]/slot/div[1]/c-ib-school-profile-information/div/div[6]/div[1]/lightning-radio-group/fieldset/div/span[1]/label/span[1]")).click();
    		 Thread.sleep(2000);
    		 WebElement web= driver.findElement(By.xpath("//input[@id=\"input-73\"]"));
    		 web.clear();
    		 web.sendKeys(website);
    		 Thread.sleep(2000);
    		 driver.findElement(By.xpath("//input[@id=\"input-24\"]")).sendKeys(phone);
    	 
    	 
     }
     
    	 @Test
    	 public void schoold() throws InterruptedException {
    		 WebElement element= driver.findElement(By.xpath("/html/body/div[4]/c-ib-school-profile/lightning-layout/slot/lightning-layout-item[2]/slot/div[1]/c-ib-school-profile-information/div/div[7]/div[1]/lightning-combobox/div[1]/lightning-base-combobox/div/div[1]"));
    	    	JavascriptExecutor exe= (JavascriptExecutor)driver;
    	    	exe.executeScript("arguments[0].click();", element);
    	    	element.sendKeys("Algeria(+213)");
    	    	Thread.sleep(1000);
    	    	WebElement selectMyElement = driver.findElement(this.getObject(By.xpath("/html/body/div[4]/c-ib-school-profile/lightning-layout/slot/lightning-layout-item[2]/slot/div[1]/c-ib-school-profile-information/div/div[7]/div[1]/lightning-combobox/div[1]/lightning-base-combobox/div/div[1]"))); 
    	    	selectMyElement.click();
    	    	Actions action= new Actions(driver);
    	    	
    	    	action.sendKeys("Algeria(+213)");
    	    	 Thread.sleep(3000);
    	    	
    		 WebElement school= driver.findElement(By.id("combobox-button-27"));
        	 school.click();
        	 
        	 JavascriptExecutor exe1= (JavascriptExecutor)driver;
 	    	exe1.executeScript("arguments[0].click();", school);
 	    	element.sendKeys("2020");
 	    	 Thread.sleep(3000);
        	 

        	
  			
    	 }
    	
    	 
    	private By getObject(By xpath) {
			// TODO Auto-generated method stub
			return null;
		}

		@Test
    	public void school_year() {
			
      String actualString = driver.findElement(By.xpath("/html/body/div[4]/c-ib-school-profile/lightning-layout/slot/lightning-layout-item[2]/slot/div[1]/c-ib-school-profile-information/div/div[9]/div")).getText();
   	  assertTrue(actualString.contains("The school is years old."));
    	 {
    	System.out.println("Text!" +actualString+ "is present.");
    	}
    	 
    	}
    	      @Test
    	      public void school_txt() {
    	   // isDisplayed() to get text
    	    	  
    	      boolean eleSelected= driver.findElement(By.xpath("/html/body/div[4]/c-ib-school-profile/lightning-layout/slot/lightning-layout-item[2]/slot/div[1]/c-ib-school-profile-information/div/div[9]/div/p")).isDisplayed();
    	      
    	         System.out.println("Text: "  +eleSelected+ " is displayed on the page. ");
    	      } 
    	      
    	}
    	*/
     
    
	


