package SchoolPackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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



  class School_Programme {
  WebDriver driver;
    @BeforeTest
	  public void   Browser() throws InterruptedException{
    	
			
    		System.setProperty("webdriver.chrome.driver", "C://Users//Admin//chromedriver.exe");
    		 driver= new ChromeDriver();
    		 
    		 String baseURL= "https://ibo--pspdevpro.sandbox.my.site.com/ibportal/IBPortalLogin";
    		 driver.get(baseURL);
    		 driver.manage().window().maximize();
    		 
    		 System.out.println("Chrome Browser open successfully.");
    		 Thread.sleep(3000);
    		
    	}

    @Test (priority=1,dataProvider="LoginDataProvider",dataProviderClass= Login_Credentials.class)
    public void Login_1(String username, String password) {
		 
			try 
			{
				//WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("PimsLogin:IBPortalSiteTemplate:loginForm:username")));

               
				 
				driver.findElement(By.xpath("//input[@id=\"input-1\"]")).sendKeys(username);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id=\"input-2\"]")).sendKeys(password);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class=\"loginButton\"]")).click();
				Thread.sleep(2000);
				
				System.out.println("IB login successfully!");
				Thread.sleep(2000);
				 driver.findElement(By.xpath("//img[@src=\"/ibportal/resource/1669122441000/myibtiles_new/My_School.png\"]")).click();
				 Thread.sleep(4000);
			}
				
				catch(Exception e) {
					System.out.println("IB Failed to login!");
				}
		}
     @Test(priority=2)
     public void dashboard() throws InterruptedException {
    	 JavascriptExecutor scroll_down = (JavascriptExecutor)driver;
	     scroll_down.executeScript("window.scrollBy(0,250)");
	   //*[@id="drop-pyp"]/li[1]/a
    	   driver.findElement(By.xpath("//a[@class='button small secondary radius'][normalize-space()='Ver solicitud']")).click();
    	    Thread.sleep(2000);
    	    driver.findElement(By.xpath("//button[@title='Next']")).click();
            driver.findElement(By.xpath("//button[@title='Next']")).click();
    	   	  	 
    	 Thread.sleep(4000);
    	 driver.findElement(By.xpath("//textarea[@id=\"input-50\"]")).sendKeys("school regression PSP PYP");
    	 driver.findElement(By.xpath("//textarea[@id=\"input-52\"]")).sendKeys("school regression PSP PYP");
    	 driver.findElement(By.xpath("//textarea[@id=\"input-58\"]")).sendKeys("school regression PSP PYP");

    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath("//button[@title=\"Save the Form\"]")).click();
    	 
         driver.findElement(By.xpath("//span[@title='Liderazgo 1: El colegio revisa regularmente y respeta todas las normas, los reglamentos y las directrices del IB para apoyar la implementación y el desarrollo continuo de los programas. (0201-01)']")).click();
        
         driver.findElement(By.xpath("//span[@title='Liderazgo 1.2: El equipo de liderazgo y gobierno entiende todas las normas, los reglamentos y las directrices del IB, y ha establecido estructuras y procesos para asegurar su cumplimiento. (0201-01-0200)']")).click();
        
         driver.findElement(By.xpath("//span[contains(text(),'Otra (especifique cuál)')]")).click();
         driver.findElement(By.xpath("(//textarea[@id='input-114'])[1]")).isDisplayed();
         driver.findElement(By.xpath("//textarea[@id='input-182']")).sendKeys("other selected in liderzago 1.2");
    	 WebElement str=driver.findElement(By.xpath("//div[@id='lgt-accordion-section-65']//span[contains(text(),'El IB también evaluará este requisito mediante la ')]"));
         String text_prgrph ="El IB también evaluará este requisito mediante la revisión del sitio web del colegio, la información relativa al desarrollo profesional del colegio, el acuerdo enviado junto con la solicitud de categoría de colegio solicitante, la declaración del compromiso financiero con el programa, la información proporcionada en el perfil del colegio, la tabla del personal, la documentación relativa a la entidad legal y las licencias o acreditaciones, el presupuesto, el organigrama del colegio, y las descripciones de tareas del director del colegio y el coordinador del programa (si el colegio desea impartir el programa en varias sedes o impartir el PAI en asociación con otros colegios";
		if(driver.getPageSource().contains("El IB también evaluará este requisito mediante la revisión del sitio web del colegio, la información relativa al desarrollo profesional del colegio, el acuerdo enviado junto con la solicitud de categoría de colegio solicitante, la declaración del compromiso financiero con el programa, la información proporcionada en el perfil del colegio, la tabla del personal, la documentación relativa a la entidad legal y las licencias o acreditaciones, el presupuesto, el organigrama del colegio, y las descripciones de tareas del director del colegio y el coordinador del programa (si el colegio desea impartir el programa en varias sedes o impartir el PAI en asociación con otros colegios).\r\n"
         		+ ""))
		{
		
         System.out.println("Text Under Liderazgo 1.2 is present");
         
         }
         else {
        	 System.out.println("Text is missing under Liderazgo 1.2 other");
         }
         
    	 Assert.assertEquals(str, text_prgrph);
    	 System.out.println("The text paragrapg under lideraazgo 1.2 is" +str);
     }
     
     @Test(priority=3)
     public void Liderzago_2() {
    	 driver.findElement(By.xpath("span[title='Liderazgo 2: El equipo de liderazgo pedagógico del colegio incluye un coordinador del programa capacitado por el IB que está habilitado para facilitar la implementación eficaz del programa. (0201-02)']")).click();
    	 driver.findElement(By.xpath("span[title='Liderazgo 2.1: El colegio nombra a un coordinador del programa que cuenta con las funciones, la asignación de tiempo, el apoyo necesario y las responsabilidades organizativas para facilitar el desarrollo del currículo y el programa. (0201-02-0100)']")).click();
    	 driver.findElement(By.xpath("//span[contains(text(),'Español')]")).click();
    	 driver.findElement(By.xpath("span[title='Liderazgo 2.2: El coordinador del programa participa en actividades de desarrollo profesional obligatorias que se corresponden con la versión más actual del programa del que es responsable. (0201-02-0200)']")).click();
    	 if(driver.getPageSource().contains("El IB evaluará este requisito mediante la revisión de la información relativa al desarrollo profesional del colegio y la prueba de haber participado o haberse inscrito en los talleres"))
    	 {
    		 System.out.println("\"Text Under Liderazgo 2.1 is present");
    	 }
    	 else {
    		 System.out.println("Text is missing under Liderazgo 2.1 and not  present");
    	 }
    	 
    	 driver.findElement(By.xpath("span[title='Liderazgo 5: El colegio financia y asigna recursos que permiten mantener y continuar desarrollando los programas del IB que imparte. (0201-05)']")).click();
         driver.findElement(By.xpath("span[title='Liderazgo 5.1: El colegio financia recursos adecuados para implementar los programas y cumplir los requisitos de estos. (0201-05-0100)']")).click();
         if(driver.getPageSource().contains("//div[@id='lgt-accordion-section-110']//span[contains(text(),'El IB evaluará este requisito mediante la revisión')]"))
         {System.out.println("Text Under Liderazgo 5.1 is present");
         
         }
         else {
        	 System.out.println("Text Under Liderazgo 5.1 is not present");
         }
         
     }
     
     @Test(priority=4)
     public void student_support_pyp_0202() throws InterruptedException {
    	
    	driver.findElement(By.xpath("button[title='Save the Form']")).click();	 
    	 Thread.sleep(15000);
    		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		 
    		 driver.findElement(By.xpath("span[title='Apoyo a los alumnos 1: El colegio proporciona recursos humanos, naturales, construidos y virtuales pertinentes para implementar los programas del IB. (0202-01)']")).click();
    		 driver.findElement(By.xpath("//label[@for='radio-0-123']//span[@class='slds-radio_faux']")).click();
    		 driver.findElement(By.xpath("button[title='Save the Form']")).click();	
     }
    		 @Test
    		 public void Teacher_Support_0203() {
    			 
    		 driver.findElement(By.xpath("span[title='Apoyo a los docentes 2: El colegio se asegura de que el equipo de liderazgo y los docentes participen en actividades de aprendizaje profesional adecuadas y oportunas que sirvan de base para sus prácticas. (0203-02)']")).click();
    		 
    		 String Env_teacher_support_text_expected= "Antes de enviar esta solicitud, asegúrese de que la información sobre el desarrollo profesional del colegio esté completa y actualizada. Esta información se puede actualizar en la sección “Desarrollo profesional” del “Perfil del colegio”.\r\n"
    		 		+ "";
    		
      	
    		 
    		  WebElement element123 =driver.findElement(By.xpath("lightning-formatted-rich-text[class='title slds-rich-text-editor__output'] span i"));
    		 
    		  element123.getText();
    		  if(Env_teacher_support_text_expected.equals(element123))
    		 {
    			 System.out.println("Text Under teacher support 3.1 is verified successfully.");
    	 }
     
    		 else{
    		 System.out.println("Text is not present, failed.");
    	 }
    		  driver.findElement(By.xpath("button[title='Save the Form']")).click();
    		  
    		 }
     @Test(priority=5)
     public void Culture_3() throws InterruptedException {
    	 
    	 Thread.sleep(3000);
    	 
    	 
    	 
    	
       // if(teacher_txt.isEnabled() && teacher_s_txt.contains("Learning environments in IB World Schools support and empower teachers."));
        driver.findElement(By.xpath("span[title='Cultura 1: El colegio garantiza el acceso de la mayor variedad posible de alumnos a la educación del IB. (0301-01)']")).click();
        Thread.sleep(2000);
        
    	
        
     
     String culture_txt_title= "Los colegios deben tratar de que sus programas del IB estén disponibles para el mayor número de alumnos posible, garantizando la igualdad de acceso al currículo y brindando a los alumnos el apoyo que necesiten para fijarse metas educativas adecuadamente exigentes y para cumplir esas metas. Para obtener más información sobre la admisión, el acceso y la inclusión de alumnos en el IB, consulte la publicación De los principios a la práctica correspondiente al programa en cuestión. Esas publicaciones se encuentran disponibles en el Centro de recursos para los programas del IB";
     WebElement culture_text= driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/div[1]")); 
     
     String Actual_one=culture_text.getText();
    
     //if(culture_text.isEnabled() && cul.contains("Schools develop, implement, communicate and review effective policies that help to create a school culture in which IB philosophy can thrive."));
     if(culture_txt_title.equals(Actual_one))
     {
    	 System.out.println("Text under culture 1 is verified and present.");
     }
     else {
    	 System.out.println("Text under culture 1 is not present");
     }
     driver.findElement(By.xpath("//span[@title='Cultura 1.3: El colegio proporciona oportunidades de acceso a los programas a la mayor variedad posible de alumnos. (0301-01-0300)']")).click();
     
     driver.findElement(By.xpath("//div[@class=\"slds-form-element__control slds-grow textarea-container\"] //textarea[@id=\"input-142\"]")).sendKeys("Culture text 1.3 entered");
     driver.findElement(By.xpath("//span[@title='PEP 1: El colegio articula y demuestra que todos los alumnos pueden acceder al PEP, sin importar la variabilidad entre ellos, a menos que el entorno regulatorio del colegio impida la matriculación de todo el alumnado y requiera que el colegio ofrezca a determinados alumnos el currículo nacional o estatal/provincial correspondiente. (0301-01-0311)']")).click();
     driver.findElement(By.xpath("//div[@id='lgt-accordion-section-138']//lightning-textarea[@class='slds-m-left_medium slds-size_1-of-2 input slds-form-element']")).sendKeys("PYP1 Text Entered");	 
     
     Select select_Q2=new Select(driver.findElement(By.xpath("//button[@id='combobox-button-157']//span[@class='slds-truncate'][normalize-space()='Ninguno']")));
     select_Q2.selectByIndex(0);
     
     Select select_Q3=new Select(driver.findElement(By.xpath("//button[@id='combobox-button-162']//span[@class='slds-truncate'][normalize-space()='Ninguno']")));
     
     select_Q3.selectByIndex(0);
   //span[normalize-space()='Ninguno']
   //span[@class='slds-truncate']
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-textarea[2]/div[1]/textarea[1]")).sendKeys("PYP1 Question4 entered value");
   //label[@for='radio-0-168']//span[@class='slds-form-element__label'][normalize-space()='Sí']
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-radio-group[1]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-radio-group[2]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-radio-group[3]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-radio-group[4]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-radio-group[5]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-radio-group[6]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-radio-group[7]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-radio-group[8]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[1]/section[1]/div[2]/slot[1]/lightning-accordion[1]/slot[1]/lightning-accordion-section[2]/section[1]/div[2]/slot[1]/lightning-radio-group[9]/fieldset[1]/div[1]/span[1]/label[1]/span[1]")).click();
     driver.findElement(By.xpath("button[title='Save the Form']")).click();
     WebElement element_budget=driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/div[2]"));
     String Paragraph_budget=element_budget.getText();
     
     if(element_budget.equals(Paragraph_budget))
     {
    	 System.out.println("Paragraph is displaying in the budget section and present!" +Paragraph_budget);
     }
     else {
    	 System.out.println("Paragraph in budget section is not displaying! Not present");
    	 
     }
    
     
    //if(culture1_text.isEnabled() && culturemain_italic.contains("Schools should seek to make their IB programme(s) available to as many students as possible, ensuring equality of access to the curriculum and providing students with the support they need to set and meet appropriately challenging educational goals. For more information on admission, access and inclusion in the IB, please consult the From principles into practice publication for the relevant programme(s). These publications are available on the IB programme resource centre."));
    
    
  
    
    Thread.sleep(3000);
   
    	 
    
	Select budget_dropdown= new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/lightning-combobox[1]/div[1]/lightning-base-combobox[1]/div[1]/div[1]/button[1]/span[1]")));
	budget_dropdown.selectByIndex(2);
        
         Thread.sleep(2000);
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[2]/div[1]/lightning-input[1]/div[1]")).sendKeys("58");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[3]/div[1]/lightning-input[1]/div[1]")).sendKeys("59");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[4]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[5]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[3]/td[6]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[3]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[4]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[5]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[4]/td[6]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[2]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[3]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[4]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[5]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[5]/td[6]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[2]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[3]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[4]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[5]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[6]/td[6]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[2]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[3]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[4]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[5]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[7]/td[5]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[2]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[3]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[4]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[5]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[9]/td[6]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[2]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[3]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[4]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[5]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[10]/td[6]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[2]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[3]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[4]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
        
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[5]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");
         driver.findElement(By.xpath("//body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-budget-section[1]/table[1]/tbody[1]/tr[11]/td[6]/div[1]/lightning-input[1]/div[1]")).sendKeys("60");

         driver.findElement(By.xpath("button[title='Save the Form']")).click();
     }
  
   
     @Test(priority=6)
     public void Document() throws InterruptedException {
    	 
    	
    	 //(//*[name()='svg'][@class='slds-button__icon slds-button__icon_left'])[1]
    	 WebElement ele_doc= driver.findElement(By.xpath("//lightning-button[@data-document-type='Legal entity documentation']//button[@type='button'][normalize-space()='Cargar']"));
    	 ele_doc.click();
    	
    	 
    	WebElement ele_upload_doc=driver.findElement(By.xpath("//span[@class='slds-file-selector__button slds-button slds-button_neutral']//lightning-primitive-icon//*[name()='svg']"));
    	//ele_upload_doc.sendKeys("C:\\Users\\Omer.Ejaz\\Desktop\\apex.PNG");
    	//Declaring a constructor to run atleast one time must
    	File file= new File("./cyber.PNG");
    	System.out.println(file.getAbsolutePath());
    	
    	ele_upload_doc.sendKeys(file.getAbsolutePath());
    	driver.findElement(By.xpath("//lightning-button[@data-id='confirmationButton']//button[@type='button'][normalize-space()='Cargar']")).click();
    	Thread.sleep(2000);
    	
    	
    	 
    	 
    	 
    	// driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-documents-section[1]/div[3]/div[2]/lightning-button[1]/button[1]")).click();
    	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-documents-section[1]/c-custom-modal[1]/div[1]/section[1]/div[1]/footer[1]/lightning-button[2]/button[1]")).click();
    	Thread.sleep(2000);
    	String error_msg="Please select the file first.";
    	WebElement error= driver.findElement(By.xpath("//div[@role=\"alert\"]"));
    	String doc_error=error.getAttribute("textContent");
    	if(error.isEnabled() && doc_error.contains("Please select the file first."));
    	
    	System.out.println("error message found, empty can not be uploaded.");
    	
    			
    	Thread.sleep(6000);
    	WebElement upload= driver.findElement(By.xpath("/html[1]/body[1]/div[3]/c-ib-psp-forms[1]/lightning-layout[1]/slot[1]/lightning-layout-item[2]/slot[1]/lightning-layout-item[1]/slot[1]/c-ib-psp-documents-section[1]/c-custom-modal[1]/div[1]/section[1]/div[1]/div[1]/slot[1]/span[1]/lightning-input[1]/div[1]/div[1]/lightning-primitive-file-droppable-zone[1]/slot[1]/label[1]/span[1]"));
    	Thread.sleep(2000);
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
     
    
	


