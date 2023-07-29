package synchronisation.HowToWaitForApplicationState;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CanUseInlineWebDriverWait {

    private static ChromeDriver driver;

    @BeforeAll
    public static void startSelenium(){
        driver = new ChromeDriver();
    }

    @Test
    public void useInLineExpectedCondition(){
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        new WebDriverWait(driver,10)
            .until(
                    new ExpectedCondition<Boolean>(){
                        @Override
                        public Boolean apply(WebDriver driver) {
                            return driver.getTitle().startsWith("Selenium");
                        }
                    }
                );
    }

    @Test
    public void useViaLambdaExpressions(){
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        WebDriverWait wait = new WebDriverWait(driver,10);
        ExpectedCondition<Boolean> titleStartsWithSelenium = mydriver ->
                            { return mydriver.getTitle().startsWith("Selenium");};

        wait.until(titleStartsWithSelenium);
    }

    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }


}
