package com.eviltester.gwtshowcase.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;

import com.eviltester.gwtshowcase.pageObjects.BasicButtonPanel;
import com.thoughtworks.selenium.Selenium;

public class SideMenu {

	private Selenium selenium;
	private MenuHeading widgets;
	private MenuHeading listsAndMenus;
	private MenuHeading textInput;
	private MenuHeading tables;
	private MenuHeading cellWidgets;
	private WebDriver driver;

	public SideMenu(WebDriver driver) {
		this.driver= driver;
		this.selenium = new WebDriverBackedSelenium(driver,"http://localhost/");

		widgets = new MenuHeading(selenium,"Widgets", "Checkbox");
		listsAndMenus = new MenuHeading(selenium,"Lists and Menus", "List Box");
		textInput = new MenuHeading(selenium,"Text Input", "Basic Text");
		tables = new MenuHeading(selenium,"Tables", "Grid");
		cellWidgets = new MenuHeading(selenium,"Cell Widgets", "Cell List");
	}

	public MenuHeading widgets(){
		return this.widgets;
	}
	
	public HyperLinksPanel selectWidgetsHyperlink() {
		clickSubMenuItem("Hyperlink");
		return new HyperLinksPanel(selenium);	
	}
	
	public RadioButtonsPanel selectWidgetsRadioButton() {
		clickSubMenuItem("Radio Button");
		return new RadioButtonsPanel(selenium);	
	}

	public BasicButtonPanel selectWidgetsBasicButton() {
		clickSubMenuItem("Basic Button");
		return new BasicButtonPanel(selenium);	
	}

	private void clickSubMenuItem(String subMenuText) {
		
		String subMenuLocator = "//div[@class=\"GALD-WOBF\" and .=\"" + subMenuText + "\"]"; 
		driver.findElement(By.xpath(subMenuLocator)).click();
		
		selenium.waitForCondition("document.title.match(/" + subMenuText + "/);", "2000");
	}
	
	
	public MenuHeading listsAndMenus(){
		return this.listsAndMenus;
	}		


	public MenuHeading textInput() {
		return this.textInput;
	}
	
	public BasicTextPanel selectTextInputBasicText() {
		clickSubMenuItem("Basic Text");
		return new BasicTextPanel(selenium);	
	}

	public MenuHeading tables() {
		return this.tables;
	}

	public FlexTablePanel selectTablesFlexTable() {
		clickSubMenuItem("Flex Table");
		return new FlexTablePanel(selenium);	
	}

	public MenuHeading cellWidgets() {
		return this.cellWidgets;
	}

	public CellTablePanel selectCellWidgetsCellTable() {
		clickSubMenuItem("Cell Table");
		return new CellTablePanel(selenium);
	}

	

}
