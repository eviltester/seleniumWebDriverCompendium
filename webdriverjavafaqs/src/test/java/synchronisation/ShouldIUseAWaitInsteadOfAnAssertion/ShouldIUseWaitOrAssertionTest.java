package synchronisation.ShouldIUseAWaitInsteadOfAnAssertion;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShouldIUseWaitOrAssertionTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        driver = new ChromeDriver();
    }

    @Test
    public void ifIWasTestingForPageTitle() {

        driver.get("https://testpages.eviltester.com/pages/forms/");

        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/pages/forms/html-form/']")));
        link.click();

        // wait.until(ExpectedConditions.titleIs("HTML Form Elements"));

        Assertions.assertEquals("HTML Form | Test Pages",
                driver.getTitle());
    }

    @Test
    public void ifIWasEnsuringIWasOnTheCorrectPageBeforeTesting() {

        driver.get("https://testpages.eviltester.com/pages/forms/");

        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/pages/forms/html-form/']")));
        link.click();

        wait.until(ExpectedConditions.titleIs("HTML Form | Test Pages"));

        Assertions.assertEquals("cancel",
                driver.findElement(By.name("submitbutton")).
                        getAttribute("value"));
    }

    @Test
    public void ifIHadToWaitForPageTitle() {

        driver.get("https://testpages.eviltester.com/pages/forms/");

        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/pages/forms/html-form/']")));
        link.click();

        String pageTitle = "HTML Form | Test Pages";
        wait.until(ExpectedConditions.titleIs(pageTitle));

        // wait will already have failed, but the condition
        // we are testing for is the page title
        Assertions.assertEquals(pageTitle, driver.getTitle());
    }

    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }

}
