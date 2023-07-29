package eventfiringwebdriver.UsingMultipleListeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CanIUseMultipleListenersWithEventFiringWebDriverTest {

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void canUseMultipleListeners() {

        WebDriver driver = new ChromeDriver();

        final EventFiringWebDriver eventFiringWebDriver =
                                new EventFiringWebDriver(driver);

        BeforeEventListener before = new BeforeEventListener();
        AfterEventListener after = new AfterEventListener();
        eventFiringWebDriver.register(before);
        eventFiringWebDriver.register(after);

        String indexPage = "https://testpages.herokuapp.com/styled/index.html";
        eventFiringWebDriver.get(indexPage);
        eventFiringWebDriver.findElement(By.id("basicpagetest")).click();

        eventFiringWebDriver.get(indexPage);
        eventFiringWebDriver.findElement(By.id("elementattributestest")).click();

        eventFiringWebDriver.get(indexPage);
        eventFiringWebDriver.findElement(By.id("findbytest")).click();

        eventFiringWebDriver.get(indexPage);

        Assertions.assertEquals(3, before.getClickCount());
        Assertions.assertEquals(3, after.getClickCount());

        driver.quit();

    }

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
}
