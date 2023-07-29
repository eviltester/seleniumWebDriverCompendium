package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlexTablePanel {

	private WebDriver driver;

	public FlexTablePanel(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith("Flex Table");
	}

	public int getNumberOfRows() {
		return (driver.findElements(By.xpath("//table[@id='gwt-debug-cwFlexTable']/tbody/tr")).size() -1);
	}

	public void addRow(){
		driver.findElement(By.xpath("//td[@id='gwt-debug-cwFlexTable-0-1']//button[.='Add a row']")).click();
	}
	
	public void removeRow(){
		driver.findElement(By.xpath("//td[@id='gwt-debug-cwFlexTable-0-1']//button[.='Remove a row']")).click();
	}
	
}
