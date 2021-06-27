//package stepDefinitions;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import cucumber.api.DataTable;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import junit.framework.Assert;
//
//public class DealsStepDefinition {
//
//	WebDriver driver;
//	@Given("^user is already on Login page")
//	public void user_already_on_login_page()
//	{
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://ui.cogmento.com/");	
//	}
//	
//	@When("^title of Login page is Free CRM$")
//	public void title_of_login_page_is_free_CRM() {
//		String expectedTitle = "Cogmento CRM";
//		String actualTitle = driver.getTitle();
//		Assert.assertEquals(expectedTitle, actualTitle);		
//	}
//	
//	@Then("^user enters username and the password$")
//	public void user_enters_username_and_the_password(DataTable credentials) {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
////		Initializing credentials variable that is of type DataTable
////		raw will give complete access to the data table using cucumber API's
//		List<List<String>> loginData = credentials.raw();
//		
//		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys(loginData.get(0).get(0));
//		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(loginData.get(0).get(1));
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
//	@Then("^user hovers on deals icon and clicks$")
//	public void user_hovers_on_deals_icon_and_clicks() {
//	    By dealsIconLoc = By.xpath("//i[@class='money icon']");
//	    driver.findElement(dealsIconLoc).click();
//	}
//
//	@And("^deals page is displayed$")
//	public void deals_page_is_displayed(){
//		By dealsText = By.xpath("//div[text()='Deals']");
//		if(driver.findElement(dealsText).isDisplayed()) {
//			System.out.println("User is on deals page");
//		}
//		else {
//			System.out.println("Unable to navigate to deals page");
//		}
//	}
//
//	@Then("^user clicks on New button$")
//	public void user_clicks_on_New_button() {
//		By createNewContactBtn=By.xpath("//button[text()='New']");
//		driver.findElement(createNewContactBtn).click();
//	}
//	
//	@And("^user will enter deal details$")
//	public void user_will_enter_deal_details(DataTable dealsData){
////		raw is used to initialize the data table local variable that is of DataTable class type
//		List<List<String>> dealsDataList = dealsData.raw();
//		
//		By dealNameLoc = By.xpath("//input[@name='title']");
//		By amountLoc = By.xpath("//input[@name='amount']");
//		By probablityLoc = By.xpath("//input[@name='probability']");
//		By commissionLoc = By.xpath("//input[@name='commission']");
//		
////		Getting data from Test data table from 0th row and 0 to 3rd element of the data table from features file
//		driver.findElement(dealNameLoc).sendKeys(dealsDataList.get(0).get(0));
//		driver.findElement(amountLoc).sendKeys(dealsDataList.get(0).get(1));
//		driver.findElement(probablityLoc).sendKeys(dealsDataList.get(0).get(2));
//		driver.findElement(commissionLoc).sendKeys(dealsDataList.get(0).get(3));
//	    
//	}
//	
//	@And("^clicks on Save$")
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
//	
//	@Then("^the created deals can be validated on deals activity$")
//	public void the_created_deals_can_be_validated_on_deals_activity(){
//	    
//	}
//	
//	@Then("^user closes the browser$")
//	public void user_closes_the_browser(){
//	    driver.quit();
//	}
//}
