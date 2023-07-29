/*

MarionetteDriver was last present in WebDriver in version 3.0.1

Any version above 3.0.1 the following code will not work - and has been commented out of the project as a result.

If you are using versions of WebDriver between 2.53.1 and 3.0.1 (inclusive) then this might help you use the
Marionette/GeckoDriver

Otherwise ignore this code.

 */
package com.eviltester.webdriver;

import org.junit.Test;

/*
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
*/

public class MyFirstTestFF48 {


    @Test
    public void startWebDriver(){

        System.out.println("This test has been disabled for versions of WebDriver above 3.0.1");
        System.out.println("Because MarionetteDriver was removed in version 3.1.0");
        System.out.println("If you are using version 3.0.1 or lower then you can uncomment out the imports and body of this test to use MarionetteDriver");
        System.out.println("For versions of webDriver above 3.0.1, use the FirefoxDriver");

    /*
        // * The following code is for the Marionette Driver
        // *    this will work in v 2.53.1 and v 3.0.0 and 3.0.1 of WebDriver
        // *    but is deprecated in v 3.0.1 of WebDriver so may not work in future versions
        // *   You also need to download the Marionette executable
        // *   https://developer.mozilla.org/en-US/docs/Mozilla/QA/Marionette/WebDriver
        // *
        // *   for version 2.53.1 of webdriver, rename geckodriver.exe to wires.exe


        // * You can set the path to the actual file location of the driver *
        // String currentDir = System.getProperty("user.dir");
        // String marionetteDriverLocation = currentDir + "/tools/marionette/wires.exe";
        // System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);

        //If you add the folder with geckodriver.exe (wires.exe) to the path then you only need the following line
        // and you don't need to set the property as listed in the 3 lines above
        // e.g. D:\Users\Alan\Documents\github\startUsingSeleniumWebDriver\tools\marionette
        WebDriver driver = new MarionetteDriver();


        // The actual test code follows assumes that you have either
        // - been able to instantiate FirefoxDriver or
        // - downloaded firefox portable and instantiated a driver with FirefoxBinary
        // - or using Marionette/GeckoDriver and set the webdriver.gecko.driver and instantiated MarionetteDriver
        // - or added the path of geckodriver.exer (wires.exe) to the system path and instantiated MarionetteDriver

        driver.navigate().to("http://seleniumsimplified.com");

        Assert.assertTrue("title should start differently",
                            driver.getTitle().startsWith("Selenium Simplified"));

        driver.close();
        driver.quit();

    */

    }


}

