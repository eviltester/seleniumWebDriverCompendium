package com.eviltester.drivers;

import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.ProxyPort;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

//import org.openqa.selenium.firefox.MarionetteDriver;

/**
 * cover nuances with the Marionette Driver
 */
public class FirefoxMarionetteDriverTest {


    /**
     *
     as from Firefox 46 the inbuilt Firefox Driver in Selenium 2 will not work
     to use it we need to stay on Firefox 45 (Extended Support Release)
     download from here https://www.mozilla.org/en-US/firefox/organizations/all/

     More details about this on David Burn's Blog
     http://www.theautomatedtester.co.uk/blog/2016/selenium-webdriver-and-firefox-46.html

     More details about marionette here
     https://developer.mozilla.org/en-US/docs/Mozilla/QA/Marionette/WebDriver

     Download the .zip from the above page
     Unarchive to a folder
     Rename the .exe to wires.exe
     Either:
        - Add this wires.exe to your path
        - or set a property called webdriver.gecko.driver that points to your wires.exe

     Then instead of using FirefoxDriver use MarionetteDriver

     */

    @BeforeClass
    public static void setupTheMarionetteDriverSystemProperty(){

        // tell webdriver where to find the chrome driver
        String currentDir = System.getProperty("user.dir");
        String marionetteDriverLocation = currentDir + "/../tools/marionette/wires.exe";
        System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);

    }


    @Test
    public void basicMarionetteUsage(){

        WebDriver marionette = new FirefoxDriver();

        marionette.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(marionette.getTitle(), is("HTML Form Elements"));

        marionette.quit();
    }


    @Test
    public void marionetteDriverWithCapabilitiesForProxy(){

        // 2016/04/22 Marionette works with Firefox Capabilities, but I don't think proxy works yet
        //              it doesn't fail, it just ignores the proxy
        //run this only if proxy is running e.g. Fiddler or BrowserMobProxy or BurpSuite etc.
        if(ProxyPort.inUse(Driver.PROXYHOST, Driver.PROXYPORT)) {
            org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
                    proxy.setHttpProxy(Driver.PROXY)
                    .setFtpProxy(Driver.PROXY)
                    .setSslProxy(Driver.PROXY);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.PROXY, proxy);

            WebDriver firefox = new FirefoxDriver(capabilities);

            firefox.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

            assertThat(firefox.getTitle(), is("HTML Form Elements"));

            firefox.quit();
        }else{
            System.out.println(
                    "No Proxy seemed to be running on " +
                            Driver.PROXY +
                            " so didn't run test marionetteDriverWithCapabilitiesForProxy");
        }
    }




}
