Feature: Exporting XLS report and verification of data

  Background:
    Given user goes to the main page "url"
    When the correct page loads
    Then user clicks on the link to download the table
    Then user controls if the excel table is downloaded


  Scenario Outline: open the web site and download the excel table



    Then controls if the column A contains the following "<states>"
    Examples:
      | states         |
      | Georgia        |
      | Hawaii         |
      | Texas          |


  Scenario: open the excel file and update data

    Then user verifies the summation of the energy consumed by all states is equal to "97144.7"
    Then user records the most energy consuming state in transportation
    Then user records the least energy consuming state in residential
    Then user records the most energy consuming state in commercial
    Then user records the least energy consuming state in industrial












