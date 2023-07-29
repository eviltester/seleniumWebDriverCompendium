package uk.co.compendiumdev.examples.component;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * This is a copy of the TodoMVCPojoPage to keep the examples isolated
 */
public class ComponentPojoPage {

    private static final By TODO_ITEMS = By.cssSelector("ul.todo-list li div.view");

    private final WebDriver driver;
    private final String url;
    private final WebDriverWait wait;

    public ComponentPojoPage(WebDriver driver, String url) {
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
    }
}
