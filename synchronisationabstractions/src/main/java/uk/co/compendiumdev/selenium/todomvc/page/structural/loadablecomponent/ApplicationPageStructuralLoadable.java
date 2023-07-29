package uk.co.compendiumdev.selenium.todomvc.page.structural.loadablecomponent;

import uk.co.compendiumdev.selenium.support.webelement.EnsureWebElementIs;
import uk.co.compendiumdev.todomvc.page.structural.pojo.StructuralApplicationPage;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.compendiumdev.todomvc.page.structural.pojo.StructuralEnums.ItemsInState;
import uk.co.compendiumdev.todomvc.page.structural.pojo.StructuralEnums.Filter;

import java.awt.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationPageStructuralLoadable extends LoadableComponent<ApplicationPageStructuralLoadable> implements StructuralApplicationPage {

    private static final By CLEAR_COMPLETED = By.id("clear-completed");

    private final WebDriver driver;
    private final TodoMVCSite todoMVCSite;
    private final WebDriverWait wait;

    public ApplicationPageStructuralLoadable(WebDriver driver, TodoMVCSite todoMVCSite) {
        this.driver = driver;
        this.todoMVCSite = todoMVCSite;
        wait = new WebDriverWait(driver,10);
    }

    public int getCountOfTodo(ItemsInState state) {
        return getTodoItems(state).size();
    }

    public String getToDoText(int itemIndex) {
        List<WebElement> items = getTodoItems(ItemsInState.VISIBLE);
        return items.get(itemIndex).getText();
    }

    public List<WebElement> getTodoItems(ItemsInState state) {
        return driver.findElements(By.cssSelector(state.cssSelector()));
    }


    public void typeIntoNewToDo(CharSequence... keysToSend) {
        WebElement createTodo = driver.findElement(By.id("new-todo"));
        createTodo.click();
        createTodo.sendKeys(keysToSend);
    }

    @Override
    public void open() {
        get();
    }


    @Override
    protected void load() {
        driver.get(todoMVCSite.getURL());

        int maxNumberOfTimesToCheckIsLoaded=100;
        long millisecondsToWaitForPollingTime=100L;

        while(maxNumberOfTimesToCheckIsLoaded>0){

            try{
                isLoaded();
                break; // we are loaded - exit the loop
            }catch(Error e){
                // not loaded yet, but don't propogate Error from load
            }

            maxNumberOfTimesToCheckIsLoaded--;
            try {
                Thread.sleep(millisecondsToWaitForPollingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    @Override
    protected void isLoaded() throws Error {

        boolean loadedState = true;
        String notLoadedDescription = "";

        // wrap in an exception catch and convert to an error
        try{
            if(!driver.getTitle().endsWith("TodoMVC")){
                loadedState = false;
                notLoadedDescription += " [Title does not end with TodoMVC]";
            }

            // app sections must exist in the dom
            // throws noSuchElementException if not available
            driver.findElement(By.id("todoapp"));
            driver.findElement(By.id("header"));
            driver.findElement(By.id("main"));
            driver.findElement(By.id("footer"));
            driver.findElement(By.id("new-todo"));

        }catch(Exception e){
            throw new Error("Exception thrown when checking isLoaded " + e.getMessage());
        }

        if(!loadedState){
            throw new Error("Page not loaded: " + notLoadedDescription);
        }
    }

    public boolean isFooterVisible() {
        return driver.findElement(By.id("footer")).isDisplayed();
    }

    public boolean isMainVisible() {
        return driver.findElement(By.id("main")).isDisplayed();
    }

    public void deleteTodoItem(int todoIndex) {
        List<WebElement> items = getTodoItems(ItemsInState.VISIBLE);
        WebElement todoListItem = items.get(todoIndex);

        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        // on my mac, sometimes this fails because
        // the default size of the window is small so
        // the elementabstraction is off screen,
        // I used to do this with an extra todoListItem.click()
        // where the first click brings it on to screen
        // but by scrolling, the button is lost
        // I decided to use JavaScript to scroll it into view instead
        EnsureWebElementIs.inViewOnThePage(driver, todoListItem);

        todoListItem.click(); // enable the destroy button

        WebElement destroyButton = todoListItem.findElement(By.cssSelector("button.destroy"));
        wait.until(ExpectedConditions.elementToBeClickable(destroyButton));

        destroyButton.click();
    }

    public void editItem(int itemIndex, String editTheTitleTo) {
        List<WebElement> items = getTodoItems(ItemsInState.VISIBLE);
        WebElement todoListItem = items.get(itemIndex);
        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        // have no choice but to use actions here
        new Actions(driver).doubleClick(todoListItem.findElement(By.cssSelector("div > label"))).perform();
        // have to be more specific about locators on the mac, the above works, the below doesn't
        //new Actions(driver).doubleClick(todoListItem).perform();

        WebElement editfield = todoListItem.findElement(By.cssSelector("input.edit"));
        wait.until(ExpectedConditions.elementToBeClickable(editfield));
        editfield.click();
        editfield.clear();
        editfield.sendKeys(editTheTitleTo);
        editfield.sendKeys(Keys.ENTER);
    }


    public Integer getCountInFooter() {
        WebElement countElement = driver.findElement(By.cssSelector("#todo-count strong"));
        return Integer.valueOf(countElement.getText());
    }

    public String getCountTextInFooter() {
        WebElement countElement = driver.findElement(By.cssSelector("#todo-count"));
        String countText = countElement.getText();

        // remove the number from the string
        return countText.replace(getCountInFooter() + " ", "");
    }

    public void clickOnFilter(Filter filter) {
        List<WebElement> filters = driver.findElements(By.cssSelector("#filters li a"));
        filters.get(filter.index()).click();
    }

    public void toggleCompletionOfItem(int itemIndex) {

        List<WebElement> items = getTodoItems(ItemsInState.VISIBLE);
        WebElement todoListItem = items.get(itemIndex);
        wait.until(ExpectedConditions.elementToBeClickable(todoListItem));

        WebElement checkbox = todoListItem.findElement(By.cssSelector("input.toggle"));
        checkbox.click();
    }

    public boolean isClearCompletedVisible() {
        // it may or may not be in the dom
        List<WebElement> clearCompleted = driver.findElements(CLEAR_COMPLETED);
        if(clearCompleted.size()==0){return false;}

        return clearCompleted.get(0).isDisplayed();
    }

    public Integer getClearCompletedCount() {
        Integer clearCompletedCount=0;

        if(isClearCompletedVisible()){
            WebElement clearCompletedButton = driver.findElement(CLEAR_COMPLETED);
            String clearCompletedText = clearCompletedButton.getText();
            Pattern completedText = Pattern.compile("Clear completed \\((.+)\\)");
            Matcher matcher = completedText.matcher(clearCompletedText);

            if(matcher.matches()){
                return Integer.valueOf(matcher.group(1));
            }
        }

        return clearCompletedCount;
    }

    public void clickClearCompleted() {
        WebElement clearCompletedButton = driver.findElement(CLEAR_COMPLETED);
        clearCompletedButton.click();
    }

}
