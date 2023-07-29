package com.eviltester.gwtshowcase.pageObjects.expectedConditions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class PageTitleStartsWithExpectedCondtion implements
		ExpectedCondition<Boolean> {

	private String titleOfPageStartsWith;

	public PageTitleStartsWithExpectedCondtion(String titleOfPageStartsWith) {
		this.titleOfPageStartsWith = titleOfPageStartsWith;
	}

	@Override
	public Boolean apply(WebDriver driver) {
		return driver.getTitle().startsWith(titleOfPageStartsWith);
	}
}
