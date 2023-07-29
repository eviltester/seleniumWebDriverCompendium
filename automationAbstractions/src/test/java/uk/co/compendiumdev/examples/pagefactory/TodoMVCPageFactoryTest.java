package uk.co.compendiumdev.examples.pagefactory;

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
 * in this case the page object uses the PageFactory annotations and is
 * intialised with an initElements call
 */
public class TodoMVCPageFactoryTest {

    private WebDriver driver;
    private TodoMVCSite todoMVCSite;

    private TodoMVCPageFactoryPage todoMVC;

    // TODO:
    //      EXERCISE:
    //                - Use the intellij compare functionality to compare this
    //                  test with the TodoMVCPojoTest
    //                - Only the page objects should be functionally different
    //                - Then compare the page objects themselves

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        todoMVCSite = new TodoMVCSite();

        todoMVC = new TodoMVCPageFactoryPage(driver, todoMVCSite.getURL());
        todoMVC.open();
    }

    @Test
    public void canCreateAToDo(){

        // TODO:
        //      QUESTION:
        //           should the page object have a count todos method?
        //           rather than return a list of WebElements?
        int originalNumberOfTodos = todoMVC.getTodoItems().size();

        // TODO:
        //      QUESTION:
        //          should the ENTER be handled by the page object?
        // TODO:
        //      QUESTION:
        //          should the page object have a createTodo method?
        todoMVC.typeIntoNewToDo("New Task" + Keys.ENTER);

        int newToDos = todoMVC.getTodoItems().size();

        Assertions.assertTrue(newToDos > originalNumberOfTodos);
        Assertions.assertEquals(originalNumberOfTodos + 1, newToDos);

        // TODO:
        //      QUESTION:
        //           Should getToDoText be zero indexed?
        //           - Does that make the test easier to understand?
        Assertions.assertEquals("New Task", todoMVC.getToDoText(newToDos-1));
    }

    @Test
    public void canDeleteATodo(){

        int originalNumberOfTodos = todoMVC.getTodoItems().size();

        todoMVC.typeIntoNewToDo("Delete Me" + Keys.ENTER);

        int addedATodoCount = todoMVC.getTodoItems().size();

        Assertions.assertEquals(originalNumberOfTodos + 1, addedATodoCount);

        // TODO:
        //      QUESTION:
        //           Should delete be zero indexed?
        //           - Is that how people think?
        //           - Does that make the test easier to understand?
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

        // TODO:
        //      QUESTION:
        //          should editItem be zero indexed?
        todoMVC.editItem(addedATodoCount-1, "Edited Todo");

        int afterEditCount = todoMVC.getTodoItems().size();
        Assertions.assertEquals(addedATodoCount, afterEditCount);

        Assertions.assertEquals("Edited Todo",
                                todoMVC.getToDoText(afterEditCount-1));
    }

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
            Assertions.assertEquals("Edited Todo " + todoIndex,
                                    todoMVC.getToDoText(todoIndex));
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


}
