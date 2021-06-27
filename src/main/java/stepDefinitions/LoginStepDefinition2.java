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

public class LoginStepDefinition2
{
	WebDriver driver;
	
	@Given("^user is already on login2 page$")
	public void user_already_on_login2_page()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://ui.cogmento.com/");
		wait.until(ExpectedConditions.urlContains("cogmento"));
	}
	
	@SuppressWarnings("deprecation")
	@When("^title of login2 page is Free CRM$")
	public void title_of_login2_page_is_free_CRM() {
		String expectedTitle = "Cogmento CRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);		
	}
	
	@Then("^user enters2 username and password$")
	
	public void user_enters2_username_and_password(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']"))).sendKeys("puneeth297@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Krishna123");
	}

	@Then("^user clicks on login2 button$")
	public void user_clicks_on_login2_button(){
		driver.findElement(By.xpath("//div[text() = 'Login']")).click();
	}

	@SuppressWarnings("deprecation")
	@And("^user is on homepage2$")
	public void user_is_on_homepage2(){
		String expectedTitle = "Cogmento CRM";
		String actualTitle = driver.getTitle();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("CRM"));
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println(actualTitle);
	}
	
	@Then ("^close the browser2$")
	public void close_browser2() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}
