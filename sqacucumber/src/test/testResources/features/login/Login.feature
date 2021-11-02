Feature: logging in
  Scenario Outline:
    Given user is on login page of "https://demo.actitime.com/login.do"
    When user enters <username> and <password>
    And clicks login button
    Then close the browser

    Examples:
      | username | password |
      | admin | manager |
      | abc | manager |
      | admin | bbb |
      | bbcb | kajd |