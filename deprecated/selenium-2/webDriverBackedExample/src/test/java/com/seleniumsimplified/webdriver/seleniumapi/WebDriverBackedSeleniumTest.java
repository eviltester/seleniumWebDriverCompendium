package com.seleniumsimplified.webdriver.seleniumapi;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// the import changed at some point, but only caused issues in 2_42_2
// changed from import org.openqa.selenium.WebDriverBackedSelenium;
// to import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class WebDriverBackedSeleniumTest {

    @Test
    /*
      * Should be able to inject a driver into the WebDriverBackedSelenium object
      * and then use the Selenium interface.
      */
    public void SeleniumOneAPI_IsSupportedByWebDriverFirefox(){

        WebDriver driver = new FirefoxDriver();

        String baseUrl = "http://www.compendiumdev.co.uk";
        Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);

        selenium.open("/selenium");


        Assert.assertEquals(true, selenium.getTitle().startsWith("Selenium Simplified"));

        // according to official docs need to use .stop() otherwise JVM continues to run
        selenium.stop();


        // after a quit, you cannot use the Firefox driver
        driver.quit();
    }


}
