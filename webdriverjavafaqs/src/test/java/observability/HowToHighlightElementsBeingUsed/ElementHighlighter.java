package observability.HowToHighlightElementsBeingUsed;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class ElementHighlighter implements WrapsDriver {
    WebDriver driver;

    public ElementHighlighter(final WebDriver aDriver,
                              final String desiredBackgroundColour) {

        ElementHighlighterListener listener = new ElementHighlighterListener(aDriver, desiredBackgroundColour);
        driver = new EventFiringDecorator<>(listener).decorate(aDriver);
    }

    @Override
    public WebDriver getWrappedDriver() {
        return driver;
    }

    public class ElementHighlighterListener implements WebDriverListener {

        HighlightElement highlighter;

        public ElementHighlighterListener(WebDriver driver,
                                          final String highlightColour) {

            highlighter = new HighlightElement(driver, highlightColour);
        }

        @Override
        public void beforeClick(final WebElement element) {

            highlighter.highlight(element);
        }

        @Override
        public void beforeSendKeys(final WebElement element,
                                        final CharSequence[] keysToSend) {

            highlighter.highlight(element);
        }

        @Override
        public void afterFindElement(final WebDriver driver, final By by, final WebElement element) {
                highlighter.highlight(element);
        }
    }
}
