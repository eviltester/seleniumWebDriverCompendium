package uk.co.compendiumdev.examples.synchronisedcomponent;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/*
 This is a copy of the TodoMVCPojoPage to keep the examples isolated
 but the editItem has been amended to use a component
 the component has in built synchronisation so that a 'get' will
 wait until the component is ready to work with.

 The page has been edited to 'be' a LoadableComponent which means it
 inherits a 'get' method and we implement the methods to detect if
 we are on the correct page or not.

 LoadableComponent is not a synchronisation component, it is an assertion
 approach and a common loading interface.

 Slow Loadable Component is a synchronisation approach.
*/
public class SynchronisedComponentPojoPage extends LoadableComponent {

    private static final By TODO_ITEMS = By.cssSelector("ul.todo-list li div.view");

    private final WebDriver driver;
    private final String url;
    private final WebDriverWait wait;


    public SynchronisedComponentPojoPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        wait = new WebDriverWait(driver,10);
    }

    public List<WebElement> getTodoItems() {
        return driver.findElements(TODO_ITEMS);
    }


    public String getToDoText(int itemIndex) {
        List<WebElement> items = getTodoItems();
        return items.get(itemIndex).getText();
    }

    public void typeIntoNewToDo(CharSequence... keysToSend) {
        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys(keysToSend);
    }

    public void open() {
        driver.get(url);
    }


    public void deleteTodoItem(int todoIndex) {
        List<WebElement> items = getTodoItems();
        WebElement todoListItem = items.get(todoIndex);

        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        // show the destroy button
        //todoListItem.click(); // chrome only
        new Actions(driver).moveToElement(todoListItem).perform(); // hover

        WebElement destroyButton = todoListItem.findElement(By.cssSelector("button.destroy"));
        wait.until(ExpectedConditions.elementToBeClickable(destroyButton));
        destroyButton.click();
    }

    public void editItem(int itemIndex, String editTheTitleTo) {

        List<WebElement> items = getTodoItems();
        WebElement todoListItem = items.get(itemIndex);

        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        // double click on the label
        todoListItem = todoListItem.findElement(By.tagName("label"));

        // used actions here because WebElement supports click only
        new Actions(driver).doubleClick(todoListItem).perform();

        // TodoEditField is a component with synchronisation
        final TodoEditField editField = new TodoEditField(driver);
        editField.get();
        editField.edit(editTheTitleTo);

    }

    @Override
    protected void load() {
        open();
    }

    @Override
    protected void isLoaded() throws Error {
        boolean loaded = false;
        try{
            if(driver.findElement(By.className("new-todo"))!=null){
                loaded = true;
            }
        }catch (Exception e){

        }
        if(!loaded){
            throw new Error("page not loaded");
        }
    }
}
