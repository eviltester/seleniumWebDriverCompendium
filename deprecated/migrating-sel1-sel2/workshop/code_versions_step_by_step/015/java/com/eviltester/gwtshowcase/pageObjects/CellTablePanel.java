package com.eviltester.gwtshowcase.pageObjects;

import com.thoughtworks.selenium.Selenium;

public class CellTablePanel {

	private Selenium selenium;

	public CellTablePanel(Selenium selenium) {
		this.selenium = selenium;
	}

	public boolean isPageTitleCorrect() {
		return selenium.getTitle().endsWith("Cell Table");
	}
	
	public void setFirstNameOnRow(int i,String name) {
		String rowXpath = "//table[@class=\"GALD-WOPD GALD-WOCH\"]/tbody/tr[" + i + "]";
		String firstName = rowXpath + "/td[2]/div";
		selenium.click(firstName);
		selenium.type(firstName + "/input", name);
		selenium.fireEvent(firstName + "/input", "mouseout");
		//TODO: need the javascript to 'take' this input
		
	}

	public String getFirstNameOnRow(int i) {
		String rowXpath = "//table[@class=\"GALD-WOPD GALD-WOCH\"]/tbody/tr[" + i + "]";
		String firstName = rowXpath + "/td[2]/div";
		return selenium.getText(firstName);		
	}

}
