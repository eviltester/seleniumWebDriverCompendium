package com.eviltester.gwtshowcase.pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.Wait;


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
			waitForOpen();
		}
	}
	
	private void waitForOpen() {
		new Wait(){
			@Override
			public boolean until() {
				return isOpen();
			}
		}.wait("did not open");	
	}

	private void waitForClosed() {
		new Wait(){
			@Override
			public boolean until() {
				return !isOpen();
			}
		}.wait("did not open");
	}

	public void close(){
		if(isOpen()){
			openClose();
			waitForClosed();
		}		
	}
	
	public void openClose() {
		driver.findElement(By.xpath("//div[.=\""+ this.menuHeading + "\"]/../div/img")).click();
	}

	
}
