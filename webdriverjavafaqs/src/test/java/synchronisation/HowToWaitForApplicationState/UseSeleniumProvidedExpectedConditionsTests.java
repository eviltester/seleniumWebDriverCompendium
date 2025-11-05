package synchronisation.HowToWaitForApplicationState;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// this test originally from https://github.com/eviltester/webDriverExperiments
public class UseSeleniumProvidedExpectedConditionsTests {

    private static WebDriver driver;

    @BeforeAll
    public static void startSelenium(){
        driver = new ChromeDriver();
    }

    @Test
    public void useInBuiltExpectedConditions(){
        driver.get("https://testpages.eviltester.com/apps/server-side-calculator/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Server"));
    }

    @Test
    public void withoutUsingInBuildExpectedConditions(){
        driver.get("https://testpages.eviltester.com/apps/server-side-calculator/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(new TitleContainsCondition("Server"));
    }

    @Test
    public void withoutUsingInBuildExpectedConditionsAndFactory(){
        driver.get("https://testpages.eviltester.com/apps/server-side-calculator/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(WaitFor.titleContainsCondition("Server"));
    }

    @AfterAll
    public static void closeSelenium(){
        driver.quit();
    }


}
