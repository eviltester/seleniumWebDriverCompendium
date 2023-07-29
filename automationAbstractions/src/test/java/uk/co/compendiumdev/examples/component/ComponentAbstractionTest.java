package uk.co.compendiumdev.examples.component;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.examples.pojo.TodoMVCPojoPage;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class ComponentAbstractionTest {

    private WebDriver driver;


    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        final TodoMVCSite todoMVCSite = new TodoMVCSite();

        final TodoMVCPojoPage todoMVC = new TodoMVCPojoPage(driver, todoMVCSite.getURL());
        todoMVC.open();

        for(int todos=0; todos<5; todos++){
            todoMVC.typeIntoNewToDo("todo " + todos + Keys.ENTER);

            if (todos % 2 == 0) {
                // mark completed
                todoMVC.getTodoItems().get(todos).findElement(By.className("toggle")).click();
            }
        }
    }

    @Test
    public void canUseComponents(){

        // examples of using a variety of components
        final ItemsLeftCount itemsLeft = new ItemsLeftCount(driver);
        Assertions.assertEquals(2,itemsLeft.count());
        Assertions.assertEquals(5,countVisibleTodos());

        final FooterFilters filters = new FooterFilters(driver);
        filters.active();
        Assertions.assertEquals(2,countVisibleTodos());

        filters.completed();
        Assertions.assertEquals(3,countVisibleTodos());

        VisibleToDoEntry todo = VisibleToDoEntry.getToDoAt(driver, 1);
        Assertions.assertEquals("todo 2",todo.getText());

        todo.edit("visible todo");
        Assertions.assertEquals("visible todo",todo.getText());

        todo.markActive();
        Assertions.assertEquals(2,countVisibleTodos());

        filters.active();
        Assertions.assertEquals(3,countVisibleTodos());

        todo = VisibleToDoEntry.getToDoAt(driver, 1);
        Assertions.assertEquals("visible todo",todo.getText());

    }

//    TODO:
//        EXERCISE:
//            - Review the components ItemsLeftCount, FooterFilters, VisibleToDoEntry
//            - Make sure you understand them.


//    TODO:
//      EXERCISE:
//            refactor this method into a new component
//            - the component should be called VisibleTodoList
//            - use the component in the test
    public int countVisibleTodos(){
        return driver.findElements(By.cssSelector("ul.todo-list li:not(.hidden)")).size();
    }

//   TODO:
//      EXERCISE:
//              - the VisibleTodoList component should return a VisibleToDoEntry
//                from a method named getToDoAt(int position) - create this method
//              - did you also remove the static method from VisibleToDoEntry?
//                or did you wrap that method and use it?


//   TODO:
//      EXERCISE:
//               - refactor the ComponentPojoPage page object
//                 to move the method editItem into the VisibleTodoList
//               - create an @Test method in this class which uses the editItem

//     TODO:
//          EXERCISE:
//               - refactor the ComponentPojoPage page object
//                 to move the method deleteTodoItem into the VisibleTodoList
//               - create an @Test method in this class which uses the deleteTodoItem

//     TODO:
//          QUESTION:
//                should the ComponentPojoPage still have the methods
//                editItem and deleteTodoItem?
//          EXERCISE:
//                - If so, then re-implement them but use
//                  the VisibleTodoList in the methods.
//                  e.g. something like...
//                    public void editTodoItem(int item){
//                          new VisibleTodoList(driver).editTodoItem(item);
//                    }

//     TODO:
//          QUESTION:
//                   - should the VisibleTodoList have the methods
//                    editItem and deleteTodoItem?
//                   - or should we rely on the getToDoAt(position) method
//                    and then use the edit and delete methods on the visibleToDoItem?
//          EXERCISE:
//                   - try it and see

//     TODO:
//          QUESTION:
//                   - Should the ComponentPojoPage implement a filters()
//                    method which returns a FooterFilters object?
//                      e.g. page.filters().active();
//                    Or should there be a new Footer Component?
//                      e.g. page.footer().itemsLeftCount();
//                      e.g. page.footer().clickActiveFilter();
//          EXERCISE:
//                  - Decide, and then implement.
//                  - Or find a better way to model the footer.


//   TODO:
//       QUESTION:
//           What other components would you create?
//       EXERCISE:
//          - Look at the application under test.
//          - Model it as a diagram, or list of components to design
//            a possible set of components that you would create to model
//            the application and use in the tests.
//          - If you create any components that are not here then try and
//            implement some of them and use them in some tests.

    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }
}
