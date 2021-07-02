package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.BasePage;
import junit.framework.Assert;

public class HomePage extends BasePage
{
	@FindBy(xpath="")
	private WebElement xx;
	
	@FindBy(xpath="//i[@class='money icon']")
	private WebElement dealsLink;
	
	@FindBy(xpath="//a[@href='/contacts']/i")
	private WebElement contactLink;
	
	@FindBy(xpath="//span[@class='user-display']")
	private WebElement usernameText;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateHomePageTitle(String expectedTitle) {
		String actual=driver.getTitle();
		Assert.assertEquals(expectedTitle, actual);
	}
	
	
	public void validateLoggedInUser() {
		String actual=usernameText.getText();
		String expected=prop.getProperty("usernameText");
		Assert.assertEquals(expected, actual);
	}
	
	public ContactsPage clickContacts() {
		Actions action=new Actions(driver);
		action.moveToElement(contactLink).click().build().perform();
		return new ContactsPage();
	}
	
	public DealsPage clickDeals() {
		Actions action=new Actions(driver);
		action.moveToElement(dealsLink).click().build().perform();
		return new DealsPage();
	}
}
