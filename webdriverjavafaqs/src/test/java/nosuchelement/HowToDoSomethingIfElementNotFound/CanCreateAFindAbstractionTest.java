package nosuchelement.HowToDoSomethingIfElementNotFound;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CanCreateAFindAbstractionTest {

    /* we can create an abstraction for 'finding' stuff and if not found
       then do something e.g. take a screenshot */
    

    @Test
    public void aFindElementAbstractionCanHandleExceptions(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com");

        ElementFinder finder = new ElementFinder(driver);

        Exception e = Assertions.assertThrows(NoSuchElementException.class, () -> {
                    finder.findElement(By.id("thisiddoesnotexist"));
                });

        driver.quit();

    }


    private class ElementFinder {
        private final WebDriver driver;

        public ElementFinder(final WebDriver driver) {
            this.driver = driver;
        }

        public WebElement findElement(final By by) {
            try{

                return driver.findElement(by);

            }catch(NoSuchElementException e){
                System.out.println(
                        "I did something for the element finding issue here for " + by);
                // e.g. create a screenshot, write to a log, etc.
                throw e;
            }
        }
    }
}
