package uk.co.compendiumdev.examples.domain.todos;

import java.util.ArrayList;
import java.util.List;

/**
 * A domain representation of a To Do List - no interaction with WebDriver
 * Would be used for context and expected results
 */
public class ToDoList {

    List<ToDoItem> todos;

    public ToDoList(){
        todos = new ArrayList<>();
    }

    public ToDoList addNewToDoItems(String ...todoText){

        for(String text : todoText){
            addNewToDoItem(text);
        }

        return this;
    }

    public ToDoList addNewToDoItem(String todoText){
        ToDoItem item = new ToDoItem(todoText);
        todos.add(item);
        return this;
    }

    public ToDoItem getItemAtPosition(int position){
        return todos.get(position);
    }

    public ToDoList deleteItemAtPosition(int position){
        todos.remove(position);
        return this;
    }

    public ToDoList and(){
        return this;
    }

    public ToDoList then(){
        return this;
    }

    public int size() {
        return todos.size();
    }

    public int getPositionOf(String toDoText) {

        int position = 0;

        for(ToDoItem item : todos){
            if(item.getText().contentEquals(toDoText))
                return position;

            position++;
        }

        throw new IndexOutOfBoundsException("Could not find " + toDoText);
    }

    public boolean contains(String toDoText){

        try{
            getPositionOf(toDoText);
            return true;

        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }

    public List<ToDoItem> todos() {
        return todos;
    }
}
