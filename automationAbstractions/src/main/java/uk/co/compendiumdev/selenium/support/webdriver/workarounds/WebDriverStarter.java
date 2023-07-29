package uk.co.compendiumdev.selenium.support.webdriver.workarounds;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/*
    WebDriver manager will work on most machines to download
    the drivers. But sometimes it doesn't work due to laptop
    or environment lockdown.

    In which case we need to manually download and install
    ChromeDriver or GheckoDriver and then change the code
    here so that we use the installed driver.

    In some environments we may also need to set the profile.

 */
public class WebDriverStarter {

    public WebDriver get() {

        // if you receive an error that the path to
        // webdriver.chrome.driver needs to be set then
        // ... try adding your ChromeDriver.exe into a
        // folder on the path.
        //
        // if that doesn't work then change the page in
        // setPathToDriver to point to the correct executable
        // and enable the line below

        // setPathToDriver();

        // Some environments might be configured to use
        // a specific profile or do not start with a blank
        // profile, so we might need to change the options
        // used to setup ChromeDriver, edit the
        // getWebDriverOptions method to configure it for
        // your environment
        return new ChromeDriver(getWebDriverOptions());

    }

    private void setPathToDriver() {
        // this should match the path to your
        // chromedriver executable if you want to
        // enable it
        System.setProperty("webdriver.chrome.driver",
                "c:/drivers/chromedriver.exe");
    }

    private ChromeOptions getWebDriverOptions() {

        ChromeOptions options = new ChromeOptions();

        // can create an empty folder to force chrome
        // to create a new profile

        //options.addArguments("user-data-dir=" + Files.createTempDir());

        try {
            File directory = new File(System.getProperty("user.dir"),"chromeProfiles");
            directory.mkdirs();

            options.addArguments("user-data-dir=" +
                    Files.createTempDirectory(directory.toPath(),"chrome"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return options;
    }

    /*
        A workaround method for use if the profile is shared
        and we want to open the browser on a page with a clean
        local Storage object.

        Instead of driver.get(url) use
        WebDriverStarter.getWithCleanStorage(driver, url)

     */
    public static void getWithCleanStorage(WebDriver driver, String url){
        driver.get(url);
        ((JavascriptExecutor)driver).executeScript("localStorage.clear()");
        driver.navigate().refresh();
    }
}
