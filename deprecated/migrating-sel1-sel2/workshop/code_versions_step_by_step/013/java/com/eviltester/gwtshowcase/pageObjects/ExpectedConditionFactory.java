package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.support.ui.ExpectedCondition;
import com.eviltester.gwtshowcase.pageObjects.waits.JavascriptExpectedCondition;

public class ExpectedConditionFactory {

	public ExpectedCondition<Boolean> GWTTitleMatches(String subMenuText) {
		return new JavascriptExpectedCondition("return document.title.indexOf(\"" + subMenuText + "\")!=-1;");
	}
}
