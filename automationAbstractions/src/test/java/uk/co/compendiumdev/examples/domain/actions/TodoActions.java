package uk.co.compendiumdev.examples.domain.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.examples.domain.pojofordomain.TodoMVCDomainPojoPage;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class TodoActions {

    private final WebDriver driver;
    final TodoMVCDomainPojoPage page;

    public TodoActions(WebDriver driver){

        this.driver = driver;
        page = new TodoMVCDomainPojoPage(
                                            driver,
                                            new TodoMVCSite().getURL());
    }

    public void createMultipleTodos(String ... todoNames){

        for(String todoName : todoNames){
            page.typeIntoNewToDo(todoName + Keys.ENTER);
        }
    }

    public void createTodos(final int count, final String template) {
        createTodosOffset(count, template, 1);

    }

    public void createTodosOffset(final int count, final String template, int offset) {

        int number=offset;

        for(int item=0; item<count; item++){
            page.typeIntoNewToDo(String.format(template, number) + Keys.ENTER);
            number++;
        }

    }
}
