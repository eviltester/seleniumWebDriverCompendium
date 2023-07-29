package uk.co.compendiumdev.examples.browserstorage;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import uk.co.compendiumdev.examples.browserstorage.html5.Storage;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;


public class LocalStorageTest {

    private WebDriver driver;
    private TodoMVCSite todoMVCSite;
    private TodoMVCStoragePojoPage todoMVC;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        todoMVCSite = new TodoMVCSite();

        todoMVC = new TodoMVCStoragePojoPage(driver, todoMVCSite.getURL());
        todoMVC.open();
    }

    @Test
    public void updatesLocalStorageInitiallyUglyCode(){

        // initially code for backbone
        // the spec is loosely interpreted by different frameworks
        // so this will not be generic
        // todos-[framework]

        String storage_namespace = "todos-" + todoMVCSite.getName();
        LocalStorage storage = new Storage((JavascriptExecutor)driver);

        int initialSize = 0;
        String[] keys;

        try{
            keys = storage.getItem(storage_namespace).split(",");
            initialSize = keys.length;
        }catch(NullPointerException e){
            // the key might not exist
        }

        todoMVC.enterNewToDo("First Added Item");

        keys = storage.getItem(storage_namespace).split(",");
        int newSize = keys.length;

//    TODO:
//        EXERCISE:
//           - Convert this test to use Hamcrest for assertions
//            if you like it then experiment with Hamcrest in
//            other tests.
//           - You can learn more about hamcrest
//            at http://hamcrest.org/
//        EXERCISE COMMENT:
//            Most of the tests use JUnit 5 Assertions
//            Hamcrest, might make this test more readable e.g.
//                 assertThat(newSize, greaterThan(initialSize));
//            instead of
//                Assertions.assertTrue(newSize > initialSize);
//            and the assertTrue and assertEquals might read more
//            readable if using assertThat e.g.
//                assertThat(foundit, is(true));
//                assertThat(todoStorage.length(), is(0L));
        Assertions.assertTrue(newSize > initialSize);

        boolean foundit = false;

        // has title
        keys = storage.getItem(storage_namespace).split(",");
        for(String key : keys){
            String itemKey = storage_namespace + "-" + key;
            String item = storage.getItem(itemKey);
            // should really parse json
            if(item.contains("\"" + "First Added Item" + "\""))
                foundit = true;
        }

        Assertions.assertTrue(foundit);
    }

    @Test
    public void updatesLocalStorageRefactored(){

        TodoMvcLocalStorage todoStorage = new BackBoneTodoMVCLocalStorage(
                                                    (JavascriptExecutor) driver);

        Assertions.assertEquals(0L, todoStorage.length());

        todoMVC.enterNewToDo("First Added Item");

        Assertions.assertEquals(1L, todoStorage.length());

        Assertions.assertTrue(todoStorage.containsTitle("First Added Item"));

        todoMVC.enterNewToDo("Next Added Item");
        Assertions.assertEquals(2L, todoStorage.length());

        todoMVC.enterNewToDo("Third Added Item");
        Assertions.assertEquals(3L, todoStorage.length());
    }

    @AfterEach
    public void teardown(){

        ExecutionDriver.closeDriver(driver);
    }

//    TODO:
//        EXERCISE:
//            The different implementations of todomvc use different local storage implementations
//            - Analyse a few of the implementations
//            - How would you build an abstraction to handle multiple implementations?
//                - would you create an interface?
//                - would you have a Factory class?
//            - Create an implementation for a different implementation e.g. vanillajs

}
