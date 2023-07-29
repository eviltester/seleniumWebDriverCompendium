package uk.co.compendiumdev.examples.navigation;

import uk.co.compendiumdev.todomvc.site.TodoMVCSite;
import org.openqa.selenium.WebDriver;

public class TodoMVCNav {
    private final WebDriver driver;
    private final TodoMVCSite todoMVCSite;

    public enum Pages{
        ALL_TODOS_PAGE("#/"), COMPLETED_TODOS_PAGE("#/completed"), ACTIVE_TODOS_PAGE("#/active");
        private final String siteUrlSuffix;

        Pages(String siteUrlSuffix) {
            this.siteUrlSuffix = siteUrlSuffix;
        }

        public String getUrlSuffix() {
            return siteUrlSuffix;
        }
    }

    public TodoMVCNav(WebDriver driver, TodoMVCSite todoMVCSite) {
        this.driver = driver;
        this.todoMVCSite = todoMVCSite;
    }

    public void open(Pages thisPage) {
        driver.get(todoMVCSite.getURL() + thisPage.getUrlSuffix());
    }


}
