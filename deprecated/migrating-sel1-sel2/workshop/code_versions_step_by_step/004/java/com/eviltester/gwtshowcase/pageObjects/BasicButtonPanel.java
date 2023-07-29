package com.eviltester.gwtshowcase.pageObjects;

import com.thoughtworks.selenium.Selenium;

public class BasicButtonPanel {

	private Selenium selenium;

	public BasicButtonPanel(Selenium selenium) {
		this.selenium = selenium;
	}

	public boolean isPageTitleCorrect() {
		return selenium.getTitle().endsWith("Basic Button");
	}

	public boolean clickNormalButtonAndExpectPopUp() {
		selenium.click("gwt-debug-cwBasicButton-normal");
		boolean alert = selenium.isAlertPresent();
		boolean ok_so_far = alert;
		String alert_text;
		
		if(alert){
			ok_so_far = selenium.getAlert().contentEquals("Stop poking me!");
		}
		
		return ok_so_far;
	}

}
