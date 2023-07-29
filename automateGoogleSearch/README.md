# Automate Google Search

Code to support my "Let's Automate Google Search" videos

- https://www.youtube.com/playlist?list=PLrM2ELpRbbu7c9oZKG8IHNX41Yi20p4an

In general - examples that automate Google are a bad idea because Google keeps changing and requires cookie consent so these examples probably fail.

I deliberately picked Google Search because it is often shown in sample "My First Test" Webdriver code samples.

But... it changes so often that it isn't a reliable system to automate.

You should really use something like: https://testpages.herokuapp.com


## Update 20230729

I amended the code to have a hacky static method to dismiss the Cookie accept dialog.

```java
public class Modals {
    private static String ACCEPT_BUTTON_TEXT = "accept all";

     public static void dismiss(WebDriver driver){
        try{
            // if a cookie accept appears then accept it so we can
            // automate
            WebDriverWait wait = new WebDriverWait(driver, 2);
            // if there is a modal dialog
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-modal='true']")));
            final List<WebElement> buttons = modal.findElements(By.cssSelector("button"));
            for (WebElement button: buttons) {
                if(button.getText().trim().toLowerCase(Locale.ROOT).equals(ACCEPT_BUTTON_TEXT)){
                    button.click();
                }
            }
        }catch (Exception e){
            // ignore any exceptions - there might not be a modal dialog
        }
    }
}
```

The rest of the changes were:

- locator changes to handle Google amendments
- Google no longer has a 'search' button, you just press ENTER
- I added a page limit on the search examples to prevent infinite loop when it doesn't find a match.

**REMEMBER: Automating Google Search is a bad idea and this code shows why.**