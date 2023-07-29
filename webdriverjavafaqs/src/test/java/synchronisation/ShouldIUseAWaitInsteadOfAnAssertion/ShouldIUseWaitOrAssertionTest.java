package synchronisation.ShouldIUseAWaitInsteadOfAnAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShouldIUseWaitOrAssertionTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void ifIWasTestingForPageTitle() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("htmlformtest")));
        driver.findElement(By.id("htmlformtest")).click();

        // wait.until(ExpectedConditions.titleIs("HTML Form Elements"));

        Assertions.assertEquals("HTML Form Elements",
                driver.getTitle());
    }

    @Test
    public void ifIWasEnsuringIWasOnTheCorrectPageBeforeTesting() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("htmlformtest")));
        driver.findElement(By.id("htmlformtest")).click();

        wait.until(ExpectedConditions.titleIs("HTML Form Elements"));

        Assertions.assertEquals("cancel",
                driver.findElement(By.name("submitbutton")).
                        getAttribute("value"));
    }

    @Test
    public void ifIHadToWaitForPageTitle() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("htmlformtest")));
        driver.findElement(By.id("htmlformtest")).click();

        String pageTitle = "HTML Form Elements";
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
