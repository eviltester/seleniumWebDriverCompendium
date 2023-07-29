package uk.co.compendiumdev.todomvc.casestudyexample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.casestudyexample.componentpage.ApplicationPageStructuralComponents;
import uk.co.compendiumdev.todomvc.casestudyexample.componentpage.VisibleToDoEntry;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class StructuralComponentPageTest {

    private WebDriver driver;
    ApplicationPageStructuralComponents todoMVC;

    /*
        A fuller example of a page that uses structural components.

        The tests cover CRUD (Create, Read, Update, Delete actions)

        Use this for experimenting with different browsers, general refactoring.
        And building other abstraction layers on top of a working structural page.

        This package simulates working in an existing code base that is using abstractions, but
        the abstractions may not be as good as they could be, or may not fit how you
        would want to model the application.
    */

//    TODO:
//        EXERCISE:
//           - Run the tests and make sure you understand the implementation.
//           - Choose any of the exercises below in any order
//           - Run this test on different browsers by amending the ExecuteDriver
//               - you may need to amend the page object for additional synchronisation and minor changes
//           - Create more tests using the existing abstraction layers.
//           - Create a 'functional page that delegates to the Page Object but makes it a little easier to work with.
//           - Create a User Domain object that delegates to the Page Object.
//           - Expand and refactor this however you want to.


    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        final TodoMVCSite todoMVCSite = new TodoMVCSite();

        todoMVC = new ApplicationPageStructuralComponents(driver, todoMVCSite);

        todoMVC.get();
    }

    @Test
    public void canCreateATodo(){

        todoMVC.typeIntoNewToDo("A Todo", Keys.ENTER);

        Assertions.assertEquals(1, todoMVC.getCountOfTodo());
        Assertions.assertEquals(1, todoMVC.footer().getCount());
    }

    @Test
    public void canEditATodo(){

        todoMVC.typeIntoNewToDo("A Todo", Keys.ENTER);
        final VisibleToDoEntry todoItem = todoMVC.getToDoEntryAt(0);
        todoItem.edit("Edited Todo");

        Assertions.assertEquals(1, todoMVC.getCountOfTodo());
        Assertions.assertEquals("Edited Todo", todoItem.getText());

        Assertions.assertFalse(todoItem.isComplete());
    }

    @Test
    public void canDeleteATodo(){

        todoMVC.typeIntoNewToDo("A Todo", Keys.ENTER);
        Assertions.assertEquals(1, todoMVC.getCountOfTodo());

        todoMVC.getToDoEntryAt(0).delete();

        Assertions.assertEquals(0, todoMVC.getCountOfTodo());
    }

    @Test
    public void canFilterTodos(){

        Assertions.assertFalse(todoMVC.footer().isVisible());

        todoMVC.typeIntoNewToDo("Todo 1", Keys.ENTER);
        todoMVC.typeIntoNewToDo("Todo 2", Keys.ENTER);
        todoMVC.typeIntoNewToDo("Todo 3", Keys.ENTER);

        Assertions.assertTrue(todoMVC.footer().isVisible());

        Assertions.assertEquals(3, todoMVC.getCountOfTodo());
        Assertions.assertEquals(3, todoMVC.footer().getCount());

        todoMVC.getToDoEntryAt(0).markCompleted();
        Assertions.assertEquals(2, todoMVC.footer().getCount());

        todoMVC.footer().active();
        Assertions.assertEquals(2, todoMVC.getCountOfTodo());

        todoMVC.footer().completed();
        Assertions.assertEquals(1, todoMVC.getCountOfTodo());

        todoMVC.footer().all();
        Assertions.assertEquals(3, todoMVC.getCountOfTodo());

        todoMVC.footer().clearCompleted();
        todoMVC.footer().completed();
        Assertions.assertEquals(0, todoMVC.getCountOfTodo());
    }


    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }
}
