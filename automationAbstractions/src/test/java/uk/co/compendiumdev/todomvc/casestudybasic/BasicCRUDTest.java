package uk.co.compendiumdev.todomvc.casestudybasic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

import java.util.List;


/*

        This package simulates working in an new code base that has some
        tests but no abstraction layers.

        It isn't all bad, because the programmer has created local
        methods for some of the functionality so the tests are easier
        to read.

        Refactor this to page objects or components or local methods.

        Do as you see fit
*/

//    TODO:
//        EXERCISES:
//            - review the tests, are there enough assertions to cover the test effectively?
//                - if not expand them
//            - use this as a basis for clean refactoring e.g.
//            - remove duplicate code and use fields for By variables
//            - remove other duplicate code by creating classes e.g. filters
//            - create page objects
//            - create component objects
//            - experiment with assertion abstractions
//            - add more tests to cover more functionality
//            - do the tests run on different browsers?
//            - do the tests run on different app implementations?


public class BasicCRUDTest {

    private WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        final TodoMVCSite todoMVCSite = new TodoMVCSite();

        driver.get(todoMVCSite.getURL());
    }

    @Test
    public void canCreateAToDo(){

        enterNewToDo("new task");

        Assertions.assertEquals(1, getCountOfTodoDoItems());
        Assertions.assertEquals("new task", getTodos().get(0).getText());
    }

    @Test
    public void canDeleteATodo(){

        enterNewToDo("Delete Me");

        Assertions.assertEquals(1, getCountOfTodoDoItems());

        deleteDo(0);

        Assertions.assertEquals(0, getCountOfTodoDoItems());
    }



    @Test
    public void canEditAnItem(){

        enterNewToDo("Edit Me");

        Assertions.assertEquals("Edit Me", getTodos().get(0).getText());

        editTodo(0, "Edited Me");

        Assertions.assertEquals("Edited Me", getTodos().get(0).getText());
    }

    @Test
    public void canWorkWithFooter(){

        enterNewToDo("First Item");
        Assertions.assertEquals(1, getCountInFooter());

    }

    @Test
    public void canUseTheFilters(){
        enterNewToDo("Need at least one");

        filterOnActive();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("#/active"));

        filterOnCompleted();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("#/completed"));

        filterOnAll();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("#/"));
    }


    @Test
    public void canMarkAnItemCompleted(){
        enterNewToDo("First Added Item");

        getTodos().get(0).findElement(By.cssSelector("input.toggle")).click();

        filterOnCompleted();

        Assertions.assertEquals(1, getCountOfTodoDoItems());

        filterOnActive();

        Assertions.assertEquals(0, getCountOfTodoDoItems());
    }

    private void enterNewToDo(String todoTitle) {

        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys(todoTitle);
        createTodo.sendKeys(Keys.RETURN);
    }

    private int getCountInFooter() {
        return Integer.valueOf(driver.findElement(By.cssSelector(".todo-count strong")).getText());
    }

    public List<WebElement> getTodos() {
        return driver.findElements(By.cssSelector("ul.todo-list li:not(.hidden)"));
    }

    public int getCountOfTodoDoItems() {
        return driver.findElements(By.cssSelector("ul.todo-list li:not(.hidden)")).size();
    }

    public void filterOnAll() {
        List<WebElement> filters = driver.findElements(By.cssSelector(".filters li a"));
        filters.get(0).click();
    }

    public void filterOnActive() {
        List<WebElement> filters = driver.findElements(By.cssSelector(".filters li a"));
        filters.get(1).click();
    }

    public void filterOnCompleted() {
        List<WebElement> filters = driver.findElements(By.cssSelector(".filters li a"));
        filters.get(2).click();
    }

    public void deleteDo(int x) {

        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement todoListItem = getTodos().get(x);

        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        new Actions(driver).moveToElement(todoListItem).perform();

        WebElement destroyButton = todoListItem.findElement(By.cssSelector("button.destroy"));
        wait.until(ExpectedConditions.elementToBeClickable(destroyButton));

        destroyButton.click();
    }


    public void editTodo(int x, String editTheTitleTo) {

        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement todoListItem = getTodos().get(x);
        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        final WebElement fieldLabel = todoListItem.findElement(By.cssSelector("div > label"));

        String textToEdit = fieldLabel.getText();

        // double click to edit and reveal the input field
        new Actions(driver).doubleClick(fieldLabel).perform();

        WebElement editField = todoListItem.findElement(By.cssSelector("input.edit"));
        wait.until(ExpectedConditions.elementToBeClickable(editField));
        editField.click();

        // clearing the field causes the entire field to disappear again
        // and then we have a stale element exception when we send keys
        // does field lose control?
        // Note: this used to work - did GUI change? or did webdriver change?
        // editField.clear();
        // will calculate length of existing text, then issue backspaces

        StringBuilder seq = new StringBuilder();
        for(int backspaceToAdd = 0; backspaceToAdd<textToEdit.length(); backspaceToAdd++){
            seq.append(Keys.BACK_SPACE);
        }
        seq.append(editTheTitleTo);
        seq.append(Keys.ENTER);
        editField.sendKeys(seq.toString());

        // OPTION: could use actions to do the same thing? which might simulate human more
        // OPTION: could use JavaScript to change the values of the field?
        // OPTION: is there a way to retain focus between clear and sendKeys?

    }

    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }
}
