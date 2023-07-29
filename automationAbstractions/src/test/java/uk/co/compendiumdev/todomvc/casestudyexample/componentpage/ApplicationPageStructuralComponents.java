package uk.co.compendiumdev.todomvc.casestudyexample.componentpage;

import uk.co.compendiumdev.todomvc.site.TodoMVCSite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 * This is a 'structural' page object which uses components
 * This is a case study and all functions are implemented
 * by delegation
 *
 * Where possible methods delegate to the VisibleToDoEntry component
 */
public class ApplicationPageStructuralComponents<TODOS> {

    By TODOS = By.cssSelector("ul.todo-list li:not(.hidden)");

    private final WebDriver driver;
    private final TodoMVCSite todoMVCSite;
    private final WebDriverWait wait;
    private Footer footer;

    public ApplicationPageStructuralComponents(WebDriver driver, TodoMVCSite todoMVCSite) {
        this.driver = driver;
        this.todoMVCSite = todoMVCSite;
        wait = new WebDriverWait(driver,10);
        footer = new Footer(driver);
    }

    public int getCountOfTodo() {
        return getVisibleTodoItems().size();
    }

    public List<WebElement> getVisibleTodoItems() {
        return driver.findElements(TODOS);
    }

    /**
     * getAToDoEntryAt and then you can use it to:
     * - getText
     * - delete the to do item
     * - edit the to do item
     * - mark it completed or toggle it
     *
     * @param itemIndex
     * @return
     */
    public VisibleToDoEntry getToDoEntryAt(int itemIndex){
        List<WebElement> items = getVisibleTodoItems();
        return new VisibleToDoEntry(driver, items.get(itemIndex));
    }


    public void typeIntoNewToDo(CharSequence... keysToSend) {
        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        for(CharSequence seq : keysToSend) {
            createTodo.sendKeys(seq);
        }
    }

    public void get() {
        driver.get(todoMVCSite.getURL());
    }

    /**
     * get the footer and then you can check if it is visible,
     * or filter by All, Completed, Active
     * and get the displayed count
     * @return
     */
    public Footer footer(){
        return footer;
    }


}
