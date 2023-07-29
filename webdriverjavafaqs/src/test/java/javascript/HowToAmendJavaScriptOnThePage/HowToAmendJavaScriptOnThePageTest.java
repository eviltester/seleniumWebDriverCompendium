package javascript.HowToAmendJavaScriptOnThePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToAmendJavaScriptOnThePageTest {

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void canTriggerValidation(){

        final ChromeDriver driver = new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/basic-javascript-validation-test.html");

        // check existing functionality
        final WebElement input = driver.findElement(By.id("lteq30"));
        input.sendKeys("400");
        driver.findElement(By.name("submitbutton")).click();

        Assertions.assertEquals("Enter a value less than 30", driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        driver.close();
    }

    @Test
    public void canAmendJS(){

        final ChromeDriver driver = new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/basic-javascript-validation-test.html");

        // change the function by running a script to amend the existing
        // reference in the dom to a new anonymous function

        ((JavascriptExecutor)driver).executeScript(
                "window.checkGT30 = function(value){alert(\"changed function\");};"
        );

        final WebElement input = driver.findElement(By.id("lteq30"));
        input.sendKeys("450");
        driver.findElement(By.name("submitbutton")).click();

        Assertions.assertEquals("changed function", driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        driver.close();
    }

}
