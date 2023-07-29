package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonsPanel {

	private WebDriver driver;

	public RadioButtonsPanel(WebDriver driver) {
		this.driver = driver ;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith("Radio Button");
	}

	public boolean isSportSelected(String sportName) {
		String theID = "gwt-debug-cwRadioButton-sport-" + sportName.replaceAll(" ", "") + "-input";
		return driver.findElement(By.id(theID)).isSelected();
	}
	
	public void selectSport(String sportName) {
		String theID = "gwt-debug-cwRadioButton-sport-" + sportName.replaceAll(" ", "") + "-input";
		driver.findElement(By.id(theID)).setSelected();
	}	

	public boolean isColorSelected(String colorName) {
		String theID = "gwt-debug-cwRadioButton-color-" + colorName + "-input";
		return driver.findElement(By.id(theID)).isSelected();
	}	

	public void selectColor(String colorName) {
		String theID = "gwt-debug-cwRadioButton-color-" + colorName + "-input";
		driver.findElement(By.id(theID)).setSelected();
	}	
}
