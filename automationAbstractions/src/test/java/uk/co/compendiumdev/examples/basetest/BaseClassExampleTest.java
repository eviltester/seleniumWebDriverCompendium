package uk.co.compendiumdev.examples.basetest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class BaseClassExampleTest extends SeleniumBaseTestCase {

    @Test
    public void canUseADefaultBrowser(){

        final TodoMVCSite todoMVCSite = new TodoMVCSite();

        driver().get(todoMVCSite.getURL());

        Assertions.assertTrue(driver().getTitle().contains("TodoMVC"));
    }

}
