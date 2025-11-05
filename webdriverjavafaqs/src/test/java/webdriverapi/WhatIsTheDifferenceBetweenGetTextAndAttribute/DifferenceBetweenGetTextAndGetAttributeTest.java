package webdriverapi.WhatIsTheDifferenceBetweenGetTextAndAttribute;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenGetTextAndGetAttributeTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        driver = new ChromeDriver();
    }

    @BeforeEach

    public void getThePage(){
        driver.get("https://testpages.eviltester.com/pages/basics/basic-web-page/");

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
                "Basic Web Page | Test Pages",
                            title.getText());

        Assertions.assertEquals("", title.getText());
    }

    @Test
    public void textAsAnAttribute(){

        WebElement title = driver.findElement(By.tagName("title"));

        Assertions.assertEquals(
                "Basic Web Page | Test Pages",
                title.getAttribute("text"));
    }


    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }
}
