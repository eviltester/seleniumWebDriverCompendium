package uk.co.compendiumdev.todomvc.page.structural.pojo;

public enum ItemsInState {
   VISIBLE{
       @Override
       public String cssSelector() {
           return "ul.todo-list li:not(.hidden)";
       }
   };

    public String cssSelector() {
        return "";
    }
}
