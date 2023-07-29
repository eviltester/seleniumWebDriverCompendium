package uk.co.compendiumdev.scratchpad;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.examples.navigation.TodoMVCPojoPage;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class ScratchPadTest {

    private WebDriver driver;
    private TodoMVCPojoPage todoMVC;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        final TodoMVCSite todoMVCSite = new TodoMVCSite();

        //todoMVC = new ApplicationPage(driver, todoMVCSite);
        todoMVC = new TodoMVCPojoPage(driver, todoMVCSite.getURL());
        todoMVC.open();

     }

     // a place to experiment
    @Test
    public void experimentWithSomething(){


    }

    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }


}
