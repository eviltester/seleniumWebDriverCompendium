package com.eviltester.drivers;


import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.ProxyPort;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FirefoxDriverTest {

    /*
        Firefox version 48 has changed and requires GeckoDriver/Marionette.
        This code will only work for versions of firefox 47.1 and below
        You can download version 45 of firefox from the Extended Support Release page
        https://www.mozilla.org/en-US/firefox/organizations/all/
     */
    @Test
    public void basicFirefoxDriver(){

        WebDriver firefox = new FirefoxDriver();

        firefox.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(firefox.getTitle(), is("HTML Form Elements"));

        firefox.quit();
    }

    @Test
    public void firefoxDriverWithProfile(){

        FirefoxProfile profile = new FirefoxProfile();

        // setEnableNativeEvents no longer an option in 3.12.0
        //profile.setEnableNativeEvents(true);
        // WebDriver firefox = new FirefoxDriver(profile);

        // now need to use options to set the profile (3.12.0)
        FirefoxOptions options = new FirefoxOptions().setProfile(profile);
        WebDriver firefox = new FirefoxDriver(options);

        firefox.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(firefox.getTitle(), is("HTML Form Elements"));

        firefox.quit();
    }


    @Test
    public void firefoxDriverWithCapabilitiesForProxy(){

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
                    " so didn't run test firefoxDriverWithCapabilitiesForProxy");
        }
    }

    @Test
    public void firefoxUseExtensions() throws IOException {

        // **************************************************************************
        // profile is good for setting preferences and fiddling with browser settings
        // **************************************************************************

        // Download the extension to a local folder
        String s = File.separator;
        String extensionPath = System.getProperty("user.dir") +
                                String.format("%ssrc%stest%sresources%s%s",s,s,s,s,"firebug-1.10.5-fx.xpi");

        System.out.println(extensionPath);

        FirefoxProfile profile = new FirefoxProfile();

        // stop firebug showing the first run screen by setting the last version
        // to the current one
        profile.setPreference("extensions.firebug.currentVersion", "1.10.5");

        // add the extension to firefox
        profile.addExtension(new File(extensionPath));

        // prior to 3.12.0 we could set the profile
        //WebDriver firefox = new FirefoxDriver(profile);

        // in 3.12.0 we use the option
        FirefoxOptions options = new FirefoxOptions().setProfile(profile);
        WebDriver firefox = new FirefoxDriver(options);

        firefox.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(firefox.getTitle(), is("HTML Form Elements"));

        firefox.quit();
    }


}
