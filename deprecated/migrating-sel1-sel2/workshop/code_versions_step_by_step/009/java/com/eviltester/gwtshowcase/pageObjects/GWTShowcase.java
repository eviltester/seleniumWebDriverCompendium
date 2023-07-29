package com.eviltester.gwtshowcase.pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

public class GWTShowcase {

	private Selenium selenium;
	private WebDriver driver;
	public static final String TITLE_OF_SHOWCASEPAGE_STARTSWITH = "Showcase of Features: ";
	
	public GWTShowcase(WebDriver driver) {
		this.driver = driver;
		this.selenium = new WebDriverBackedSelenium(driver,"http://localhost/");
	}

	public void open() {
		driver.get("http://localhost/showcase.html");
		
		new Wait("Page Did Not Load"){
		     @Override
		     public boolean until() {				
			   try{
		             return driver.getTitle().startsWith(TITLE_OF_SHOWCASEPAGE_STARTSWITH);
		         }catch(Exception e){
		             // ignore not found exceptions 
		         };
		         return false;
		     }}.wait("Page Did Not Load");
		     		
		assertTrue("wrong title", getPageTitle().startsWith(TITLE_OF_SHOWCASEPAGE_STARTSWITH));
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}

	public SideMenu sideMenu() {
		return new SideMenu(selenium);
	}

}
