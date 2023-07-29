package uk.co.compendiumdev.letsautomate.googlesearch;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

/**
 * Created by Alan on 07/11/2016.
 */
public class ReconTest {

    @Test
    public void doesWebDriverWork(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.co.uk");

        // 20230729 - Google now shows a cookie accept dialog
        Modals.dismiss(driver);

        // search page
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // 20230729 - this used to be "input[name='q']";
        String cssOfInputField = "textarea[name='q']";

        WebElement inputFieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfInputField)));

        inputFieldQ.sendKeys("test");

        // 20230729 - Google used to have a button, now it just has keyboard input
        inputFieldQ.sendKeys(Keys.ENTER);
//        String cssOfSearchButton = "button[name='btnG']";
//
//        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchButton)));
//        searchButton.click();

        // search results page

        String cssOfNextPageButton = "a#pnnext";

        WebElement nextLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfNextPageButton)));

        List<WebElement> resultEntries = driver.findElements(By.cssSelector("h3.r > a"));

        for(WebElement element : resultEntries){
            System.out.println(element.getAttribute("href"));
            System.out.println(element.getText());
        }

        nextLink.click();

        System.out.println("wait here");
        driver.close();
        driver.quit();
    }
}
