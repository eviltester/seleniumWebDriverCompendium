package uk.co.compendiumdev.examples.firsttests;


import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NoAbstractionTest {

    @Test
    public void canCreateAToDo(){

        // a true test with no abstraction would use the driver directly
        // WebDriver driver = new ChromeDriver();
        WebDriver driver = new ExecutionDriver().get();

        // admittedly the line below is an abstraction but it allows me to
        // run the tests locally more easily.
        // String siteURL = "http://todomvc.com/examples/backbone/"
        String siteURL = new TodoMVCSite().getURL();

        driver.get(siteURL);

        int originalNumberOfTodos = driver.findElements(
                                        By.cssSelector("ul.todo-list li")).size();

        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys("new task");
        createTodo.sendKeys(Keys.ENTER);

        Assertions.assertTrue(driver.findElement(
                                By.className("filters")).isDisplayed());

        int newToDoCount = driver.findElements(
                                By.cssSelector("ul.todo-list li")).size();

        Assertions.assertTrue(newToDoCount > originalNumberOfTodos);

        driver.close();
        try {
            driver.quit();
        }catch(Exception e){
        }
    }
}
