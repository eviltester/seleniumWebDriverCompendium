package uk.co.compendiumdev.examples.component;

import org.openqa.selenium.*;
import uk.co.compendiumdev.examples.component.element.CheckboxElement;
import uk.co.compendiumdev.selenium.support.webelement.EnsureWebElementIs;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisibleToDoEntry {

    private final WebElement todoEntry;
    private final WebDriver driver;
    private final WebDriverWait wait;

    public VisibleToDoEntry(WebDriver driver, WebElement toDoEntry){
        this.todoEntry = toDoEntry;
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static VisibleToDoEntry getToDoAt(WebDriver driver, int position){

        WebElement element = driver.findElements(By.cssSelector("ul.todo-list li:not(.hidden)")).
                                get(position);
        return new VisibleToDoEntry(driver, element);
    }

    public String getText(){
        return todoEntry.getText();
    }

    public void delete(){

        waitUntilClickable();

        EnsureWebElementIs.inViewOnThePage(driver, todoEntry);

        todoEntry.click(); // enable the destroy button

        WebElement destroyButton = todoEntry.findElement(By.cssSelector("button.destroy"));
        wait.until(ExpectedConditions.elementToBeClickable(destroyButton));

        destroyButton.click();
    }

    public VisibleToDoEntry edit(String newText){
        waitUntilClickable();

        EnsureWebElementIs.inViewOnThePage(driver, todoEntry);

        // have no choice but to use actions here
        new Actions(driver).doubleClick(todoEntry.findElement(By.cssSelector("div > label"))).perform();

        WebElement editField = todoEntry.findElement(By.cssSelector("input.edit"));
        wait.until(ExpectedConditions.elementToBeClickable(editField));
        editField.click();

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].value='';", editField);

        editField.sendKeys(newText);
        editField.sendKeys(Keys.ENTER);

        return this;
    }

    public VisibleToDoEntry markCompleted(){
        waitUntilClickable();
        EnsureWebElementIs.inViewOnThePage(driver, todoEntry);
        checkbox().check();
        return this;
    }

    public VisibleToDoEntry markActive(){
        waitUntilClickable();
        EnsureWebElementIs.inViewOnThePage(driver, todoEntry);
        checkbox().uncheck();
        return this;
    }

    public boolean isComplete(){
        waitUntilClickable();
        EnsureWebElementIs.inViewOnThePage(driver, todoEntry);
        return checkbox().isChecked();
    }

    private void waitUntilClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(todoEntry));
    }

    public VisibleToDoEntry toggle(){
        waitUntilClickable();
        EnsureWebElementIs.inViewOnThePage(driver, todoEntry);
        checkbox().toggle();
        return this;
    }

    public CheckboxElement checkbox() {
        WebElement checkboxElement = todoEntry.findElement(By.cssSelector("input.toggle"));
        return new CheckboxElement(checkboxElement);
    }


}
