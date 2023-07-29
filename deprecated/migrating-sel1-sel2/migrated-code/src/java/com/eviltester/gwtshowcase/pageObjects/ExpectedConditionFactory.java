package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.eviltester.gwtshowcase.pageObjects.expectedConditions.ElementStopsGrowingCondition;
import com.eviltester.gwtshowcase.pageObjects.expectedConditions.JavascriptExpectedCondition;
import com.eviltester.gwtshowcase.pageObjects.expectedConditions.PageTitleEndsWithExpectedCondtion;
import com.eviltester.gwtshowcase.pageObjects.expectedConditions.PageTitleStartsWithExpectedCondtion;
import com.google.common.base.Function;

public class ExpectedConditionFactory {

	public ExpectedCondition<Boolean> GWTTitleMatches(String subMenuText) {
		return new JavascriptExpectedCondition("return document.title.indexOf(\"" + subMenuText + "\")!=-1;");
	}

	public ExpectedCondition<Boolean> elementStopsGrowing(By locator,
			WebDriver driver) {
		return new ElementStopsGrowingCondition(locator, driver);
	}

	public  ExpectedCondition<Boolean> pageTitleStartsWith(
			String titleOfPageStartswith) {
		return new PageTitleStartsWithExpectedCondtion(titleOfPageStartswith);
	}

	public ExpectedCondition<Boolean> pageTitleEndsWith(
			String titleOfPageEndsWith) {
		return new PageTitleEndsWithExpectedCondtion(titleOfPageEndsWith);
	}

}
