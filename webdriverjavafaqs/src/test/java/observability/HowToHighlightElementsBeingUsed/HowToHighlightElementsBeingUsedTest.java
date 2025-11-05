package observability.HowToHighlightElementsBeingUsed;


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

public class HowToHighlightElementsBeingUsedTest {

    /*
        Context, Selenium-RC had a 'highlight' command that showed which elements
        were being used. How can we replicate this functionality in WebDriver to
        see which elements are being used.
     */
    

    @Test
    public void simpleHighlightWithDirectClass(){


        WebDriver driver = new ChromeDriver();

        HighlightElement highlighter = new HighlightElement(driver, "yellow");

        //driver = new ChromeDriver();

        driver.get("https://testpages.eviltester.com/pages/forms/");

        // fill in a form
        highlighter.highlight(driver.findElement(By.cssSelector("a[href='/pages/forms/html-form/'"))).click();
        pauseToAllowVisibility();

        highlighter.highlight(driver.findElement(By.name("username"))).sendKeys("Bob");
        pauseToAllowVisibility();

        highlighter.highlight(driver.findElement(By.name("comments"))).clear();
        pauseToAllowVisibility();
        driver.findElement(By.name("comments")).sendKeys("These are bob's comments");
        pauseToAllowVisibility();

        final WebElement button = highlighter.highlight(
                                    driver.findElements(By.name("submitbutton")).get(1));
        pauseToAllowVisibility();
        new Actions(driver).moveToElement(button).perform();
        button.click();

        Assertions.assertEquals("Bob",
                new WebDriverWait(driver, Duration.ofSeconds(10)).
                        until(ExpectedConditions.elementToBeClickable(
                                By.id("_valueusername"))).getText());

        driver.close();
    }

    @Test
    public void highlightWithEventFiringWebDriver(){

        WebDriver driver = new ElementHighlighter(new ChromeDriver(), "yellow").getWrappedDriver();
        //driver = new ChromeDriver();

        driver.get("https://testpages.eviltester.com/pages/forms/");

        // fill in a form
        driver.findElement(By.cssSelector("a[href='/pages/forms/html-form/'")).click();
        pauseToAllowVisibility();

        driver.findElement(By.name("username")).sendKeys("Bob");
        pauseToAllowVisibility();

        driver.findElement(By.name("comments")).clear();
        pauseToAllowVisibility();
        driver.findElement(By.name("comments")).sendKeys("These are bob's comments");
        pauseToAllowVisibility();

        final WebElement button = driver.findElements(By.name("submitbutton")).get(1);
        pauseToAllowVisibility();
        new Actions(driver).moveToElement(button).perform();
        button.click();

        Assertions.assertEquals("Bob",
                new WebDriverWait(driver,Duration.ofSeconds(10)).
                        until(ExpectedConditions.elementToBeClickable(
                                By.id("_valueusername"))).getText());

        driver.close();
    }




    private void pauseToAllowVisibility() {
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            // ignore
        }
    }

}
