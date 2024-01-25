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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;



 class school_pyp_Programme {
  WebDriver driver;
    @BeforeTest
	  public void   Browser() throws InterruptedException{
    	
			
		System.setProperty("webdriver.gecko.driver", "C:/Users/Omer.Ejaz/Downloads/geckodriver-v0.33.0-win64/geckodriver.exe");
    		 driver= new FirefoxDriver();
    		 Thread.sleep(3000);
    		String baseURL= "https://ibo--pspdev2.sandbox.my.site.com/ibportal/IBPortalRegistration";
    		 driver.get(baseURL);
    		 driver.navigate().to(baseURL);
    		 driver.manage().window().maximize();
    		 
    		 System.out.println("Firefox Browser open successfully.");
    		 Thread.sleep(3000);
    		 
    		
    	}

    @Test (dataProvider="LoginDataProvider",dataProviderClass= Login_Credentials.class) 
    public void Login_1(String firstname, String lastname, String email, String confirm_email) {
		 
			try 
			{
				//WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("PimsLogin:IBPortalSiteTemplate:loginForm:username")));

               Thread.sleep(1000);
				 
				driver.findElement(By.xpath("//input[@id=\"IBPortalREgistration:IBPortalSiteTemplate:signUpForm:contfirstNameId\"]")).sendKeys(firstname);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id=\"IBPortalREgistration:IBPortalSiteTemplate:signUpForm:contlastNameId\"]")).sendKeys(lastname);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id=\"homeEmailId\"]")).sendKeys(email);
				driver.findElement(By.xpath("//input[@id=\"confEmailId\"]")).sendKeys(confirm_email);
				System.out.println("IB user register successfully!");
				Thread.sleep(3000);	
			}
				
				catch(Exception e) {
					System.out.println("IB user Failed to register!");
				}
			
		}
    //If want to disable the test case, we can use enabled=false
    @Test(enabled=false,dataProvider="LoginDataProvider1",dataProviderClass=data123.class)
     void sanam(String Address, String org_email) {
    	try {
		driver.findElement(By.xpath("//input[@id=\"IBPortalREgistration:IBPortalSiteTemplate:signUpForm:birthLocaleId\"]")).sendKeys(Address);
		driver.findElement(By.xpath("//input[@id=\"IBPortalREgistration:IBPortalSiteTemplate:signUpForm:schoolEmailId\"]")).sendKeys(org_email);
    	}
    	catch(Exception e)
    	{
    		System.out.println("error");
    	}
    }
    @AfterMethod
    public void after() {
    	
    }
 }
    /*
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
    		 
    		 ////span[contains(text(),'1. Does the school ensure that�all teachers meet the local/state/national and any other relevant requirements for the roles to which they have been appointed?')]
//    	 driver.findElement(By.xpath("//span[@title=\"Student support 1: The school provides relevant human, natural, built and virtual resources to implement its IB programme(s). (0202-01)\"]")).click();
    	 Thread.sleep(6000);
    	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[1]/h3[1]/button[1]/span[1]")).click();
    	 
    	 String txt1= "1. Does the school ensure that�all teachers meet the local/state/national and any other relevant requirements for the roles to which they have been appointed?";
    	 
    	 WebElement el12= driver.findElement(By.xpath("//span[contains(text(),'1. Does the school ensure that�all teachers meet the local/state/national and any other relevant requirements for the roles to which they have been appointed?')]"));
    	
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
 }
 */
        
