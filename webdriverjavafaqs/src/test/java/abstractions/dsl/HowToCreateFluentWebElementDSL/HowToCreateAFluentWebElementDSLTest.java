package abstractions.dsl.HowToCreateFluentWebElementDSL;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HowToCreateAFluentWebElementDSLTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/pages/forms/javascript-validation/");
    }


    @Test
    public void whatIfWeHadAFluentWebElementForSearchPage(){

        FluentWebElement value1 = new FluentWebElement(driver.findElement(By.id("lteq30a")));
        FluentWebElement value2 = new FluentWebElement(driver.findElement(By.id("lteq30b")));

        value1.clear().then().sendKeys("22");

        value2.clear().then().sendKeys("21").and().submit();

        new WebDriverWait(driver, Duration.ofSeconds(10)).
            until(ExpectedConditions.not(
                ExpectedConditions.textToBe(By.id("_valuevalue1"), "")));

        Assertions.assertEquals("22",
                driver.findElement(By.id("_valuevalue1")).getText());
        Assertions.assertEquals("21",
                driver.findElement(By.id("_valuevalue2")).getText());

    }

    @Test
    public void whatIfWeDidNotHaveAFluentWebElementForSearchPage(){

        WebElement value1 = driver.findElement(By.id("lteq30a"));
        WebElement value2 = driver.findElement(By.id("lteq30b"));

        value1.clear();
        value1.sendKeys("22");

        value2.clear();
        value2.sendKeys("21");
        value2.submit();

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.not(
                        ExpectedConditions.textToBe(By.id("_valuevalue1"), "")));

        Assertions.assertEquals("22",
                driver.findElement(By.id("_valuevalue1")).getText());
        Assertions.assertEquals("21",
                driver.findElement(By.id("_valuevalue2")).getText());
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
