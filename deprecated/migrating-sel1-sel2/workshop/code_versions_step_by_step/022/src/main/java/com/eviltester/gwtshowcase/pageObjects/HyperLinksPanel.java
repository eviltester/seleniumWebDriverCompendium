package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HyperLinksPanel {

	private WebDriver driver;

	public HyperLinksPanel(WebDriver driver) {
		this.driver= driver;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith("Hyperlink");
	}

	public RadioButtonsPanel selectRadioButtonLink() {
		driver.findElement(By.id("gwt-debug-cwHyperlink-com.google.gwt.sample.showcase.client.content.widgets.CwRadioButton")).click();
		return new RadioButtonsPanel(driver);
	}

	public BasicButtonPanel selectBasicButtonLink() {
		driver.findElement(By.id("gwt-debug-cwHyperlink-com.google.gwt.sample.showcase.client.content.widgets.CwBasicButton")).click();
		return new BasicButtonPanel(driver);
	}

}
