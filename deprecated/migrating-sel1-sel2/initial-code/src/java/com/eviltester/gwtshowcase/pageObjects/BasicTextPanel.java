package com.eviltester.gwtshowcase.pageObjects;

import com.thoughtworks.selenium.Selenium;

public class BasicTextPanel {

	private Selenium selenium;

	public BasicTextPanel(Selenium selenium) {
		this.selenium = selenium;
	}

	public boolean isPageTitleCorrect() {
		return selenium.getTitle().endsWith("Basic Text");
	}

	public void overTypeNormalTextBoxWith(String textToType) {
		selenium.type("gwt-debug-cwBasicText-textbox", textToType);
		// TODO: can't get this working in Selenium 0.9
	}

	public int getNormalTextBoxSelectedPosition() {
		String selectedText;
		
		selectedText = selenium.getText("//input[@id='gwt-debug-cwBasicText-textbox']/../../td[2]/div");
		selectedText = selectedText.replaceFirst("Selected: ", "");
		String []values = selectedText.split(",");
		
		return Integer.parseInt(values[0].trim());
	}

}
