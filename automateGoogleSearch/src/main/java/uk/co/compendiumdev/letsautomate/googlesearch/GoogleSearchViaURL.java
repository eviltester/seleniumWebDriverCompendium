package uk.co.compendiumdev.letsautomate.googlesearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Alan on 08/11/2016.
 */
public class GoogleSearchViaURL implements GoogleSearchI {
    private final String domain;
    private final WebDriver driver;
    private String theSearchURL;
    private GoogleSearchResultsI googleSearchResults;

    public GoogleSearchViaURL(String siteDomain) {
        this.driver = new ChromeDriver();;
        this.domain = siteDomain;
    }

    @Override
    public void searchFor(String searchTerm, String matchInUrl) {

        String searchForString = "";

        try {
            searchForString = URLEncoder.encode(searchTerm, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        this.theSearchURL = this.domain + "/search?q=" + searchForString;

        driver.get(this.theSearchURL);

        Modals.dismiss(driver);

    }

    @Override
    public GoogleSearchResultsI results() {
        if(googleSearchResults==null){
            googleSearchResults = new GoogleSearchResultsViaURL(driver, 1, theSearchURL);
        }
        return googleSearchResults;
    }

    @Override
    public void endSearch() {
        driver.close();
        driver.quit();
    }
}
