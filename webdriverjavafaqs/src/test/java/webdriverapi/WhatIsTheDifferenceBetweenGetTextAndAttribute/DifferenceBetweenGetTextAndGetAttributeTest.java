package webdriverapi.WhatIsTheDifferenceBetweenGetTextAndAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenGetTextAndGetAttributeTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach

    public void getThePage(){
        driver.get("https://testpages.herokuapp.com/styled/" +
                "basic-web-page-test.html");

        // e.g <p id="para1" class="main">A paragraph of text</p>
    }

    @Test
    public void getTextExample() {

        Assertions.assertEquals("A paragraph of text",
            driver.findElement(By.id("para1")).
                    getText());
    }

    @Test
    public void getAttributeExample() {

        Assertions.assertEquals("main",
                driver.findElement(By.id("para1")).
                        getAttribute("class"));

        Assertions.assertNull(
                driver.findElement(By.id("para1")).
                        getAttribute("name"));
    }

    @Test
    public void cannotGetTextOfSomeElements(){

        WebElement title = driver.findElement(By.tagName("title"));

        // page title is "Basic Web Page Title"
        // but can't use getText on <title>
        Assertions.assertNotEquals(
                "Basic Web Page Title",
                            title.getText());

        Assertions.assertEquals("", title.getText());
    }

    @Test
    public void textAsAnAttribute(){

        WebElement title = driver.findElement(By.tagName("title"));

        Assertions.assertEquals(
                "Basic Web Page Title",
                title.getAttribute("text"));
    }


    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }
}
