package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.BasePage;

public class ContactsPage extends BasePage
{
	@FindBy(xpath="")
	private WebElement xx;
	
	@FindBy(xpath="")
	private WebElement xx2;
	
	@FindBy(xpath="")
	private WebElement xx3;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
}
