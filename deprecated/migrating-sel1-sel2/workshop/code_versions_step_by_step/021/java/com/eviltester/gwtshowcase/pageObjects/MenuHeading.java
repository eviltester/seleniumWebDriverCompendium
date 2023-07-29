package com.eviltester.gwtshowcase.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MenuHeading {

	private String menuHeading;
	private String firstMenuItemName;
	private WebDriver driver;
	private ExpectedConditionFactory weCanSee;
	private WebDriverWait wait;

	public MenuHeading(WebDriver driver, String menuHeading, String firstMenuItemName) {
		this.driver = driver;
		this.menuHeading = menuHeading;
		this.firstMenuItemName = firstMenuItemName;
		
		weCanSee = new ExpectedConditionFactory();
		wait = new WebDriverWait(driver,20);
	}
	
	public boolean isOpen(){
		return(elementFound(By.xpath("//div[@class=\"GALD-WOBF\" and .=\"" + this.firstMenuItemName + "\"]")));
	}
	
	private boolean elementFound(By byLocator) {
		 try {
		      driver.findElement(byLocator);
		      return true;
		 } catch (NoSuchElementException e) {
		      return false;
		 }
	}
	
	public boolean isClosed(){
		return(!isOpen());
	}	

	public void open(){
		if(isClosed()){
			openClose();
		}
	}

	public void close(){
		if(isOpen()){
			openClose();
		}		
	}
	
	public void openClose() {
		driver.findElement(By.xpath("//div[.=\""+ this.menuHeading + "\"]/../div/img")).click();
		By parentDiv = By.xpath("//div[.=\""+ this.menuHeading + "\"]/../../..");
		wait.until(weCanSee.elementStopsGrowing(parentDiv, driver));	
	}

	
}
