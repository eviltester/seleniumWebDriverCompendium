package uk.co.compendiumdev.examples.firsttests;


import org.junit.jupiter.api.Assertions;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverWaitTest {

    private WebDriver driver;
    String siteURL;

    @BeforeEach
    public void startDriver(){
        // a true test with no abstraction would use the driver directly
        // driver = new FirefoxDriver();
        driver = new ExecutionDriver().get();

        // admittedly the line below is an abstraction but it allows me to
        // run the tests locally more easily. It is the only abstraction
        // used in this test class though
        siteURL = new TodoMVCSite().getURL();

        //siteURL = "http://todomvc.com/architecture-examples/backbone/";
    }

    @AfterEach
    public void stopDriver(){
        ExecutionDriver.closeDriver(driver);
    }


    @Test
    public void implicitWaitExample(){

        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);

        driver.get(siteURL);

        int originalNumberOfTodos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys("new task");
        createTodo.sendKeys(Keys.ENTER);

        Assertions.assertTrue(driver.findElement(
                By.className("filters")).isDisplayed());

        int newToDos = driver.findElements(
                By.cssSelector("ul.todo-list li")).size();

        Assertions.assertTrue(newToDos > originalNumberOfTodos);
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

        Assertions.assertTrue(newToDos > originalNumberOfTodos);
    }

}
