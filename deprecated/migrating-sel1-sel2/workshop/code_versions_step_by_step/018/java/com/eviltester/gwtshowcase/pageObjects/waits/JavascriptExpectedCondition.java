package com.eviltester.gwtshowcase.pageObjects.waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class JavascriptExpectedCondition implements ExpectedCondition<Boolean> {

	private String theScript;
	public JavascriptExpectedCondition(String javaScriptScript) {
		this.theScript= javaScriptScript;
	}
	@Override
	public Boolean apply(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return (Boolean)js.executeScript(theScript);
	}
}

