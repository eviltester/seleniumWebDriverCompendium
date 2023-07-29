package com.seleniumsimplified.firsttests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class NoAbstractionTest {

    private WebDriver driver;
    String siteURL;

    @Before
    public void startDriver(){
        driver = new FirefoxDriver();

        siteURL = "http://todomvc.com/examples/backbone/";

    }

    @Test
    public void explicitWaitExample(){

        driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,15);

        driver.get(siteURL);

        int originalNumberOfTodos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys("new task");
        createTodo.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.className("filters")));

        int newToDos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        assertThat(newToDos, greaterThan(originalNumberOfTodos));
        assertThat(newToDos, is(1));
    }

    @After
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
