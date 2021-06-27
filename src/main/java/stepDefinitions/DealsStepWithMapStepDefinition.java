package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BrowserUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class DealsStepWithMapStepDefinition {

/**
 * Data Table with MAPS concept
 * We will have data table in Feature file
 * The data table from feature file will be accessed in Step Definition file using Maps concept
 * Using a FOR EACH Loop
 * 
 * public void methName(DataTable data)
 * For(Map<String,String> dataTableValues : data.asMap(String.class, String.class)
 * {
 * 		dataTableValues.get("colNameOfDataTableInFeaturesFile");
 * }
 * 
 */
	WebDriver driver;
	BrowserUtils bu;
	String dealName;
	
	@Given("^user is already on Login page")
	public void user_already_on_login_page()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		bu=new BrowserUtils(driver);
		driver.manage().window().maximize();
		driver.get("https://ui.cogmento.com/");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe("https://ui.cogmento.com/"));
	}
		
	@When("^title of Login page is Free CRM$")
	public void title_of_login_page_is_free_CRM() {
		Assert.assertEquals("Cogmento CRM", driver.getTitle());
	}
		
	@Then("^user enters username and the password$")
	public void user_enters_username_and_the_password(DataTable credentials) {
		for(Map<String, String> loginDataMap : credentials.asMaps(String.class, String.class)) {
			bu.getEle(By.xpath("//input[@name='email']")).sendKeys(loginDataMap.get("username"));
			bu.getEle(By.xpath("//input[@name='password']")).sendKeys(loginDataMap.get("password"));
		}
	}
	
	@Then("^user clicks on the login button$")
	public void user_clicks_on_loginButton(){
		bu.getEle(By.xpath("//div[text()='Login']")).click();
	}
		
	@Then("^user is on Homepage$")
	public void user_is_on_Homepage(){
		if(bu.waitForPageTitle("Cogmento CRM")) {
	    	System.out.println("User is logged in");
	    }	
	}

	@Then("^user hovers on deals icon and clicks$")
	public void user_hovers_on_deals_icon_and_clicks(){
	    bu.mouseHoverandClick(By.xpath("//i[@class='money icon']"));
	}


	@Then("^user clicks on New button$")
	public void user_clicks_on_New_button(){
		bu.getEle(By.xpath("//button[contains(text(),'Create')]")).click();
		if(bu.getEle(By.xpath("//div[text()='Create new Deal']")).isDisplayed()) {
			System.out.println("User is navigated to new deal creation page");
		}
	}

	@Then("^user will enter deal details$")
	public void user_will_enter_deal_details(DataTable dealData){
	    for(Map<String, String> dealDataValues : dealData.asMaps(String.class, String.class)) {
	    	dealName=dealDataValues.get("dealTitle");
	    	bu.getEle(By.xpath("//input[@name='title']")).sendKeys(dealDataValues.get("dealtitle"));
	    	bu.getEle(By.xpath("//input[@name='amount']")).sendKeys(dealDataValues.get("amount"));
	    	bu.getEle(By.xpath("//input[@name='probability']")).sendKeys(dealDataValues.get("probablity"));
	    	bu.getEle(By.xpath("//input[@name='commission']")).sendKeys(dealDataValues.get("commission"));
	    	bu.getEle(By.xpath("//button[contains(text(),'Save')]")).click();
	    	
	    	user_hovers_on_deals_icon_and_clicks();
	    	user_clicks_on_New_button();
	    }
	
	}

	@Then("^user navigates to home page$")
	public void user_navigates_to_home_page(){
	
	}

	@Then("^the created deals can be validated on deals activity$")
	public void the_created_deals_can_be_validated_on_deals_activity() throws InterruptedException{
	
//		Thread.sleep(3000);
//		System.out.println(bu.getEle(By.xpath("//div[contains(@class,'ui header item mb')]")).getText());
//		Assert.assertEquals(dealName, bu.getEle(By.xpath("//div[contains(@class,'ui header item mb')]")).getText());
	}
	
	@Then("^user closed browser$")
	public void user_closes_the_browser(){
	    driver.quit();
	}
	
}
