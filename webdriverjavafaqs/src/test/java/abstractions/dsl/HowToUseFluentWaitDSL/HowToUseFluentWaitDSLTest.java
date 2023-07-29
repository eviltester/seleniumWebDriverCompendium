package abstractions.dsl.HowToUseFluentWaitDSL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class HowToUseFluentWaitDSLTest {

    private static ChromeDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void aBasicWait() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // selenium 3
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // selenium 4
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("htmlformtest")));
        driver.findElement(By.id("htmlformtest")).click();

        Assertions.assertEquals("HTML Form Elements",
                            driver.getTitle());
    }

    @Test
    public void aBasicWaitIsFluent() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(
                By.id("htmlformtest")))
                .click();

        Assertions.assertEquals("HTML Form Elements",
                driver.getTitle());
    }

    @Test
    public void aFluentWaitInAction(){

        driver.get("https://testpages.herokuapp.com/styled/"+
                    "javascript-countdown-test.html");

        By countdown = By.id("javascript_countdown_time");

        // create a basic default wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        // wait till countdown exists on screen
        wait.until( ExpectedConditions.
                    visibilityOfElementLocated(countdown));

        // reconfigure the wait fluently and use it to wait until
        // the countdown ends with :04
        wait.withTimeout(Duration.ofSeconds(30)).
             pollingEvery(Duration.ofMillis(500)).
                until(ExpectedConditions.textMatches(
                        countdown, Pattern.compile(".*:04$")) );

        Assertions.assertEquals("04",
                driver.findElement(countdown).getText().substring(6));
    }

    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }
}
