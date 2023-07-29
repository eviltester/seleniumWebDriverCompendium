package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.Wait;

public class GWTShowcase {

	private WebDriver driver;
	public static final String TITLE_OF_SHOWCASEPAGE_STARTSWITH = "Showcase of Features: ";
	
	public GWTShowcase(WebDriver driver) {
		this.driver = driver;
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
		  
		// do not need the assert as the above wait will fail if the title is not correct
		//assertTrue("wrong title", getPageTitle().startsWith(TITLE_OF_SHOWCASEPAGE_STARTSWITH));
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}

	public SideMenu sideMenu() {
		return new SideMenu(driver);
	}

}
