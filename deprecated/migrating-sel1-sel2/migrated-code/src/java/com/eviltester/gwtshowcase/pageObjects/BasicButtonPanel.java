package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicButtonPanel {

	private WebDriver driver;
	public final String TITLE_OF_PAGE_ENDS_WITH_THIS = "Basic Button";
	
	public BasicButtonPanel(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith(TITLE_OF_PAGE_ENDS_WITH_THIS);
	}

	public boolean clickNormalButtonAndExpectPopUp() {
		driver.findElement(By.id("gwt-debug-cwBasicButton-normal")).click();
		
		Boolean alertTextOK;
		System.out.println(driver.switchTo().alert().getText());
		alertTextOK = driver.switchTo().alert().getText().contentEquals("Stop poking me!");
		driver.switchTo().alert().accept();
		return alertTextOK;
	}

}
