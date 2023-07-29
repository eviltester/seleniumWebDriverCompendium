package com.eviltester.gwtshowcase.pageObjects;

import com.thoughtworks.selenium.Selenium;

public class FlexTablePanel {

	private Selenium selenium;

	public FlexTablePanel(Selenium selenium) {
		this.selenium = selenium;
	}

	public boolean isPageTitleCorrect() {
		return selenium.getTitle().endsWith("Flex Table");
	}

	public int getNumberOfRows() {
		return (selenium.getXpathCount("//table[@id='gwt-debug-cwFlexTable']/tbody/tr").intValue() -1);
	}

	public void addRow(){
		selenium.click("//td[@id='gwt-debug-cwFlexTable-0-1']//button[.='Add a row']");
	}
	
	public void removeRow(){
		selenium.click("//td[@id='gwt-debug-cwFlexTable-0-1']//button[.='Remove a row']");
	}
	
}
