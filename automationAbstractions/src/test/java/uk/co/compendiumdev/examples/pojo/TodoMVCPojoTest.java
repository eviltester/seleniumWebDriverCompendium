package uk.co.compendiumdev.examples.pojo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;


/**
 * This is a basic example of a test that uses a very simple page object
 */
public class TodoMVCPojoTest {

    private WebDriver driver;
    private TodoMVCSite todoMVCSite;
    private TodoMVCPojoPage todoMVC;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        todoMVCSite = new TodoMVCSite();

        todoMVC = new TodoMVCPojoPage(driver, todoMVCSite.getURL());
        todoMVC.open();
    }

    @Test
    public void canCreateAToDo(){

        // Question: should the page object have a count todos method?
        //           rather than return a list of WebElements?
        int originalNumberOfTodos = todoMVC.getTodoItems().size();

        // Question: should the ENTER be handled by the page object?
        // Question: should the page object have a createTodo method?
        todoMVC.typeIntoNewToDo("New Task" + Keys.ENTER);

        int newToDos = todoMVC.getTodoItems().size();

        Assertions.assertTrue(newToDos > originalNumberOfTodos);
        Assertions.assertEquals(originalNumberOfTodos + 1, newToDos);

        // Question: Should getToDoText be zero indexed?
        //           Does that make the test easier to understand?
        Assertions.assertEquals("New Task", todoMVC.getToDoText(newToDos-1));
    }

    @Test
    public void canDeleteATodo(){

        int originalNumberOfTodos = todoMVC.getTodoItems().size();

        todoMVC.typeIntoNewToDo("Delete Me" + Keys.ENTER);

        int addedATodoCount = todoMVC.getTodoItems().size();

        Assertions.assertEquals(originalNumberOfTodos + 1, addedATodoCount);

        // Question: Should delete be zero indexed?
        //           Is that how people think?
        //           Does that make the test easier to understand?
        todoMVC.deleteTodoItem(addedATodoCount-1);

        int afterDeleteCount = todoMVC.getTodoItems().size();
        Assertions.assertEquals(originalNumberOfTodos, afterDeleteCount);
    }

    @Test
    public void canEditATodo(){

        int originalNumberOfTodos = todoMVC.getTodoItems().size();

        todoMVC.typeIntoNewToDo("Edit Me" + Keys.ENTER);

        int addedATodoCount = todoMVC.getTodoItems().size();

        Assertions.assertEquals(originalNumberOfTodos + 1, addedATodoCount);

        // Question: should editItem be zero indexed?
        todoMVC.editItem(addedATodoCount-1, "Edited Todo");

        int afterEditCount = todoMVC.getTodoItems().size();
        Assertions.assertEquals(addedATodoCount, afterEditCount);

        Assertions.assertEquals("Edited Todo", todoMVC.getToDoText(afterEditCount-1));
    }


//    TODO:
//        QUESTION:
//            - Is this test necessary?
//            - Because we have seen that we can create, edit and delete to do items.
//            - Why would we need a scenario test?
    @Test
    public void scenarioTest(){

        int originalNumberOfTodos = todoMVC.getTodoItems().size();

        for(int todoIndex=0; todoIndex<10; todoIndex++) {
            todoMVC.typeIntoNewToDo("Todo Number " + todoIndex + Keys.ENTER);
        }

        int addedATodoCount = todoMVC.getTodoItems().size();

        Assertions.assertEquals(originalNumberOfTodos + 10, addedATodoCount);

        for(int todoIndex=0; todoIndex<10; todoIndex++) {
            todoMVC.editItem(todoIndex, "Edited Todo " + todoIndex);
        }

        int afterEditCount = todoMVC.getTodoItems().size();
        Assertions.assertEquals(addedATodoCount, afterEditCount);

        for(int todoIndex=0; todoIndex<10; todoIndex++) {
            Assertions.assertEquals("Edited Todo " + todoIndex, todoMVC.getToDoText(todoIndex));
        }

        for(int todoIndex=9; todoIndex>=0; todoIndex--) {
            todoMVC.deleteTodoItem(todoIndex);
        }

        Assertions.assertEquals(0, todoMVC.getTodoItems().size());
    }


    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }

    /*
        single tests are useful for application functionality,
        but when building abstraction layers
        we need to know that they will be robust in more circumstances.
        Scenario tests help flush out synchronisation and other issues
        in page objects which tests focused on individual functionality do not.

        Scenario tests are a good way to flush out intermittency due to the abstraction
        layers, which might not appear until many tests are running in CI.
     */
}
