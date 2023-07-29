package com.eviltester.drivers;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PortableFirefoxDriverTest {

    /*
        Sometimes we want more than one version of Firefox.

        On Windows this is easy because we can use portable versions of Firefox
        then when we instantiate FirefoxDriver we tell it which Firefox executable
        to use.

        This will work with FirefoxDriver and Marionette/GeckoDriver

        https://sourceforge.net/projects/portableapps/files/Mozilla%20Firefox%2C%20Portable%20Ed./

     */
    @Test
    public void basicFirefoxDriver(){

        DesiredCapabilities portableCapabilities = DesiredCapabilities.firefox();

        // to use the Legacy Built in Firefox Driver with Selenium 3 set marionette capability to false
        portableCapabilities.setCapability("marionette", false);

        // assuming I installed FirefoxPortable.exe to c:\webdrivers\FirefoxPortable

/*
        WebDriver firefox = new FirefoxDriver(
                new FirefoxBinary(
                        new File("c:/webdrivers/FirefoxPortable/v47_0_1/FirefoxPortable.exe")),
                new FirefoxProfile(),
                portableCapabilities);
*/

        // upgrading to 3.12.0 and Firefox Capabilites are depreacted so moving to FirefoxOptions
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(
                new File("c:/webdrivers/FirefoxPortable/v47_0_1/FirefoxPortable.exe")));
        options.setProfile(new FirefoxProfile());
        options.setLegacy(true);


        WebDriver firefox = new FirefoxDriver(options);



        firefox.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(firefox.getTitle(), is("HTML Form Elements"));

        firefox.quit();
    }


}
