package uk.co.compendiumdev.examples.synchronisedcomponent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class SynchronisedComponentAbstractionTest {

    private WebDriver driver;

    private SynchronisedComponentPojoPage todoMVC;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        final TodoMVCSite todoMVCSite = new TodoMVCSite();

        todoMVC = new SynchronisedComponentPojoPage(driver, todoMVCSite.getURL());
        // todoMVC.open()
        todoMVC.get(); // use Loadable Component interface

    }

    @Test
    public void canUseSynchronisedComponents(){

        todoMVC.typeIntoNewToDo("Edit Me" + Keys.ENTER);

        todoMVC.editItem(0, "Edited Todo");

        Assertions.assertEquals("Edited Todo", todoMVC.getToDoText(0));
    }


    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }
}
