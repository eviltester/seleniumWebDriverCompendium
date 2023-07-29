package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicTextPanel {

	private WebDriver driver;

	public BasicTextPanel(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith("Basic Text");
	}

	public void overTypeNormalTextBoxWith(String textToType) {
		WebElement textBox = driver.findElement(By.id("gwt-debug-cwBasicText-textbox"));
		textBox.sendKeys(textToType);
	}

	public int getNormalTextBoxSelectedPosition() {
		String selectedText;
		
		WebElement positionText = driver.findElement(By.xpath("//input[@id='gwt-debug-cwBasicText-textbox']/../../td[2]/div"));
		selectedText = positionText.getText();
		selectedText = selectedText.replaceFirst("Selected: ", "");
		String []values = selectedText.split(",");
		
		return Integer.parseInt(values[0].trim());
	}

}
