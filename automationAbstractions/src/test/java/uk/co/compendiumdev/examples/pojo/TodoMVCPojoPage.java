package uk.co.compendiumdev.examples.pojo;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class TodoMVCPojoPage {

    private static final By TODO_ITEMS = By.cssSelector("ul.todo-list li:not(.hidden)");

    private final WebDriver driver;
    private final String url;
    private final WebDriverWait wait;

    public TodoMVCPojoPage(WebDriver driver, String url) {
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

    // TODO:
    //       EXERCISE:
    //                  - refactor the class so that all By selectors are static final fields
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

        WebElement editField = wait.until(ExpectedConditions.
                                        elementToBeClickable(
                                                By.cssSelector("li.editing input.edit")));

        editField.click();

        // TODO:
        //       EXERCISE:
        //           - refactor this into a 'clear' method on EnsureWebElementIs
        //             and use the EnsureWebElementIs in the page object
        // clear causes the javascript on the field to trigger and close the input
        // perhaps it loses focus? Use JS instead to empty field
        // editField.clear();
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].value='';", editField);

        editField.sendKeys(editTheTitleTo);
        editField.sendKeys(Keys.ENTER);
    }

    public int getCountOfTodoDoItems() {
        return getTodoItems().size();
    }

    public boolean isFooterVisible() {
        return driver.findElements(By.cssSelector("ul.filters li a")).size()>0;
    }


// TODO:
//       EXERCISE:
//             - are the methods on this page at a good level of abstraction?
//                  - e.g. deleteToDoItem or enableDeleteButton , clickDeleteButton?
//             - what levels could this model?
//             - create a list of alternative methods that the page object could expose
//             - should the methods you have identified all be on one page object, or would you have many?
//             - if you would have many, then what would they be called?
//             - write down your decisions for the existence of the objects you have identifed
//             - implement some of the page objects you have identified and use them in tests

}
