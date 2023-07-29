package uk.co.compendiumdev.examples.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsLeftCount {
    private final WebDriver driver;

    public ItemsLeftCount(final WebDriver driver) {
        this.driver = driver;
    }

    public int count() {
            WebElement countElement = driver.findElement(By.cssSelector("footer > span.todo-count > strong"));
            return Integer.valueOf(countElement.getText());
    }
}
