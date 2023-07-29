package abstractions.driver.HowToCreateADriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * A singleton style manager to maintain Drivers to prevent
 * test slowdown for creating a browser for each class with tests.
 */
public class Driver extends Thread{
    private static WebDriver aDriver=null;
    private static boolean avoidRecursiveCall=false;
    public static final String BROWSER_PROPERTY_NAME = "webdriverjavafaqs.webdriver";

    //private static final  String DEFAULT_BROWSER = "FIREFOX";
    //private static final  String DEFAULT_BROWSER = "SAFARI";
    private static final  String DEFAULT_BROWSER = "GOOGLECHROME";

    public enum BrowserName{FIREFOX, GOOGLECHROME, SAUCELABS, GRID, SAFARI}

    public static BrowserName currentDriver;

    private static BrowserName useThisDriver = null;

    public static String PROXYHOST="localhost";
    public static String PROXYPORT="8888";
    public static String PROXY=PROXYHOST+":"+PROXYPORT;

    public static WebDriver get() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        if(useThisDriver == null){

            String defaultBrowser = getPropertyOrEnv(BROWSER_PROPERTY_NAME, DEFAULT_BROWSER);

            switch (defaultBrowser){
                case "FIREFOX":
                case "GOOGLECHROME":
                case "GRID":
                case "SAFARI":
                    useThisDriver = BrowserName.valueOf(defaultBrowser);
                    break;
                case "CHROME":
                    useThisDriver = BrowserName.GOOGLECHROME;
                    break;
                default:
                    throw new RuntimeException("Unknown Browser in " + BROWSER_PROPERTY_NAME + ": " + defaultBrowser);
            }
        }


        if(aDriver==null){

            switch (useThisDriver) {
                case FIREFOX:
                    FirefoxOptions foptions = new FirefoxOptions();

                    if(getPropertyOrEnv("WEBDRIVER_HEADLESS_BROWSER", "").length()>0) {
                        foptions.addArguments("-headless");
                    }
                    aDriver = new FirefoxDriver(foptions);
                    currentDriver = BrowserName.FIREFOX;
                    break;

                case GOOGLECHROME:
                    ChromeOptions coptions = new ChromeOptions();
                    coptions.setAcceptInsecureCerts(true);

                    if(getPropertyOrEnv("WEBDRIVER_HEADLESS_BROWSER", "").length()>0) {
                        coptions.addArguments("--headless");
                    }

                    aDriver = new ChromeDriver(coptions);
                    currentDriver = BrowserName.GOOGLECHROME;
                    break;

                case GRID:

                    String gridBrowser = getPropertyOrEnv("WEBDRIVER_GRID_BROWSER", "firefox");
                    String gridBrowserVersion = getPropertyOrEnv("WEBDRIVER_GRID_BROWSER_VERSION", "");
                    String gridBrowserPlatform = getPropertyOrEnv("WEBDRIVER_GRID_BROWSER_PLATFORM", "");

                    DesiredCapabilities gridCapabilities = new DesiredCapabilities();
                    gridCapabilities.setBrowserName(gridBrowser);
                    if(gridBrowserVersion.length()>0)
                        gridCapabilities.setVersion(gridBrowserVersion);
                    if(gridBrowserPlatform.length()>0)
                        gridCapabilities.setPlatform(Platform.fromString(gridBrowserPlatform));

                    // Allow adding any capability defined as an environment variable
                    // extra environment capabilities start with "WEBDRIVER_GRID_CAP_X_"
                    // e.g. WEBDRIVER_GRID_CAP_X_os_version XP
                    // e.g. WEBDRIVER_GRID_CAP_X_browserstack.debug true
                    Map<String, String> anyExtraCapabilities = System.getenv();
                    addAnyValidExtraCapabilityTo(gridCapabilities, anyExtraCapabilities.keySet());

                    // Now check properties for extra capabilities
                    Properties anyExtraCapabilityProperties = System.getProperties();
                    addAnyValidExtraCapabilityTo(gridCapabilities, anyExtraCapabilityProperties.stringPropertyNames());


                    try {
                        // add url to environment variables to avoid releasing with source
                        String gridURL = getPropertyOrEnv("WEBDRIVER_GRID_URL", "http://localhost:4444/wd/hub");
                        aDriver = new RemoteWebDriver(new URL(gridURL), gridCapabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    currentDriver = BrowserName.GRID;
                    break;

                case SAFARI:
                    aDriver = new SafariDriver();
                    currentDriver = BrowserName.SAFARI;
                    break;
            }


            // we want to shutdown the shared brower when the tests finish
            Runtime.getRuntime().addShutdownHook(
                    new Thread(){
                        public void run(){
                            Driver.quit();
                        }
                    }
            );

        }else{
            // driver is set, close it and start again

            try{
                // is browser still alive
                if(aDriver.getWindowHandle()!=null){
                    // assume it is still alive
                }
            }catch(Exception e){
                if(avoidRecursiveCall){
                    // something has gone wrong as we have been here already
                    throw new RuntimeException("something has gone wrong as we have been in Driver.get already");
                }

                try {
                    quit();
                }catch(Exception inner){
                    //
                }
                aDriver=null;
                avoidRecursiveCall = true;
                return get();
            }
        }

        avoidRecursiveCall = false;
        return aDriver;
    }



    private static void addAnyValidExtraCapabilityTo(DesiredCapabilities gridCapabilities, Set<String> possibleCapabilityKeys) {

        String extraCapabilityPrefix = "WEBDRIVER_GRID_CAP_X_";

        for(String capabilityName : possibleCapabilityKeys){

            if(capabilityName.startsWith(extraCapabilityPrefix)){

                String capabilityValue = getPropertyOrEnv(capabilityName, "");

                if(capabilityValue.length()>0){
                    String capability = capabilityName.replaceFirst(extraCapabilityPrefix,"");
                    System.out.println("To Set Capability " + capability + " with value " + capabilityValue);
                    gridCapabilities.setCapability(capability, capabilityValue);
                }
            }
        }
    }

    public static WebDriver get(String aURL, boolean maximize){
        get();
        aDriver.get(aURL);
        if(maximize){
            try{
                aDriver.manage().window().maximize();
            }catch(Exception e){
                System.out.println("Driver does not support maximise");
            }
        }
        return aDriver;
    }

    public static WebDriver get(String aURL){
        return get(aURL,true);
    }

    public static void quit(){
        if(aDriver!=null){
            try{
                aDriver.quit();
                aDriver=null;
            }catch(Exception e){
                // I don't care about errors at this point
            }
        }
    }


    private static String getPropertyOrEnv(String name, String theDefault){

        String theValue = System.getProperty(name);
        if(theValue == null){

            theValue = System.getenv(name);

            if(theValue==null){

                System.out.println("No Environment Variable or Property named [" + name + "] using default value [" + theDefault + "]");
                theValue = theDefault;

            }else{
                System.out.println("Using Environment Variable " + name + " with value " + theValue);
            }
        }else{
            System.out.println("Using Property " + name + " with value " + theValue);
        }

        return theValue;
    }

}
