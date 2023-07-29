package uk.co.compendiumdev.examples.firsttests;

import uk.co.compendiumdev.examples.domain.actors.TodoMVCUser;
import uk.co.compendiumdev.examples.pojo.TodoMVCPojoPage;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/*
    This test uses many abstractions:

    - WebDriver, variables, test and method names,
    - annotations for test execution - ordering and 'test' identification
    - Hamcrest as an assertion abstraction
    - TodoMVCUser as a domain abstraction for the system user
    - A page object ApplicationPageFunctional
    - A Driver manager ExecutionDriver
    - A domain abstraction for the TodoMVCSite and environment
 */
public class WithAbstractionTest {

    @Test
    public void canCreateAToDo(){

        WebDriver driver = new ExecutionDriver().get();

        TodoMVCUser user = new TodoMVCUser(driver, new TodoMVCSite());

        user.opensApplication().and().createNewToDo("new task");

        TodoMVCPojoPage page =
                new TodoMVCPojoPage(driver, new TodoMVCSite().getURL());

        assertThat(page.getCountOfTodoDoItems(), is(1));
        assertThat(page.isFooterVisible(), is(true));

        ExecutionDriver.closeDriver(driver);
    }
}
