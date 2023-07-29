package com.eviltester.gwtshowcase.pageObjects;

import com.thoughtworks.selenium.Selenium;

public class MenuHeading {

	private String menuHeading;
	private String firstMenuItemName;
	private Selenium selenium;

	public MenuHeading(Selenium selenium, String menuHeading, String firstMenuItemName) {
		this.selenium = selenium;
		this.menuHeading = menuHeading;
		this.firstMenuItemName = firstMenuItemName;
	}
	
	public boolean isOpen(){
		return(selenium.isElementPresent("//div[@class=\"GALD-WOBF\" and .=\"" + this.firstMenuItemName + "\"]"));
	}
	
	public boolean isClosed(){
		return(!isOpen());
	}	

	public void open(){
		if(isClosed()){
			openClose();
			waitForOpen();
		}
	}
	
	private void waitForOpen() {
		try {
			selenium.waitForCondition("selenium.isElementPresent('xpath=//div[@class=\"GALD-WOBF\" and .=\"" + this.firstMenuItemName + "\"]');", "2000");
		} catch (Exception e) {
		}		
	}

	private void waitForClosed() {
		try {
			selenium.waitForCondition("!selenium.isElementPresent('xpath=//div[@class=\"GALD-WOBF\" and .=\"" + this.firstMenuItemName + "\"]');", "2000");
		} catch (Exception e) {
		}		
	}	
	public void close(){
		if(isOpen()){
			openClose();
			waitForClosed();
		}		
	}
	
	public void openClose() {
		selenium.fireEvent("//div[.=\""+ this.menuHeading + "\"]/../div/img","mousedown");
	}

	
}
