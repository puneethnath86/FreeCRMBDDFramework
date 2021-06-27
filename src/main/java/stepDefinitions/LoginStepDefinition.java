package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginStepDefinition
{
	WebDriver driver;
	
	@Given("^user is already on login page of \"(.*)\"$")
	public void user_already_on_login_page(String pageURL)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(pageURL);
		wait.until(ExpectedConditions.urlContains(pageURL));
	}
	
	@SuppressWarnings("deprecation")
	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_free_CRM() {
		String expectedTitle = "Cogmento CRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);		
	}
	
	@Then("^user enters \"(.*)\" and \"(.*)\"$")
//	\"(.*)\" ----> (.*) --> This is a regular expression to tell that username and passwords are parameterized{\"}
//	This  is another regular expression that can be used ([^]*) with \"----> \"([^\"]*)\"
	
	public void user_enters_username_and_password(String un, String pwd){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']"))).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button(){
		driver.findElement(By.xpath("//div[text() = 'Login']")).click();
	  
	}

	@And("^user is on homepage$")
	public void user_is_on_homepage(){
		String expectedTitle = "Cogmento CRM";
		String actualTitle = driver.getTitle();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("CRM"));
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println(actualTitle);	   
	}
	
	@Then ("^close the browser$")
	public void close_browser() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}
