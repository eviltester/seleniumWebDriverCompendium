package com.eviltester.gwtshowcase.drivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.opera.core.systems.OperaDriver;

public class DriverFactory {

	public static WebDriver getDriver(String browserCode) {
		if(browserCode.contentEquals("*firefox")){
			return getFirefoxDriver();
		}
		if(browserCode.contentEquals("*iexplore")){
			// to use IE on vista all protected mode settings need to
			// be the same
			// in IE tools \ Internet Options \ Security \ []Enable Protected Mode
			return new InternetExplorerDriver();
		}	
		if(browserCode.contentEquals("*googlechrome")){
			// requires chrome 12
			return new ChromeDriver();
		}
		if(browserCode.contentEquals("*opera")){
			// needs something - don't know what it needs
			return new OperaDriver();
		}		
		if(browserCode.contentEquals("*sauce_firefox_windows")){
			return getSauceLabsDriver("firefox", "3.6.", Platform.XP);
		}	
		if(browserCode.contentEquals("*sauce_firefox_linux")){
			return getSauceLabsDriver("firefox", "3.6.", Platform.LINUX);
		}	

		
		return null;
	}

	private static WebDriver getSauceLabsDriver(String browser, String version, Platform platform){
		DesiredCapabilities capabilities = new DesiredCapabilities(
		           browser, version, platform);
		capabilities.setCapability("name", "Migration Tests");
		
		URL mySauceLabsAccountURL=null;
		try {
			mySauceLabsAccountURL = new URL(getSauceLabsRemoteAddress());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return new RemoteWebDriver(mySauceLabsAccountURL,capabilities);
	}
	
	
	private static String getSauceLabsRemoteAddress() {
		Properties props;
		props = new Properties();
		String propertyFile = "saucelabs.properties";
		
		try {
			props.load(new FileInputStream("./" + propertyFile));
		} catch (FileNotFoundException e) {
			System.out.println("No Saucelabs Properties file found");
		} catch (IOException e) {
			System.out.println("Error loading Saucelabs properties file");
		}
		 
		return props.getProperty("remoteaddress","");
	}

	private static WebDriver getFirefoxDriver() {
		String firebugVersion = getFirebugVersion();
		
	    String extensionPath = "./firefoxExtensions/firebug-" + firebugVersion + ".xpi";
	    FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("extensions.firebug.currentVersion", firebugVersion);
		profile.enableNativeEvents();
		try {
			profile.addExtension(new File(extensionPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new FirefoxDriver(profile);
	}

	private static String getFirebugVersion() {
		Properties props;
		props = new Properties();
		String propertyFile = "firefox.properties";
		
		try {
			props.load(new FileInputStream("./" + propertyFile));
		} catch (FileNotFoundException e) {
			System.out.println("No Firefox Properties file found");
		} catch (IOException e) {
			System.out.println("Error loading Firefox properties file");
		}
		 
		return props.getProperty("firebugversion","1.7.1");
	}	
}
