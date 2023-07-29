package nosuchelement.HowToDoSomethingIfElementNotFound;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotUsingEventForElementNotFoundTest {

    /* we can't use an EventFiringWebDriver to detect
       if an element is found or not */

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void whatIfElementNotFound(){

        WebDriver driver = new ChromeDriver();

        final EventFiringWebDriver eventFiringWebDriver =
                                new EventFiringWebDriver(driver);

        eventFiringWebDriver.register(new MyFindEventListener());

        String indexPage = "https://testpages.herokuapp.com/styled/index.html";
        eventFiringWebDriver.get(indexPage);

        Exception e = Assertions.assertThrows(NoSuchElementException.class, () -> {
                    eventFiringWebDriver.findElement(By.id("thisiddoesnotexist"));
                });

        driver.quit();

    }

    private class MyFindEventListener extends AbstractWebDriverEventListener {

        @Override
        public void beforeFindBy(final By by, final WebElement element, final WebDriver driver) {

            System.out.println("Before Find By");

            if(element==null){
                System.out.println("Element is always null in beforeFindBy");
            }

            try {
                super.beforeFindBy(by, element, driver);
            }catch(Throwable e){
                System.out.println("Should never see this message -" +
                                    " cannot catch exception here");
            }
        }

        @Override
        public void afterFindBy(final By by, final WebElement element, final WebDriver driver) {
            System.out.println("afterFindBy is not called when element not found");
            super.afterFindBy(by, element, driver);
        }

    }

}
