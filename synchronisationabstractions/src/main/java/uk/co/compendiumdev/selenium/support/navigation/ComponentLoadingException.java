package uk.co.compendiumdev.selenium.support.navigation;

import org.openqa.selenium.WebDriverException;

public class ComponentLoadingException extends WebDriverException {

    // used in the loadable component wrapper classes to localise the exception reporting
    public ComponentLoadingException(String component, String because) {
        super(String.format(
                "Could not load component \"%s\" because \"%s\"", component, because));
    }
}
