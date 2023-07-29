package uk.co.compendiumdev.examples.elementabstraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxElementTest {

    private WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        final TodoMVCSite todoMVCSite = new TodoMVCSite();

        driver.get(todoMVCSite.getURL());
    }

    // NOTE: using local methods as DSL rather than Page object
    //       this is partly to keep the test separate from other tests
    //       but also to demonstrate this local abstraction concept.

    @Test
    public void canMarkAnItemCompleted(){
        createTodo("First Added Item");
        createTodo("Second Added Item");
        createTodo("Third Added Item");

        Assertions.assertEquals(3, getCountOfTodoItems());
        Assertions.assertEquals( 0 , getCountOfCompletedItems());

        // TODO:
        //       EXERCISE:
        //           - the next 3 lines of code mean "mark Item Completed"
        //           - refactor the next 3 lines into a local markItemCompleted(int) method
        WebElement todoListItem1 = getCheckboxWebElementAt(1);
        CheckboxHTMLElement checkBox = new CheckboxHTMLElement(todoListItem1);
        checkBox.check();

        Assertions.assertEquals(1, getCountOfCompletedItems());

        // TODO:
        //    Exercise:
        //        - the next 3 lines of code mean "mark Item Active"
        //        - refactor the next 3 lines into a local markItemActive(int) method
        WebElement todoListItem = getCheckboxWebElementAt(1);
        checkBox = new CheckboxHTMLElement(todoListItem);
        checkBox.uncheck();

        Assertions.assertEquals(0, getCountOfCompletedItems());
    }

    public void createTodo(CharSequence... keysToSend) {
        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys(keysToSend);
        createTodo.sendKeys(Keys.ENTER);
    }

    private WebElement getCheckboxWebElementAt(int itemIndex) {
        return driver.findElements(By.cssSelector("input.toggle")).get(itemIndex);
    }

    private int getCountOfTodoItems(){
        return driver.findElements(By.cssSelector("ul.todo-list div.view")).size();
    }

    private int getCountOfCompletedItems(){
        return driver.findElements(By.cssSelector("ul.todo-list div.view input.toggle[checked]")).size();

        // TODO:
        //      EXERCISE:
        //          - The vanillajs implementation does not mark the checkbox
        //            as checked, can you make this selector more universal
        //            and apply to more implementations.
        //          - In vanillajs the li is given a class completed 'ul.todo-list li.completed'
        //            look at other implementations, is there a more generic locator strategy that
        //            would work for more implementations?
        //          - If so, change the code and run the tests on different browsers.
        //          - You may need to change other classes in the code to use your new selector strategy.
    }

    // TODO:
    //       EXERCISE:
    //          - Convert this test to use a page object
    //          - optional - should the markItemActive be refactored into a page object?
    //          - optional - should the markItemCompleted be refactored into a page object?
    //          - optional - should the markItemCompleted/Active be refactored into a To do object?
    //          - question - should the CheckBoxHTMLElement implement a CheckBox interface?
    //             - would that help? if it would help should we create that now or later?
    //          - question - CheckboxHTMLElement implements WrapsElement
    //             - does that help us? are there any risks to doing that?

    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }

    // TODO:
    //    EXERCISE
    //      - add ability to pass in a By and a driver
    //      - does this add more complexity?
    //      - would you need to add synchronisation code?

    // TODO:
    //       EXERCISE:
    //               The Selenium WebDriver classes have a Select class which is an element abstraction.
    //               Have a look at the source code for this and see if it gives you additional ideas
    //               For how to create Element Abstractions.
}
