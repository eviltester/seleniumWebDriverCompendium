package uk.co.compendiumdev.examples.fluent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class FluentExampleTest {

    private WebDriver driver;
    private TodoMVCSite todoMVCSite;

    private FluentTodoMVCPage todoMVC;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        todoMVCSite = new TodoMVCSite();
    }

    @Test
    public void useFluent(){

        final FluentTodoMVCPage page = new FluentTodoMVCPage(driver, todoMVCSite.getURL());

        // TODO:
        //      QUESTION:
        //               - Does the fluent interface make the following code
        //                 easier to understand?
        page.
            open().
            and().
                createTodo("My First Todo").
                createTodo("My Second Todo").
                createTodo("My Third Todo").
                createTodo("My Fourth Todo").
            then().
                toggleTodoStatus(1);

        // TODO:
        //      QUESTION:
        //              - Does the fluent interface make the assertion code
        //                easier to understand?
        Assertions.assertEquals(3,page.clickFilterActive().
                                            and().countVisibleTodos());

        page.
            deleteTodoItem(1).
            and().
            editItem(1,"Edited Todo");

        Assertions.assertEquals(2,page.countVisibleTodos());
    }

    // TODO:
    //      EXERCISE:
    //              - Build more tests using the FluentTodoMVCPage
    //              - Add additional methods where appropriate.

    // TODO:
    //      EXERCISE:
    //              - Think about the pros and cons of a fluent interface.
    //              - When would it work well?
    //              - When would it not work well?
    //              - What rules or guidelines would you recommend?



    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }

}
