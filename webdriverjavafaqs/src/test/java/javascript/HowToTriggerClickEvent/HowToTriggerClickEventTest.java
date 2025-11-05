package javascript.HowToTriggerClickEvent;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class HowToTriggerClickEventTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        driver = new ChromeDriver();
    }

    @Test
    public void exampleOfClick() {
        driver.get("https://testpages.eviltester.com/pages/basics/alerts-javascript/");

        driver.findElement(By.id("alertexamples")).click();

        driver.switchTo().alert().dismiss();

        // check alert has gone
        Assertions.assertThrows(NoAlertPresentException.class, () ->
                driver.switchTo().alert());
    }

    @Test
    public void bypassClickUsingJavascriptExecutor() {
        driver.get("https://testpages.eviltester.com/pages/basics/alerts-javascript/");

        WebElement element = driver.findElement(By.id("alertexamples"));
        ((JavascriptExecutor)driver).
                executeScript("arguments[0].click()", element);

        driver.switchTo().alert().dismiss();

        // check alert has gone
        Assertions.assertThrows(NoAlertPresentException.class, () ->
                driver.switchTo().alert());
    }

    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }
}
