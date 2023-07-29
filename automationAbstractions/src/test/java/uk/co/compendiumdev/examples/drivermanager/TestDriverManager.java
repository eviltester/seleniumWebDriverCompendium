package uk.co.compendiumdev.examples.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class to abstract the creation of the driver to make it easier to
 * configure and switch between browsers.
 */
public class TestDriverManager {

    private WebDriver driver;
    private static WebDriver globalDriver;


    /**
        Create a 'managed driver' i.e.

        - cached
        - closeable by the class

     */
    public WebDriver get() {

        if(driver==null){
            driver = getUncached();
        }

        return driver;
    }

    /**
        Create a cached global driver used statically.
     */
    public static WebDriver getDriver() {

        if(globalDriver==null){
            globalDriver = new TestDriverManager().getUncached();
        }

        return globalDriver;
    }

    /**
        Close the cached and managed driver
     */
    public void close() {
        if(driver!=null){
            TestDriverManager.closeDriver(driver);
        }
    }

    /**
        Allow creation of a new unmanaged driver that the
        test has to manage the closing of.

        This is not cached or remembered in any way.
     */
    public WebDriver getUncached(){

        //return new FirefoxDriver();
        return new ChromeDriver();
        //return new SafariDriver(); // Mac only
    }

    /**
        A convenience method to make it easier to close
        unmanaged drivers without caring if they need
        one or both close/quit methods
     */
    public static void closeDriver(WebDriver adriver){

        try {
            adriver.close();
            adriver.quit();
        }catch(Exception e){

        }
    }

    /**
        Close the cached global driver.
     */
    public static void closeBrowser() {
        TestDriverManager.closeDriver(globalDriver);
    }



}
