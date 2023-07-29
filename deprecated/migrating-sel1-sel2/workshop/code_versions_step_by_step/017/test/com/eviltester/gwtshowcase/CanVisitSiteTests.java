package com.eviltester.gwtshowcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.eviltester.gwtshowcase.pageObjects.BasicButtonPanel;
import com.eviltester.gwtshowcase.pageObjects.BasicTextPanel;
import com.eviltester.gwtshowcase.pageObjects.CellTablePanel;
import com.eviltester.gwtshowcase.pageObjects.FlexTablePanel;
import com.eviltester.gwtshowcase.pageObjects.GWTShowcase;
import com.eviltester.gwtshowcase.pageObjects.HyperLinksPanel;
import com.eviltester.gwtshowcase.pageObjects.RadioButtonsPanel;

public class CanVisitSiteTests {

	
	private static WebDriver driver;

	@BeforeClass
	public static void startSelenium(){
		String extensionPath = System.getProperty("user.dir")
	 	+ "/"
	 	+ "firefoxExtensions/firebug-1.6.2.xpi";

	 	// create a custom profile

	 	FirefoxProfile profile = new FirefoxProfile();
	 	profile.setPreference("extensions.firebug.currentVersion", "1.6.2");
	 	try {
	 		profile.addExtension(new File(extensionPath));
	 	} catch (IOException e) {
			e.printStackTrace();
		}


		driver = new FirefoxDriver(profile);
		
		
	}
	
	@Test
	public void visitSiteAndCheckTitle(){
		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		assertTrue("wrong default page title", showcase.getPageTitle().endsWith("Checkbox"));
	
	}
	
	@Test
	public void openCloseWidgets(){
		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().widgets().open();
		
		assertTrue("Expected Widgets Open",showcase.sideMenu().widgets().isOpen());
		
		showcase.sideMenu().widgets().close();
		assertTrue("Expected Widgets Closed",showcase.sideMenu().widgets().isClosed());
		
		showcase.sideMenu().widgets().open();
		assertTrue("Expected Widgets Open",showcase.sideMenu().widgets().isOpen());

	}	
	
	@Test
	public void clickWidgetsHyperlink(){		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().widgets().open();
		HyperLinksPanel hyperLinks = showcase.sideMenu().selectWidgetsHyperlink();		
		assertTrue("wrong page title", hyperLinks.isPageTitleCorrect());
	}

	@Test
	public void clickWidgetsAndListsAndMenus(){		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().widgets().open();
		assertTrue(showcase.sideMenu().widgets().isOpen());
		showcase.sideMenu().widgets().close();
		assertTrue(showcase.sideMenu().widgets().isClosed());
		showcase.sideMenu().widgets().open();
		assertTrue(showcase.sideMenu().widgets().isOpen());
		showcase.sideMenu().widgets().close();
		assertTrue(showcase.sideMenu().widgets().isClosed());
		
		showcase.sideMenu().listsAndMenus().open();
		assertTrue(showcase.sideMenu().listsAndMenus().isOpen());
		showcase.sideMenu().listsAndMenus().close();
		assertTrue(showcase.sideMenu().listsAndMenus().isClosed());
		showcase.sideMenu().listsAndMenus().open();
		assertTrue(showcase.sideMenu().listsAndMenus().isOpen());
		showcase.sideMenu().listsAndMenus().close();
		assertTrue(showcase.sideMenu().listsAndMenus().isClosed());
	}	
	
	@Test
	public void navigateFromHyperLinkToRadioButton(){		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().widgets().open();
		HyperLinksPanel hyperLinks = showcase.sideMenu().selectWidgetsHyperlink();		
		RadioButtonsPanel radioButtons = hyperLinks.selectRadioButtonLink();	
		assertTrue("wrong page title", radioButtons.isPageTitleCorrect());
	}
	
	@Test
	public void useRadioButtons(){		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().widgets().open();
		RadioButtonsPanel radioButtons = showcase.sideMenu().selectWidgetsRadioButton();	
		assertTrue("wrong page title", radioButtons.isPageTitleCorrect());
		
		assertTrue("Football not selected by default", radioButtons.isSportSelected("Football"));
		
		radioButtons.selectSport("Baseball");
		assertTrue("Incorrect Sport Selected", radioButtons.isSportSelected("Baseball"));

		radioButtons.selectSport("Water Polo");
		assertTrue("Incorrect Sport Selected", radioButtons.isSportSelected("Water Polo"));
		
		assertFalse("green selected by default", radioButtons.isColorSelected("green"));
		assertFalse("red selected by default", radioButtons.isColorSelected("red"));
		assertFalse("blue selected by default", radioButtons.isColorSelected("blue"));
		
		radioButtons.selectColor("blue");
		assertTrue("incorrect color selected", radioButtons.isColorSelected("blue"));
		radioButtons.selectColor("red");
		assertTrue("incorrect color selected", radioButtons.isColorSelected("red"));
	}	
	
	
	@Test
	public void navigateFromHyperLinkToBasicButton(){		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().widgets().open();
		HyperLinksPanel hyperLinks = showcase.sideMenu().selectWidgetsHyperlink();		
		BasicButtonPanel basicButtons = hyperLinks.selectBasicButtonLink();	
		assertTrue("wrong page title", basicButtons.isPageTitleCorrect());
	}
	
	@Test
	public void useBasicButtons(){		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().widgets().open();
		BasicButtonPanel basicButtons = showcase.sideMenu().selectWidgetsBasicButton();	
		assertTrue("wrong page title", basicButtons.isPageTitleCorrect());
		
		assertTrue("problem with normal button",basicButtons.clickNormalButtonAndExpectPopUp());
	}	
	
	// basic text
	@Test
	public void useTextInput(){		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().textInput().open();
		BasicTextPanel basicText = showcase.sideMenu().selectTextInputBasicText();	
		assertTrue("wrong page title", basicText.isPageTitleCorrect());
		
		basicText.overTypeNormalTextBoxWith("hello");
		//TODO: get this check working as haven't been able to get it working in Selenium 0.9
		//assertEquals("position count not as expected",5,basicText.getNormalTextBoxSelectedPosition());
	}	

	
	// flex table
	@Test
	public void useFlexTable(){		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().tables().open();
		FlexTablePanel flexTable = showcase.sideMenu().selectTablesFlexTable();	
		assertTrue("wrong page title", flexTable.isPageTitleCorrect());
		
		assertEquals("incorrect number of default rows", 2, flexTable.getNumberOfRows());
		flexTable.addRow();
		flexTable.addRow();
		assertEquals("incorrect number of rows", 4, flexTable.getNumberOfRows());
		flexTable.addRow();
		flexTable.addRow();
		assertEquals("incorrect number of rows", 6, flexTable.getNumberOfRows());
		
		flexTable.removeRow();
		flexTable.removeRow();
		flexTable.removeRow();
		assertEquals("incorrect number of rows", 3, flexTable.getNumberOfRows());
	}	
	
	// cell table
	@Test
	public void useCellTable(){		
		GWTShowcase showcase = new GWTShowcase(driver);
		showcase.open();
		showcase.sideMenu().cellWidgets().open();
		CellTablePanel cellTable = showcase.sideMenu().selectCellWidgetsCellTable();	
		assertTrue("wrong page title", cellTable.isPageTitleCorrect());
		cellTable.setFirstNameOnRow(1,"zaphod");
		// TODO: test does not run on Selenium 1 as input doesn't 'take'
		//assertEquals("wrong name on grid", "zaphod", cellTable.getFirstNameOnRow(1));
		
	}
	
	
	@AfterClass
	public static void stopWebDriver(){
		driver.close();
	}
}
