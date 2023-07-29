package com.eviltester.gwtshowcase.pageObjects;

import static org.junit.Assert.assertTrue;

import com.thoughtworks.selenium.Selenium;

public class GWTShowcase {

	private Selenium selenium;
	public static final String TITLE_OF_SHOWCASEPAGE_STARTSWITH = "Showcase of Features: ";
	
	public GWTShowcase(Selenium selenium) {
		this.selenium = selenium;
	}

	public void open() {
		selenium.open("Showcase.html");
		
		// ajax page so wait for it to load
		selenium.waitForCondition("var waitvalue = selenium.getTitle(); waitvalue.match(/" + TITLE_OF_SHOWCASEPAGE_STARTSWITH + "/);", "2000");
		
		assertTrue("wrong title", getPageTitle().startsWith(TITLE_OF_SHOWCASEPAGE_STARTSWITH));
	}
	
	public String getPageTitle(){
		return selenium.getTitle();
	}

	public SideMenu sideMenu() {
		return new SideMenu(selenium);
	}

}
