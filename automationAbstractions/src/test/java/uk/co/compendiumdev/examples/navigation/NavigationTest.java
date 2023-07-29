package uk.co.compendiumdev.examples.navigation;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.selenium.support.webdriver.ExecutionDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

import static uk.co.compendiumdev.examples.navigation.TodoMVCNav.Pages.ACTIVE_TODOS_PAGE;

public class NavigationTest {

    private WebDriver driver;
    private TodoMVCSite todoMVCSite;

    private TodoMVCPojoPage todoMVC;

    @BeforeEach
    public void setup(){
        driver = new ExecutionDriver().get();
        todoMVCSite = new TodoMVCSite();

        //todoMVC = new ApplicationPage(driver, todoMVCSite);
        todoMVC = new TodoMVCPojoPage(driver, todoMVCSite.getURL());
        todoMVC.open();

        for(int todos=0; todos<9; todos++){
            todoMVC.typeIntoNewToDo("todo " + todos + Keys.ENTER);

            if (todos % 2 == 0) {
                // mark completed
                todoMVC.getTodoItems().get(todos).findElement(By.className("toggle")).click();
            }
        }
    }

    public int countVisibleTodos(){
        return driver.findElements(By.cssSelector("ul.todo-list li:not(.hidden)")).size();
    }

    /*

        For the purposes of this test imagine that the hash addressing is treated as
        different pages. And that we navigate between those pages by using the
        filter buttons.

        Decisions To Explore for navigation:

        - Should the page objects return other page objects as navigation?
        - Should the filter component be a navigation bar which returns other page objects?
        - Should we not navigate? Instead click navigation button then instantiate page objects
          for the state that we think the app should be in?

        Other Decisions:

        - if a page synchronises when it loads and throws an exception/error if it fails then
          do we need to add an assertion in the test or can we rely on the implicit assertion
          from the wait? e.g. page.open(); if it fails to open would through a timeout exception
     */

    // Note: direct navigation will only work through a server, not direct file access
    @Test
    public void navigateDirectlyFromPageObjectGet(){

        // navigate directly from page objects
        // ignores system navigation flow i.e. clicking on links, buttons etc.
        // simulates url manipulation by user
        // risk: can sometimes put app in a state user does not normally reach
        // the 'open' method has a wait which would fail if not on correct page
        // which is why there are no assertions here

        AllToDosPage allPage = new AllToDosPage(driver, todoMVCSite);
        allPage.open();


        // TODO:
        //      QUESTION:
        //             - Does adding an assertion above make it clearer
        //               that the test is 'doing' something?
        //             - Does it make it easier to understand the test at a glance?
        //             - Or is having an 'implicit' assertion via a hidden wait OK?
        //             - Consider the pros and cons.
        //      EXERCISE:
        //             - Add an isLoaded() method to the page object to allow asserting
        //               Assertions.assertTrue(allPage.isLoaded());

        ActiveToDosPage activePage = new ActiveToDosPage(driver, todoMVCSite);
        activePage.open();

        Assertions.assertEquals(4, countVisibleTodos());

        // TODO:
        //      EXERCISE:
        //              - Add an isLoaded() method to the page object to allow asserting
        //                Assertions.assertTrue(activePage.isLoaded());


        CompletedToDosPage completedPage = new CompletedToDosPage(driver, todoMVCSite);
        completedPage.open();

        Assertions.assertEquals(5, countVisibleTodos());

        // TODO:
        //      EXERCISE:
        //              - Add an isLoaded() method to the page object to allow asserting
        //                Assertions.assertTrue(completedPage.isLoaded());


        allPage.open();

        Assertions.assertEquals(9, countVisibleTodos());

    }

    @Test
    public void navigateAsSideEffect(){

        /*
         Sometimes we don't want to navigate to the page because it happens with
         normal usage flow.

         no direct navigation, but check that correct pages have loaded after
         the methods that trigger page load have finished
        */

        // expect the All ToDos Page to Load
        AllToDosPage allPage = new AllToDosPage(driver, todoMVCSite);
        allPage.waitUntilLoaded();

        Assertions.assertEquals(9, countVisibleTodos());

        // perform an action that causes a navigation to occur
        allPage.clickOnActiveFilter();

        // expect the Active ToDos Page to Load
        ActiveToDosPage activePage = new ActiveToDosPage(driver, todoMVCSite);
        activePage.waitUntilLoaded();

        Assertions.assertEquals(4, countVisibleTodos());

        // perform an action that causes a navigation to occur
        activePage.clickOnCompletedFilter();

        // expect the Completed ToDos Page to Load
        CompletedToDosPage completedPage = new CompletedToDosPage(driver, todoMVCSite);
        completedPage.waitUntilLoaded();

        Assertions.assertEquals(5, countVisibleTodos());

        // causes a navigation to the all page
        completedPage.clickOnAllFilter();

        allPage.waitUntilLoaded();

        Assertions.assertEquals(9, countVisibleTodos());

    }

    @Test
    public void navigateAndReturnObject(){

        /*
            Sometimes people like to have methods which cause a navigation
            to return a page object for the page navigated to.
         */

        todoMVC.open(); // by default we are on the allPage

        // TODO:
        //      QUESTION:
        //              - Should the open return an AllToDosPage object?
        //      EXERCISE:
        //             - Try it and see if you like that approach.
        //               when might that not work?

        AllToDosPage allPage = new AllToDosPage(driver, todoMVCSite);
        allPage.waitUntilLoaded();

        // perform an action that causes a navigation to occur
        ActiveToDosPage activePage = allPage.clickOnActiveFilter();
        activePage.waitUntilLoaded();

        // TODO:
        //      QUESTION:
        //             - I only implemented this 'return a page object' in one method.
        //             - Is this a useful approach?
        //             - When would returning a page object from a method not be appropriate?
        //      EXERCISE:
        //             - Experiment with returning page objects from methods and
        //               decide if it is appropriate or not.
        //             - What would happen if multiple page objects can be returned from
        //               an action?
        //               e.g. login("username","password") might login and go to app
        //               or might fail and leave us at the login page.
    }


    // TODO:
    //      EXERCISE:
    //              - Create a new test which navigates to the different pages but
    //                instead of using the 'open' method on the Page Object, create a
    //                TodoMVCNavigator object with methods like:
    //                openAllFilterPage(), openCompletedFilterPage()
    //                i.e. an object with responsibility for navigating to pages
    //              - You will have to decide if these methods should return page objects or not

    // TODO:
    //      QUESTION:
    //              - Would it be useful to have the TodoMVCNavigator object know how to
    //                navigate as a user navigates?
    //                e.g. navigateToAllFilterPage() would click on the 'all' filter link
    //                    and return an AllFilterPage
    //              - What would happen in a more complicated application?
    //              - Is this an idea you like or not?
    //      EXERCISE:
    //              - Experiment with this and see if it works for you.


//    TODO:
//        EXERCISE:
//            - There is a TodoMVCNav object in this package.
//            - Try and use that in a test and see if an enum based approach
//              helps readability and maintenance
//            - e.g. new TodoMVCNav(driver, todoMVCSite).open(ACTIVE_TODOS_PAGE);


    // TODO:
    //      EXERCISE:
    //          - the compendiumdev.co.uk/apps version of to do app has more functionality
    //            and can be used for navigating between a list of todos and a management
    //            section for managing todos
    //            if you want to experiment with navigation then expand these tests to cover
    //            the list management functionality - see the url in the TodoMVCSite class

    @AfterEach
    public void teardown(){
        ExecutionDriver.closeDriver(driver);
    }

    /*
        Navigation is often not thought about.

        Many people default to methods that navigate returning new Page objects for
        the navigation path.

        This means that:

        - page objects are now responsible for navigation and have to be changed when
          navigation flow changes, as well as structural changes on the page.
        - some methods might return multiple objects, which people handle with:
          login("username","password")  which returns the 'logged in' page and
          failToLogin("username","password") which returns the 'login page'
        - inconsistency between methods as some will return page objects and some will not

        There are no 'rights' and 'wrongs'. There are simply decisions we make
        when automating.
     */
}
