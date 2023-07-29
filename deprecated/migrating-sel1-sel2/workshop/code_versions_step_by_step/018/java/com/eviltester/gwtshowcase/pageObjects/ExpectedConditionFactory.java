package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.eviltester.gwtshowcase.pageObjects.waits.ElementStopsGrowingCondition;
import com.eviltester.gwtshowcase.pageObjects.waits.JavascriptExpectedCondition;

public class ExpectedConditionFactory {

	public ExpectedCondition<Boolean> GWTTitleMatches(String subMenuText) {
		return new JavascriptExpectedCondition("return document.title.indexOf(\"" + subMenuText + "\")!=-1;");
	}
	
	public ExpectedCondition<Boolean> elementStopsGrowing(By parentDiv, WebDriver driver) {
		return new ElementStopsGrowingCondition(parentDiv, driver);
	}	
}
