package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;

import com.thoughtworks.selenium.Selenium;

public class HyperLinksPanel {

	private Selenium selenium;
	private WebDriver driver;

	public HyperLinksPanel(WebDriver driver) {
		this.driver= driver;
		this.selenium = new WebDriverBackedSelenium(driver,"http://localhost/");
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
		return new BasicButtonPanel(driver);
	}

}
