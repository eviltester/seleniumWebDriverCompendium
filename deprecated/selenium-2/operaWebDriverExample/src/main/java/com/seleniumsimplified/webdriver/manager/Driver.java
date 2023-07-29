package com.seleniumsimplified.webdriver.manager;

import com.opera.core.systems.OperaDriver;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * A singleton style manager to maintain Drivers to prevent
 * test slowdown for creating a browser for each class with tests.
 *
 * Also counts time to start a browser and extrapolates from that how much
 * time you have saved using such hacky code.
 */
public class Driver extends Thread {
    private static WebDriver aDriver=null;
    private static long browserStartTime = 0L;
    private static long savedTimecount = 0L;
    private static boolean avoidRecursiveCall=false;
    public static final String BROWSER_PROPERTY_NAME = "selenium2basics.webdriver";

    private static final String DEFAULT_BROWSER = "FIREFOX";

    public static WebDriver get(String aURL){
        return get(aURL,true);
    }

    public enum BrowserName{FIREFOX, OPERA}

    public static BrowserName currentDriver;

    private static BrowserName useThisDriver = null;

    // default for browsermob localhost:8080
    // default for fiddler: localhost:8888
    public static String PROXYHOST="localhost";
    public static String PROXYPORT="8888";
    public static String PROXY=PROXYHOST+":"+PROXYPORT;

    public static void set(BrowserName aBrowser){
        useThisDriver = aBrowser;

        // close any existing driver
        if(aDriver != null){
            aDriver.quit();
            aDriver = null;
        }
    }

    public static WebDriver get() {

        if(useThisDriver == null){

            String defaultBrowser = System.getProperty(BROWSER_PROPERTY_NAME, DEFAULT_BROWSER);


            if("FIREFOX".contentEquals(defaultBrowser))
                useThisDriver = BrowserName.FIREFOX;

            if("OPERA".contentEquals(defaultBrowser))
                useThisDriver = BrowserName.OPERA;


            // if none of the previous if statements were exercised then useThisDriver will
            // still be none, this is the 'default' line from the Switch statement.
            if(useThisDriver==null)
                throw new RuntimeException("Unknown Browser in " + BROWSER_PROPERTY_NAME + ": " + defaultBrowser);


        }


        if(aDriver==null){


            long startBrowserTime = System.currentTimeMillis();

            switch (useThisDriver) {
                case FIREFOX:
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setEnableNativeEvents(true);

                    aDriver = new FirefoxDriver();//profile);
                    currentDriver = BrowserName.FIREFOX;
                    break;

                case OPERA:

                    // OperaDriver only supports version 12.x
                    // https://code.google.com/p/selenium/wiki/OperaDriver
                    aDriver = new OperaDriver();
                    currentDriver = BrowserName.OPERA;
                    break;

            }


            long browserStartedTime = System.currentTimeMillis();
            browserStartTime = browserStartedTime - startBrowserTime;

            // we want to shutdown the shared brower when the tests finish
            Runtime.getRuntime().addShutdownHook(
                    new Thread(){
                        public void run(){
                            Driver.quit();
                        }
                    }
            );

        }else{

            try{
                // is browser still alive
                if(aDriver.getWindowHandle()!=null){
                    // assume it is still alive
                }
            }catch(Exception e){
                if(avoidRecursiveCall){
                    // something has gone wrong as we have been here already
                    throw new RuntimeException();
                }

                quit();
                aDriver=null;
                avoidRecursiveCall = true;
                return get();
            }

            savedTimecount += browserStartTime;
            System.out.println("Saved another " + browserStartTime + "ms : total saved " + savedTimecount + "ms");
        }

        avoidRecursiveCall = false;
        return aDriver;
    }


    public static WebDriver get(String aURL, boolean maximize){
        get();
        aDriver.get(aURL);
        if(maximize){
            try{
                aDriver.manage().window().maximize();
            }catch(UnsupportedCommandException e){
                System.out.println("Remote Driver does not support maximise");
            }catch(UnsupportedOperationException e){
                System.out.println("Opera driver does not support maximize yet");
            }
        }
        return aDriver;
    }


    public static void quit(){
        if(aDriver!=null){
            System.out.println("total time saved by reusing browsers " + savedTimecount + "ms");
            try{
                aDriver.quit();
                aDriver=null;
            }catch(Exception e){
                // I don't care about errors at this point
            }

        }
    }
}
