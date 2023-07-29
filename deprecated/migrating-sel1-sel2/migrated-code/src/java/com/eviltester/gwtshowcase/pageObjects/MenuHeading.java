package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MenuHeading {

	private String menuHeading;
	private String firstMenuItemName;
	private WebDriver driver;
	

	public MenuHeading(WebDriver driver, String menuHeading, String firstMenuItemName) {
		this.driver = driver;
		this.menuHeading = menuHeading;
		this.firstMenuItemName = firstMenuItemName;
	}
	
	public boolean isOpen(){
		By childDiv = By.xpath("//div[@class='GALD-WOBF' and .='" + this.firstMenuItemName + "']");
		return(elementFound(childDiv));		
	}
	
	private boolean elementFound(By byLocator) {
		try{
			driver.findElement(byLocator);
			return true;
		}
		catch(NoSuchElementException e){
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
		WebDriverWait wait = new WebDriverWait(driver,20);
		ExpectedConditionFactory weCanSee = new ExpectedConditionFactory();
		
		String menuImage = "//div[.='"+ this.menuHeading + "']/../div/img";
		driver.findElement(By.xpath(menuImage)).click();
		
		By parentDiv = By.xpath("//div[.='"+ this.menuHeading + "']/../../..");
		wait.until(weCanSee.elementStopsGrowing(parentDiv,driver));
	}

	
}
