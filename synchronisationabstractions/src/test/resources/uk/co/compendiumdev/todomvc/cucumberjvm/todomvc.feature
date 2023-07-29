Feature: We can create and edit To Do lists in ToDoMvc

  We want to amend todos in ToDoMVC because that is
  the set of exercises on the abstraction tutorial

  Scenario: Create a ToDo Item
    Given a user opens a blank ToDoMVC page
    When the user creates a todo "new task"
    Then they see 1 todo item on the page