package uk.co.compendiumdev.letsautomate.googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 09/11/2016.
 */
public class WebDriverGoogleSearchResultsExtractor {
    public static List<TitledUrl> getReturnUrls(WebDriver driver) {
        List<WebElement> resultEntries = driver.findElements(By.cssSelector("h3.r > a"));
        List<TitledUrl> resultUrls = new ArrayList<>();

        for(WebElement element : resultEntries){
            String href = element.getAttribute("href");
            String title = element.getText();

            TitledUrl titledUrl = new TitledUrl(href, title);
            resultUrls.add(titledUrl);

        }

        return resultUrls;
    }
}
