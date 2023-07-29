package uk.co.compendiumdev.examples.navigation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class AllToDosPage{

    private final WebDriver driver;
    private final TodoMVCSite site;

    public AllToDosPage(WebDriver driver, TodoMVCSite site){
        this.driver = driver;
        this.site = site;
    }

    protected void open() {
        driver.get(site.getURL() + "#");
        waitUntilLoaded();
    }

    public void waitUntilLoaded() {
        new WebDriverWait(driver,10).until(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector(".filters li > a.selected"),"All"
                ));
    }

    public void clickOnAllFilter() {
        new FooterFilters(driver).all();
    }

    public ActiveToDosPage clickOnActiveFilter() {
        new FooterFilters(driver).active();
        return new ActiveToDosPage(driver, site);
    }

    public void clickOnCompletedFilter() {
        new FooterFilters(driver).completed();
    }
}

