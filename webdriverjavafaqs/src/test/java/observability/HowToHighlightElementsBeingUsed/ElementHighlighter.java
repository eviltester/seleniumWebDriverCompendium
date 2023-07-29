package observability.HowToHighlightElementsBeingUsed;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Random;

public class ElementHighlighter implements WrapsDriver {
    EventFiringWebDriver driver;

    public ElementHighlighter(final WebDriver aDriver,
                              final String desiredBackgroundColour) {

        driver = new EventFiringWebDriver(aDriver);
        driver.register(new ElementHighlighterListener(
                                    driver, desiredBackgroundColour));
    }

    @Override
    public WebDriver getWrappedDriver() {
        return driver;
    }

    private class ElementHighlighterListener extends AbstractWebDriverEventListener {

        HighlightElement highlighter;

        public ElementHighlighterListener(WebDriver driver,
                                          final String highlightColour) {

            highlighter = new HighlightElement(driver, highlightColour);
        }

        @Override
        public void beforeClickOn(final WebElement element, final WebDriver driver) {

            highlighter.highlight(element);
            super.beforeClickOn(element, driver);
        }

        @Override
        public void beforeChangeValueOf(final WebElement element,
                                        final WebDriver driver,
                                        final CharSequence[] keysToSend) {

            highlighter.highlight(element);
            super.beforeChangeValueOf(element, driver, keysToSend);
        }

        @Override
        public void afterFindBy(final By by, final WebElement element,
                                final WebDriver driver) {

            highlighter.highlight(element);
            super.afterFindBy(by, element, driver);
        }
    }
}
