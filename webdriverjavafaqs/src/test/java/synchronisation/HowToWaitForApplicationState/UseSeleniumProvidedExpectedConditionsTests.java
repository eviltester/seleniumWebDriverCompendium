package synchronisation.HowToWaitForApplicationState;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// this test originally from https://github.com/eviltester/webDriverExperiments
public class UseSeleniumProvidedExpectedConditionsTests {

    private static WebDriver driver;

    @BeforeAll
    public static void startSelenium(){
        driver = new ChromeDriver();
    }

    @Test
    public void useInBuiltExpectedConditions(){
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        new WebDriverWait(driver,10).until(ExpectedConditions.titleContains("Selenium"));
    }

    @Test
    public void withoutUsingInBuildExpectedConditions(){
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        new WebDriverWait(driver,10).
                until(new TitleContainsCondition("Selenium"));
    }

    @Test
    public void withoutUsingInBuildExpectedConditionsAndFactory(){
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        new WebDriverWait(driver,10).until(WaitFor.titleContainsCondition("Selenium"));
    }

    @AfterAll
    public static void closeSelenium(){
        driver.quit();
    }


}
