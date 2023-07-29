package javascript.HowToTriggerClickEvent;

import io.github.bonigarcia.wdm.WebDriverManager;
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
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void exampleOfClick() {
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

        driver.findElement(By.id("alertexamples")).click();

        driver.switchTo().alert().dismiss();

        // check alert has gone
        Assertions.assertThrows(NoAlertPresentException.class, () ->
                driver.switchTo().alert());
    }

    @Test
    public void bypassClickUsingJavascriptExecutor() {
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

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
