package abstractions.dsl.HowToCreateFluentWebElementDSL;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HowToCreateAFluentWebElementDSLTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/search");
    }


    @Test
    public void whatIfWeHadAFluentWebElementForSearchPage(){

        FluentWebElement searchBox = new FluentWebElement(driver.findElement(By.name("q")));

        searchBox.clear().then().
                sendKeys("Fluent Programming").and().submit();

        Assertions.assertTrue(
                driver.getTitle().contains("Fluent Programming"));
    }

    @Test
    public void whatIfWeDidNotHaveAFluentWebElementForSearchPage(){

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.clear();
        searchBox.sendKeys("Normal Programming");
        searchBox.submit();

        Assertions.assertTrue(driver.getTitle().contains("Normal Programming"));
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
