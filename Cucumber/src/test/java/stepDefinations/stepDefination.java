package stepDefinations;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;

import java.awt.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@RunWith(Cucumber.class)
public class stepDefination {
	WebDriver driver;
	  	

    @Given("^I am on NHS cost checking portal$")
    public void i_am_on_nhs_cost_checking_portal() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");					
    	driver= new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.manage().window().maximize();			
        driver.get("https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start");	  
    }

    @When("^I start my journey to get NHS costs$")
    public void i_start_my_journey_to_get_nhs_costs() throws Throwable {
    	
    	driver.findElement(By.id("next-button")).click();
    }
    
    @And("^for \"([^\"]*)\" \"([^\"]*)\" and click next$")
    public void for_something_something_and_click_next(String question, String country) throws Throwable  {
   	
   	 Actions act= new Actions(driver);   
   	 act.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + question + "')]/parent::fieldset//input[@value='" + country + "']"))).click().build().perform();
   	driver.findElement(By.id("next-button")).click();
   
    }

    @And("^enter dd as \"([^\"]*)\" mm as \"([^\"]*)\" yy as \"([^\"]*)\" for What is your date of birth and navigate to next screen$")
    public void enter_dd_as_something_mm_as_something_yy_as_something_for_what_is_your_date_of_birth_and_navigate_to_next_screen(String strArg1, String strArg2, String strArg3) throws Throwable  {
    	driver.findElement(By.id("dob-day")).sendKeys(strArg1);
    	driver.findElement(By.id("dob-month")).sendKeys(strArg2);
    	driver.findElement(By.id("dob-year")).sendKeys(strArg3);
    	driver.findElement(By.id("next-button")).click();
    }
    
    @And("^select \"([^\"]*)\" for \"([^\"]*)\" question and navigate to next screen$")
    public void select_something_for_something_question_and_navigate_to_next_screen(String answer, String question) throws Throwable {
      Actions act= new Actions(driver);   
      act.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + question + "')]/parent::fieldset//input[@value='" + answer + "']"))).click().build().perform();  
      driver.findElement(By.id("next-button")).click();
    }
    
    @And("^choose \"([^\"]*)\" for \"([^\"]*)\" question and navigate to next screen$")
    public void choose_something_for_something_question_and_navigate_to_next_screen(String answer, String question) throws Throwable {
        Actions act= new Actions(driver);   
        act.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + question + "')]/parent::fieldset//input[@value='" + answer + "']"))).click().build().perform();  
        driver.findElement(By.id("next-button")).click();
    }
    @When("^set \"([^\"]*)\" for question \"([^\"]*)\" navigate to next screen$")
    public void set_for_question_navigate_to_next_screen(String answer, String question) throws Throwable {
        Actions act= new Actions(driver);   
        act.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + question + "')]/parent::fieldset//*[contains(text()[normalize-space()],\"" + answer +"\")]"))).click().build().perform();  
       driver.findElement(By.id("next-button")).click();
    }
    @When("^user slects \"([^\"]*)\" for \"([^\"]*)\" question and navigate to next screen$")
    public void user_slects_for_question_and_navigate_to_next_screen(String answer, String question) throws Throwable {
        
        Actions act= new Actions(driver);   
        act.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + question + "')]/following::fieldset//input[@value='" + answer + "']"))).click().build().perform();  
        driver.findElement(By.id("next-button")).click();
    }
    @And("^User selects \"([^\"]*)\" for take-home pay of £935 or less in your last Universal Credit period and click next$")
    public void user_selects_something_for_takehome_pay_of_935_or_less_in_your_last_universal_credit_period_and_click_next(String answer) throws Throwable {
    	 Actions act= new Actions(driver);   
         act.moveToElement(driver.findElement(By.xpath("//*//*[contains(text(),'Take-home pay is used to work out your Universal Credit payments')]/following::fieldset//input[@value='" + answer + "']"))).click().build().perform();  
         driver.findElement(By.id("next-button")).click(); 
    	
    }
    
    @And("^check screen \"([^\"]*)\" displayed and navigate to next screen$")
    public void check_screen_something_displayed_and_navigate_to_next_screen(String pagename) throws Throwable {
    	if(driver.getTitle().equals(pagename)){
    		driver.findElement(By.id("next-button")).click();
    	}
    	
    }
    
    @And("^Select Income Support for Do you or your partneet any of these benefits and navigate to next screen$")
    public void select_income_support_for_do_you_or_your_partneet_any_of_these_benefits_and_navigate_to_next_screen() throws Throwable {

    	      Actions act= new Actions(driver);   
    	      act.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Do you or your partner get any of these benefits?')]/following::fieldset//*[contains(text()[normalize-space()],'Income Support')]"))).click().build().perform(); 
    	      driver.findElement(By.id("next-button")).click();
    	 //*[contains(text(),'Do you or your partner get any of these benefits?')]/following::fieldset//*[contains(text()[normalize-space()],'Income Support')]
      
       }
    	
	
    @Then("^user should get You or your partner's Income Support entitles you to help with NHS costs Page$")
    public void user_should_get_you_or_your_partners_income_support_entitles_you_to_help_with_nhs_costs_page() throws Throwable {
      
    	String my_title = driver.getTitle();
    	String exp_title = "You or your partner's Income Support entitles you to help with NHS costs" ;
    	Assert.assertEquals(my_title ,exp_title );
    	
    	
    	if(driver.getTitle().equals("You or your partner's Income Support entitles you to help with NHS costs")){
      		 System.out.println("Test is successfull");
    	}
    }
    
    
    
    
    
    @Then("^user should get only NHS prescriptions as free$")
    public void user_should_get_only_nhs_prescriptions_as_free() throws Throwable {
   	 	     
    	if(driver.getTitle().equals("Because you or your partner get qualifying universal credit you get help paying NHS costs")){
   		 System.out.println("Test is successfull");
    }    	
         
   
    }
}