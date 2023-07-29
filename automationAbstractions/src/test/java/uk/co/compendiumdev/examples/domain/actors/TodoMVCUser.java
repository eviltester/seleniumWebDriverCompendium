package uk.co.compendiumdev.examples.domain.actors;


import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.examples.domain.pojofordomain.TodoMVCDomainPojoPage;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

/**
 * A high level user object which wraps 'user' functionality making a user focused DSL without
 * bringing in Cucumber
 * It uses lower level abstractions as appropriate e.g. structural and functional pages
 */
public class TodoMVCUser {
    private final WebDriver driver;
    private final TodoMVCSite site;


    public TodoMVCUser(WebDriver driver, TodoMVCSite todoMVCSite) {
        this.driver = driver;
        this.site = todoMVCSite;

    }

    public TodoMVCUser opensApplication() {
        driver.get(site.getURL());
        return this;
    }

    public TodoMVCUser createNewToDo(String toDoText) {

        TodoMVCDomainPojoPage page = new TodoMVCDomainPojoPage(driver, site.getURL());

        page.enterNewToDo(toDoText);

        return this;
    }


    public TodoMVCUser deleteToDoAt(int positionInList) {

        TodoMVCDomainPojoPage page = new TodoMVCDomainPojoPage(driver, site.getURL());
        page.deleteTodoItem(positionInList);

        return this;
    }

    public TodoMVCUser and(){
        return this;
    }

}
