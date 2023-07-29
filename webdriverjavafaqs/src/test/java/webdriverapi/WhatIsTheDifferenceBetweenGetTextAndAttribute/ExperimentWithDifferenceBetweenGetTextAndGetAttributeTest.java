package webdriverapi.WhatIsTheDifferenceBetweenGetTextAndAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExperimentWithDifferenceBetweenGetTextAndGetAttributeTest {


    private static WebDriver driver;
    private int TEXT_LENGTH_TO_DISPLAY=20;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void getThePageToExperimentWith(){
        driver.get("https://testpages.herokuapp.com/styled/" +
                "basic-web-page-test.html");
    }

    @Test
    public void experimentForYourself(){

        // for the given page - scan page and report on all elements
        Map<String, String> tags = new HashMap<String, String>();

        List<WebElement> elements = driver.findElements(By.cssSelector("*")); // get everything
        for(WebElement element : elements){

            String getText = "";
            String getAttribute = "";

            if(tags.containsKey(element.getTagName())){
                // skip this one we already have an example
                continue;
            }

            try{
                getText = element.getText();
            }catch (Exception e){}

            try{
                getAttribute = element.getAttribute("text");
            }catch (Exception e){}

            getText = shortenAndReplaceNewLines(getText, TEXT_LENGTH_TO_DISPLAY);
            getAttribute = shortenAndReplaceNewLines(getAttribute, TEXT_LENGTH_TO_DISPLAY);

            System.out.println(element.getTagName());
            System.out.println(" - getText : " + getText);
            System.out.println(" - getAttribute : " + getAttribute);
            tags.put(element.getTagName(), String.format("| %s | %s | %s |",
                    element.getTagName(), getText, getAttribute));

        }

        System.out.println("| TAG   |  Text    |   Attribute  |");
        System.out.println("|-------|----------|--------------|");
        for(Map.Entry<String,String> tagExample : tags.entrySet()){
            System.out.println(tagExample.getValue());
        }

    }

    private String shortenAndReplaceNewLines(final String text, final int maxlength) {
        if(text==null) return "null";

        int getTextLen = text.length();
        String retText="";

        if(getTextLen>0) {
            int stringLenToGet = (getTextLen > maxlength) ? maxlength : getTextLen;
            retText = text.replaceAll("\n", "").substring(0, stringLenToGet);
            retText = (getTextLen > maxlength) ? retText + "..." : retText;
        }

        return retText;
    }


    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }
}
