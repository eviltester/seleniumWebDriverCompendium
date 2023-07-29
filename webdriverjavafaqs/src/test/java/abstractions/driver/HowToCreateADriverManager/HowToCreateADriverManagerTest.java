package abstractions.driver.HowToCreateADriverManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HowToCreateADriverManagerTest {

    @Test
    public void useChrome(){
        System.setProperty(Driver.BROWSER_PROPERTY_NAME, "CHROME");
        WebDriver driver = Driver.get();

        driver.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");
        Assertions.assertEquals("A paragraph of text",
                            driver.findElement(By.id("para1")).getText());
    }

    @Test
    public void useFirefox(){
        System.setProperty(Driver.BROWSER_PROPERTY_NAME, "FIREFOX");
        WebDriver driver = Driver.get();

        driver.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");
        Assertions.assertEquals("A paragraph of text",
                driver.findElement(By.id("para1")).getText());
    }

    @Test
    public void useFirefoxHeadless(){
        System.setProperty(Driver.BROWSER_PROPERTY_NAME, "FIREFOX");
        System.setProperty("WEBDRIVER_HEADLESS_BROWSER", "true");

        WebDriver driver = Driver.get();

        driver.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");
        Assertions.assertEquals("A paragraph of text",
                driver.findElement(By.id("para1")).getText());
    }

    @Test
    public void useChromeHeadless(){
        System.setProperty(Driver.BROWSER_PROPERTY_NAME, "CHROME");
        System.setProperty("WEBDRIVER_HEADLESS_BROWSER", "true");
        WebDriver driver = Driver.get();

        driver.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");
        Assertions.assertEquals("A paragraph of text",
                driver.findElement(By.id("para1")).getText());
    }

    // note the Driver has a jvm shutdown hook,
    // so we don't need to quit it if we don't want to
}
