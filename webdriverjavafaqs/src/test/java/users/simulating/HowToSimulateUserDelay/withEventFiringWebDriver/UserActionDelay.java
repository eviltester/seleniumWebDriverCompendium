package users.simulating.HowToSimulateUserDelay.withEventFiringWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Random;

public class UserActionDelay implements WrapsDriver {
    EventFiringWebDriver driver;

    public UserActionDelay(final WebDriver aDriver, final int shortestWait, final int maximumWait) {
        driver = new EventFiringWebDriver(aDriver);
        driver.register(new UserDelaysEvents(shortestWait, maximumWait));
    }

    @Override
    public WebDriver getWrappedDriver() {
        return driver;
    }

    private class UserDelaysEvents extends AbstractWebDriverEventListener {
        private final int shortestWait;
        private final int longestWait;

        public UserDelaysEvents(final int shortestWait, final int maximumWait) {
            this.shortestWait = shortestWait;
            this.longestWait = maximumWait;
        }

        @Override
        public void beforeClickOn(final WebElement element, final WebDriver driver) {
            userWaitsForSomeTime();
            super.beforeClickOn(element, driver);
        }

        @Override
        public void beforeChangeValueOf(final WebElement element, final WebDriver driver, final CharSequence[] keysToSend) {
            userWaitsForSomeTime();
            super.beforeChangeValueOf(element, driver, keysToSend);
        }

        private void userWaitsForSomeTime() {
            final Random rnd = new Random();
            final int seconds = rnd.nextInt(longestWait - shortestWait);
            System.out.println(String.format("Wait for %d seconds ", seconds + shortestWait));
            try {
                Thread.sleep((seconds + shortestWait) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
