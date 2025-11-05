package javascript.HowToAmendJavaScriptOnThePage;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HowToAmendJavaScriptOnThePageTest {

    @BeforeAll
    public static void setupClass() {
    }

    @Test
    public void canTriggerValidation(){

        final ChromeDriver driver = new ChromeDriver();

        driver.get("https://testpages.eviltester.com/pages/forms/javascript-validation/");

        // check existing functionality
        final WebElement input = driver.findElement(By.id("lteq30a"));
        input.sendKeys("400");
        driver.findElement(By.name("submitbutton")).click();

        // wait until it shows an error message
        By errorTextLocator = By.id("lteq30aError");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.not(ExpectedConditions.textToBe(errorTextLocator,"")));
        Assertions.assertEquals("Enter a numeric value less than 30", driver.findElement(errorTextLocator).getText());

        driver.close();
    }

    @Test
    public void canAmendJS(){

        final ChromeDriver driver = new ChromeDriver();

        driver.get("https://testpages.eviltester.com/pages/forms/javascript-validation/");

        // change the function by running a script to amend the existing
        // reference in the dom to a new anonymous function
        // this new set of code bypasses the field validation
        ((JavascriptExecutor)driver).executeScript(
                "window.checkGT30a = function(){return true;};window.checkGT30b = function(){return true;};"
        );

        final WebElement input = driver.findElement(By.id("lteq30a"));
        input.sendKeys("450");
        driver.findElement(By.name("submitbutton")).click();

        // now we submitted 450 as the value to the server
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.
                    textToBe(By.id("_valuevalue1"), "450"));

        driver.close();
    }

}
