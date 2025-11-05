package synchronisation.HowToWaitForApplicationState;


import observability.HowToHighlightElementsBeingUsed.ElementHighlighter;
import observability.HowToHighlightElementsBeingUsed.HighlightElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HowToUseWebDriverWaitTest {


    @Test
    public void canWaitForExpectedConditions(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://testpages.eviltester.com/pages/forms/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By formLink = By.cssSelector("a[href='/pages/forms/html-form/']");
        wait.until(ExpectedConditions.elementToBeClickable(formLink));
        driver.findElement(formLink).click();

        pauseToAllowVisibility();

        By usernameLocator = By.name("username");

        final WebElement usernameField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        usernameLocator));

        usernameField.clear();
        usernameField.sendKeys("bob");

        driver.findElement(By.name("HTMLFormElements")).submit();

        Assertions.assertEquals(
                "bob",
                            wait.until(
                                ExpectedConditions.presenceOfElementLocated(
                                By.id("_valueusername")))
                            .getText());

        driver.close();
    }

    private void pauseToAllowVisibility() {
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            // ignore
        }
    }
}
