package uk.co.compendiumdev.examples.pagefactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class TodoMVCPageFactoryPage {

    // TODO:
    //      EXERCISE:
    //              - Compare this page object with the TODOMVCPojoPage
    //              - Aside from the annotations, what else is different
    //                between the pages?

    @FindBy(how = How.CSS, using="ul.todo-list li div.view")
    List<WebElement> todoItems;

    @FindBy(how = How.CLASS_NAME, using="new-todo")
    WebElement createTodo;

    @FindBy(how = How.CSS, using="li.editing input.edit")
    WebElement editField;

    private final WebDriver driver;
    private final String url;
    private final WebDriverWait wait;

    public TodoMVCPageFactoryPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver, this);

        // TODO:
        //      EXERCISE:
        //              -   Instead of using the initElements above,
        //                  Uncomment the line below,
        //                  and comment out all the WebDriverWait calls,
        //              -   The AjaxElementLocatorFactory is supposed to synchronise on dynamic element creation
        //                  Does the test work? If not, why not?
        //              -   Is it as fast? If not, why not?
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),  this);

        // PageFactory code often has fewer waits,
        // and people often use ImplicitWait to resolve
        // synchronisation issues - I do not recommend this.
        // if you experience any timing issues in the PageFactoryTest try
        // uncommenting this line - but remember this will impact your
        // other tests
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public List<WebElement> getTodoItems() {
        return todoItems;
    }


    public String getToDoText(int itemIndex) {
        List<WebElement> items = getTodoItems();
        return items.get(itemIndex).getText();
    }


    public void typeIntoNewToDo(CharSequence... keysToSend) {
        createTodo.click();
        createTodo.sendKeys(keysToSend);
    }

    public void open() {
        driver.get(url);
    }


    public void deleteTodoItem(int todoIndex) {

        WebElement todoListItem = todoItems.get(todoIndex);

        // show the destroy button
        //todoListItem.click(); // chrome only
        new Actions(driver).moveToElement(todoListItem).perform();

        // there are multiple destroy buttons in the DOM, I need
        // to find the destroy button under the current todo
        // I can't do that with a Page Factory annotation
        final WebElement destroyButton = todoListItem.findElement(By.cssSelector("button.destroy"));
        wait.until(ExpectedConditions.elementToBeClickable(destroyButton));
        destroyButton.click();
    }

    public void editItem(int itemIndex, String editTheTitleTo) {

        List<WebElement> items = getTodoItems();
        WebElement todoListItem = items.get(itemIndex);

        // TODO:
        //    EXERCISE:
        //        Is this necessary to click on the label?
        //        Is there another way to do it, and use an annotated field instead of a relative findElement for label?
        // double click on the label
        todoListItem = todoListItem.findElement(By.tagName("label"));
        // used actions here because WebElement supports click only
        new Actions(driver).doubleClick(todoListItem).perform();

        editField.click();

        // TODO:
        //       EXERCISE:
        //           - refactor this into a 'cleared' method on EnsureWebElementIs
        //             and use the EnsureWebElementIs in the page object
        // clear causes the javascript on the field to trigger and close the input
        // perhaps it loses focus? Use JS instead to empty field
        // editField.clear();
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].value='';", editField);

        editField.sendKeys(editTheTitleTo);
        editField.sendKeys(Keys.ENTER);
    }

}
