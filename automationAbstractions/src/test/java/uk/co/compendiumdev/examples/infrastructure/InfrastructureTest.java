package uk.co.compendiumdev.examples.infrastructure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class InfrastructureTest {

    /*
        Abstractions exist to help with the infrastructure of Selenium WebDriver

        e.g. https://github.com/bonigarcia/webdrivermanager

        getting local WebDriver environment ready via

        mvn test -Dtest=InfrastructureTest
     */

    @Test
    public void ensureChromeDriverIsAvailable(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        final TodoMVCSite todoMVCSite = new TodoMVCSite();
        driver.get(todoMVCSite.getURL());

        driver.close();
        driver.quit();
    }

    @Test
    public void ensureFirefoxDriverIsAvailable(){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        final TodoMVCSite todoMVCSite = new TodoMVCSite();
        driver.get(todoMVCSite.getURL());

        // firefox wants only one: close, or quit, not both
        //driver.close();
        driver.quit();
    }
}
