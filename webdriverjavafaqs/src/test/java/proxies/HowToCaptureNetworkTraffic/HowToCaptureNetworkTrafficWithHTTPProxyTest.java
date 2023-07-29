package proxies.HowToCaptureNetworkTraffic;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class HowToCaptureNetworkTrafficWithHTTPProxyTest {

    private static WebDriver driver;
    private static BrowserMobProxyServer proxyServer;

    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();

        // start the proxy
        proxyServer = new BrowserMobProxyServer();
        proxyServer.start();

        // capture content as a HAR (HTTP Archive)
        // to process when test is complete
        proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT,
                                          CaptureType.RESPONSE_CONTENT);
        proxyServer.newHar();

        // configure the driver to use the BrowserMob proxy
        final Proxy proxyConfig = ClientUtil.createSeleniumProxy(proxyServer);

        // for external proxy set the proxy string
/*
        String proxyDetails = "127.0.0.1:8080";
        final Proxy proxyConfig = new Proxy().
                                    setHttpProxy(proxyDetails).
                                    setSslProxy(proxyDetails);
*/

        final ChromeOptions options = new ChromeOptions();
        options.setProxy(proxyConfig);
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);

        /*
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProxy(proxyConfig);
        driver = new FirefoxDriver(firefoxOptions);
*/
    }

    @Test
    public void captureTraffic(){

        driver.get("https://testpages.herokuapp.com/styled/sync/xhttp-messages.html");

        // wait for all messages to be sent by the app
        ((JavascriptExecutor)driver).executeAsyncScript(
                "window.callBackWhenNoQueuedMessages=arguments[arguments.length-1]");

        // get all the https messages as Har responses
        final Har httpMessages = proxyServer.getHar();
        for(HarEntry httpMessage : httpMessages.getLog().getEntries()){

            // check no errors on the XHR requests
            if(httpMessage.getRequest().getUrl().contains("/messageset")) {
                Assertions.assertEquals(200, httpMessage.getResponse().getStatus());

                // just to show something happened
                System.out.println("Request:");
                System.out.println(httpMessage.getRequest().getUrl());
                System.out.println("Response:");
                System.out.println(httpMessage.getResponse().getContent().getText());
            }
        }


    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
        proxyServer.abort();
    }
}
