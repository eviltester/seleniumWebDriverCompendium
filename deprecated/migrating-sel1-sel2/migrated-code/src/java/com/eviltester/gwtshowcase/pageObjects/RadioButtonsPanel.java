package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonsPanel {

	private WebDriver driver;
	public final String TITLE_OF_PAGE_ENDS_WITH_THIS = "Radio Button";

	public RadioButtonsPanel(WebDriver driver) {
		this.driver = driver ;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith(TITLE_OF_PAGE_ENDS_WITH_THIS);
	}

	public boolean isSportSelected(String sportName) {
		String elementID = "gwt-debug-cwRadioButton-sport-" + sportName.replaceAll(" ", "") + "-input";
		return driver.findElement(By.id(elementID)).isSelected();
	}
	
	public void selectSport(String sportName) {
		String elementID = "gwt-debug-cwRadioButton-sport-" + sportName.replaceAll(" ", "") + "-input";
		driver.findElement(By.id(elementID)).setSelected();
	}	

	public boolean isColorSelected(String colorName) {
		String elementID = "gwt-debug-cwRadioButton-color-" + colorName + "-input";
		return driver.findElement(By.id(elementID)).isSelected();		
	}	

	public void selectColor(String colorName) {
		String elementID = "gwt-debug-cwRadioButton-color-" + colorName + "-input";
		driver.findElement(By.id(elementID)).setSelected();
	}	

}
