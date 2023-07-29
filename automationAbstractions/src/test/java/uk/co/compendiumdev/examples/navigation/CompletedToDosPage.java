package uk.co.compendiumdev.examples.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class CompletedToDosPage{

    private final WebDriver driver;
    private final TodoMVCSite site;

    public CompletedToDosPage(WebDriver driver, TodoMVCSite site){
        this.driver = driver;
        this.site = site;
    }

    protected void open() {
        driver.get(site.getURL() + "#/completed");
        waitUntilLoaded();
    }

    public void waitUntilLoaded() {
        new WebDriverWait(driver,10).until(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector(".filters li > a.selected"),"Completed"
                ));
    }

    public void clickOnAllFilter() {
        new FooterFilters(driver).all();
    }

    public void clickOnActiveFilter() {
        new FooterFilters(driver).active();
    }

    public void clickOnCompletedFilter() {
        new FooterFilters(driver).completed();
    }

}
