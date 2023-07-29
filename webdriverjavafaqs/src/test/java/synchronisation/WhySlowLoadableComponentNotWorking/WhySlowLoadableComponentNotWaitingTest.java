package synchronisation.WhySlowLoadableComponentNotWorking;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;

public class WhySlowLoadableComponentNotWaitingTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void exampleSlowLoadableUsage(){
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        final DynamicButtonPage page = new DynamicButtonPage(driver);
        page.get();
        page.clickStart();

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.id("button01"))
        );

        Assertions.assertEquals(null,driver.findElement(By.id("button00")).getAttribute("disabled"));
        Assertions.assertEquals(null,driver.findElement(By.id("button01")).getAttribute("disabled"));
        Assertions.assertEquals("true",driver.findElement(By.id("button02")).getAttribute("disabled"));
    }



    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }


    private class DynamicButtonPage extends SlowLoadableComponent<DynamicButtonPage> {

        private final WebDriver driver;

        public DynamicButtonPage(final WebDriver driver) {
            super(Clock.systemDefaultZone(), 10);
            this.driver = driver;
        }

        @Override
        protected void load() {
            driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        }

        @Override
        protected void isLoaded() throws Error {
            // if I forget to throw an error when page is not loaded
            // then my SlowLoadableComponent will not 'wait'
            try {
                // button must exist
                final WebElement button =
                        driver.findElement(By.id("button00"));
                if(!button.isDisplayed() && !button.isEnabled()){
                    throw new RuntimeException("Button not Ready");
                }
            }catch(Exception e){
                throw new Error(e);
            }
        }

        public void clickStart() {
            driver.findElement(By.id("button00")).click();
        }
    }
}
