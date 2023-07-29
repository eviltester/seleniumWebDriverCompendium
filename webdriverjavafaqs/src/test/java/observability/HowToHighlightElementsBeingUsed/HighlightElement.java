package observability.HowToHighlightElementsBeingUsed;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {
    private final WebDriver driver;
    private final String backgroundColour;
    WebElement lastElement;
    String lastElementOrigColour;


    public HighlightElement(final WebDriver driver,
                            final String backgroundColour) {
        this.driver = driver;
        this.backgroundColour = backgroundColour;
    }

    public WebElement highlight(WebElement newElement){

        // turn off last element
        if(lastElement!=null){
            setBackgroundColourOfElement(lastElement,
                    driver, this.lastElementOrigColour);
        }

        lastElement = newElement;

        if(newElement!=null){
            this.lastElementOrigColour =
                        newElement.getCssValue("backgroundColor");
            setBackgroundColourOfElement(newElement, driver, backgroundColour);
        }

        return newElement;
    }

    private void setBackgroundColourOfElement(final WebElement element,
                                              WebDriver driver,
                                              final String desiredColour) {

        try {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].style.backgroundColor=arguments[1]",
                            element, desiredColour);

        }catch(Exception e){
            if(e instanceof StaleElementReferenceException){
                // ignore
            }else {
                System.out.println("Error setting background colour of element");
                e.printStackTrace();
            }
        }
    }
}
