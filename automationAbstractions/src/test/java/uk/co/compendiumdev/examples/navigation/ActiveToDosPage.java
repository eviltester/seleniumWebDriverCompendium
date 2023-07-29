package uk.co.compendiumdev.examples.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class ActiveToDosPage{

    private final WebDriver driver;
    private final TodoMVCSite site;


    public ActiveToDosPage(WebDriver driver, TodoMVCSite site){
        this.driver = driver;
        this.site = site;
    }

    protected void open() {
        driver.get(site.getURL() + "#/active");
        waitUntilLoaded();
    }

    public void waitUntilLoaded() {
        new WebDriverWait(driver,10).until(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector(".filters li > a.selected"),"Active"
                ));
    }


// TODO:
//      QUESTION:
//             - The way that these pages are written each of the pages has
//               duplicated the methods clickOnAllFilter, clickOnActiveFilter etc.
//             - How could we handle that?
//               e.g. a FilterPageObject that they all extend? an abstract class?
//                    an interface?
//                    or not have the methods and simply have a filters() method
//                    which returns new FooterFilters(driver)?
//       EXERCISE:
//             - Choose an approach and implement it for all three pages:
//               ActiveToDosPage, AllToDosPage, CompletedToDosPage

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
