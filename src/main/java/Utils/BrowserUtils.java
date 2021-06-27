package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils 
{
	public WebDriver driver;
	
	public BrowserUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getEle(By loc) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(loc));
		flash(ele);
		return ele;
	}
	
	public boolean waitForPageTitle(String title_txt) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		boolean titleMatch = wait.until(ExpectedConditions.titleContains(title_txt));
		return titleMatch;
	}
	
	public void mouseHoverandClick(By loc) {
		Actions action=new Actions(driver);
		WebElement targetEle=getEle(loc);
		flash(targetEle);
		action.moveToElement(targetEle).click().build().perform();
	}
	
	
	
	
	
	
	public void flash(WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String bgcolor = ele.getCssValue("backgroundColour");
//		Flash 10 times
		for(int i=0;i<=5;i++) {
			changeColor("rgb(200,0,0)", ele);
			changeColor(bgcolor, ele);
		}
	}
	
	public void changeColor(String color, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", ele);
		try {
			Thread.sleep(40);
		}	catch(Exception e) {}
	}
}
