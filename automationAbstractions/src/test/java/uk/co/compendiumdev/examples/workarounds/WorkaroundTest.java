package uk.co.compendiumdev.examples.workarounds;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class WorkaroundTest {

    private WebDriver driver;
    private TodoMVCSite todoMVCSite;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        todoMVCSite = new TodoMVCSite();

        driver.get(todoMVCSite.getURL());

        // EXAMPLE WORKAROUND:
        // mouse used to interfere sometimes
        // move it out of the way
        MouseControl.moveOutOfTheWay();

        // 60 should be enough to go off the page
        for(int todos=0; todos<60; todos++){
            createTodo("todo " + todos);
        }
    }

    @Test
    public void workWithSomethingOffThePage(){

        // previous versions of WebDriver did not scroll to element
        // created a workaround class to allow tests to function
        // but kept it 'readable'
        final EnsureWebElementIs ensure = new EnsureWebElementIs(driver);

        ensure.inViewOnThePage(todoStatusAt(59)).click();
        ensure.inViewOnThePage(todoStatusAt(1)).click();
        ensure.inViewOnThePage(todoStatusAt(58)).click();
        ensure.inViewOnThePage(todoStatusAt(2)).click();

        Assertions.assertTrue(todoStatusAt(59).isSelected());
        Assertions.assertTrue(todoStatusAt(1).isSelected());
        Assertions.assertTrue(todoStatusAt(58).isSelected());
        Assertions.assertTrue(todoStatusAt(2).isSelected());
    }

    private void createTodo(String value) {
        final By findTodos = By.cssSelector("ul.todo-list > li");
        int todos = driver.findElements(findTodos).size();
        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys(value);
        createTodo.sendKeys(Keys.ENTER);
        new WebDriverWait(driver,5).until(ExpectedConditions.numberOfElementsToBe(findTodos,todos+1));
    }

    private WebElement todoStatusAt(int itemIndex) {
        return driver.findElements(By.cssSelector("input.toggle")).get(itemIndex);
    }

    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }

    // TODO:
    //      EXERCISE:
    //             - Is the inViewOnThePage method required in current versions of WebDriver?
    //             - For all browsers?
    //             - When could it be useful?
}
