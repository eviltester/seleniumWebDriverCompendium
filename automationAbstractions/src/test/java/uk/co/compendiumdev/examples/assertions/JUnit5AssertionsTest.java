package uk.co.compendiumdev.examples.assertions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class JUnit5AssertionsTest {

    /*
        The different assertion approaches can make a difference to the readability
        of the tests. It is important to be able to read the code quickly and understand
        what the test is doing.

        A reliance on comments can slow down reading, and has the risk that the comments
        do not match the actual code that has been commented because someone amended
        the code but forgot, or didn't have time, to amend the comment.

        Assertions which are readable and self documenting can help.

        JUnit 5 assertions are part of JUnit and documented:

        - https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
        - https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html
     */

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
    public void JUnit5AssertionsExample(){

//    TODO:
//        EXERCISE:
//           - My personal preference is to use Assertions.
//             But some people like to statically include the
//             assertion methods.
//           - Try changing the code so that assertEquals
//             is statically imported rather than Assertions.
//           - Does that impact readability?

        todoMVC.typeIntoNewToDo("Edit Me" + Keys.ENTER);

        Assertions.assertEquals(1, todoMVC.getTodoItems().size());

        todoMVC.editItem(0, "Edited Todo");

        Assertions.assertEquals(1, todoMVC.getTodoItems().size());

        Assertions.assertEquals("Edited Todo",
                todoMVC.getToDoText(0));

        todoMVC.deleteTodoItem(0);
        Assertions.assertEquals(0, todoMVC.getTodoItems().size());
    }

//    TODO:
//        EXERCISE:
//           - JUnit 5 assertions can take a text string used when the assert fails
//           - Add a text string to describe the assertions, does that help readability?
//           - Change the assertions so they fail, does the test string help understand the failure?


    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }

    /*
        The benefit of different assertion libraries is that the can be more readable
        than others.

        And they upgrade/change at different times than the JUnit or TestNG execution
        frameworks. If you have to upgrade between JUnit 4 and 5, but have used
        hamcrest or AssertJ for your assertion abstractions then you do not have
        to upgrade as much code.

        I used Hamcrest in my Cucumber steps as the assertion library because it avoided
        issues with JUnit5 not being compatible with Cucumber JVM.
     */
}
