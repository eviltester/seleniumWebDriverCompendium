package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CellTablePanel {

	private WebDriver driver;

	public CellTablePanel(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleCorrect() {
		return driver.getTitle().endsWith("Cell Table");
	}
	
	public void setFirstNameOnRow(int i,String name) {
		String rowXpath = "//table[@class='GALD-WOPD GALD-WOCH']/tbody/tr[" + i + "]";
		String firstName = rowXpath + "/td[2]/div";
		
		WebElement row = driver.findElement(By.xpath(firstName));
		row.click();		
		
		WebElement field = driver.findElement(By.xpath(firstName + "/input"));
		field.sendKeys(Keys.chord(Keys.CONTROL, "a") + name + Keys.RETURN);
	}

	public String getFirstNameOnRow(int i) {
		String rowXpath = "//table[@class='GALD-WOPD GALD-WOCH']/tbody/tr[" + i + "]";
		String firstName = rowXpath + "/td[2]/div";
		return driver.findElement(By.xpath(firstName)).getText();		
	}

}
