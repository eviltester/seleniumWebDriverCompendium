package com.eviltester.gwtshowcase.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eviltester.gwtshowcase.pageObjects.expectedConditions.PageTitleEndsWithExpectedCondtion;


public class HyperLinksPanel {

	private WebDriver driver;
	private ExpectedConditionFactory weCanSee;
	private WebDriverWait wait;
	private final String TITLE_OF_PAGE_ENDS_WITH_THIS = "Hyperlink";

	public HyperLinksPanel(WebDriver driver) {
		  this.driver = driver;
		  weCanSee = new ExpectedConditionFactory();
		  wait = new WebDriverWait(driver, 10);
	}

	public boolean isPageTitleCorrect() {
		return new PageTitleEndsWithExpectedCondtion(TITLE_OF_PAGE_ENDS_WITH_THIS).apply(driver);
	}

	public RadioButtonsPanel selectRadioButtonLink() {
		String elementID = "gwt-debug-cwHyperlink-com.google.gwt.sample" + 
					".showcase.client.content.widgets.CwRadioButton";
		driver.findElement(By.id(elementID)).click();
		final RadioButtonsPanel newPanel = new RadioButtonsPanel(driver);
		wait.until(weCanSee.pageTitleEndsWith(newPanel.TITLE_OF_PAGE_ENDS_WITH_THIS));
				
		return newPanel;
	}

	public BasicButtonPanel selectBasicButtonLink() {
		String elementID = "gwt-debug-cwHyperlink-com.google.gwt.sample" + 
							".showcase.client.content.widgets.CwBasicButton";
		driver.findElement(By.id(elementID)).click();
		final BasicButtonPanel newPanel = new BasicButtonPanel(driver);
		wait.until(weCanSee.pageTitleEndsWith(newPanel.TITLE_OF_PAGE_ENDS_WITH_THIS));
				
		return newPanel;		
	}

}
