Feature: creating a new report
  Scenario Outline:
    Given user is on reports page of "https://demo.actitime.com/reports/reports.do"
    When user clicks new report button
    And selects report type and clicks configure button
    And clicks generate html report button
    And clicks add to dashboard button and enter <reportName> and save
    And clicks reports dashboard button
    Then confirm <reportName> is in dashboard
    Then close the browser

    Examples:
      | reportName |
      | report1 |