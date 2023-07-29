package com.eviltester.gwtshowcase.pageObjects.expectedConditions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class JavascriptExpectedCondition implements ExpectedCondition<Boolean> {

	private String thisScript;

	public JavascriptExpectedCondition(String javaScript) {
		this.thisScript = javaScript;
	}

	@Override
	public Boolean apply(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return (Boolean)js.executeScript(thisScript);
	}

}
