package uk.co.compendiumdev.letsautomate.googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Alan on 08/11/2016.
 */
public class GoogleSearchResultsViaClickAndType implements GoogleSearchResultsI {
    private final WebDriver driver;
    private final WebDriverWait wait;


    public GoogleSearchResultsViaClickAndType(WebDriver driver) {
        this.driver = driver;


        wait = new WebDriverWait(driver, 5);
    }

    @Override
    public List<TitledUrl> returnUrls() {

        return WebDriverGoogleSearchResultsExtractor.getReturnUrls(driver);


    }

    @Override
    public void waitUntilAvailable() {
        // 20230729 - was ""div#navcnt"
        String cssOfFooter = "div[role='navigation'] > h1";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssOfFooter)));

        // removed 20230729 as no div appears
//        // handle any page load div
//        try{
//
//            String flyrCssSelector = "div#flyr";
//            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(flyrCssSelector)));
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(flyrCssSelector)));
//
//        }catch(Exception e){
//            // ignore any exceptions
//        }
    }

    @Override
    public boolean getMoreResults() {


        String cssOfNextPageButton = "a#pnnext";

        boolean haveMoreResults = false;

        try{
            WebElement nextLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfNextPageButton)));
            nextLink.click();
            haveMoreResults=true;}
        catch(Exception e){
            // ignore
        }

        return haveMoreResults;

    }
}
