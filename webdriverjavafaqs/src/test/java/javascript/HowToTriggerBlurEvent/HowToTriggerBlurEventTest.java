package javascript.HowToTriggerBlurEvent;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HowToTriggerBlurEventTest {

    /*
        Context, Selenium-RC had a 'fireEvent' command that triggered JavaScript events.
        How can we replicate this functionality in WebDriver to
        trigger blur events?.
     */

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void triggerEventUsingJavaScript(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        final WebElement button = driver.findElement(By.id("onblur"));
        final WebElement status = driver.findElement(By.id("onblurstatus"));
        Assertions.assertEquals("", status.getText());

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].dispatchEvent(new Event('blur'))",button);

        Assertions.assertEquals("Event Triggered", status.getText());
        driver.close();
    }

    @Test
    public void physicalWorkaround(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        final WebElement button = driver.findElement(By.id("onblur"));
        final WebElement status = driver.findElement(By.id("onblurstatus"));
        Assertions.assertEquals("", status.getText());

        // trigger a blur by selecting the item
        // and then moving away from it
        // - warning may not be cross browser compatible
        button.click();
        button.sendKeys(Keys.TAB);

        Assertions.assertEquals("Event Triggered", status.getText());
        driver.close();
    }
}
