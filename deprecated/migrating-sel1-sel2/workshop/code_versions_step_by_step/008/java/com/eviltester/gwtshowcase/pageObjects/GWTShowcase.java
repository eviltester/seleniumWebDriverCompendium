package com.eviltester.gwtshowcase.pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;

import com.thoughtworks.selenium.Selenium;

public class GWTShowcase {

	private Selenium selenium;
	private WebDriver driver;
	public static final String TITLE_OF_SHOWCASEPAGE_STARTSWITH = "Showcase of Features: ";
	
	public GWTShowcase(WebDriver driver) {
		this.driver = driver;
		this.selenium = new WebDriverBackedSelenium(driver,"http://localhost/");
	}

	public void open() {
		selenium.open("showcase.html");
		
		// ajax page so wait for it to load
		selenium.waitForCondition("document.title.match(/" + TITLE_OF_SHOWCASEPAGE_STARTSWITH + "/);", "2000");
		
		assertTrue("wrong title", getPageTitle().startsWith(TITLE_OF_SHOWCASEPAGE_STARTSWITH));
	}
	
	public String getPageTitle(){
		return selenium.getTitle();
	}

	public SideMenu sideMenu() {
		return new SideMenu(selenium);
	}

}
