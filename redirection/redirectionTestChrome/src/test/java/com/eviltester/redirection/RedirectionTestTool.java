package com.eviltester.redirection;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Ignore("This can be a useful tool type test, and all the code to scrape the user agents is here, but the RedirectionTest is parameterised and easier to see working")
public class RedirectionTestTool {

    UserAgentStrings toCheck = new UserAgentStrings();


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


    public void getAllUserAgents() throws IOException {

        File userAgentPropertyFile = new File(System.getProperty("user.dir"), "userAgentsToCheck.properties");
        UserAgentPropertyFileReader reader = new UserAgentPropertyFileReader(userAgentPropertyFile);
        reader.populateUserAgentStrings(toCheck);

        // if we have cached them, then just use the cache
        // remove this to refresh the list from useragentstring
        if(toCheck.userAgents.size()>0)
            return;



        // Create a list of Oracle URL pages,
        // we will scan these for user agent strings that we will use in the test
        // could even use these
        // http://www.useragentstring.com/pages/Mobile%20Browserlist/
        List<String> oracleURLS = new ArrayList<String>();
        oracleURLS.add("http://www.useragentstring.com/pages/All/");
        oracleURLS.add("http://www.useragentstring.com/_uas_BlackBerry_version_.php");
        oracleURLS.add("http://www.useragentstring.com/_uas_Android%20Webkit%20Browser_version_.php");

        //if you want to double check getting results then set headless to false
        WebDriver driver = getDriver(false, "");

        for (String oracleURL : oracleURLS) {

            driver.navigate().to(oracleURL);

            List<WebElement> anchors = driver.findElements(By.cssSelector("ul > li > a"));
            int total = anchors.size();
            int current = 0;



            for (WebElement anchor : anchors) {
                System.out.println("Building User Agent Oracle List: " + current + "/" + total + " | " + toCheck.userAgents.size());
                UserAgentString userAgent = new UserAgentString(anchor.getText(), anchor.getAttribute("href"));
                if (oracleURL.contains("BlackBerry")) {
                    toCheck.addUserAgent(userAgent);
                }
                if (oracleURL.contains("Android")) {
                    toCheck.addUserAgent(userAgent);
                }
                if (userAgent.getUserAgentString().contains("(Blackberry;")) {
                    toCheck.addUserAgent(userAgent);
                }
                if (userAgent.getUserAgentString().startsWith("BlackBerry")) {
                    toCheck.addUserAgent(userAgent);
                }
                if (userAgent.getUserAgentString().contains("(iPhone;")) {
                    toCheck.addUserAgent(userAgent);
                }
                if (userAgent.getUserAgentString().contains("Windows Phone OS")) {
                    toCheck.addUserAgent(userAgent);
                }
                current++;
            }
        }

        UserAgentPropertyFileWriter writer = new UserAgentPropertyFileWriter(userAgentPropertyFile);
        writer.writeUserAgentsToPropertyFile(toCheck);

        driver.quit();

    }


    /*
        This is a 'tool' based test. It iterates over a lot of combinations of the parameters, but does so within a loop in the test.
        So it will run for a long time, showing output in the console and then generating a report at the end.
     */
    @Test
    public void exploreUsingChrome() throws IOException {

        List<UserAgentString> failedAgents = new ArrayList<UserAgentString>();
        List<UserAgentString> passedAgents = new ArrayList<UserAgentString>();

        // if you want a quick test then use the iphone string, otherwise getAllUserAgents
        getAllUserAgents();
        // checkUserAgents.add("Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_0 like Mac OS X; en-us) AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8A293 Safari/6531.22.7");

        int total = toCheck.userAgents.size();
        int current = 0;
        int failedCount=0;
        int passedCount=0;

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

        for(UserAgentString userAgent : toCheck.userAgents.values()){

            String agent = userAgent.getUserAgentString();

            System.out.println(current + "/" + total + " | " + failedCount);
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

                if(!exceptionRaised && redirectedTo.contains(redirectToContain)){
                    System.out.print("PASSED : ");
                    passedAgents.add(userAgent);
                    passedCount++;
                }else{
                    System.out.print("FAILED : ");
                    failedAgents.add(userAgent);
                    failedCount++;
                }

                System.out.println(redirectedTo + " === from === " + redirectFromThisURL);

                driver.quit();  // otherwise you have a whole set of browsers lying about
            }

            current++;
        }

        File outputFile = new File(System.getProperty("user.dir"), "htmlOutput" + String.valueOf(System.currentTimeMillis()) + ".htm");

        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

        System.out.println("");
        System.out.println("The following " + failedAgents.size() + " user agents failed to redirect");
        for(String toRedirectFrom : redirectFrom){
            System.out.println(toRedirectFrom + " to " + redirectToContain);
        }
        System.out.println("=================================================");
        for(UserAgentString failed : failedAgents){
            System.out.println(failed.getUserAgentString());
        }

        output.println("<html><head><title>HTML Output of User-Agent Check</title></head><body>");
        output.println("<b>The following " + failedAgents.size() + " user agents failed to redirect</b>");
        for(String toRedirectFrom : redirectFrom){
            output.println("<p>" + toRedirectFrom + " to " + redirectToContain + "</p>");
        }

        output.println("<hr/><p><strong>Failed</strong></p><ul>");
        for(UserAgentString failed : failedAgents){
            output.println("<li><a href='" + failed.getUserAgentURL() + "'>" + failed.getUserAgentString() + "</a></li>");
        }
        output.println("</ul>");

        output.println("<hr/><p><strong>Passed</strong></p><ul>");
        for(UserAgentString passed : passedAgents){
            output.println("<li><a href='" + passed.getUserAgentURL() + "'>" + passed.getUserAgentString() + "</a></li>");
        }
        output.println("</ul>");

        output.println("</body></html>");
        output.close();

        // expect redirect
        assertThat(failedAgents.size(), is(0));
    }



}
