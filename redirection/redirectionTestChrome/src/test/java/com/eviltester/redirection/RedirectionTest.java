package com.eviltester.redirection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RedirectionTest {




    public WebDriver getDriver(Boolean headless, String agent){
        ChromeOptions options = new ChromeOptions();
        List arguments = new ArrayList();

        if(headless) {
            arguments.add("--headless");
        }

        if(agent!=null && agent.length()>0) {
            arguments.add("--user-agent=" + agent);
        }

        options.addArguments(arguments);

        return new ChromeDriver(options);
    }


    @Parameterized.Parameters(name = "{index}: {0}")
    public static Iterable<String> getAllUserAgents() throws IOException {

        // assume the existence of the 'userAgentsToCheck.properties' file
        UserAgentStrings toCheck = new UserAgentStrings();
        File userAgentPropertyFile = new File(System.getProperty("user.dir"), "userAgentsToCheck.properties");
        UserAgentPropertyFileReader reader = new UserAgentPropertyFileReader(userAgentPropertyFile);
        reader.populateUserAgentStrings(toCheck);

        return toCheck.getAgentStrings();
    }

    private String agent;

    public RedirectionTest(String aGivenUserAgent){
        this.agent = aGivenUserAgent;
    }

    @Test
    public void exploreUsingChrome() throws IOException {

        // visit these urls and check that they redirect
        List<String> redirectFrom = new ArrayList<String>();
        // TODO: CHANGE THESE TO YOUR SITE URLS
        redirectFrom.add("https://youtube.com");
        //redirectFrom.add("https://testpages.herokuapp.com/styled/redirect/user-agent-redirect-test");

        // to find sites that exhibit this redirect behaviour
        // try searching for:
        // inurl:https://m.

        // should I clear cookies after every redirect attempt?
        boolean clearCookies = true;

        // consider it a redirect if the URL contains ... makes it a bit more generic than starts with
        // e.g. String redirectToContain = "https://mobile.";
        // String redirectToContain = "https://mob.";
        String redirectToContain = "https://m.";

        // for the https://testpages.herokuapp.com/styled/redirect/user-agent-redirect-test
        //String redirectToContain = "/mobile/";


        System.out.println(agent);

        boolean exceptionRaised = false;

        // this does not need to use headless and could be run normally
        // WebDriver driver = getDriver(false, agent);
        // to run headless
        WebDriver driver = getDriver(true, agent);


        for(String redirectFromThisURL : redirectFrom){

            try{
                driver.navigate().to(redirectFromThisURL);

            }catch(Exception e){
                // swallow it
                e.printStackTrace();
                exceptionRaised = true;
            }finally{
                if(clearCookies){
                    driver.manage().deleteAllCookies();
                }
            }

            String redirectedTo = driver.getCurrentUrl();

            driver.quit();  // otherwise you have a whole set of browsers lying about

            if(!exceptionRaised && redirectedTo.contains(redirectToContain)){
                System.out.print("PASSED : ");
            }else{
                Assert.fail(redirectedTo + " === from === " + redirectFromThisURL);
            }

            System.out.println(redirectedTo + " === from === " + redirectFromThisURL);


        }

    }

}
