package selectors.css.FindByIdWhichContainsPeriodFullStop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByIdWhichContainsPeriodFullStopTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void cssWithoutEscapingFails(){

        driver.get("https://testpages.herokuapp.com/styled/" +
                "challenges/hard-selectors.html");

        Assertions.assertThrows(NoSuchElementException.class, () ->
            driver.findElement(By.cssSelector("#select.me.by.id")));
    }

    @Test
    public void cssEscapingExample(){

        driver.get("https://testpages.herokuapp.com/styled/" +
                    "challenges/hard-selectors.html");

        String goodSelector = "#select\\.me\\.by\\.id";
        final WebElement button = driver.findElement(
                                By.cssSelector(goodSelector));
        button.click();

        Assertions.assertEquals("Event Triggered",
                driver.findElement(By.cssSelector(goodSelector + "status")).
                        getText());
    }

    @Test
    public void orJustUseById(){

        driver.get("https://testpages.herokuapp.com/styled/" +
                "challenges/hard-selectors.html");

        String goodSelector = "select.me.by.id";
        final WebElement button = driver.findElement(
                By.id(goodSelector));
        button.click();

        Assertions.assertEquals("Event Triggered",
                driver.findElement(By.id(goodSelector + "status")).
                        getText());
    }

    @Test
    public void orUseXPath(){

        driver.get("https://testpages.herokuapp.com/styled/" +
                "challenges/hard-selectors.html");

        String goodSelector = "//button[@id='select.me.by.id']";
        final WebElement button = driver.findElement(
                By.xpath(goodSelector));
        button.click();

        Assertions.assertEquals("Event Triggered",
                driver.findElement(
                        By.xpath("//p[@id='select.me.by.idstatus']")).
                        getText());
    }

    @AfterAll
    public static void endSelenium(){
        driver.close();
    }
}
