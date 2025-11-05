package synchronisation.HowToWaitForApplicationState;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CanUseInlineWebDriverWait {

    private static ChromeDriver driver;

    @BeforeAll
    public static void startSelenium(){
        driver = new ChromeDriver();
    }

    @Test
    public void useInLineExpectedCondition(){
        driver.get("https://testpages.eviltester.com/apps/server-side-calculator/");
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(
                    new ExpectedCondition<Boolean>(){
                        @Override
                        public Boolean apply(WebDriver driver) {
                            return driver.getTitle().startsWith("Server");
                        }
                    }
                );
    }

    @Test
    public void useViaLambdaExpressions(){
        driver.get("https://testpages.eviltester.com/apps/server-side-calculator/");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        ExpectedCondition<Boolean> titleStartsWithServer = mydriver ->
                            { return mydriver.getTitle().startsWith("Server");};

        wait.until(titleStartsWithServer);
    }

    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }


}
