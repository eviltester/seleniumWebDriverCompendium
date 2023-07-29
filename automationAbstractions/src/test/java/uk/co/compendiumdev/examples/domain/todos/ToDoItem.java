package uk.co.compendiumdev.examples.domain.todos;

/**
 * A domain representation of a To Do Item, no interaction with the Web or WebDriver
 */
public class ToDoItem {

    private String itemText;
    private boolean done;

    public ToDoItem(String itemText){
        if(itemText.trim().length() == 0){
            throw new IllegalArgumentException("A Todo Item Cannot Have Empty Text");
        }

        this.itemText = itemText;
        this.done = false;
    }

    public ToDoItem(String itemText, boolean isDone){
        this(itemText);

        this.done = isDone;
    }

    public ToDoItem markCompleted(){
        this.done = true;
        return this;
    }

    public ToDoItem markActive(){
        this.done = false;
        return this;
    }

    public String getText(){
        return this.itemText;
    }

    public ToDoItem setText(String itemText){
        this.itemText = itemText;
        return this;
    }

    public boolean isCompleted(){
        return this.done;
    }

    public boolean isActive(){
        return !this.done;
    }

    public ToDoItem and(){
        return this;
    }

    public ToDoItem then(){
        return this;
    }

    public ToDoItem also(){
        return this;
    }
}
