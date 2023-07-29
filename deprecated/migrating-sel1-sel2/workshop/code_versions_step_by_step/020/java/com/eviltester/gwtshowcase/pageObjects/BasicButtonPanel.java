package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicButtonPanel {

	private WebDriver driver;

	public BasicButtonPanel(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith("Basic Button");
	}

	public boolean clickNormalButtonAndExpectPopUp() {
		
		driver.findElement(By.id("gwt-debug-cwBasicButton-normal")).click();
		
		Boolean alertTextOK;
		
		alertTextOK = driver.switchTo().alert().getText().contentEquals("Stop poking me!");
		driver.switchTo().alert().dismiss();
		
		return alertTextOK;
	}

}
