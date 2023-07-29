package com.eviltester.gwtshowcase.pageObjects;

import com.thoughtworks.selenium.Selenium;

public class HyperLinksPanel {

	private Selenium selenium;

	public HyperLinksPanel(Selenium selenium) {
		this.selenium = selenium;
	}

	public boolean isPageTitleCorrect() {
		return selenium.getTitle().endsWith("Hyperlink");
	}

	public RadioButtonsPanel selectRadioButtonLink() {
		selenium.click("gwt-debug-cwHyperlink-com.google.gwt.sample.showcase.client.content.widgets.CwRadioButton");
		return new RadioButtonsPanel(selenium);
	}

	public BasicButtonPanel selectBasicButtonLink() {
		selenium.click("gwt-debug-cwHyperlink-com.google.gwt.sample.showcase.client.content.widgets.CwBasicButton");
		return new BasicButtonPanel(selenium);
	}

}
