package uk.co.compendiumdev.examples.fluent;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * The fluent page returns 'this' from all methods that don't
 * have a specific return value.
 *
 * This can enable people who do not code well to build tests
 * using code completion easily.
 *
 * The syntactic sugar methods and, then, also make the final
 * code read like English language.
 *
 * Note: the page object only returns 'this' or primitives
 *
 */
public class FluentTodoMVCPage {

    private static final By TODO_ITEMS = By.cssSelector("ul.todo-list li:not(.hidden)");

    private final WebDriver driver;
    private final String url;
    private final WebDriverWait wait;

    public FluentTodoMVCPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        wait = new WebDriverWait(driver,10);
    }

    public List<WebElement> getTodoItems() {
        return driver.findElements(TODO_ITEMS);
    }

    public int countVisibleTodos(){
        return driver.findElements(TODO_ITEMS).size();
    }

    public String getToDoText(int itemIndex) {
        List<WebElement> items = getTodoItems();
        return items.get(itemIndex).getText();
    }

    public FluentTodoMVCPage typeIntoNewToDo(CharSequence... keysToSend) {
        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys(keysToSend);
        return this;
    }

    public FluentTodoMVCPage createTodo(String name){
        return typeIntoNewToDo(name + Keys.ENTER);
    }

    public FluentTodoMVCPage open() {
        driver.get(url);
        return this;
    }


    public FluentTodoMVCPage deleteTodoItem(int todoIndex) {
        List<WebElement> items = getTodoItems();
        WebElement todoListItem = items.get(todoIndex);

        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        // show the destroy button
        //todoListItem.click(); // chrome only
        new Actions(driver).moveToElement(todoListItem).perform(); // hover

        WebElement destroyButton = todoListItem.findElement(By.cssSelector("button.destroy"));
        wait.until(ExpectedConditions.elementToBeClickable(destroyButton));
        destroyButton.click();
        return this;
    }

    public FluentTodoMVCPage editItem(int itemIndex, String editTheTitleTo) {

        List<WebElement> items = getTodoItems();
        WebElement todoListItem = items.get(itemIndex);

        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        // double click on the label
        todoListItem = todoListItem.findElement(By.tagName("label"));

        // used actions here because WebElement supports click only
        new Actions(driver).doubleClick(todoListItem).perform();

        WebElement editField = wait.until(ExpectedConditions.
                                        elementToBeClickable(
                                                By.cssSelector("li.editing input.edit")));

        editField.click();

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].value='';", editField);

        editField.sendKeys(editTheTitleTo);
        editField.sendKeys(Keys.ENTER);
        return this;
    }

    public FluentTodoMVCPage clickFilterAll() {
        clickOnFilter(0);
        return this;
    }

    public FluentTodoMVCPage clickFilterActive() {
        clickOnFilter(1);
        return this;
    }

    public FluentTodoMVCPage clickFilterCompleted() {
        clickOnFilter(2);
        return this;
    }

    private void clickOnFilter(int filterIndex) {
        List<WebElement> filters = driver.findElements(By.cssSelector("ul.filters li a"));
        filters.get(filterIndex).click();
    }

    /* starts at 1, not 0 */
    public FluentTodoMVCPage toggleTodoStatus(final int position) {
        driver.findElements(
                    By.cssSelector("input.toggle")).
                get(position).click();
        return this;
    }

    public FluentTodoMVCPage and(){
        return this;
    }

    public FluentTodoMVCPage then(){
        return this;
    }

    public FluentTodoMVCPage also(){
        return this;
    }
}

// TODO:
//      QUESTION:
//             - Would any of the methods be improved by making them void?
//      EXERCISE:
//             - If so, make the changes and see if it is improved.


// TODO:
//      QUESTION:
//             - The page object only returns this or primitives, would
//               there be any issues if we returned other Page objects or
//               abstraction classes?
//      EXERCISE:
//             - refactor the page so that the clickFilter* methods are in a
//               FooterFilters class and the page returns a new FooterFilters object
//               from a filters() method.
//             - Does this help or hinder the fluent interface?

