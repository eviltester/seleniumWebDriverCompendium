package users.simulating.HowToSimulateUserDelay.withEventFiringWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Random;

public class UserActionDelay implements WrapsDriver {
    WebDriver driver;

    public UserActionDelay(final WebDriver aDriver, final int shortestWait, final int maximumWait) {
        UserDelaysEvents listener = new UserDelaysEvents(shortestWait, maximumWait);
        driver = new EventFiringDecorator<>(listener).decorate(aDriver);
    }

    @Override
    public WebDriver getWrappedDriver() {
        return driver;
    }

    public class UserDelaysEvents implements WebDriverListener {
        private final int shortestWait;
        private final int longestWait;

        public UserDelaysEvents(final int shortestWait, final int maximumWait) {
            this.shortestWait = shortestWait;
            this.longestWait = maximumWait;
        }

        @Override
        public void beforeClick(final WebElement element) {
            userWaitsForSomeTime();
        }

        @Override
        public void beforeSendKeys(final WebElement element, final CharSequence[] keysToSend) {
            userWaitsForSomeTime();
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
