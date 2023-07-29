package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GWTShowcase {

	private WebDriver driver;
	private String apphost;
	public static final String TITLE_OF_SHOWCASEPAGE_STARTSWITH = "Showcase of Features: ";
	private ExpectedConditionFactory weCanSee;
	private WebDriverWait wait;

	public GWTShowcase(WebDriver driver, String apphost) {
		  this.driver = driver;
		  this.apphost = apphost;
		  weCanSee = new ExpectedConditionFactory();
		  wait = new WebDriverWait(driver, 10);
	}

	public void open() {
		driver.get(apphost+"Showcase.html");
		wait.until(weCanSee.pageTitleStartsWith(TITLE_OF_SHOWCASEPAGE_STARTSWITH));
	}

	public String getPageTitle(){
		return driver.getTitle();
	}

	public SideMenu sideMenu() {
		return new SideMenu(driver, apphost);
	}

}
