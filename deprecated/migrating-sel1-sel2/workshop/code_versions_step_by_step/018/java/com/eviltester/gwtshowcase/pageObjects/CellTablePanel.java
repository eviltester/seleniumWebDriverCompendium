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
		WebElement row = driver.findElement(By.xpath(firstNameXpath(i)));
		row.click();
		driver.findElement(By.xpath(firstNameXpath(i) + "/input")).sendKeys(name + Keys.RETURN);		
	}
	
	public String getFirstNameOnRow(int i) {
		return driver.findElement(By.xpath(firstNameXpath(i))).getText();
	}

	private String firstNameXpath(int row) {
		String rowXpath = "//table[@class=\"GALD-WOPD GALD-WOCH\"]/tbody/tr[" + row + "]";
		return rowXpath + "/td[2]/div";
	}
	
}
