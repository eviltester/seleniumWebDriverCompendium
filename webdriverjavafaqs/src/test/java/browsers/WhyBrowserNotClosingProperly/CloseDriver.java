package browsers.WhyBrowserNotClosingProperly;

import org.openqa.selenium.WebDriver;

public class CloseDriver {
    public static void now(final WebDriver driver) {
        driver.close();
        try{
            driver.quit();
        }catch (Exception e){
            System.out.println("Browser closed already, " +
                            "did not need to quit");
            e.printStackTrace();
        }
    }
}
