Feature: creating a new task
  Scenario Outline:
    Given user is on taskList page of "https://demo.actitime.com/tasks/tasklist.do"
    When user clicks add new button and selects New Task
    And selects customer and project from dropdown lists
    And enters <taskName> and <est>
    Then clicks create tasks button
    Then close the browser

    Examples:
      | taskName | est |
      | task1 | 20 |