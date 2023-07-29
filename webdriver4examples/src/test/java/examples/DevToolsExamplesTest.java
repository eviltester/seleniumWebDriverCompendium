package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.console.Console;
import org.openqa.selenium.devtools.log.Log;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.runtime.Runtime;

import java.util.Optional;

public class DevToolsExamplesTest {

    static ChromeDriver driver;
    static DevTools devtools;

    @BeforeAll
    public static void createDevToolsConnectedDriver(){
        driver = new ChromeDriver();
        devtools = driver.getDevTools();
        devtools.createSession();

    }

    @Test
    public void pretendToBeMobile(){

        String mobileFirefoxUserAgentString = "Mozilla/5.0 (Android 7.0; Mobile; rv:54.0) Gecko/54.0 Firefox/54.0";

        devtools.send(Network.setUserAgentOverride(mobileFirefoxUserAgentString,
                Optional.empty(), Optional.empty(), Optional.empty()));

        driver.get("https://testpages.herokuapp.com/styled/" +
                    "redirect/user-agent-redirect-test");

        Assertions.assertEquals("User Agent Based Mobile Test", driver.getTitle());


    }


    @Test
    public void logTraffic(){

        devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devtools.addListener(Network.requestWillBeSent(), request ->
        {
                System.out.println("REQUEST:");
                System.out.println(request.getDocumentURL());
                System.out.println(request.getRequest());
                System.out.println(request.getRequest().getPostData().toString());
        });

        devtools.addListener(Network.responseReceived(), response ->
        {
            System.out.println("RESPONSE:");
            System.out.println(response.getResponse().getUrl());
            System.out.println(response.getResponse().getHeadersText());
            System.out.println(response.getLoaderId().toJson());
        });

        devtools.addListener(Network.loadingFinished(), response ->
        {
            System.out.println("LOADED:");
            // get the message body
            System.out.println(devtools.send(Network.getResponseBody(response.getRequestId())).getBody());
            System.out.println(response.getRequestId().toJson());
        });

        driver.get("https://testpages.herokuapp.com/styled/sync/xhttp-messages.html");


        // wait for all messages to be sent by the app
        ((JavascriptExecutor)driver).executeAsyncScript(
                "window.callBackWhenNoQueuedMessages=arguments[arguments.length-1]");

    }

    @Test
    public void devToolsExample(){

        devtools.send(Console.enable());
        devtools.send(Log.enable());
        devtools.send(Runtime.enable());

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        devtools.addListener(Console.messageAdded(), message ->
                System.out.println("CONSOLE: " + message.getText()));

        devtools.addListener(Log.entryAdded(), message ->
            System.out.println("LOG: " + message.getText()));

        devtools.addListener(Runtime.consoleAPICalled(), message ->
                System.out.println("RUNTIME: " + message.getType().toJson()));

        ((JavascriptExecutor)driver).
                executeScript("console.log('hello there');");

        ((JavascriptExecutor)driver).
                executeScript("console.log('extra message');");

    }
}
