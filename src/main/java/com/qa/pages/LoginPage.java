package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utils.BasePage;

public class LoginPage extends BasePage
{
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement userNameTxt;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTxt;
	
	@FindBy(xpath="//div[text() = 'Login']")
	private WebElement loginBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateLoginPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	public void enterCredentials(String uname, String pass) {
		userNameTxt.sendKeys(uname);
		passwordTxt.sendKeys(pass);
	}
	
	public HomePage clickLoginBtn() {
		loginBtn.click();
		return new HomePage();
	}
}
