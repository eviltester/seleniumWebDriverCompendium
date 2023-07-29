package browsers.WhyBrowserNotClosingProperly;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WhyBrowserNotClosingTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void exampleSlowLoadableUsage(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @AfterAll
    public static void endSelenium(){
        CloseDriver.now(driver);
    }

}
