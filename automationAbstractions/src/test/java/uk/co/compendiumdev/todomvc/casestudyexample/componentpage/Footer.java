package uk.co.compendiumdev.todomvc.casestudyexample.componentpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Footer {
    private final WebDriver driver;

    public Footer(final WebDriver driver) {
        this.driver = driver;
    }

    public int getCount() {
        WebElement countElement = driver.findElement(By.cssSelector("span.todo-count strong"));
        return Integer.valueOf(countElement.getText());
    }

    public void all() {
        clickOnFilter(Filter.ALL.filterIndex);
    }

    public void active() {
        clickOnFilter(Filter.ACTIVE.filterIndex);
    }

    public void completed() {
        clickOnFilter(Filter.COMPLETED.filterIndex);
    }

    public void clearCompleted(){
        driver.findElement(By.cssSelector("button.clear-completed")).click();
    }

    public boolean isVisible(){
        if(getFilters().size()>0){
            return getFilters().get(0).isDisplayed();
        }
        return false;
    }

    private void clickOnFilter(int filterIndex) {
        getFilters().get(filterIndex).click();
    }

    private List<WebElement> getFilters(){
        return driver.findElements(By.cssSelector("ul.filters li a"));
    }

    private enum Filter {
        ALL(0), ACTIVE(1), COMPLETED(2);

        private int filterIndex;
        Filter(int index){
            this.filterIndex = index;
        }

        public int index(){
            return filterIndex;
        }
    }
}
