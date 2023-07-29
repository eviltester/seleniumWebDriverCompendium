package uk.co.compendiumdev.examples.workarounds;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Some utility methods working with WebElements
 */
public class EnsureWebElementIs {

    private final WebDriver driver;

    public EnsureWebElementIs(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * because click didn't scroll up on Mac Firefox -
     * added a scroll to y location method called inViewOnThePage
     * which scrolls to the element abstraction's y position
     *
     * This may not be required in newest versions of WebDriver
      */

    public WebElement inViewOnThePage(WebElement todoListItem) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + todoListItem.getLocation().getY() + ")");
        return todoListItem;
    }
}
