package users.simulating.HowToSimulateUserDelay.withEventFiringWebDriver;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HowToSimulateUserDelayTest {


    @BeforeAll
    public static void setupClass() {
        // TODO: FAQ - how to create a webdriver factory
        // TODO: FAQ - how to use WebDriverManager
    }

    //TODO: how to simulate a user delay using page objects
    @Test
    public void simulateUserDelayWithEventFiringWebDriver(){


        WebDriver driver = new UserActionDelay(new ChromeDriver(), 5, 10).getWrappedDriver();
        //driver = new ChromeDriver();

        driver.get("https://testpages.eviltester.com/");

        //navigate about a bit
        driver.findElement(By.cssSelector("a[href='/pages/']")).click();
        driver.findElement(By.cssSelector("a[href='/pages/basics/']")).click();

        // fill in a form
        driver.findElement(By.cssSelector("a[href='/pages/forms/']")).click();
        driver.findElement(By.cssSelector("a[href='/pages/forms/html-form/']")).click();

        driver.findElement(By.name("username")).sendKeys("Bob");
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys("These are bob's comments");

        // TODO: FAQ: how to submit a form - submit, different locator strategies for buttons
        WebElement button = driver.findElements(By.name("submitbutton")).get(1);
        new Actions(driver).moveToElement(button).perform();
        button.click();

        Assertions.assertEquals("Bob",
                new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.elementToBeClickable(
                                By.id("_valueusername"))).getText());

        driver.close();
    }
}
