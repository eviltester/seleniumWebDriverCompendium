package eventfiringwebdriver.UsingMultipleListeners;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class CanIUseMultipleListenersWithEventFiringWebDriverTest {

    @BeforeAll
    public static void setupClass() {
    }

    /*
        We used to use

                final EventFiringWebDriver eventFiringWebDriver =
                                new EventFiringWebDriver(driver);

        BeforeEventListener before = new BeforeEventListener();
        AfterEventListener after = new AfterEventListener();
        eventFiringWebDriver.register(before);
        eventFiringWebDriver.register(after);

        String indexPage = "https://testpages.eviltester.com/styled/index.html";
        eventFiringWebDriver.get(indexPage);
        eventFiringWebDriver.findElement(By.id("basicpagetest")).click();

        ---

        private class BeforeEventListener extends AbstractWebDriverEventListener {

        private int countOfClicks = 0;

        @Override
        public void beforeClickOn(final WebElement element, final WebDriver driver) {

            System.out.println("About to click on element ");
            countOfClicks++;
            System.out.println(element.getText());
            super.beforeClickOn(element, driver);
        }

        public int getClickCount(){
            return countOfClicks;
        }
    }

    private class AfterEventListener extends AbstractWebDriverEventListener {

        private int countOfClicks = 0;

        @Override
        public void afterClickOn(final WebElement element, final WebDriver driver) {
            System.out.println("Have clicked on element");
            countOfClicks++;
            super.afterClickOn(element, driver);
        }

        public int getClickCount(){
            return countOfClicks;
        }
    }

     */

    /*
        Now we create a listener which implments WebDriverListener

        And instead of registering listeners, we override methods
     */

    public class BeforeEventListener implements WebDriverListener{

        private int countOfClicks = 0;

        @Override
        public void beforeClick(final WebElement element) {

            System.out.println("About to click on element ");
            countOfClicks++;
            System.out.println(element.getText());
        }

        public int getClickCount(){
            return countOfClicks;
        }
    }

    public class AfterEventListener implements WebDriverListener{

        private int countOfClicks = 0;

        @Override
        public void afterClick(final WebElement element) {
            System.out.println("Have clicked on element");
            countOfClicks++;
        }

        public int getClickCount(){
            return countOfClicks;
        }
    }

    @Test
    public void canUseMultipleListeners() {

        WebDriver driver = new ChromeDriver();

        BeforeEventListener before = new BeforeEventListener();
        AfterEventListener after = new AfterEventListener();

        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(before, after).decorate(driver);


        String indexPage = "https://testpages.eviltester.com/";
        eventFiringWebDriver.get(indexPage);
        eventFiringWebDriver.findElements(By.cssSelector("ul.navbar-nav li")).get(0).click();

        eventFiringWebDriver.get(indexPage);
        eventFiringWebDriver.findElements(By.cssSelector("ul.navbar-nav li")).get(1).click();

        eventFiringWebDriver.get(indexPage);
        eventFiringWebDriver.findElements(By.cssSelector("ul.navbar-nav li")).get(2).click();

        eventFiringWebDriver.get(indexPage);

        Assertions.assertEquals(3, before.getClickCount());
        Assertions.assertEquals(3, after.getClickCount());

        driver.quit();

    }

}
