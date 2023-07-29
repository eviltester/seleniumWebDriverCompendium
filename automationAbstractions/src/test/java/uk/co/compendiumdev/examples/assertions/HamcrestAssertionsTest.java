package uk.co.compendiumdev.examples.assertions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HamcrestAssertionsTest {

    /*
        The different assertion approaches can make a difference to the readability
        of the tests. It is important to be able to read the code quickly and understand
        what the test is doing.

        A reliance on comments can slow down reading, and has the risk that the comments
        do not match the actual code that has been commented because someone amended
        the code but forgot, or didn't have time, to amend the comment.

        Assertions which are readable and self documenting can help.

        Hamcrest can be found at:

        - http://hamcrest.org

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
    public void HamcrestAssertionsExample(){

        todoMVC.typeIntoNewToDo("Edit Me" + Keys.ENTER);

        assertThat(todoMVC.getTodoItems().size(), is(1));

        todoMVC.editItem(0, "Edited Todo");

        assertThat(todoMVC.getTodoItems().size(), is(1));

        assertThat(todoMVC.getToDoText(0),
                   is(equalTo("Edited Todo")));

        todoMVC.deleteTodoItem(0);

        assertThat(todoMVC.getTodoItems().size(),
                    is(equalTo(0)));
    }

//    TODO:
//        EXERCISE:
//            - The hamcrest messages when assertions fail are supposed to be readable.
//            - Change the code so that the assertions fail.
//            - Are the error messages readable?

//    TODO:
//        EXERCISE:
//            - Add more tests, or change the test code so that you can experiment
//              with more of the matchers listed at http://hamcrest.org



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
