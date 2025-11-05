package nosuchelement.HowToDoSomethingIfElementNotFound;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotUsingEventForElementNotFoundTest {

    /* we can't use an EventFiringWebDriver to detect
       if an element is found or not */



    @Test
    public void whatIfElementNotFound(){

        WebDriver driver = new ChromeDriver();
        WebDriverListener listener = new MyFindEventListener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);


        String indexPage = "https://testpages.eviltester.com";
        eventFiringWebDriver.get(indexPage);

        Exception e = Assertions.assertThrows(NoSuchElementException.class, () -> {
                    eventFiringWebDriver.findElement(By.id("thisiddoesnotexist"));
                });

        // this element does exist
        eventFiringWebDriver.findElement(By.cssSelector("li.nav-item"));

        driver.quit();

    }

    public class MyFindEventListener implements WebDriverListener {

        @Override
        public void beforeFindElement(final WebDriver driver, final By by) {

            System.out.println("Before Find By");
        }

        @Override
        public void afterFindElement(final WebDriver driver, final By by, final WebElement element) {
            System.out.println("afterFindBy is only called when element is found");
            if(element != null){
                System.out.println("Found element");
            }else{
                System.out.println("NOT FOUND element");
            }
        }

    }

}
