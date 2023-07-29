package com.eviltester.gwtshowcase.pageObjects.expectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ElementStopsGrowingCondition implements ExpectedCondition<Boolean> {

	private By by;
	private int lastHeight;
	private int hasBeenThisHeightFor;

	public ElementStopsGrowingCondition(By locator, WebDriver driver) {
		this.by = locator;
		WebElement element = driver.findElement(by);
		setHeightDetails(element.getSize().height);
	}

	private void setHeightDetails(int newHeight) {
		this.lastHeight = newHeight;
		this.hasBeenThisHeightFor = 1;
		
	}

	@Override
	public Boolean apply(WebDriver driver) {
		WebElement element = driver.findElement(by);
		int currentHeight = element.getSize().height;
		if(currentHeight == this.lastHeight){
			this.hasBeenThisHeightFor++;
		}else{
			setHeightDetails(currentHeight);
		}
		
		if(this.hasBeenThisHeightFor>3){
			return true;
		}else{
			return false;
		}
	}

}
