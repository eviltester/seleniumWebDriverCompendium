package com.eviltester.gwtshowcase.pageObjects;

import com.thoughtworks.selenium.Selenium;

public class RadioButtonsPanel {

	private Selenium selenium;

	public RadioButtonsPanel(Selenium selenium) {
		this.selenium = selenium ;
	}

	public boolean isPageTitleCorrect() {
		return selenium.getTitle().endsWith("Radio Button");
	}

	public boolean isSportSelected(String sportName) {
		return selenium.isChecked("gwt-debug-cwRadioButton-sport-" + sportName.replaceAll(" ", "") + "-input");
	}
	
	public void selectSport(String sportName) {
		selenium.check("gwt-debug-cwRadioButton-sport-" + sportName.replaceAll(" ", "") + "-input");
	}	

	public boolean isColorSelected(String colorName) {
		return selenium.isChecked("gwt-debug-cwRadioButton-color-" + colorName + "-input");
	}	

	public void selectColor(String colorName) {
		selenium.check("gwt-debug-cwRadioButton-color-" + colorName + "-input");
	}	

}
