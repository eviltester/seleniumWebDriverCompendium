package com.eviltester.gwtshowcase.pageObjects.expectedConditions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.google.common.base.Function;

public class PageTitleEndsWithExpectedCondtion implements
	ExpectedCondition<Boolean> {

	private String titleOfPageEndsWith;

	public PageTitleEndsWithExpectedCondtion(String titleOfPageEndsWith) {
		this.titleOfPageEndsWith = titleOfPageEndsWith;
	}

	@Override
	public Boolean apply(WebDriver driver) {
		return driver.getTitle().endsWith(titleOfPageEndsWith);
	}

}
