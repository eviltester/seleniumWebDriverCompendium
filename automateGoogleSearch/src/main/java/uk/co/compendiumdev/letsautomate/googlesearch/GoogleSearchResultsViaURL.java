package uk.co.compendiumdev.letsautomate.googlesearch;

import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by Alan on 08/11/2016.
 */
public class GoogleSearchResultsViaURL implements GoogleSearchResultsI {
    private final WebDriver driver;
    private final String searchUrl;
    private int pageNumber;

    public GoogleSearchResultsViaURL(WebDriver driver, int pageNumber, String theSearchURL) {
        this.driver = driver;
        this.pageNumber = pageNumber;
        this.searchUrl = theSearchURL;

    }

    @Override
    public List<TitledUrl> returnUrls() {

        return WebDriverGoogleSearchResultsExtractor.getReturnUrls(driver);
    }

    @Override
    public void waitUntilAvailable() {
        //String cssOfFooter = "div#navcnt";
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssOfFooter)));

    }

    @Override
    public boolean getMoreResults() {

        String pageUrl = searchUrl;

        pageNumber++;
        pageUrl = pageUrl + "&start=" + ((pageNumber-1)*10);

        driver.get(pageUrl);

        //waitUntilAvailable();

        return (returnUrls().size()>0);

    }
}
