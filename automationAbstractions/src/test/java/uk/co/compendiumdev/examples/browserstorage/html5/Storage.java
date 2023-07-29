package uk.co.compendiumdev.examples.browserstorage.html5;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.html5.LocalStorage;

import java.util.HashSet;
import java.util.Set;

/* HTML5 Storage is not supported by all browsers, so need a wrapper
    Implemented using the interface to make tests easier to maintain when WebDriver
    supports this on more browsers - mainly Android driver that does this at the moment
 */
public class Storage implements LocalStorage{

    private final JavascriptExecutor js;

    public Storage(JavascriptExecutor js){
        this.js = js;
    }

    @Override
    public String getItem(String key) {
        return (String) js.executeScript(
                    String.format(
                        "return window.localStorage.getItem('%s');", key));
    }

    @Override
    public Set<String> keySet() {
        // decided not to use .keys
        Set<String> keys = new HashSet<>();

        for (int keyIndex=0; keyIndex<=size()-1; keyIndex++)
        {
            keys.add(key(keyIndex));
        }

       return keys;
    }

    private String key(int keyIndex) {
        return (String) js.executeScript(String.format(
                "return window.localStorage.key('%s');", keyIndex));
    }

    @Override
    public void setItem(String key, String value) {
        js.executeScript(String.format(
                "window.localStorage.setItem('%s','%s');", key, value));
    }

    @Override
    public String removeItem(String key) {
        js.executeScript(String.format(
                "window.localStorage.removeItem('%s');", key));
        return key; // I have no idea what this is supposed to return
    }

    @Override
    public void clear() {
        js.executeScript("window.localStorage.clear();");
    }

    @Override
    public int size() {
        return (int) js.executeScript("return window.localStorage.length;");
    }
}
