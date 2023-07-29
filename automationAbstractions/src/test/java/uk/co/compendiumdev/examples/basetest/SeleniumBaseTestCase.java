package uk.co.compendiumdev.examples.basetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumBaseTestCase {

    private static WebDriver driver;

    @BeforeAll
    public static void setupSelenium() {
        driver = new ChromeDriver();
    }

    public static WebDriver driver(){
        return driver;
    }

    @AfterAll
    public static void tearDownSeleniumTest() {
        if (null != driver) {
            driver.close();
            try {
                driver.quit();
            } catch (Exception e) {
            }
        }
    }
}

    /*
        Clearly this class does not have to create Drivers directly
        i.e new ChromeDriver();

        It could use other abstraction layers.

        Much of the time I see this approach being used, it doesn't.

        Also this class has a habit of being a dumping ground for
        methods we want to reuse.

        This might even have a driver.get() to open the main application page.
     */
