package uk.co.compendiumdev.examples.assertions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

import static org.assertj.core.api.BDDAssertions.*;

public class AssertJAssertionsTest {

//    TODO:
//        EXERCISE:
//           - Compare the AssertJ, Hamcrest and JUnit 5 tests to see which
//             is more readable and then use them to see which is more usable.

    /*
        The different assertion approaches can make a difference to the readability
        of the tests. It is important to be able to read the code quickly and understand
        what the test is doing.

        A reliance on comments can slow down reading, and has the risk that the comments
        do not match the actual code that has been commented because someone amended
        the code but forgot, or didn't have time, to amend the comment.

        Assertions which are readable and self documenting can help.

        Assert J can be found at:

        - https://joel-costigliola.github.io/assertj/
        - docs at https://assertj.github.io/doc/

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
    public void AssertJExample(){

        todoMVC.typeIntoNewToDo("Edit Me" + Keys.ENTER);

        assertThat(todoMVC.getTodoItems().size()).isEqualTo(1);

        todoMVC.editItem(0, "Edited Todo");

        assertThat(todoMVC.getTodoItems().size()).isEqualTo(1);

        // example of chaining in AssertJ
        assertThat(todoMVC.getToDoText(0)).
                        startsWith("Edited").
                        endsWith("Todo").
                        contains(" ").
                        isEqualTo("Edited Todo");


        todoMVC.deleteTodoItem(0);
        assertThat(todoMVC.getTodoItems().size()).isEqualTo(0);
    }

    @Test
    public void AssertJThenExample(){

        todoMVC.typeIntoNewToDo("Edit Me" + Keys.ENTER);

        then(todoMVC.getTodoItems().size()).isEqualTo(1);

        todoMVC.editItem(0, "Edited Todo");

        then(todoMVC.getTodoItems().size()).isEqualTo(1);

        then(todoMVC.getToDoText(0)).isEqualTo("Edited Todo");

        todoMVC.deleteTodoItem(0);
        then(todoMVC.getTodoItems().size()).isEqualTo(0);
    }

//    TODO:
//        EXERCISE:
//           - Add more tests, or change the test code so that you can experiment
//             with more of the assertion approaches listed at
//              - https://assertj.github.io/doc/#get-assertj-core
//              - https://assertj.github.io/doc/#assertj-core-assertions-guide


    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }

    /*

        AssertJ has many more features than 'matching' it also allows soft asserts
        so that you can have assertions that do not fail the test immediately.
        There are a lot of features available. It is worth reading the documentation
        to see its features.

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
