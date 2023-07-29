package com.eviltester.gwtshowcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.jibble.simplewebserver.SimpleWebServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.server.SeleniumServer;

import com.eviltester.gwtshowcase.pageObjects.BasicButtonPanel;
import com.eviltester.gwtshowcase.pageObjects.BasicTextPanel;
import com.eviltester.gwtshowcase.pageObjects.CellTablePanel;
import com.eviltester.gwtshowcase.pageObjects.FlexTablePanel;
import com.eviltester.gwtshowcase.pageObjects.GWTShowcase;
import com.eviltester.gwtshowcase.pageObjects.HyperLinksPanel;
import com.eviltester.gwtshowcase.pageObjects.RadioButtonsPanel;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class CanVisitSiteTests {

	
	private static SeleniumServer server;
	private static Selenium selenium;
	private static SimpleWebServer appserver;

	@BeforeClass
	public static void startSelenium(){
		server=null;
		
		Properties props;
		props = new Properties();
		String propertyFile = "migrationTest.properties";
		
		try {
			props.load(new FileInputStream("./" + propertyFile));
		} catch (FileNotFoundException e) {
			System.out.println("No Properties file found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error loading properties file");
			e.printStackTrace();
		}
		 
		String browser = props.getProperty("browser","*iexplore");
		String useLocalAppServer = props.getProperty("useLocalAppServer","yes");
		String apphost = props.getProperty("apphost","http://localhost:8088/");
		String localAppServerPort = props.getProperty("localAppServerPort","8088");
		
		try {
			server = new SeleniumServer();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// start the app server to run the test app
		if(useLocalAppServer.contentEquals("yes")){
			try {
				appserver = new SimpleWebServer(new File("./demoSite"), Integer.parseInt(localAppServerPort));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		selenium = new DefaultSelenium("localhost", 4444, browser, apphost);
		selenium.start();		
	}
	
	@Test
	public void visitSiteAndCheckTitle(){
		
		GWTShowcase showcase = new GWTShowcase(selenium);
		showcase.open();
		assertTrue("wrong default page title", showcase.getPageTitle().endsWith("Checkbox"));
	
	}
	
	@Test
	public void openCloseWidgets(){
		
		GWTShowcase showcase = new GWTShowcase(selenium);
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
		GWTShowcase showcase = new GWTShowcase(selenium);
		showcase.open();
		showcase.sideMenu().widgets().open();
		HyperLinksPanel hyperLinks = showcase.sideMenu().selectWidgetsHyperlink();		
		assertTrue("wrong page title", hyperLinks.isPageTitleCorrect());
	}

	@Test
	public void clickWidgetsAndListsAndMenus(){		
		GWTShowcase showcase = new GWTShowcase(selenium);
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
		GWTShowcase showcase = new GWTShowcase(selenium);
		showcase.open();
		showcase.sideMenu().widgets().open();
		HyperLinksPanel hyperLinks = showcase.sideMenu().selectWidgetsHyperlink();		
		RadioButtonsPanel radioButtons = hyperLinks.selectRadioButtonLink();	
		assertTrue("wrong page title", radioButtons.isPageTitleCorrect());
	}
	
	@Test
	public void useRadioButtons(){		
		GWTShowcase showcase = new GWTShowcase(selenium);
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
		GWTShowcase showcase = new GWTShowcase(selenium);
		showcase.open();
		showcase.sideMenu().widgets().open();
		HyperLinksPanel hyperLinks = showcase.sideMenu().selectWidgetsHyperlink();		
		BasicButtonPanel basicButtons = hyperLinks.selectBasicButtonLink();	
		assertTrue("wrong page title", basicButtons.isPageTitleCorrect());
	}
	
	@Test
	public void useBasicButtons(){		
		GWTShowcase showcase = new GWTShowcase(selenium);
		showcase.open();
		showcase.sideMenu().widgets().open();
		BasicButtonPanel basicButtons = showcase.sideMenu().selectWidgetsBasicButton();	
		assertTrue("wrong page title", basicButtons.isPageTitleCorrect());
		
		assertTrue("problem with normal button",basicButtons.clickNormalButtonAndExpectPopUp());
	}	
	
	// basic text
	@Test
	public void useTextInput(){		
		GWTShowcase showcase = new GWTShowcase(selenium);
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
		GWTShowcase showcase = new GWTShowcase(selenium);
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
		GWTShowcase showcase = new GWTShowcase(selenium);
		showcase.open();
		showcase.sideMenu().cellWidgets().open();
		CellTablePanel cellTable = showcase.sideMenu().selectCellWidgetsCellTable();	
		assertTrue("wrong page title", cellTable.isPageTitleCorrect());
		cellTable.setFirstNameOnRow(1,"zaphod");
		// TODO: test does not run on Selenium 1 as input doesn't 'take'
		//assertEquals("wrong name on grid", "zaphod", cellTable.getFirstNameOnRow(1));
		
	}
	
	
	@AfterClass
	public static void stopSeleniumServer(){
		selenium.close();
		server.stop();
	}
}
