package uk.co.compendiumdev.examples.structuralvsfunctional;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import uk.co.compendiumdev.todomvc.site.TodoMVCSite;

public class ApplicationPageFunctionalExample {

    private ApplicationPageStructuralExample structure;

    public ApplicationPageFunctionalExample(WebDriver driver, TodoMVCSite todoMVCSite) {

        structure = new ApplicationPageStructuralExample(driver, todoMVCSite);
    }

    public int getCountOfTodoDoItems() {
        return structure.getVisibleTodos().size();
    }

    public void enterNewToDo(String todoTitle) {
        // could be Keys.ENTER on 2.40.0 and below
        // but needs to be Keys.RETURN on 2.41.0
        structure.typeIntoNewToDo(todoTitle, Keys.RETURN);
    }

    public void open() {
        structure.open();
    }

    public boolean isFooterVisible() {
        // catch any not found exceptions at functional layer
        try{
            return structure.isFooterVisible();
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public int getCountInFooter() {
        // if there is an exception because count is not visible
        // then there are 0 items
        try{
            return structure.getCountInFooter();
        }catch(Exception e){
            return 0;
        }
    }

    public void filterOnAll() {
        structure.clickOnFilter(0);
    }

    public void filterOnActive() {
        structure.clickOnFilter(1);
    }

    public void filterOnCompleted() {
        structure.clickOnFilter(2);
    }

    public void markTodoCompleted(int index){
        if(structure.getItemCheckbox(index).isSelected()){
            return;
        }
        structure.clickStateOfItem(index);
    }

    public void markTodoActive(int index){
        if(!structure.getItemCheckbox(index).isSelected()){
            return;
        }
        structure.clickStateOfItem(index);
    }

}
