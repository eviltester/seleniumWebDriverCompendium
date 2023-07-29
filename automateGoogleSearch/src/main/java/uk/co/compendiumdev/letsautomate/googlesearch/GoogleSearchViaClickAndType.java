package uk.co.compendiumdev.letsautomate.googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alan on 08/11/2016.
 */
public class GoogleSearchViaClickAndType implements GoogleSearchI {
    private final String domain;
    private final WebDriver driver;
    private String theSearchURL;
    private GoogleSearchResultsI googleSearchResults;

    public GoogleSearchViaClickAndType(String siteDomain) {
        this.driver = new ChromeDriver();
        this.domain = siteDomain;

        driver.get(siteDomain);

        Modals.dismiss(driver);
    }

    @Override
    public void searchFor(String searchTerm, String matchInUrl) {

        WebDriverWait wait = new WebDriverWait(driver, 5);

        // 20230729 used to be an input now it is a textarea
        String cssOfInputField = "textarea[name='q']";

        WebElement inputFieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfInputField)));

        inputFieldQ.sendKeys(searchTerm);

        // 20230729 used to be a button, now it is keyboard events
        inputFieldQ.sendKeys(Keys.ENTER);
//        String cssOfSearchButton = "button[name='btnG']";
//        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchButton)));
//        searchButton.click();
    }

    @Override
    public GoogleSearchResultsI results() {
        if(googleSearchResults==null){
            googleSearchResults = new GoogleSearchResultsViaClickAndType(driver);
        }
        return googleSearchResults;
    }

    @Override
    public void endSearch() {
        driver.close();
        driver.quit();
    }
}
