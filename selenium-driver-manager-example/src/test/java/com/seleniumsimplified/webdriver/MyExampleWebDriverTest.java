package com.seleniumsimplified.webdriver;

import com.seleniumsimplified.webdriver.manager.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alan on 20/10/2016.
 */
public class MyExampleWebDriverTest {

    @Test
    public void visitSeleniumTestPage(){

        WebDriver driver = Driver.get();

        driver.get("http://compendiumdev.co.uk/selenium/testpages/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement formLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("htmlform")));

        formLink.click();

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='submitbutton'][value='submit']")));

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("bob");

        submitButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("back_to_form")));

        WebElement enteredUserName = driver.findElement(By.id("_valueusername"));

        assertEquals("bob", enteredUserName.getText());

        driver.close();
        driver.quit();
    }
}
