package uk.co.compendiumdev.examples.structuralvsfunctional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

import java.util.List;

public class ApplicationPageStructuralExample{

    private static final By VISIBLE_TODOS = By.cssSelector("ul.todo-list li:not(.hidden)");

    private final WebDriver driver;
    private final TodoMVCSite todoMVCSite;
    private final WebDriverWait wait;

    public ApplicationPageStructuralExample(WebDriver driver, TodoMVCSite todoMVCSite) {
        this.driver = driver;
        this.todoMVCSite = todoMVCSite;
        wait = new WebDriverWait(driver,10);
    }

    public String getToDoText(int itemIndex) {
        List<WebElement> items = getVisibleTodos();
        return items.get(itemIndex).getText();
    }


    public void typeIntoNewToDo(CharSequence... keysToSend) {
        WebElement createTodo = driver.findElement(By.className("new-todo"));
        createTodo.click();
        createTodo.sendKeys(keysToSend);
    }

    public void open() {
        driver.get(todoMVCSite.getURL());
    }

    public boolean isFooterVisible() {
        return driver.findElement(By.className("footer")).isDisplayed();
    }

    public int getCountInFooter() {
        WebElement countElement = driver.findElement(By.cssSelector(".todo-count strong"));
        return Integer.valueOf(countElement.getText());
    }

    public void clickOnFilter(int index) {
        List<WebElement> filters = driver.findElements(By.cssSelector(".filters li a"));
        filters.get(index).click();
    }

    public WebElement getItemCheckbox(int itemIndex){
        List<WebElement> items = getVisibleTodos();
        WebElement todoListItem = items.get(itemIndex);
        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        return todoListItem.findElement(By.cssSelector("input.toggle"));
    }

    public void clickStateOfItem(int itemIndex) {
        getItemCheckbox(itemIndex).click();
    }

    public List<WebElement> getVisibleTodos() {
        return driver.findElements(VISIBLE_TODOS);
    }
}
