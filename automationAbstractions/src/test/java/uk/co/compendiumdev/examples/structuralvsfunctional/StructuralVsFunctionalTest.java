package uk.co.compendiumdev.examples.structuralvsfunctional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class StructuralVsFunctionalTest {

    /*
        A structural page represents the physical structure.

        It might be as simple as something which is responsible for
        managing all the selectors.

        It might also be responsible for doing stuff.

        We might choose to split it into two:

        - StructuralPageLocators - manages all the By locators
        - StructuralPage - performs actions e.g. typeIntoCreateTodo, getTodoElement,
                                                 hoverOverTodo, clickVisibleDeleteButton

        Where the Structural Page, uses the Structural Page Selectors.


        A Functional Page would model the functions that we use the page to implement
        e.g. createTodo, countNumberOfTodos, deleteTodo etc.

        A Structural page would throw exceptions, but a functional page would most likely
        trap them - particularly if the function was a boolean e.g. isFooterVisible

     */

//    TODO:
//        EXERCISE:
//            - Compare the two tests to see the difference in the Structural and
//              Functional Page Abstractions. They both do 'exactly' the same thing.

    private WebDriver driver;
    private TodoMVCSite todoMVCSite;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        todoMVCSite = new TodoMVCSite();

    }

    @Test
    public void canUseFunctionalPage(){

        final ApplicationPageFunctionalExample page =
                    new ApplicationPageFunctionalExample(driver, todoMVCSite);

        page.open();

        Assertions.assertFalse(page.isFooterVisible());
        Assertions.assertEquals(0, page.getCountInFooter());
        Assertions.assertEquals(0, page.getCountOfTodoDoItems());

        page.enterNewToDo("My Todo 1");
        page.enterNewToDo("My Todo 2");
        page.enterNewToDo("My Todo 3");
        page.enterNewToDo("My Todo 4");
        page.enterNewToDo("My Todo 5");
        page.enterNewToDo("My Todo 6");

        Assertions.assertTrue(page.isFooterVisible());
        Assertions.assertEquals(6, page.getCountInFooter());
        Assertions.assertEquals(6, page.getCountOfTodoDoItems());

        // duplicate mark to do completed makes no difference
        page.markTodoCompleted(1);
        page.markTodoCompleted(1);
        page.markTodoCompleted(2);

        page.filterOnActive();
        Assertions.assertEquals(4, page.getCountInFooter());
        Assertions.assertEquals(4, page.getCountOfTodoDoItems());

        page.filterOnCompleted();
        Assertions.assertEquals(4, page.getCountInFooter());
        Assertions.assertEquals(2, page.getCountOfTodoDoItems());

        page.markTodoCompleted(1);
        Assertions.assertEquals(4, page.getCountInFooter());
        Assertions.assertEquals(2, page.getCountOfTodoDoItems());

        page.markTodoActive(1);
        Assertions.assertEquals(5, page.getCountInFooter());
        Assertions.assertEquals(1, page.getCountOfTodoDoItems());
    }

    @Test
    public void canUseStructuralPage(){

        final ApplicationPageStructuralExample page =
                new ApplicationPageStructuralExample(driver, todoMVCSite);

        page.open();

        try {
            Assertions.assertFalse(page.isFooterVisible());
            Assertions.assertEquals(0, page.getCountInFooter());
            Assertions.fail("Footer was not supposed to exist");
        }catch(Exception e){
            // there is no footer so the structural page call fails
        }
        Assertions.assertEquals(0, page.getVisibleTodos().size());

        page.typeIntoNewToDo("My Todo 1", Keys.ENTER);
        page.typeIntoNewToDo("My Todo 2", Keys.ENTER);
        page.typeIntoNewToDo("My Todo 3", Keys.ENTER);
        page.typeIntoNewToDo("My Todo 4", Keys.ENTER);
        page.typeIntoNewToDo("My Todo 5", Keys.ENTER);
        page.typeIntoNewToDo("My Todo 6", Keys.ENTER);

        Assertions.assertTrue(page.isFooterVisible());
        Assertions.assertEquals(6, page.getCountInFooter());
        Assertions.assertEquals(6, page.getVisibleTodos().size());

        // duplicate toggle here would make a difference as it would
        // move to completed and then back to active
        //page.clickStateOfItem(1);
        page.clickStateOfItem(1);
        page.clickStateOfItem(2);

        page.clickOnFilter(1);
        Assertions.assertEquals(4, page.getCountInFooter());
        Assertions.assertEquals(4, page.getVisibleTodos().size());

        page.clickOnFilter(2);
        Assertions.assertEquals(4, page.getCountInFooter());
        Assertions.assertEquals(2, page.getVisibleTodos().size());

        // Can't mark it as completed because it is already completed
        // page.clickStateOfItem(1);
        // Assert.assertEquals(4, page.getCountInFooter());
        // Assert.assertEquals(2, page.getVisibleTodos().size());

        page.clickStateOfItem(1);
        Assertions.assertEquals(5, page.getCountInFooter());
        Assertions.assertEquals(1, page.getVisibleTodos().size());
    }


//    TODO:
//        EXERCISE:
//            - Create some new tests that exercise the functionality of the application.
//            - Expand the Structural or Functional Pages as you do.
//            - Remember the Functional page can use the structural page, but probably not
//              the reverse... unless you think that is valid.
//            - Suggested things to test:
//               - edit a to do
//               - delete a to do
//               - create a CRUD scenario (possibly more with different variations)
//                  i.e. create, then check text, then update, then delete

    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }
}
