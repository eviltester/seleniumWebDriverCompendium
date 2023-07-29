package uk.co.compendiumdev.examples.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FooterFilters {
    private final WebDriver driver;

    public FooterFilters(final WebDriver driver) {
        this.driver = driver;
    }

    public void active() {
        clickOnFilter(1);
    }

    public void completed() {
        clickOnFilter(2);
    }

    private void clickOnFilter(int filterIndex) {
        List<WebElement> filters = driver.findElements(By.cssSelector("ul.filters li a"));
        filters.get(filterIndex).click();
    }

}
