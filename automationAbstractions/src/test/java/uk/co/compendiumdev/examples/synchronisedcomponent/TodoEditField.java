package uk.co.compendiumdev.examples.synchronisedcomponent;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.SlowLoadableComponent;

import java.time.Clock;

/*

 This implementation uses the SlowLoadableComponent
 SlowLoadableComponent offers the same interface as LoadableComponent
 but the isLoaded is used for synchronisation i.e. wait until isLoaded
 in LoadableComponent isLoaded is used as an 'assertion mechanism' to
 make sure we are on the expected page

 The sync and check is triggered by the inherited 'get' method

---

# SlowLoadable Component Example

* Extends SlowLoadableComponent
* Constructor has to additionally call
    * super(new SystemClock(), 10);
    * Where 10 is a timeout # of seconds
* _**get()**_
    * If isLoaded then return this Else load
    * While not loaded{ wait for 200 millseconds}
* Implement _**load**_ and _**isLoaded**_
    * But can remove sync loops from load




*/

// TODO:
//      EXERCISE:
//              Make this simpler by not extending SlowLoadableComponent
//              and implementing a get method which uses a WebDriverWait
//              to wait until the field is clickable
public class TodoEditField extends SlowLoadableComponent {


    private final WebDriver driver;

    public TodoEditField(WebDriver driver) {
        super(Clock.systemDefaultZone(), 20);
        this.driver = driver;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

        try {
            WebElement element = driver.findElement(By.cssSelector("li.editing input.edit"));
            if (element.isEnabled() && element.isDisplayed()) {
                return;
            }
        }catch(Exception e){

        }
        // if it isn't loaded throw an Error since
        // that is how SlowLoadableComponent works
        throw new Error("Component not loaded");
    }

    public void edit(final String editTheTitleTo) {

        WebElement editField = driver.findElement(By.cssSelector("li.editing input.edit"));
        editField.click();

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].value='';", editField);

        editField.sendKeys(editTheTitleTo);
        editField.sendKeys(Keys.ENTER);
    }
}
