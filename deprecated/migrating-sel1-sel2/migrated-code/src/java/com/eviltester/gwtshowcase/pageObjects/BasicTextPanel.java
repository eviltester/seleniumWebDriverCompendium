package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicTextPanel {

	

	private WebDriver driver;

	public BasicTextPanel(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith("Basic Text");
	}

	public void overTypeNormalTextBoxWith(String textToType) {
		driver.findElement(By.id("gwt-debug-cwBasicText-textbox")).sendKeys(textToType);
	}

	public int getNormalTextBoxSelectedPosition() {
		String selectedText;
		
		String textBox = "//input[@id='gwt-debug-cwBasicText-textbox']/../../td[2]/div";
		selectedText = driver.findElement(By.xpath(textBox)).getText();
		
		selectedText = selectedText.replaceFirst("Selected: ", "");
		String []values = selectedText.split(",");
		
		return Integer.parseInt(values[0].trim());
	}

}
