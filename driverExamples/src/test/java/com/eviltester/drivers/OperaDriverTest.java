package com.eviltester.drivers;

import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.ProxyPort;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * cover nuances with the Opera Driver
 *
 * Opera https://www.opera.com/
 *
 * Opera is now built on Chromium so the driver used is based on the chromium driver,
 * but maintained seperately at
 *
 * https://github.com/operasoftware/operachromiumdriver
 *
 * https://github.com/operasoftware/operachromiumdriver/releases
 *
 * Install on mac using brew, or download and run yourself.
 *
 * https://formulae.brew.sh/cask/operadriver
 *
 * $ brew cask install operadriver
 *
 */
public class OperaDriverTest {

    @BeforeClass
    public static void setupTheChromeDriverSystemProperty(){

        // tell webdriver where to find the chrome driver
        String currentDir = System.getProperty("user.dir");

        //String operaDriverLocation = currentDir + "/../tools/operadriver/operadriver.exe";

        // if chrome is on your path then you do not need to set the location
        // if this test fails then Chrome might not be on your path and you may need to configure the property above
        //System.setProperty("opera.chrome.driver", operaDriverLocation);


    }


    @Test
    public void basicOperaUsage(){

        WebDriver opera = new OperaDriver();

        opera.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");

        assertThat(opera.getTitle(), is("Basic Web Page Title"));

        opera.quit();
    }

    @Test
    public void basicOperaDriverOptions(){

        OperaOptions options = new OperaOptions();
        options.addArguments("test-type");
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");


        WebDriver driver = new OperaDriver(options);

        driver.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");

        assertThat(driver.getTitle(), is("HTML Form Elements"));

        driver.quit();
    }


    @Test
    public void basicChromeDriverProxy(){

        //run this only if proxy is running e.g. Fiddler or BrowserMobProxy or BurpSuite etc.
        if(ProxyPort.inUse(Driver.PROXYHOST, Driver.PROXYPORT)) {

            // http://peter.sh/experiments/chromium-command-line-switches/
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("disable-plugins");
            options.addArguments("disable-extensions");
            options.addArguments("proxy-server=" + Driver.PROXY);

            WebDriver chrome = new ChromeDriver(options);

            chrome.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

            assertThat(chrome.getTitle(), is("HTML Form Elements"));

            chrome.quit();

        }else{
            System.out.println(
                    "No Proxy seemed to be running on " +
                            Driver.PROXY +
                            " so didn't run test basicChromeDriverProxy");
        }
    }



}
