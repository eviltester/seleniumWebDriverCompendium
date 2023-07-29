package users.simulating.HowToSimulateUserDelay.withEventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HowToSimulateUserDelayTest {


    @BeforeAll
    public static void setupClass() {
        // TODO: FAQ - how to create a webdriver factory
        // TODO: FAQ - how to use WebDriverManager
        WebDriverManager.chromedriver().setup();
    }

    //TODO: how to simulate a user delay using page objects
    @Test
    public void simulateUserDelayWithEventFiringWebDriver(){


        WebDriver driver = new UserActionDelay(new ChromeDriver(), 5, 10).getWrappedDriver();
        //driver = new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //navigate about a bit
        driver.findElement(By.id("basicpagetest")).click();
        driver.findElement(By.linkText("Index")).click();

        // fill in a form
        driver.findElement(By.id("htmlformtest")).click();

        driver.findElement(By.name("username")).sendKeys("Bob");
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys("These are bob's comments");

        // TODO: FAQ: how to submit a form - submit, different locator strategies for buttons
        driver.findElements(By.name("submitbutton")).get(1).click();

        Assertions.assertEquals("Bob",
                new WebDriverWait(driver,10).
                        until(ExpectedConditions.elementToBeClickable(
                                By.id("_valueusername"))).getText());

        driver.close();
    }
}
