package uk.co.compendiumdev.examples.environmentabstraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;

public class EnvironmentAbstractionTest {

    /*
        Another early abstraction that we often add is the Environment Abstraction

        This helps us avoid hard coding urls and admin passwords etc. into our test:

        Instead of:

        ~~~~~~~~
        driver.get("https://test.myenv.com");
        ~~~~~~~~

        We delegate the handling of information to other classes.

        ~~~~~~~~
        final TodoMVCEnvironment todoMVCSite = new TodoMVCEnvironment();
        driver.get(todoMVCSite.getURL());
        ~~~~~~~~

        People also use a base test class to abstract this type of information.
        I think this lacks flexibility.

     */

    // Note - this test is using a package specific class - not the main TodoMVCSite used by other tests
    @Test
    public void canUseADefaultBrowser(){

        ExecutionDriver manager = new ExecutionDriver();

        // TODO:
        //       EXERCISE:
        //         - change the code in the TodoMVCEnvironment to point
        //           to a different environment or instantiation of TodoMVC
        //           some urls are listed in the class
        WebDriver driver = manager.get();

        final TodoMVCEnvironment todoMVCSite = new TodoMVCEnvironment();

        driver.get(todoMVCSite.getURL());

        Assertions.assertTrue(driver.getTitle().contains("TodoMVC"));

        manager.close();
    }

    /*
        Because these classes often contain sensitive data they are likely to:

        - configure themselves from System Properties e.g. JVM -D parameters
        - configure themselves from Environment Variables
     */

    // TODO:
    //      EXERCISE:
    //          - implement some additional configuration approaches e.g.
    //              - constructor parameters
    //              - system properties
    //              - environment variables
    //              - resource files
}
