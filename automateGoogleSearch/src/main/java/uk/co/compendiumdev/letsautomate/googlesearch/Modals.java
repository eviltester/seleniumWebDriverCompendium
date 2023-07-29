package uk.co.compendiumdev.letsautomate.googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

public class Modals {

    // You might be running a different language browser so
    // may have to change this text to match what you see in the dialog
    private static String ACCEPT_BUTTON_TEXT = "accept all";

    /*
        Google now displays a 'modal' div which requires
        cookie permissions
     */

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
            // ignore any exceptions just in case there was no modal dialog
        }
    }
}
