package uk.co.compendiumdev.examples.domaindslcucumberjvm;

import cucumber.api.java.en.And;
import uk.co.compendiumdev.examples.domain.actors.TodoMVCUser;
import uk.co.compendiumdev.examples.domain.pojofordomain.TodoMVCDomainPojoPage;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ToDoMvcSteps {

    private WebDriver driver;
    private TodoMVCSite todoMVCSite;
    private TodoMVCUser user;
    private TodoMVCDomainPojoPage page;

    @Given("^a user opens a blank ToDoMVC page$")
    public void a_user_opens_a_blank_ToDoMVC_page() throws Throwable {

        driver = new ExecutionDriver().get();
        todoMVCSite = new TodoMVCSite();
        user = new TodoMVCUser(driver, todoMVCSite);

        user.opensApplication();

        page = new TodoMVCDomainPojoPage(driver, todoMVCSite.getURL());

        assertThat(page.getTodoItems().size(), is(0));
    }

    @When("^the user creates a todo \"([^\"]*)\"$")
    public void the_user_creates_a_todo(String todoName) throws Throwable {

        final int initialCount = page.getTodoItems().size();

        user.createNewToDo(todoName);

        assertThat(page.getTodoItems().size(), is( initialCount+1));
    }


    @Then("^they see (\\d+) todo item on the page$")
    public void they_see_todo_item_on_the_page(int expectedToDoCount) throws Throwable {
        assertThat(page.getTodoItems().size(), is(expectedToDoCount));
    }

    // when using JUnit 4 I was able to use a hook, but not with JUnit 5
//    @After
//    public void closeBrowser(){
//        ExecutionDriver.closeDriver(driver);
//    }

    // for JUnit 5 I added a close browser step rather than try and hack about
    // with additional hooks and other complications
    @And("^exit the application$")
    public void exitTheApplication() {
        ExecutionDriver.closeDriver(driver);
    }
}
