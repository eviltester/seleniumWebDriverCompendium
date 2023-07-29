package com.eviltester.gwtshowcase.pageObjects.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ElementStopsGrowingCondition implements ExpectedCondition<Boolean> {

	private By by;
	private int lastHeight;
	private int hasBeenThisHeightFor;

	public ElementStopsGrowingCondition(By parentDiv, WebDriver driver) {
		this.by = parentDiv;
		setHeightDetails(((RenderedWebElement)driver.findElement(parentDiv)).getSize().height);
	}

	private void setHeightDetails(int newHeight) {
		this.lastHeight = newHeight;
		this.hasBeenThisHeightFor = 1;
	}

	@Override
	public Boolean apply(WebDriver driver) {
		int currentHeight = ((RenderedWebElement)driver.findElement(by)).getSize().height;
		
		if( currentHeight == this.lastHeight){
			this.hasBeenThisHeightFor++;
		}else{
			setHeightDetails(currentHeight);
		}
		
		if(this.hasBeenThisHeightFor > 2){
			return true;
		}else{
			return false;
		}
	}
}
