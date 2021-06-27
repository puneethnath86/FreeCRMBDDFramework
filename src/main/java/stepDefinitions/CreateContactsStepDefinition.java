package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BrowserUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class CreateContactsStepDefinition{
	
	
	public WebDriver driver;
	BrowserUtils bu;
	String contactName;
	
	@Given("^user is on Login page of \"([^\"]*)\"$")
	public void user_is_on_Login_page_of(String url){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(url);
		bu=new BrowserUtils(driver);
		wait.until(ExpectedConditions.urlContains("cogmento"));
	}

	@When("^title of the Login page is Free CRM$")
	public void title_of_the_Login_page_is_Free_CRM(){
		String expectedTitle = "Cogmento CRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("^user will enter \"([^\"]*)\" and the \"([^\"]*)\"$")
	public void user_will_enter_and_the(String un, String pw){
		bu.getEle(By.xpath("//input[@name='email']")).sendKeys(un);
		bu.getEle(By.xpath("//input[@name='password']")).sendKeys(pw);
	}

	@Then("^user will click on the login button$")
	public void user_will_click_on_the_login_button(){
		bu.getEle(By.xpath("//div[text()='Login']")).click();
	}

	@Then("^user is navigated to the Homepage$")
	public void user_is_navigated_to_the_Homepage(){
	    if(bu.waitForPageTitle("Cogmento CRM")) {
	    	System.out.println("User is logged in");
	    }	    
	}

	@Then("^user hovers and clicks on contacts icon$")
	public void user_hovers_and_clicks_on_contacts_icon(){
//	    bu.getEle(By.xpath("//a[@href='/contacts']/i"));
	    bu.mouseHoverandClick(By.xpath("//a[@href='/contacts']/i"));
	}

	@Then("^Contacts page is displayed to the user$")
	public void contacts_page_is_displayed_to_the_user(){
	    if(bu.getEle(By.xpath("//div[text()='Contacts']")).isDisplayed()) {
	    	System.out.println("User is on contacts page");
	    }
	}

	@Then("^user will be clicking on New button$")
	public void user_will_be_clicking_on_New_button(){
	    bu.getEle(By.xpath("//button[text()='Create']")).click();
	}

	@Then("^user will enter new user details to be created \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_will_enter_new_user_details_to_be_created_and(String fn, String ln){
	    if(bu.getEle(By.xpath("//div[text()='Create New Contact']")).isDisplayed()) {
	    	contactName=fn+" "+ln;
	    	bu.getEle(By.xpath("//input[@name='first_name']")).sendKeys(fn);
	    	bu.getEle(By.xpath("//input[@name='last_name']")).sendKeys(ln);
	    }
	}

	@Then("^clicks on Save$")
	public void clicks_on_Save(){
		bu.getEle(By.xpath("//i[@class='save icon']")).click();
	}


	@Then("^the created contacts can be validated on Contacts activity$")
	public void the_created_contacts_can_be_validated_on_Contacts_activity() throws InterruptedException{
		Thread.sleep(3000);
	    String actualText=bu.getEle(By.xpath("//div[contains(@class, 'ui header item mb')]")).getText();
	    Assert.assertEquals(contactName, actualText);
	}

}








//
//public class CreateContactsStepDefinition {
//	
//	WebDriver driver;
//	@Given("^user is already on Login page of \"(.*)\"$")
//	public void user_already_on_login_page(String pageURL)
//	{
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get(pageURL);	
//	}
//	
//	@When("^title of Login page is Free CRM$")
//	public void title_of_login_page_is_free_CRM() {
//		String expectedTitle = "Cogmento CRM";
//		String actualTitle = driver.getTitle();
//		Assert.assertEquals(expectedTitle, actualTitle);		
//	}
//	
//	@Then("^user enters \"(.*)\" and the \"(.*)\"$")
////	\"(.*)\" ----> (.*) --> This is a regular expression to tell that username and passwords are parameterized{\"}
////	This  is another regular expression that can be used ([^]*) with \"----> \"([^\"]*)\"
//	
//	public void user_enters_username_and_password(String username, String password){
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	  driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys(username);
//	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
//	  
//	 
//	}
//
//	@Then("^user clicks on the login button$")
//	public void user_clicks_on_loginButton(){
//		driver.findElement(By.xpath("//div[text() = 'Login']")).click();
//	  
//	}
//
//	@And("^user is on Homepage$")
//	public void user_is_on_homepage(){
//		String expectedTitle = "Cogmento CRM";
//		String actualTitle = driver.getTitle();
//	   Assert.assertEquals(expectedTitle, actualTitle);
//	   
//	}
//	
//	@Then("^user hovers on contacts icon and clicks$")
//	public void user_hovers_on_contacts_icon_and_clicks() {
//		By contactsIcon = By.xpath("//i[@class='users icon']");
//		driver.findElement(contactsIcon).click();
//	}
//	
//	@And("^Contacts page is displayed$")
//	public void Contacts_page_is_displayed() {
//		By contactsText = By.xpath("//div[text()='Contacts']");
//		if(driver.findElement(contactsText).isDisplayed()) {
//			System.out.println("User is on contacts page");
//		}
//		else {
//			System.out.println("Unable to navigate to contacts page");
//		}
//	}
//	
//	@Then("^user clicks on New button$")
//	public void user_clicks_on_New_button() {
//		By createNewContactBtn=By.xpath("//button[text()='New']");
//		driver.findElement(createNewContactBtn).click();
//	}
//	
////	\"([^\"]*)\"
//	@And("^user will enter \"([^\"]*)\" and \"([^\"]*)\"$")
//	public void user_will_enter_FirstName_and_LastName(String firstname, String lastname) {
//		By firstNameTxt = By.xpath("//input[@name='first_name']");
//		By lastNameTxt = By.xpath("//input[@name='last_name']");
//		driver.findElement(firstNameTxt).sendKeys(firstname);
//		driver.findElement(lastNameTxt).sendKeys(lastname);
//	}
//	
//	@Then("^clicks on Save$")
//	public void clicks_on_Save() {
//	  By contactSaveBtn = By.xpath("//button[text()='Save']");
//	  driver.findElement(contactSaveBtn).click();
//	}
//
//	@Then("^user navigates to home page$")
//	public void user_navigates_to_home_page(){
//		By homePageIcon = By.xpath("//span[text()='Home']");
//		driver.findElement(homePageIcon).click();
//	}
//
//	@Then("^the created contacts can be validated on Contacts activity$")
//	public void the_created_contacts_can_be_validated_on_Contacts_activity(){
//		
//	}
//	
//	@Then ("^user closes the browser$")
//	public void user_closes_the_browser() {
//		driver.quit();
//	}
//}
