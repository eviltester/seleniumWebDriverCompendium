package uk.co.compendiumdev.letsautomate.googlesearch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Alan on 07/11/2016.
 */
public class PageRankTest {

    WebDriver driver;

    @Before
    public void startTest(){
        driver = new ChromeDriver();
        driver.get("https://google.co.uk");
    }

    @Test
    public void pageRankTool(){

        // 20230729 - Google now shows a cookie accept dialog
        Modals.dismiss(driver);

        // 20230729 added a max page check to avoid searching forever
        int MAX_PAGES_TO_CHECK=4;

        String searchTerm="prolog programmer"; // "selenium training";
        String matchInUrl="compendiumdev.co.uk";

        // search page

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // 20230729 used to be "input[name='q']"
        String cssOfInputField = "textarea[name='q']";

        WebElement inputFieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfInputField)));

        inputFieldQ.sendKeys(searchTerm);

        // 20230729 - Google used to have a button, now it just has keyboard input
        inputFieldQ.sendKeys(Keys.ENTER);
//        String cssOfSearchButton = "button[name='btnG']";
//
//        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfSearchButton)));
//        searchButton.click();

        // search results page

        int pageNumber=0;
        boolean foundMatch=false;
        String foundMatchingUrl="";

        while(!foundMatch){

            pageNumber++;

            String cssOfNextPageButton = "a#pnnext";

            WebElement nextLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfNextPageButton)));

            // 20230729 No divs appear after the cookie accept now
            // handle any page load div
//            try{
//
//                String flyrCssSelector = "div#flyr";
//                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(flyrCssSelector)));
//                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(flyrCssSelector)));
//
//            }catch(Exception e){
//                // ignore any exceptions
//            }


            // 20230729 results is less easy to find, used to be "h3.r > a"
            // now just find any anchor with an href
            List<WebElement> resultEntries = driver.findElements(By.cssSelector("a[href]"));

            for(WebElement element : resultEntries){
                String href = element.getAttribute("href");
                String title = element.getText();

                System.out.println(href);
                System.out.println(title);

                if(href.contains(matchInUrl)){
                    System.out.println("****FOUND MATCH*** on page " + pageNumber);
                    foundMatchingUrl = href;
                    foundMatch=true;
                }

            }



            nextLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfNextPageButton)));

            if(pageNumber < MAX_PAGES_TO_CHECK)
                nextLink.click();
            else
                break;
        }

        if(foundMatch){
            System.out.println(String.format("Found match on Page Number %d - %s", pageNumber, foundMatchingUrl));
        }else{
            System.out.println(String.format("Max Page count %d reached before match found", MAX_PAGES_TO_CHECK));
        }

    }

    @After
    public void endTest(){
        driver.close();
        driver.quit();
    }
}
