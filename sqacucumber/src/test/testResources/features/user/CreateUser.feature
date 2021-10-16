Feature: creating a new user
  Scenario Outline:
    Given user is on userList page of "https://demo.actitime.com/administration/userlist.do"
    When user clicks new user button
    And enters <firstName>, <lastName> and <email>
    And selects department
    Then clicks save and send invitation button
    Then close the browser

    Examples:
    | firstName | lastName | email |
    | abc | def | abc@def.com |