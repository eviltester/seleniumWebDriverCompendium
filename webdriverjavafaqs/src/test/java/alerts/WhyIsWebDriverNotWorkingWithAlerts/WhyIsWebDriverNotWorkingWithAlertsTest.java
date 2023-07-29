package alerts.WhyIsWebDriverNotWorkingWithAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhyIsWebDriverNotWorkingWithAlertsTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void webdriverHandlesAlerts(){
        driver.get("https://testpages.herokuapp.com/styled/" +
                    "alerts/alert-test.html");
        driver.findElement(By.id("alertexamples")).click();
        driver.switchTo().alert().dismiss();

        // alert has gone
        Assertions.assertThrows(NoAlertPresentException.class,
                ()-> driver.switchTo().alert());
    }

    @Test
    public void aDivIsNotAnAlertToHandle(){
        driver.get("https://testpages.herokuapp.com/styled/alerts/" +
                    "fake-alert-test.html");
        driver.findElement(By.id("fakealert")).click();

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("dialog")));

        // the div is not an alert
        Assertions.assertThrows(NoAlertPresentException.class,
                ()-> driver.switchTo().alert());

        // handle it like any div
        driver.findElement(By.id("dialog-ok")).click();

        // wait till it goes away
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.not(
                        ExpectedConditions.
                                visibilityOfElementLocated(
                                        By.id("dialog-text"))));

        // check no longer styled to display
        Assertions.assertFalse(
                driver.findElement(
                        By.cssSelector("#dialog > div[role='dialog']"))
                        .getAttribute("class").contains("active"));
    }

    @AfterAll
    public static void endSelenium(){
        driver.close();
    }
}
