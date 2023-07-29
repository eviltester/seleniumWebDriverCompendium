package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class WhichBrowsersHaveDevToolsTest {

    @Test
    public void checkDriversWhichHaveDevTools(){

        // test will fail and alert me if
        // any new drivers implement hasDevTools

        Map<Class,Boolean> expectedMappings = new HashMap<>();

        expectedMappings.put(ChromeDriver.class, true);
        expectedMappings.put(FirefoxDriver.class, false);
        expectedMappings.put(ChromiumDriver.class, true);
        expectedMappings.put(EdgeDriver.class, true);
        expectedMappings.put(InternetExplorerDriver.class, false);
        expectedMappings.put(OperaDriver.class, false);
        expectedMappings.put(SafariDriver.class, false);

        Map<String,Boolean> hasDevTools = new HashMap<>();

        Boolean asExpected=true;
        String unexpected = "";

        for(Map.Entry<Class,Boolean> entry: expectedMappings.entrySet()) {

            Class driverClass = entry.getKey();

            Boolean hasDevToolInterface = false;

            hasDevToolInterface = HasDevTools.class.isAssignableFrom(
                                        driverClass);

            if(hasDevToolInterface != entry.getValue()){
                asExpected=false;
                unexpected += driverClass.getSimpleName() + " | ";
            }
            hasDevTools.put(driverClass.getSimpleName(), hasDevToolInterface);
        }

        for(Map.Entry<String, Boolean>mapping : hasDevTools.entrySet()){
            String does = mapping.getValue() ? "implements" : "does not implement";
            System.out.println(String.format("- %s (%b) [%s hasDevTools]",
                    mapping.getKey(), mapping.getValue(), does));
        }

        Assertions.assertTrue(asExpected, unexpected);
    }
}
