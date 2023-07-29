package com.seleniumsimplified.webdriver.manager;

import java.io.IOException;
import java.net.Socket;

/**
 * Added code to check if proxy is running - this is to help skip proxy tests if not
 */
public class ProxyPort {

    public static boolean inUse(String host, String port) {
        return inUse(host, Integer.valueOf(port));
    }

    // http://stackoverflow.com/questions/434718/sockets-discover-port-availability-using-java
    public static boolean inUse(String host, int port) {
        Socket s = null;
        System.out.println("Checking for port on " + host + ":" + port);

        try {
            s = new Socket(host, port);

            // If the code makes it this far without an exception it means
            // something is using the port and has responded.
            System.out.println("Port " + port + " is in use, assuming proxy is running");
            return true;
        } catch (IOException e) {
            System.out.println("Port " + port + " is free, no proxy running");
            return false;
        } finally {
            if( s != null){
                try {
                    s.close();
                } catch (IOException e) {
                    System.out.println("Port " + port + " check had an error ");
                    e.printStackTrace();
                    // swallow exception and return false for our use case
                    return false;
                }
            }
        }
    }
}
