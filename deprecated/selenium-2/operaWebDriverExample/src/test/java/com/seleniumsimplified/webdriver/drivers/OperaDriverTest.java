package com.seleniumsimplified.webdriver.drivers;

import com.opera.core.systems.OperaDriver;
import com.opera.core.systems.OperaProfile;
import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.ProxyPort;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OperaDriverTest {

    @Test
    public void basicOperaDriverUsage(){
        System.setProperty("os.name","windows");
        WebDriver opera = new OperaDriver();

        opera.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(opera.getTitle(), is("HTML Form Elements"));

        opera.quit();
    }

    @Test
    public void capabilitiesOperaDriverUsage(){

        //run this only if proxy is running e.g. Fiddler or BrowserMobProxy or BurpSuite etc.
        if(ProxyPort.inUse(Driver.PROXYHOST, Driver.PROXYPORT)) {


            org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
            proxy.setHttpProxy(Driver.PROXY)
                    .setFtpProxy(Driver.PROXY)
                    .setSslProxy(Driver.PROXY);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.PROXY, proxy);

            WebDriver opera = new OperaDriver(capabilities);

            opera.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

            assertThat(opera.getTitle(), is("HTML Form Elements"));

            opera.quit();

        }else{
            System.out.println(
                    "No Proxy seemed to be running on " +
                            Driver.PROXY +
                            " so didn't run test capabilitiesOperaDriverUsage");
        }
    }

    // opera also has preferences that can be used
    //opera:config
    //http://www.opera.com/support/usingopera/operaini
    @Test
    public void preferencesOperaDriverUsage(){

        OperaProfile profile = new OperaProfile();
        // switching off Javascript will cause the opera driver to fail
        profile.preferences().set("Extensions", "Scripting", 0);

        System.setProperty("os.name","windows");
        WebDriver opera = new OperaDriver(profile);

        opera.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        assertThat(opera.getTitle(), is("HTML Form Elements"));

        opera.quit();
    }

}
